package com.bluemsun.island.controller;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.*;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.RedisUtil;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 板块
 * @author: Windlinxy
 * @create: 2021-10-22 19:33
 **/
@RestController
@RequestMapping(produces = "application/json")
public class SectionController {
    private int jud;

    private SectionService sectionService;

    private FileService fileService;

    private PageService pageService;

    private AuditService auditService;
    
    private UserService userService;

    @Autowired
    public void setSectionService(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }

    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 上传版图
     **/
    @PostMapping(value = "/sections/portraits", consumes = "multipart/form-data")
    public Map<String, Object> uploadHeadPortrait(
            HttpServletRequest request,
            @RequestParam("portrait") MultipartFile file) {
        Map<String, Object> map = new HashMap<>(5);
        System.out.println(request.getHeader("ContentType"));
        String folderString = "sections_portraits";
        String serverPath = request.getServletContext().getRealPath(folderString);
        String filename = fileService.fileStore(file, serverPath);
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/" + folderString + "/"
                + filename;
        projectServerPath = projectServerPath.replace("bluemsun_island/", "");
        ResponseUtil.returnSuccess(map);
        map.put("imageUrl", projectServerPath);
        return map;
    }

    @PostMapping(value = "/sections", consumes = "application/json")
    public Map<String, Object> addSection(@RequestBody Section section) {
        Map<String, Object> map = new HashMap<>(5);
        jud = sectionService.addSection(section);
        if (jud == ReturnCode.OP_SUCCESS) {
            map.put("section", section);
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else if (jud == ReturnCode.OP_UNKNOWN_ERROR) {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    /**
     * 申请成为版主
     **/
    @PostMapping(value = "/sections/audit", consumes = "application/json")
    public Map<String, Object> beSectionMaster(
            HttpServletRequest request,
            @RequestBody Section section) {
        Map<String, Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        RedisUtil.getUser(userId);
        String content = "用户【" + RedisUtil.getUser(userId).getUsername() + "】申请成为【" + section.getSectionName() + "】的版主";
        Audit audit = new Audit(content, userId, section.getDescription(), section.getImageUrl(), section.getSectionName());
        jud = auditService.addAudit(audit);
        if (jud == ReturnCode.OP_SUCCESS) {
            map.put("audit", audit);
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else if (jud == ReturnCode.OP_UNKNOWN_ERROR) {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    /**
     * 获取所有板块
     **/
    @GetMapping("/sections")
    public Map<String, Object> getAllSections(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getSections(currentPage, pageSize, null);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * 热门板块
     **/
    @GetMapping("/hotsections")
    public Map<String, Object> getAllHotSections(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getHotSections(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * id获取板块
     **/
    @GetMapping("/sections/:{secId}")
    public Map<String, Object> getSection(HttpServletRequest request, @PathVariable("secId") int sectionId) {
        Map<String, Object> map = new HashMap<>(7);
        Section section = sectionService.getSection(sectionId);
        if (section != null) {
            if (userService.judUserForSectionMaster(JwtUtil.getUserId(request.getHeader("Authorization")), section.getSectionName())) {
                map.put("master", 1);
            } else {
                map.put("master", 0);
            }
            ResponseUtil.returnSuccess(map);
            map.put("section", section);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 板块帖子
     **/
    @GetMapping("/sections/:{secId}/posts")
    public Map<String, Object> getPostInSection(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize,
            @PathVariable("secId") int sectionId) {
        Map<String, Object> map = new HashMap<>(5);
        Page<PostResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getPosts(currentPage, pageSize, sectionId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * 板块内热门帖
     **/
    @GetMapping("/sections/:{secId}/hotposts")
    public Map<String, Object> getHotPostInSection(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize,
            @PathVariable("secId") int sectionId) {
        Map<String, Object> map = new HashMap<>(5);
        Page<PostResult> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getHotPosts(currentPage, pageSize, sectionId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    /**
     * 搜索板块
     **/
    @GetMapping("/sections/{name}")
    public Map<String, Object> sectionList(
            @PathVariable("name") String sectionName,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            System.out.println(sectionName);
            page = pageService.getSections(currentPage, pageSize, sectionName);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @GetMapping("/master_sections")
    public Map<String, Object> getMySection(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize,
            HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(5);
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getMasterSections(currentPage, pageSize, userId);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }
}
