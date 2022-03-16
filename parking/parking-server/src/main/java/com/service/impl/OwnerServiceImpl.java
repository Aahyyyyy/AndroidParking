package com.service.impl;

import com.pojo.Owner;
import com.mapper.OwnerMapper;
import com.service.OwnerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业主表 服务实现类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;

}
