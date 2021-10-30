package com.bluemsun.island.controller;

import com.bluemsun.island.dto.JsonResult;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.CommentService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 评论
 * @author: Windlinxy
 * @create: 2021-10-30 14:59
 **/
@RestController
@RequestMapping(produces = "application/json")
public class CommentController {
    private int jud = 0;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PageService pageService;

    @PostMapping("/:{postId}/comments")
    public JsonResult<Comment> addComment(@PathVariable("postId") int postId, HttpServletRequest request, @RequestBody Comment comment){
        Map<String,Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        comment.setCommentUserId(userId);
        comment.setCommentPostId(postId);
        System.out.println(comment);
        jud = commentService.addComment(comment);
        if (jud == ReturnCode.OP_SUCCESS) {
            return new JsonResult<Comment>().ok(comment);
        } else{
            return new JsonResult<Comment>().fail();
        }
    }

    @GetMapping("/:{postId}/comments")
    public Map<String,Object> getComments(
            @PathVariable("postId") int postId,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize){
        Map<String,Object> map = new HashMap<>(5);
        Page<Comment> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getComment(currentPage, pageSize,postId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }
}
