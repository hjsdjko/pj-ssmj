package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.PeijianxinxiDao;
import com.entity.PeijianxinxiEntity;
import com.service.PeijianxinxiService;
import com.entity.view.PeijianxinxiView;

/**
 * 配件信息 服务实现类
 * @author 
 * @since 2021-02-02
 */
@Service("peijianxinxiService")
@Transactional
public class PeijianxinxiServiceImpl extends ServiceImpl<PeijianxinxiDao, PeijianxinxiEntity> implements PeijianxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<PeijianxinxiView> page =new Query<PeijianxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
