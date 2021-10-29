package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.PostMapper;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 帖子数据持久层接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:46
 **/
public class PostDao extends SqlSessionDaoSupport {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    /**
     * 插入一条Post
     *
     * @date 18:37 2021/10/22
     * @param post 帖子
     * @return int 影响行数
     **/
    public int insertPost(Post post){
        try {
            getMapper(PostMapper.class).insert(post);
            operationCode = ReturnCode.OP_SUCCESS;
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    /**
     * 查找所有帖子
     *
     * @date 10:32 2021/10/23
     * @param startIndex 开始
     * @param  pageSize 数据量大小
     * @return java.util.List<com.bluemsun.island.entity.Post>
     **/
    public List<PostResult> queryPosts(int startIndex, int pageSize) {
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAll(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    /**
     * 总帖子数
     *
     * @date 10:33 2021/10/23
     * @return int 数量
     **/
    public int getAllPostsCount(){
        int count;
        try {
            count = getMapper(PostMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<PostResult> queryPosts(int startIndex, int pageSize,int sectionId){
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllBySectionIdDate(startIndex,pageSize,sectionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public List<PostResult> queryHotPosts(int startIndex, int pageSize,int sectionId){
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllBySectionIdHot(startIndex,pageSize,sectionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public PostResult queryPostById(int postId){
        PostResult postResult;
        try {
            postResult = getMapper(PostMapper.class).selectOneById(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postResult;
    }

    public int getPostsByIdCount(int id) {
        int count;
        try {
            count = getMapper(PostMapper.class).getAllCountById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
