package com.dao;

import com.entity.KehuxixniEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KehuxixniView;

/**
 * 客户信息 Dao 接口
 *
 * @author 
 * @since 2021-02-02
 */
public interface KehuxixniDao extends BaseMapper<KehuxixniEntity> {

   List<KehuxixniView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
