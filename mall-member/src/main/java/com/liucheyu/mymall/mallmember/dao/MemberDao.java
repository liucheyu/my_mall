package com.liucheyu.mymall.mallmember.dao;

import com.liucheyu.mymall.mallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:28:46
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
