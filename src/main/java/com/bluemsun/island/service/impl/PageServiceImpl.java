package com.bluemsun.island.service.impl;

import com.bluemsun.island.dto.CommentResult;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.dto.ReplyResult;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.mapper.*;
import com.bluemsun.island.service.PageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 页面服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:43
 **/

public class PageServiceImpl implements PageService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PostMapper postMapper;
    @Resource
    private SectionMapper sectionMapper;
    @Resource
    private AuditMapper auditMapper;
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ReplyMapper replyMapper;
    @Resource
    private MasterForSectionMapper masterForSectionMapper;

    @Override
    public Page<User> getUsers(int curPage, int pageSize, String name) {
        Page<User> page;
        int totalResult;
        if (name == null || name.isEmpty()) {
            totalResult = userMapper.getAllCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(userMapper.selectAll(page.getStartIndex(), pageSize));
        } else {
            totalResult = userMapper.getCountByUserName(name);
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(userMapper.selectByUserName(page.getStartIndex(), pageSize, name));
        }
        return page;
    }

    @Override
    public Page<PostResult> getPosts(int curPage, int pageSize) {
        int totalResult = postMapper.getAllCount();
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postMapper.selectAll(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<PostResult> getPosts(int curPage, int pageSize, int sectionId) {
        int totalResult = postMapper.getAllCountBySectionId(sectionId);
        Page<PostResult> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postMapper.selectAllBySectionIdDate(page.getStartIndex(), pageSize, sectionId));
        return page;
    }

    @Override
    public Page<PostResult> getHotPosts(int curPage, int pageSize, int sectionId) {
        Page<PostResult> page;
        int totalResult;
        if (sectionId != 0) {
            totalResult = postMapper.getAllCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postMapper.selectAllBySectionIdHot(page.getStartIndex(), pageSize, sectionId));
        } else {
            totalResult = postMapper.getAllCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postMapper.selectAllHot(page.getStartIndex(), pageSize));
        }
        return page;
    }

    @Override
    public Page<PostResult> getPosts(int curPage, int pageSize, String keyword) {
        Page<PostResult> page;
        int totalResult;
        if (keyword == null || keyword.isEmpty()) {
            totalResult = postMapper.getAllCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postMapper.selectAll(page.getStartIndex(), pageSize));
        } else {
            totalResult = postMapper.getCountByPostTitle(keyword);
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(postMapper.selectByPostTitle(page.getStartIndex(), pageSize, keyword));
        }
        return page;
    }

    @Override
    public Page<Section> getSections(int curPage, int pageSize, String sectionName) {
        Page<Section> page;
        int totalResult;
        if (sectionName == null || sectionName.isEmpty()) {
            totalResult = sectionMapper.getAllCount();
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(sectionMapper.selectAll(page.getStartIndex(), pageSize));

        } else {
            totalResult = sectionMapper.getCountBySectionName(sectionName);
            page = new Page<>(curPage, pageSize, totalResult);
            page.setList(sectionMapper.selectBySectionName(page.getStartIndex(), pageSize, sectionName));
        }
        return page;
    }

    @Override
    public Page<Section> getHotSections(int curPage, int pageSize) {
        int totalResult = sectionMapper.getAllCount();
        Page<Section> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(sectionMapper.selectAllHot(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<Audit> getAudits(int curPage, int pageSize) {
        int totalResult = auditMapper.getAllCount();
        Page<Audit> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(auditMapper.selectAll(page.getStartIndex(), pageSize));
        return page;
    }

    @Override
    public Page<CommentResult> getComments(int curPage, int pageSize, int postId) {
        int totalResult = commentMapper.getCountByPostIdCount(postId);
        Page<CommentResult> page = new Page<>(curPage, pageSize, totalResult);
        List<CommentResult> list;
        list = commentMapper.selectByPostId(page.getStartIndex(), pageSize, postId);
        page.setList(list);
        return page;
    }

    @Override
    public Page<ReplyResult> getReplies(int curPage, int pageSize, int commentId) {
        int totalResult = replyMapper.getCountByCommentIdCount(commentId);
        Page<ReplyResult> page = new Page<>(curPage, pageSize, totalResult);
        List<ReplyResult> list;
        list = replyMapper.selectByCommentId(page.getStartIndex(), pageSize, commentId);
        page.setList(list);
        return page;
    }

    @Override
    public Page<Section> getMasterSections(int curPage, int pageSize, int userId) {
        int totalResult = masterForSectionMapper.getCountbyUserId(userId);
        Page<Section> page = new Page<>(curPage, pageSize, totalResult);
        List<Section> list;
        list = masterForSectionMapper.selectByUserId(page.getStartIndex(), pageSize, userId);
        page.setList(list);
        return page;
    }
}
