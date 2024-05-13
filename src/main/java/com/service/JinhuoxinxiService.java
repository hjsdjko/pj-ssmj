package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinhuoxinxiEntity;
import java.util.Map;

/**
 * 进货信息 服务类
 * @author 
 * @since 2021-02-02
 */
public interface JinhuoxinxiService extends IService<JinhuoxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}