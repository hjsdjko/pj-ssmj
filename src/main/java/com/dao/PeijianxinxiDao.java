package com.dao;

import com.entity.PeijianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeijianxinxiView;

/**
 * 配件信息 Dao 接口
 *
 * @author 
 * @since 2021-02-02
 */
public interface PeijianxinxiDao extends BaseMapper<PeijianxinxiEntity> {

   List<PeijianxinxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
