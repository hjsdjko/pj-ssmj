package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.PeijianxinxiEntity;

import com.service.PeijianxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 配件信息
 * 后端接口
 * @author
 * @email
 * @date 2021-02-02
*/
@RestController
@Controller
@RequestMapping("/peijianxinxi")
public class PeijianxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(PeijianxinxiController.class);

    @Autowired
    private PeijianxinxiService peijianxinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = peijianxinxiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        PeijianxinxiEntity peijianxinxi = peijianxinxiService.selectById(id);
        if(peijianxinxi!=null){
            return R.ok().put("data", peijianxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PeijianxinxiEntity peijianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<PeijianxinxiEntity> queryWrapper = new EntityWrapper<PeijianxinxiEntity>()
            .eq("name", peijianxinxi.getName());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeijianxinxiEntity peijianxinxiEntity = peijianxinxiService.selectOne(queryWrapper);
        peijianxinxi.setRepertory(0);
        peijianxinxi.setReplenish(0);
        peijianxinxi.setSell(0);
        if(peijianxinxiEntity==null){
            peijianxinxiService.insert(peijianxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeijianxinxiEntity peijianxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<PeijianxinxiEntity> queryWrapper = new EntityWrapper<PeijianxinxiEntity>()
            .notIn("id",peijianxinxi.getId());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeijianxinxiEntity peijianxinxiEntity = peijianxinxiService.selectOne(queryWrapper);
        if(peijianxinxiEntity==null){
            peijianxinxiService.updateById(peijianxinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        peijianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

