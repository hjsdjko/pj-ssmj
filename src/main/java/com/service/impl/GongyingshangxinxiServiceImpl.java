package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.GongyingshangxinxiDao;
import com.entity.GongyingshangxinxiEntity;
import com.service.GongyingshangxinxiService;
import com.entity.view.GongyingshangxinxiView;

/**
 * 供应商信息 服务实现类
 * @author 
 * @since 2021-02-02
 */
@Service("gongyingshangxinxiService")
@Transactional
public class GongyingshangxinxiServiceImpl extends ServiceImpl<GongyingshangxinxiDao, GongyingshangxinxiEntity> implements GongyingshangxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GongyingshangxinxiView> page =new Query<GongyingshangxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
