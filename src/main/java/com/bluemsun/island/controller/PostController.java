package com.bluemsun.island.controller;

import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.FileService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.PostService;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 帖子
 * @author: Windlinxy
 * @create: 2021-10-21 20:34
 **/
@RestController
public class PostController {
    private int jud = 0;
    @Autowired
    private FileService fileService;
    @Autowired
    private PostService postService;
    @Autowired
    private PageService pageService;

    @PostMapping(
            value = "/post/images",
            consumes = "multipart/form-data",
            produces = "application/json"
    )
    public Map<String, Object> getImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
        Map<String, Object> map = new HashMap<>(4);
        System.out.println("=======================================");
        String folderString = "images";
        String serverPath = request.getServletContext().getRealPath(folderString);
        String filename = fileService.fileStore(file, serverPath);
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/" + folderString + "/"
                + filename;

        map.put("status", ReturnCode.SUCCESS.getCode());
        map.put("imageUrl", projectServerPath);
        return map;
    }

    @PostMapping(
            value = "/posts",
            consumes = "application/json",
            produces = "application/json"
    )
    public Map<String,Object> addPost(@RequestBody Post post){
        Map<String, Object> map = new HashMap<>(4);
        jud = postService.addPost(post);
        if (jud == ReturnCode.OP_SUCCESS) {
            map.put("post", post);
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else if (jud == ReturnCode.OP_UNKNOWN_ERROR) {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    @GetMapping(
            value = "/posts",
            produces = "application/json"
    )
    public Map<String,Object> getAllPosts(@RequestParam("cur") int currentPage, @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(currentPage+"==="+pageSize);
        Page<Post> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getPosts(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }
}
