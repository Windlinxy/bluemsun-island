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
     * @date 20:44 2021/10/22
     * @param curPage 当前页
     * @param  pageSize 页面大小
     * @return Page<User>
     **/
    Page<User> getUsers(int curPage, int pageSize);

    /**
     * 获得所有帖子
     *
     * @date 10:36 2021/10/23
     * @param curPage 当前页
     * @param  pageSize 页面显示数量
     * @return Page<Post>
     **/
    Page<PostResult> getPosts(int  curPage, int pageSize);

    Page<PostResult> getPosts(int  curPage, int pageSize,int sectionId);
    /**
     * 获得所有板块
     *
     * @date 0:29 2021/10/24
     * @param curPage 当前页数
     * @param pageSize 页面数据数量
     * @return Page<Section>
     **/
    Page<Section> getAllSections(int  curPage, int pageSize);

    Page<Audit> getAudits(int  curPage, int pageSize);
}
