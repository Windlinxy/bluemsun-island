package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.*;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.*;
import com.bluemsun.island.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 页面服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:43
 **/
public class PageServiceImpl implements PageService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private SectionDao sectionDao;
    @Autowired
    private AuditDao auditDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public Page<User> getUsers(int curPage, int pageSize, String name) {
        Page<User> page;
        int totalResult;
        if (name == null || name.isEmpty()) {
            totalResult = userDao.getAllUsersCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(userDao.queryAllUsers(page.getStartIndex(), pageSize));
        } else {
            totalResult = userDao.getUsersCountByName(name);
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(userDao.queryUsersByName(page.getStartIndex(), pageSize, name));
        }
        return page;
    }

    @Override
    public Page<PostResult> getPosts(int curPage, int pageSize) {
        int totalResult = postDao.getAllPostsCount();
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postDao.queryPosts(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<PostResult> getPosts(int curPage, int pageSize, int sectionId) {
        int totalResult = postDao.getPostsBySectionIdCount(sectionId);
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postDao.queryPosts(page.getStartIndex(), pageSize, sectionId));
        return page;
    }

    @Override
    public Page<PostResult> getHotPosts(int curPage, int pageSize, int sectionId) {
        Page<PostResult> page;
        int totalResult;
        if (sectionId != 0) {
            totalResult = postDao.getAllPostsCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postDao.queryHotPosts(page.getStartIndex(), pageSize, sectionId));
        } else {
            totalResult = postDao.getAllPostsCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postDao.queryHotPosts(page.getStartIndex(), pageSize));
        }
        return page;
    }


    @Override
    public Page<Section> getSections(int curPage, int pageSize, String sectionName) {
        Page<Section> page;
        int totalResult;
        if (sectionName == null || sectionName.isEmpty()) {
            totalResult = sectionDao.getAllSectionsCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(sectionDao.queryAllSections(page.getStartIndex(), pageSize));

        } else {
            totalResult = sectionDao.getSectionCountByName(sectionName);
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(sectionDao.querySectionsByName(page.getStartIndex(), pageSize, sectionName));
        }
        return page;
    }

    @Override
    public Page<Section> getHotSections(int curPage, int pageSize) {
        int totalResult = sectionDao.getAllSectionsCount();
        Page<Section> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(sectionDao.queryAllHotSections(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<Audit> getAudits(int curPage, int pageSize) {
        int totalResult = auditDao.getAllAuditsCount();
        Page<Audit> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(auditDao.queryAllAudits(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<Comment> getComment(int curPage, int pageSize, int postId) {
        int totalResult = commentDao.getAllByPostIdCount(postId);
        Page<Comment> page = new Page<>(curPage, pageSize, totalResult);
        List<Comment> list;
        list = commentDao.queryAllByPostId(page.getStartIndex(),pageSize,postId);
        page.setList(list);
        return page;
    }
}
