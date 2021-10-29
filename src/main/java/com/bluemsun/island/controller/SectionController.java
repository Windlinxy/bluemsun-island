package com.bluemsun.island.controller;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Audit;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.AuditService;
import com.bluemsun.island.service.FileService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.SectionService;
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
    @Autowired
    private SectionService sectionService;
    @Autowired
    private FileService fileService;
    @Autowired
    private PageService pageService;
    @Autowired
    private AuditService auditService;

    @PostMapping(
            value = "/sections/portraits",
            consumes = "multipart/form-data")
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

        ResponseUtil.returnSuccess(map);
        map.put("imageUrl", projectServerPath);
        return map;
    }

    @PostMapping(
            value = "/sections",
            consumes = "application/json"
    )
    public Map<String, Object> addSection(
            HttpServletRequest request,
            @RequestBody Section section) {
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

    @PostMapping(
            value = "/sections/audit",
            consumes = "application/json"
    )
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

    @GetMapping(
            value = "/sections"
    )
    public Map<String, Object> getAllSections(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>(5);
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getSections(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @GetMapping(
            value = "/hotsections"
    )
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

    @GetMapping(
            value = "/sections/:{secId}"
    )
    public Map<String, Object> getSection(@PathVariable("secId") int sectionId) {
        Map<String, Object> map = new HashMap<>(5);
        Section section = sectionService.getSection(sectionId);
        if (section != null) {
            ResponseUtil.returnSuccess(map);
            map.put("section", section);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    @GetMapping(
            value = "/sections/:{secId}/posts"
    )
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

    @GetMapping(
            value = "/sections/:{secId}/hotposts"
    )
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

    @GetMapping(
            value = "/sections/{name}"
    )
    public Map<String, Object> sectionList(
            @PathVariable("name") String sectionName,
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize
    ) {
        Map<String, Object> map = new HashMap<>();
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
}
