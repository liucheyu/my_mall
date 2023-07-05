package com.liucheyu.mymall.mallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.mymall.mallcoupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:21:22
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

