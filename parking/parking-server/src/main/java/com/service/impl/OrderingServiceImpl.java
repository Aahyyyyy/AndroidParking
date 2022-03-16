package com.service.impl;

import com.pojo.Ordering;
import com.mapper.OrderingMapper;
import com.service.OrderingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Service
public class OrderingServiceImpl extends ServiceImpl<OrderingMapper, Ordering> implements OrderingService {

}
