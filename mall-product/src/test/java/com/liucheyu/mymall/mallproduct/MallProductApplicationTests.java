package com.liucheyu.mymall.mallproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liucheyu.mymall.mallproduct.entity.BrandEntity;
import com.liucheyu.mymall.mallproduct.service.BrandService;
import com.liucheyu.mymall.mallproduct.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;

    @Test
    void contextLoads() {
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(13L);
//		brandEntity.setDescript("ASUS");
//		brandEntity.setName("Asus");
//		brandService.save(brandEntity);
        //brandService.updateById(brandEntity);
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 13L));
        list.forEach(item -> System.out.println(item));
    }

    @Test
    void testCategoryPath() {
        Long[] categoryPath = categoryService.getCategoryPath(225L);
        //System.out.println(categoryPath);
        log.info("分類id路徑: {}", Arrays.asList(categoryPath));

    }

}
