package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongyingshangxinxiEntity;
import java.util.Map;

/**
 * 供应商信息 服务类
 * @author 
 * @since 2021-02-02
 */
public interface GongyingshangxinxiService extends IService<GongyingshangxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}