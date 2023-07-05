package com.liucheyu.mymall.mallcoupon.dao;

import com.liucheyu.mymall.mallcoupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:21:22
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
