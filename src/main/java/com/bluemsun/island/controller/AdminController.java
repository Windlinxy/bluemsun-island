package com.bluemsun.island.controller;

import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.AdminService;
import com.bluemsun.island.service.AuditService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 管理员
 * @author: Windlinxy
 * @create: 2021-10-21 20:33
 **/
@RestController
@RequestMapping(
        produces = "application/json"
)
public class AdminController {
    private int jud = 0;
    @Autowired
    private PageService pageService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AuditService auditService;

    /**
     * 获取用户列表
     **/
    @GetMapping(value = "/users")
    public Map<String, Object> userList(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<User> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getUsers(currentPage, pageSize, null);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * Id删除用户
     **/
    @DeleteMapping(value = "/users/:{id}")
    public Map<String, Object> deleteUser(@PathVariable("id") int userId) {
        Map<String, Object> map = new HashMap<>(3);
        jud = adminService.deleteUser(userId);
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    /**
     * 用户封禁与解禁
     **/
    @PatchMapping("users/:{id}/:{sta}")
    public Map<String, Object> banUser(@PathVariable("id") int userId, @PathVariable("sta") int status) {
        Map<String, Object> map = new HashMap<>(5);
        jud = adminService.changeUserStatus(userId, status);
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
            map.put("userStatus", status);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 获取用户信息
     **/
    @GetMapping("users/{id}")
    public Map<String, Object> getUserInfo(@PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<>(5);
        User userInfo = adminService.getUserInfo(id);
        if (userInfo != null) {
            ResponseUtil.returnSuccess(map);
            map.put("user", userInfo);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 搜索用户
     **/
    @GetMapping("/users/:{name}")
    public Map<String, Object> userList(
            @PathVariable("name") String username,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<User> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getUsers(currentPage, pageSize, username);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * 获取审核
     **/
    @GetMapping("/audits")
    public Map<String, Object> getAudits(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<Audit> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getAudits(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * 进行审核（通过，拒绝）
     **/
    @PatchMapping("/audits/:{id}/{sta}")
    public Map<String, Object> agreeOrRejectAudit(
            @PathVariable("id") int auditId,
            @PathVariable("sta") int status) {
        Map<String, Object> map = new HashMap<>(5);
        if (status == 1) {
            jud = auditService.agreeAudit(auditId, status);
        } else if (status == -1) {
            jud = auditService.updateAudit(new Audit(auditId, status));
        }else {
            jud = 0;
        }
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 删除审核
     **/
    @DeleteMapping("/audits/:{id}")
    public Map<String, Object> deleteAudit(@PathVariable("id") int auditId) {
        Map<String, Object> map = new HashMap<>(5);
        jud = auditService.deleteAudit(auditId);
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    /**
     * 冻结板块
     **/
    @PatchMapping("sections/:{id}/:{sta}")
    public Map<String, Object> banSection(@PathVariable("id") int sectionId, @PathVariable("sta") int status) {
        Map<String, Object> map = new HashMap<>(5);
        jud = adminService.changeSectionStatus(sectionId, status);
        if (jud == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
            map.put("sectionStatus", status);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }
}
