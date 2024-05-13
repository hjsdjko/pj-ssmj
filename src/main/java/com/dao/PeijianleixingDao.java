package com.dao;

import com.entity.PeijianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeijianleixingView;

/**
 * 配件类型 Dao 接口
 *
 * @author 
 * @since 2021-02-02
 */
public interface PeijianleixingDao extends BaseMapper<PeijianleixingEntity> {

   List<PeijianleixingView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
