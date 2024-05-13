package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeijianleixingEntity;
import java.util.Map;

/**
 * 配件类型 服务类
 * @author 
 * @since 2021-02-02
 */
public interface PeijianleixingService extends IService<PeijianleixingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}