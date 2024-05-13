package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.PeijianxinxiEntity;
import com.service.PeijianxinxiService;
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

import com.entity.XiaoshouxinxiEntity;

import com.service.XiaoshouxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 销售信息
 * 后端接口
 * @author
 * @email
 * @date 2021-02-02
*/
@RestController
@Controller
@RequestMapping("/xiaoshouxinxi")
public class XiaoshouxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoshouxinxiController.class);

    @Autowired
    private XiaoshouxinxiService xiaoshouxinxiService;

    @Autowired
    private PeijianxinxiService peijianxinxiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("员工")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = xiaoshouxinxiService.queryPage(params);
        }else{
            page = xiaoshouxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        XiaoshouxinxiEntity xiaoshouxinxi = xiaoshouxinxiService.selectById(id);
        if(xiaoshouxinxi!=null){
            return R.ok().put("data", xiaoshouxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoshouxinxiEntity xiaoshouxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<XiaoshouxinxiEntity> queryWrapper = new EntityWrapper<XiaoshouxinxiEntity>()
            .eq("numbered", xiaoshouxinxi.getNumbered());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshouxinxiEntity xiaoshouxinxiEntity = xiaoshouxinxiService.selectOne(queryWrapper);
        xiaoshouxinxi.setNumbered(String.valueOf(new Date().getTime()));
        PeijianxinxiEntity peijian = peijianxinxiService.selectOne(new EntityWrapper<PeijianxinxiEntity>().eq("name", xiaoshouxinxi.getName()));
        if(peijian == null){
            return R.error(511,"配件仓库暂时没有这个配件商品，请输入正确后再出售");
        }
        xiaoshouxinxi.setCreateTime(new Date());
        if(peijian.getSell()==null){
            peijian.setSell(0);
        }
        if(xiaoshouxinxi.getSell()==null){
            return R.error("请输入出售数量");
        }
        int sell = peijian.getRepertory() - xiaoshouxinxi.getSell();
        if(sell >= 0){
            peijian.setSell(xiaoshouxinxi.getSell());
            peijian.setRepertory(sell);
        }else{
            return R.error("库存不足，请进货");
        }
        xiaoshouxinxi.setMaxmoney(xiaoshouxinxi.getSell() * peijian.getMoney());
        xiaoshouxinxi.setPjTypes(peijian.getPjTypes());
        if(xiaoshouxinxiEntity==null){
            peijianxinxiService.updateById(peijian);
            xiaoshouxinxiService.insert(xiaoshouxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoshouxinxiEntity xiaoshouxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<XiaoshouxinxiEntity> queryWrapper = new EntityWrapper<XiaoshouxinxiEntity>()
            .notIn("id",xiaoshouxinxi.getId())
            .eq("numbered", xiaoshouxinxi.getNumbered());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoshouxinxiEntity xiaoshouxinxiEntity = xiaoshouxinxiService.selectOne(queryWrapper);
        if(xiaoshouxinxiEntity==null){
            xiaoshouxinxiService.updateById(xiaoshouxinxi);//根据id更新
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
        xiaoshouxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

