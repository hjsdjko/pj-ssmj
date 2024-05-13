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

import com.entity.JinhuoxinxiEntity;

import com.service.JinhuoxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 进货信息
 * 后端接口
 * @author
 * @email
 * @date 2021-02-02
*/
@RestController
@Controller
@RequestMapping("/jinhuoxinxi")
public class JinhuoxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JinhuoxinxiController.class);

    @Autowired
    private JinhuoxinxiService jinhuoxinxiService;

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
            page = jinhuoxinxiService.queryPage(params);
        }else{
            page = jinhuoxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JinhuoxinxiEntity jinhuoxinxi = jinhuoxinxiService.selectById(id);
        if(jinhuoxinxi!=null){
            return R.ok().put("data", jinhuoxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JinhuoxinxiEntity> queryWrapper = new EntityWrapper<JinhuoxinxiEntity>()
            .eq("numbered", jinhuoxinxi.getNumbered());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JinhuoxinxiEntity jinhuoxinxiEntity = jinhuoxinxiService.selectOne(queryWrapper);
        jinhuoxinxi.setNumbered(String.valueOf(new Date().getTime()));
        PeijianxinxiEntity peijian = peijianxinxiService.selectOne(new EntityWrapper<PeijianxinxiEntity>().eq("name", jinhuoxinxi.getName()));
        if(peijian == null){
            return R.error(511,"配件仓库暂时没有这个配件商品，请添加后再购买");
        }
        peijian.setReplenish(jinhuoxinxi.getReplenish());
        if(peijian.getRepertory()==null){
            peijian.setRepertory(0);
        }
        jinhuoxinxi.setPjTypes(peijian.getPjTypes());
        if(jinhuoxinxi.getMaxmoney() == null){
            jinhuoxinxi.setMaxmoney(0.0);
        }
        jinhuoxinxi.setCreateTime(new Date());
        jinhuoxinxi.setMaxmoney(jinhuoxinxi.getReplenish() * peijian.getMoney());
        peijian.setRepertory(peijian.getRepertory()+jinhuoxinxi.getReplenish());
        if(jinhuoxinxiEntity==null){
            peijianxinxiService.updateById(peijian);
            jinhuoxinxiService.insert(jinhuoxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JinhuoxinxiEntity jinhuoxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JinhuoxinxiEntity> queryWrapper = new EntityWrapper<JinhuoxinxiEntity>()
            .notIn("id",jinhuoxinxi.getId())
            .eq("numbered", jinhuoxinxi.getNumbered());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JinhuoxinxiEntity jinhuoxinxiEntity = jinhuoxinxiService.selectOne(queryWrapper);
        if(jinhuoxinxiEntity==null){
            jinhuoxinxiService.updateById(jinhuoxinxi);//根据id更新
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
        jinhuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

