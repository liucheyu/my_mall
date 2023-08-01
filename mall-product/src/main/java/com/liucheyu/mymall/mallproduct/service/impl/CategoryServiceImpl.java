package com.liucheyu.mymall.mallproduct.service.impl;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.common.utils.Query;

import com.liucheyu.mymall.mallproduct.dao.CategoryDao;
import com.liucheyu.mymall.mallproduct.entity.CategoryEntity;
import com.liucheyu.mymall.mallproduct.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listTree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> collect = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, categoryEntities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 檢查id是否有被其他菜單引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] getCategoryPath(Long catelogId) {
        ArrayList<Long> path = new ArrayList<>();
        List<Long> categoryParentPath = getCategoryParentPath(catelogId, path);
        Collections.reverse(categoryParentPath);

        return categoryParentPath.toArray(new Long[categoryParentPath.size()]);
    }

    private List<Long> getCategoryParentPath(Long catelogId, List<Long> path) {
        path.add(catelogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        if(categoryEntity.getParentCid() != 0) {
            getCategoryParentPath(categoryEntity.getParentCid(), path);
        }

        return path;
    }

    private List<CategoryEntity> getChildren(CategoryEntity current, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().equals(current.getCatId()))
                .map(menu -> {
                    menu.setChildren(getChildren(menu, all));
                    return menu;
                })
                .sorted((menu1, menu2) -> (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort()))
                .collect(Collectors.toList());
        return children;
    }

}