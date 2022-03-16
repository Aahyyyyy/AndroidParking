package com.service.impl;

import com.pojo.Community;
import com.mapper.CommunityMapper;
import com.service.CommunityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 楼盘 服务实现类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<Community> getAllCom() {
        return communityMapper.getAllCom();
    }
}
