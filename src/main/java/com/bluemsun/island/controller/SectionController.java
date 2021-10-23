package com.bluemsun.island.controller;

import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Section;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.FileService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.SectionService;
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
        int userId = JwtUtil.getUserId(request.getHeader("Authorization"));
        section.setMasterId(userId);
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

    @GetMapping(
            value = "/sections",
            consumes = "application/json"
    )
    public Map<String, Object> getAllSections(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize){
        Map<String, Object> map = new HashMap<>(5);
        Page<Section> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getAllSections(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }
}
