package com.liucheyu.mymall.mallmember.feign;

import com.liucheyu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mall-coupon")
public interface CouponFeignService {

    @RequestMapping("/mallcoupon/coupon/member/coupon")
    public R memberCoupons();
}
