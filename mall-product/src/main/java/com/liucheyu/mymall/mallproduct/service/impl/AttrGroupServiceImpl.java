package com.liucheyu.mymall.mallproduct.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.common.utils.Query;

import com.liucheyu.mymall.mallproduct.dao.AttrGroupDao;
import com.liucheyu.mymall.mallproduct.entity.AttrGroupEntity;
import com.liucheyu.mymall.mallproduct.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long categoryId) {
        PageUtils pageUtils;
        IPage<AttrGroupEntity> page;

        if (categoryId == 0L) {
            page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>()
            );
        } else {
            //搜尋框的值
            String key = (String) params.get("key");

            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", categoryId);
            if (StringUtils.hasLength(key)) {
                wrapper.and(obj -> {
                    obj.eq("attr_group_id", key).or().like("attr_group_name", key);
                });
            }

            page = this.page(
                    new Query<AttrGroupEntity>().getPage(params), wrapper);
        }

        pageUtils = new PageUtils(page);

        return pageUtils;
    }

}