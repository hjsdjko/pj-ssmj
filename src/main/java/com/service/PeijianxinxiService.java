package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeijianxinxiEntity;
import java.util.Map;

/**
 * 配件信息 服务类
 * @author 
 * @since 2021-02-02
 */
public interface PeijianxinxiService extends IService<PeijianxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}