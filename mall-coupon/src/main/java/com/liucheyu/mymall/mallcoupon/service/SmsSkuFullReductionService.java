package com.liucheyu.mymall.mallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.mymall.mallcoupon.entity.SmsSkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:10:36
 */
public interface SmsSkuFullReductionService extends IService<SmsSkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

