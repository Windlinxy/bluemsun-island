package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.dao.SectionDao;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.dto.UserLikePost;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.service.PostService;
import com.bluemsun.island.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @program: BulemsunIsland
 * @description: 帖子服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-22 18:33
 **/
public class PostServiceImpl implements PostService {
    private int operationJudCode = 0;
    @Autowired
    private PostDao postDao;
    @Autowired
    private SectionDao sectionDao;

    @Override
    public int addPost(Post post) {
        System.out.println(post);
        operationJudCode = postDao.insertPost(post);
        if (operationJudCode == 1) {
            operationJudCode = sectionDao.updateSection(post.getSectionId(), true);
        }
        return operationJudCode;
    }

    @Override
    public PostResult getPost(int postId) {
        PostResult postInCache = RedisUtil.getObject(postId, PostResult.class);
        if (postInCache != null) {
            return postInCache;
        } else {
            PostResult postInDatabase = postDao.searchPostById(postId);
            if (postInDatabase != null) {
                RedisUtil.setObject(postId, postInDatabase);
            }
            return postInDatabase;
        }
    }

    @Override
    public int changePost(Post post) {
        operationJudCode = postDao.updatePostById(post);
        return operationJudCode;
    }


    @Override
    public int deletePost(int postId, int sectionId) {
        operationJudCode = postDao.deletePost(postId, sectionId);
        if (operationJudCode == 1) {
            operationJudCode = sectionDao.updateSection(postId, false);
        }
        return operationJudCode;
    }

    @Override
    @Scheduled(cron = "0 */1 * * * ? ")
    public void testTime() {
        System.out.println(1);
    }

    @Override
    public int userLikeIt(int userId, int postId, boolean jud) {
        UserLikePost userLikePost = new UserLikePost(userId, postId);
        if (jud) {
            if (!isLike(userLikePost)) {
                operationJudCode = postDao.insertLikePost(userLikePost);
                PostResult postInCache = RedisUtil.getObject("PostResult:" + postId, PostResult.class);
                if (postInCache != null) {
                    postInCache.setLikeNumber(postInCache.getLikeNumber() + 1);
                    RedisUtil.setObject("PostResult:" + postId, postInCache);
                }
            } else {
                return 0;
            }
        } else {
            if (isLike(userLikePost)) {
                operationJudCode = postDao.deletePostLike(userLikePost);
                PostResult postInCache = RedisUtil.getObject("PostResult:" + postId, PostResult.class);
                if (postInCache != null) {
                    postInCache.setLikeNumber(postInCache.getLikeNumber() - 1);
                    RedisUtil.setObject("PostResult:" + postId, postInCache);
                }
            } else {
                return 0;
            }
        }
        return operationJudCode;
    }

    @Override
    public boolean isLike(UserLikePost it) {
        return postDao.searchLikePost(it);
    }

}
