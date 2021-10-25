package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.PostDao;
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
public class PostDaoImpl extends SqlSessionDaoSupport implements PostDao {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    @Override
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

    @Override
    public List<Post> queryPosts(int startIndex, int pageSize) {
        List<Post> postList;
        try {
            postList = getMapper(PostMapper.class).selectAll(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    @Override
    public int getAllPostsCount(){
        int count;
        try {
            count = getMapper(PostMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public List<Post> queryPosts(int startIndex, int pageSize,int sectionId){
        List<Post> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllBySectionId(startIndex,pageSize,sectionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    @Override
    public PostResult queryPostById(int postId){
        PostResult postResult;
        try {
            postResult = getMapper(PostMapper.class).selectOneById(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postResult;
    }

    @Override
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
