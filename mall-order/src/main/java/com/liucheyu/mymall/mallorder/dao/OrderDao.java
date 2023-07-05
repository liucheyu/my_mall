package com.liucheyu.mymall.mallorder.dao;

import com.liucheyu.mymall.mallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:43:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
