package com.liucheyu.mymall.mallproduct.dao;

import com.liucheyu.mymall.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 11:04:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
