package com.service;

import com.pojo.Community;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 楼盘 服务类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
public interface CommunityService extends IService<Community> {
    List<Community> getAllCom();
}
