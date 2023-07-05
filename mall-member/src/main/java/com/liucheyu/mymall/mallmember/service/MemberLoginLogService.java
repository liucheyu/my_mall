package com.liucheyu.mymall.mallmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.mymall.mallmember.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 13:28:46
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

