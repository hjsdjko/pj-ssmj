package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KehuxixniEntity;
import java.util.Map;

/**
 * 客户信息 服务类
 * @author 
 * @since 2021-02-02
 */
public interface KehuxixniService extends IService<KehuxixniEntity> {

     PageUtils queryPage(Map<String, Object> params);

}