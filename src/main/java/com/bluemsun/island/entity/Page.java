package com.bluemsun.island.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 页面实体类
 * @author: Windlinxy
 * @create: 2021-10-21 21:50
 **/
@Data
public class Page<T> {
    private String keyword;
    private int currentPage;
    private int pageSize;
    private int totalRecord;
    /**
     * 用于存放数据库中的数据结果集,使用泛型，增强通用性
     **/
    List<T> list;
    private int totalPage;
    private int startIndex;

    public Page(int currentPage, int pageSize, int totalRecord) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        // 总页数 = [总记录数/页面大小]，如果不是整除需要+1
        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = totalRecord / pageSize + 1;
        }
        //计算起始页号，（当前页号-1）*页面大小
        this.startIndex = currentPage * pageSize - pageSize;
    }
}
