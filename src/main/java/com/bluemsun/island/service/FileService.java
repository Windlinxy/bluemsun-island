package com.bluemsun.island.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: BulemsunIsland
 * @description: 文件服务接口
 * @author: Windlinxy
 * @create: 2021-10-20 17:44
 **/
public interface FileService {
    /**
     * 文件存储服务
     *
     * @param serverPath 绝对路径
     * @param file       上传文件
     * @return java.lang.String 文件web中路径
     * @date 20:11 2021/10/17
     **/
    String fileStore(MultipartFile file, String serverPath);
}
