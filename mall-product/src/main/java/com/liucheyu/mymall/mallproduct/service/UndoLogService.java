package com.liucheyu.mymall.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liucheyu.common.utils.PageUtils;
import com.liucheyu.mymall.mallproduct.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author liucheyu
 * @email liucheyu1987@gmail.com
 * @date 2023-07-05 11:04:57
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

