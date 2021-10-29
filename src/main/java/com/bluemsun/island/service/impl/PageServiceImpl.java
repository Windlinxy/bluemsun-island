package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.AuditDao;
import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.dao.SectionDao;
import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public Page<User> getUsers(int curPage, int pageSize) {
        int totalResult = userDao.getAllUsersCount();
        Page<User> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(userDao.queryAllUsers(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<User> getUsers(int curPage, int pageSize, String name) {
        int totalResult = userDao.getUsersCountByName(name);
        Page<User> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(userDao.queryUsersByName(page.getStartIndex(), pageSize, name));
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
        int totalResult = postDao.getAllPostsCount();
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postDao.queryPosts(page.getStartIndex(), pageSize, sectionId));
        return page;
    }

    @Override
    public Page<PostResult> getHotPosts(int curPage, int pageSize, int sectionId) {
        int totalResult = postDao.getAllPostsCount();
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postDao.queryHotPosts(page.getStartIndex(), pageSize, sectionId));
        return page;
    }

    @Override
    public Page<Section> getSections(int curPage, int pageSize) {
        int totalResult = sectionDao.getAllSectionsCount();
        Page<Section> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(sectionDao.queryAllSections(page.getStartIndex(), pageSize));
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
    public Page<Section> getSections(int curPage, int pageSize, String sectionName) {
        int totalResult = sectionDao.getSectionCountByName(sectionName);
        Page<Section> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(sectionDao.querySectionsByName(page.getStartIndex(), pageSize, sectionName));
        return page;
    }

    @Override
    public Page<Audit> getAudits(int curPage, int pageSize) {
        int totalResult = auditDao.getAllAuditsCount();
        Page<Audit> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(auditDao.queryAllAudits(page.getStartIndex(), pageSize));
        return page;
    }

}
