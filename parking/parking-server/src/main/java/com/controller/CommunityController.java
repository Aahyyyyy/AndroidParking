package com.controller;


import com.pojo.Community;
import com.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 楼盘 前端控制器
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("/getAllCom")
    public List<Community> getAllCom() {
        return communityService.getAllCom();
    }


}
