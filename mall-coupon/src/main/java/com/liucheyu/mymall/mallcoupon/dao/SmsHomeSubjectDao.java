package com.liucheyu.mymall.mallcoupon.dao;

import com.liucheyu.mymall.mallcoupon.entity.SmsHomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:10:36
 */
@Mapper
public interface SmsHomeSubjectDao extends BaseMapper<SmsHomeSubjectEntity> {
	
}
