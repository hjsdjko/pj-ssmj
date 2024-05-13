package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshouxinxiEntity;
import java.util.Map;

/**
 * 销售信息 服务类
 * @author 
 * @since 2021-02-02
 */
public interface XiaoshouxinxiService extends IService<XiaoshouxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}