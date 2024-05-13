package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.PeijianleixingDao;
import com.entity.PeijianleixingEntity;
import com.service.PeijianleixingService;
import com.entity.view.PeijianleixingView;

/**
 * 配件类型 服务实现类
 * @author 
 * @since 2021-02-02
 */
@Service("peijianleixingService")
@Transactional
public class PeijianleixingServiceImpl extends ServiceImpl<PeijianleixingDao, PeijianleixingEntity> implements PeijianleixingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<PeijianleixingView> page =new Query<PeijianleixingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
