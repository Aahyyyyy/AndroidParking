package com.controller;


import com.pojo.Owner;
import com.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/doLogin")
    public boolean doLogin(@RequestParam(required = false) Owner owner) {
        System.out.println(owner);
        return ownerService.save(owner);
    }
}
