package com.bluemsun.island.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 版主帖
 * @author: Windlinxy
 * @create: 2021-10-29 08:28
 **/
@RestController
@RequestMapping(produces = "application/json")
public class SectionMasterController {
    @GetMapping(
            value = "/:{userId}/section"
    )
    public Map<String,Object> mySection(@PathVariable("userId")int userId) {
        Map<String,Object> map = new HashMap<>();

        return map;
    }
}
