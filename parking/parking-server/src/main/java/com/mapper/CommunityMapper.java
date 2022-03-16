package com.mapper;

import com.pojo.Community;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 楼盘 Mapper 接口
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
public interface CommunityMapper extends BaseMapper<Community> {
    @Select("SELECT * FROM community")
    public List<Community> getAllCom();
}
