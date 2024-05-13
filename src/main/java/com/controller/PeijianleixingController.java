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

import com.entity.PeijianleixingEntity;

import com.service.PeijianleixingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 配件类型
 * 后端接口
 * @author
 * @email
 * @date 2021-02-02
*/
@RestController
@Controller
@RequestMapping("/peijianleixing")
public class PeijianleixingController {
    private static final Logger logger = LoggerFactory.getLogger(PeijianleixingController.class);

    @Autowired
    private PeijianleixingService peijianleixingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = peijianleixingService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        PeijianleixingEntity peijianleixing = peijianleixingService.selectById(id);
        if(peijianleixing!=null){
            return R.ok().put("data", peijianleixing);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PeijianleixingEntity peijianleixing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<PeijianleixingEntity> queryWrapper = new EntityWrapper<PeijianleixingEntity>()
            .eq("pjname", peijianleixing.getPjname())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeijianleixingEntity peijianleixingEntity = peijianleixingService.selectOne(queryWrapper);
        if(peijianleixingEntity==null){
            peijianleixingService.insert(peijianleixing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeijianleixingEntity peijianleixing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<PeijianleixingEntity> queryWrapper = new EntityWrapper<PeijianleixingEntity>()
            .notIn("id",peijianleixing.getId())
            .eq("pjname", peijianleixing.getPjname())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeijianleixingEntity peijianleixingEntity = peijianleixingService.selectOne(queryWrapper);
        if(peijianleixingEntity==null){
            peijianleixingService.updateById(peijianleixing);//根据id更新
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
        peijianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

