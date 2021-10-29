package com.bluemsun.island.service;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.entity.User;

/**
 * @program: BulemsunIsland
 * @description: 分页服务接口
 * @author: Windlinxy
 * @create: 2021-10-21 20:40
 **/
public interface PageService {
    /**
     * 获得用户页面
     *
     * @param curPage  当前页
     * @param pageSize 页面大小
     * @return Page<User>
     * @date 20:44 2021/10/22
     **/
    Page<User> getUsers(int curPage, int pageSize);

    Page<User> getUsers(int curPage, int pageSize, String name);

    /**
     * 获得所有帖子
     *
     * @param curPage  当前页
     * @param pageSize 页面显示数量
     * @return Page<Post>
     * @date 10:36 2021/10/23
     **/
    Page<PostResult> getPosts(int curPage, int pageSize);

    Page<PostResult> getPosts(int curPage, int pageSize, int sectionId);

    Page<PostResult> getHotPosts(int curPage, int pageSize, int sectionId);

    /**
     * 获得所有板块
     *
     * @param curPage  当前页数
     * @param pageSize 页面数据数量
     * @return Page<Section>
     * @date 0:29 2021/10/24
     **/
    Page<Section> getSections(int curPage, int pageSize);

    Page<Section> getHotSections(int curPage, int pageSize);

    Page<Section> getSections(int curPage, int pageSize, String sectionName);

    Page<Audit> getAudits(int curPage, int pageSize);

}
