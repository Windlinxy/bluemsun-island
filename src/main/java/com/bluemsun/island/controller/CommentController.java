package com.bluemsun.island.controller;

import com.bluemsun.island.dto.CommentResult;
import com.bluemsun.island.dto.JsonResult;
import com.bluemsun.island.dto.ReplyResult;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Reply;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.CommentService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.ReplyService;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private CommentService commentService;
    @Resource
    private PageService pageService;
    @Resource
    private ReplyService replyService;

    @PostMapping("/:{postId}/comments")
    public JsonResult<Comment> addComment(@PathVariable("postId") int postId, HttpServletRequest request, @RequestBody Comment comment){
        Map<String,Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        comment.setCommentUserId(userId);
        comment.setCommentPostId(postId);
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
        Page<CommentResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getComments(currentPage, pageSize,postId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @PostMapping("/:{commentId}/replies/:{repliedUserId}")
    public JsonResult<Reply> addReply(@PathVariable("commentId") int commentId,@PathVariable("repliedUserId") int repliedUserId, HttpServletRequest request, @RequestBody Reply reply){
        Map<String,Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        reply.setReplyUserId(userId);
        reply.setRepliedCommentId(commentId);
        reply.setRepliedId(repliedUserId);
        jud = replyService.addReply(reply);
        if (jud == ReturnCode.OP_SUCCESS) {
            return new JsonResult<Reply>().ok(reply);
        } else{
            return new JsonResult<Reply>().fail();
        }
    }

    @GetMapping("/:{commentId}/replies")
    public Map<String,Object> getReplies(
            @PathVariable("commentId")int commentId,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize){
        Map<String,Object> map = new HashMap<>(5);
        Page<ReplyResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getReplies(currentPage, pageSize,commentId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @DeleteMapping("/comments/{id}")
    public JsonResult<Object> deleteComment(@PathVariable("id")int commentId){
        jud = commentService.deleteIt(commentId);
        if (jud == ReturnCode.OP_SUCCESS) {
            return new JsonResult<>().ok();
        } else {
            return new JsonResult<>().fail();
        }
    }

    @DeleteMapping("/replies/{id}")
    public JsonResult<Object> deleteReply(@PathVariable("id")int replyId){
        jud = replyService.deleteIt(replyId);
        if (jud == ReturnCode.OP_SUCCESS) {
            return new JsonResult<>().ok();
        } else {
            return new JsonResult<>().fail();
        }
    }


}
