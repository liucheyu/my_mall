package com.liucheyu.mymall.mallorder.dao;

import com.liucheyu.mymall.mallorder.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:43:51
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}