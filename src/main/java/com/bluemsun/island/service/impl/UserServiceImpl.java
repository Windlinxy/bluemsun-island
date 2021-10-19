package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.UserService;
import com.bluemsun.island.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 用户服务接口实现类
 *
 * @program: BulemsunIsland
 * @description: 用户服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
public class UserServiceImpl implements UserService {
    private int operationJudCode = 0;
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        operationJudCode = userDao.insertUser(user);
        return operationJudCode;
    }

    @Override
    public User isUser(User user) {
        User userInDatabase;
        userInDatabase = userDao.queryOneUser(user);
        return userInDatabase;
    }

    @Override
    public String fileStore(MultipartFile file, String serverPath) {
        String fileParts;
        String permanentFileParts;
        // 获取上传的文件名扩展名
        String disposition = file.getOriginalFilename();
        System.out.println(disposition);
        String suffix = disposition.substring(disposition.lastIndexOf("."));

        // 随机的生成uuid，作为文件名的一部分。 加上刚才获取到的后缀作为最终文件名。
        String uuid = UUID.randomUUID() + "";
        String filename = uuid.substring(0, 13) + suffix;
        System.out.println("-------------------------------------");
        System.out.println("文件名： " + filename);
        System.out.println("文件绝对路径： " + serverPath);
        System.out.println("______________________________________");

        //不存在文件夹则新建一个
        File fileDisk = new File(serverPath);
        if (!fileDisk.exists()) {
            fileDisk.mkdir();
        }
        //处理windows与linux路径'\''/'问题
        if (serverPath.contains("/")) {
            fileParts = serverPath + "/" + filename;
        } else {
            fileParts = serverPath + "\\" + filename;
        }
        if (fileParts.contains("/bluemsun_island")) {
            permanentFileParts = fileParts.replace("/bluemsun_island", "");
        } else if (fileParts.contains("\\bluemsun_island")) {
            permanentFileParts = fileParts.replace("\\bluemsun_island", "");
        } else {
            permanentFileParts = "";
        }
        System.out.println("存储路径：" + fileParts);
        System.out.println("存储永久路径：" + permanentFileParts);

        try {
            file.transferTo(new File(fileParts));
            file.transferTo(new File(permanentFileParts));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return filename;
    }

    @Override
    public int changeImageUrl(String token, String imageUrl) {
        int id = JwtUtil.getUserId(token);
        operationJudCode = userDao.updateImageUrl(new User(id, imageUrl));
        return operationJudCode;
    }
}
