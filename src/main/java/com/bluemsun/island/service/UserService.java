package com.bluemsun.island.service;

import com.bluemsun.island.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户服务借口
 *
 * @program: BulemsunIsland
 * @description: 用户服务
 * @author: Windlinxy
 * @create: 2021-10-05 11:31
 **/
public interface UserService {

    /**
     * 增加用户服务
     *
     * @param user 用户
     * @return 返回状态码
     */
    int addUser(User user);

    /**
     * 判断是否是已注册用户
     *
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 用户信息
     * @date 17:56 2021/10/17
     **/
    User isUser(User user);

    /**
     * 文件存储服务
     *
     * @param serverPath 绝对路径
     * @return java.lang.String 文件web中路径
     * @date 20:11 2021/10/17
     **/
    String fileStore(MultipartFile file, String serverPath);

    /**
     * 改变用户url
     *
     * @param token    token令牌
     * @param imageUrl 图片url
     * @return int
     * @date 18:03 2021/10/19
     **/
    int changeImageUrl(String token, String imageUrl);
}
