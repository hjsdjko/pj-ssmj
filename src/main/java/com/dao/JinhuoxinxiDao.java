package com.dao;

import com.entity.JinhuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinhuoxinxiView;

/**
 * 进货信息 Dao 接口
 *
 * @author 
 * @since 2021-02-02
 */
public interface JinhuoxinxiDao extends BaseMapper<JinhuoxinxiEntity> {

   List<JinhuoxinxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
