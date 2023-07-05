package com.liucheyu.mymall.mallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.mymall.mallcoupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:21:21
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

