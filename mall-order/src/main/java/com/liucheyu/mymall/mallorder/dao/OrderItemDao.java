package com.liucheyu.mymall.mallorder.dao;

import com.liucheyu.mymall.mallorder.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:43:52
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
