package com.bluemsun.island.service.impl;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.dto.UserLikePost;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.mapper.PostMapper;
import com.bluemsun.island.mapper.SectionMapper;
import com.bluemsun.island.mapper.UserLikePostMapper;
import com.bluemsun.island.service.PostService;
import com.bluemsun.island.util.RedisUtil;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 帖子服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-22 18:33
 **/

public class PostServiceImpl implements PostService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private SectionMapper sectionMapper;
    @Resource
    private UserLikePostMapper userLikePostMapper;

    @Override
    public int addPost(Post post) {
        System.out.println(post);
        if (postMapper.insert(post) == 1) {
            sectionMapper.postNumberAdd(post.getSectionId());
        }
        return ReturnCode.OP_SUCCESS;
    }

    @Override
    public PostResult getPost(int postId, int userId) {
        PostResult postResult;
        PostResult postInCache = RedisUtil.getObject(postId, PostResult.class);
        if (postInCache != null) {
            RedisUtil.pfAdd("PostAccess:" + postId, userId + "");
            postInCache.setAccessNumber(RedisUtil.pfCount("PostAccess:" + postId));
            RedisUtil.setObject(postId, postInCache);
            postResult = postInCache;
        } else {
            PostResult postInDatabase = postMapper.selectOneById(postId);
            if (postInDatabase != null) {
                RedisUtil.pfAdd("PostAccess:" + postId, userId + "");
                postInDatabase.setAccessNumber(RedisUtil.pfCount("PostAccess:" + postId));
                RedisUtil.setObject(postId, postInDatabase);
            }
            postResult = postInDatabase;
        }
        return postResult;
    }

    @Override
    public int changePost(Post post) {
        postMapper.updateByIdSelective(post);
        return ReturnCode.OP_SUCCESS;
    }


    @Override
    public int deletePost(int postId, int sectionId) {
        if (postMapper.deleteById(postId) == 1 && sectionMapper.postNumberDel(sectionId) == 1) {
            sectionMapper.postNumberDel(sectionId);
        }
        return ReturnCode.OP_SUCCESS;
    }


    @Override
    @Scheduled(cron = "0 */1 * * * ? ")
    public void updateAccessNumberInDatabaseFromCache() {
        List<String> postKeys = RedisUtil.scanPost();
        for (String postKey : postKeys) {
            PostResult postInCache = RedisUtil.getObject(postKey, PostResult.class);
            Post post = new Post();
            post.setPostId(postInCache.getPostId());
            post.setAccessNumber(RedisUtil.pfCount("PostAccess:" + post.getPostId()));
            postMapper.updateByIdSelective(post);
        }
    }


    @Override
    public int userLikeItTx(int userId, int postId, boolean jud) {
        UserLikePost userLikePost = new UserLikePost(userId, postId);
        if (jud) {
            if (!isLike(userLikePost)) {
                userLikePostMapper.insert(userLikePost);
                postMapper.likeNumberAdd(userLikePost.getPostId());
                PostResult postInCache = RedisUtil.getObject(postId, PostResult.class);
                if (postInCache != null) {
                    postInCache.setLikeNumber(postInCache.getLikeNumber() + 1);
                    RedisUtil.setObject(postId, postInCache);
                }
            } else {
                return 0;
            }
        } else {
            if (isLike(userLikePost)) {
                userLikePostMapper.deleteByUserIdAndPostId(userLikePost);
                postMapper.likeNumberDel(userLikePost.getPostId());
                PostResult postInCache = RedisUtil.getObject(postId, PostResult.class);
                if (postInCache != null) {
                    postInCache.setLikeNumber(postInCache.getLikeNumber() - 1);
                    RedisUtil.setObject(postId, postInCache);
                }
            } else {
                return 0;
            }
        }
        return ReturnCode.OP_SUCCESS;
    }

    @Override
    public boolean isLike(UserLikePost it) {
        return 1 == userLikePostMapper.getCountByUserIdAndPostId(it);
    }

}
