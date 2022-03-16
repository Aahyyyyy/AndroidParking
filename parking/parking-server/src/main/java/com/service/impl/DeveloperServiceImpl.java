package com.service.impl;

import com.pojo.Developer;
import com.mapper.DeveloperMapper;
import com.service.DeveloperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目公司 服务实现类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Service
public class DeveloperServiceImpl extends ServiceImpl<DeveloperMapper, Developer> implements DeveloperService {

}
