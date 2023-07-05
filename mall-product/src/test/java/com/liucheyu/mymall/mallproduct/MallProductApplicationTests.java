package com.liucheyu.mymall.mallproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liucheyu.mymall.mallproduct.entity.BrandEntity;
import com.liucheyu.mymall.mallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallProductApplicationTests {

	@Autowired
	BrandService brandService;

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

}
