package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.PostMapper;
import com.bluemsun.island.dao.mapper.SectionMapper;
import com.bluemsun.island.dao.mapper.UserLikePostMapper;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.dto.UserLikePost;
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
     * @param post 帖子
     * @return int 影响行数
     * @date 18:37 2021/10/22
     **/
    public int insertPost(Post post) {
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

    public int deletePost(int postId, int sectionId) {
        try {
            getMapper(PostMapper.class).deleteById(postId);
            getMapper(SectionMapper.class).postNumberDel(sectionId);
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
     * @param startIndex 开始
     * @param pageSize   数据量大小
     * @return java.util.List<com.bluemsun.island.entity.Post>
     * @date 10:32 2021/10/23
     **/
    public List<PostResult> queryPosts(int startIndex, int pageSize) {
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAll(startIndex, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    /**
     * 总帖子数
     *
     * @return int 数量
     * @date 10:33 2021/10/23
     **/
    public int getAllPostsCount() {
        int count;
        try {
            count = getMapper(PostMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<PostResult> queryPosts(int startIndex, int pageSize, int sectionId) {
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllBySectionIdDate(startIndex, pageSize, sectionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public List<PostResult> queryHotPosts(int startIndex, int pageSize, int sectionId) {
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllBySectionIdHot(startIndex, pageSize, sectionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public List<PostResult> queryHotPosts(int startIndex, int pageSize) {
        List<PostResult> postList;
        try {
            postList = getMapper(PostMapper.class).selectAllHot(startIndex, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public PostResult searchPostById(int postId) {
        PostResult postResult;
        try {
            postResult = getMapper(PostMapper.class).selectOneById(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postResult;
    }

    public int getPostsBySectionIdCount(int id) {
        int count;
        try {
            count = getMapper(PostMapper.class).getAllCountBySectionId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int updatePostById(Post post) {
        try {
            int rowsAffected = getMapper(PostMapper.class).updateByIdSelective(post);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public int postCommentNumberAdd(int postId, boolean jud) {
        try {
            int rowsAffected;
            if (jud) {
                rowsAffected = getMapper(PostMapper.class).commentNumberAdd(postId);
            } else {
                rowsAffected = getMapper(PostMapper.class).commentNumberDel(postId);
            }
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public int getPostCountByTitle(String name) {
        int count;
        try {
            count = getMapper(PostMapper.class).getCountByPostTitle(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<PostResult> queryPostByName(int startIndex, int pageSize, String name) {
        List<PostResult> sectionList;
        try {
            sectionList = getMapper(PostMapper.class).selectByPostTitle(startIndex, pageSize, name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sectionList;
    }

    public int insertLikePost(UserLikePost it) {
        try {
            getMapper(UserLikePostMapper.class).insert(it);
            getMapper(PostMapper.class).likeNumberAdd(it.getPostId());
            operationCode = ReturnCode.OP_SUCCESS;
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public int deletePostLike(UserLikePost it) {
        try {
            getMapper(UserLikePostMapper.class).deleteByUserIdAndPostId(it);
            getMapper(PostMapper.class).likeNumberDel(it.getPostId());
            operationCode = ReturnCode.OP_SUCCESS;
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public boolean searchLikePost(UserLikePost it){
        int count;
        try {
            count = getMapper(UserLikePostMapper.class).getCountByUserIdAndPostId(it);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count == 1;
    }
}
