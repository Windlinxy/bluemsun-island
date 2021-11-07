package com.bluemsun.island.controller;

import com.bluemsun.island.dto.JsonResult;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.dto.UserLikePost;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.FileService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.PostService;
import com.bluemsun.island.util.JwtUtil;
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
@RequestMapping(produces = "application/json")
public class PostController {
    private int jud = 0;
    @Autowired
    private FileService fileService;
    @Autowired
    private PostService postService;
    @Autowired
    private PageService pageService;

    @PostMapping(value = "/post/images", consumes = "multipart/form-data")
    public Map<String, Object> getImage(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
        Map<String, Object> map = new HashMap<>(4);
        System.out.println("=======================================");
        String folderString = "images";
        String serverPath = request.getServletContext().getRealPath(folderString);
        String filename = fileService.fileStore(file, serverPath);
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/" + folderString + "/"
                + filename;
        projectServerPath = projectServerPath.replace("bluemsun_island/","");
        map.put("status", ReturnCode.SUCCESS.getCode());
        map.put("imageUrl", projectServerPath);
        return map;
    }

    @PostMapping(value = "/:{secId}/posts", consumes = "application/json")
    public Map<String, Object> addPost(
            @PathVariable("secId") int sectionId,
            HttpServletRequest request,
            @RequestBody Post post) {
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        post.setSectionId(sectionId);
        post.setUserId(userId);
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

    @GetMapping("/posts")
    public Map<String, Object> getAllPosts(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        System.out.println(currentPage + "===" + pageSize);
        Page<PostResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getPosts(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @GetMapping("/posts/{postId}")
    public Map<String, Object> getAllPosts(
            @PathVariable("postId") int postId,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        PostResult postResult = postService.getPost(postId,userId);
        if(postResult !=null){
            if(userId == postResult.getUserId()){
                map.put("master",1);
            }else {
                map.put("master",0);
            }
            if(postService.isLike(new UserLikePost(userId,postId))){
                map.put("like",1);
            }else {
                map.put("like",0);
            }
            ResponseUtil.returnSuccess(map);
            map.put("post",postResult);
        }else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    @GetMapping( "/hotposts")
    public Map<String, Object> getHotPosts(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<PostResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getHotPosts(currentPage, pageSize,0);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @PatchMapping("/posts/:{postId}/{sta}")
    public Map<String,Object> changePostStatus(@PathVariable("postId")int id,@PathVariable("sta")int status){
        Map<String,Object> map = new HashMap<>();
        jud = postService.changePost(new Post(id,status));
        if(jud== ReturnCode.OP_SUCCESS){
            ResponseUtil.returnSuccess(map);
        }else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

//    @PatchMapping("/posts/:{postId}/thumbs-up")
//    public Map<String,Object> giveLive(){
//        Map<String,Object> map = new HashMap<>(5);
//
//    }

    @DeleteMapping("/{sectionId}/posts/{postId}")
    public JsonResult<Object> deletePosts(@PathVariable("sectionId")int sectionId,@PathVariable("postId")int postId){
        jud = postService.deletePost(postId,sectionId);
        System.out.println("==========="+jud+"====================================\n\n");
        if (jud == ReturnCode.OP_SUCCESS) {

           return new JsonResult<>().ok();
        } else {
            return new JsonResult<>().fail();
        }
    }

    @GetMapping("/posts/title/:{key}")
    public Map<String, Object> getAllPosts(@PathVariable("key")String keyword,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        System.out.println(currentPage + "===" + pageSize);
        Page<PostResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getPosts(currentPage, pageSize,keyword);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @PatchMapping("/{postId}/likes/{likeSta}")
    public Map<String,Object> userLikePost(
            HttpServletRequest request,
            @PathVariable("postId")int postId,
            @PathVariable("likeSta") boolean likeJud
    ){
        Map<String, Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        jud = postService.userLikeIt(userId,postId,likeJud);
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else if (jud == ReturnCode.OP_UNKNOWN_ERROR) {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }


}
