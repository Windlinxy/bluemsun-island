package com.bluemsun.island.service.impl;

import com.bluemsun.island.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件服务接口实现类
 *
 * @program: BulemsunIsland
 * @description: 文件服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-20 17:44
 **/
@Slf4j
public class FileServiceImpl implements FileService {
    @Override
    public String fileStore(MultipartFile file, String serverPath) {
        String fileParts;
        String permanentFileParts;
        String separator = "/";
        String windowsProjectName = "\\bluemsun_island";
        String linuxProjectName = "/bluemsun_island";
        // 获取上传的文件名扩展名
        String disposition = file.getOriginalFilename();
        System.out.println(disposition);
        String suffix;
        if (disposition != null) {
            suffix = disposition.substring(disposition.lastIndexOf("."));
        } else {
            suffix = "";
        }
        File fileDisk = new File(serverPath);

        if(!fileDisk.exists()){
            fileDisk.mkdir();
        }

        // 随机的生成uuid，作为文件名的一部分。 加上刚才获取到的后缀作为最终文件名。
        String uuid = UUID.randomUUID() + "";
        String filename = uuid.substring(0, 13) + suffix;
//        System.out.println("-------------------------------------");
//        System.out.println("文件名： " + filename);
//        System.out.println("文件绝对路径： " + serverPath);
//        System.out.println("______________________________________");

        //处理windows与linux路径'\''/'问题
        if (serverPath.contains(separator)) {
            fileParts = serverPath + "/" + filename;
        } else {
            fileParts = serverPath + "\\" + filename;
        }
        if (fileParts.contains(windowsProjectName)) {
            permanentFileParts = fileParts.replace(windowsProjectName, "");
        } else if (fileParts.contains(linuxProjectName)) {
            permanentFileParts = fileParts.replace(linuxProjectName, "");
        } else {
            permanentFileParts = "";
        }
        System.out.println();
        System.out.println("存储永久路径：" + permanentFileParts);
        log.info("存储路径：" + fileParts);

        try {
            //file.transferTo(new File(fileParts));
            file.transferTo(new File(permanentFileParts));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return filename;
    }
}
