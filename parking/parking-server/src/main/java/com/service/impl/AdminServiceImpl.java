package com.service.impl;

import com.pojo.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台管理人员 服务实现类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
