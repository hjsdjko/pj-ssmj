package com.entity.vo;

import com.entity.GongyingshangxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 供应商信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("gongyingshangxinxi")
public class GongyingshangxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 供应商名称 Search
     */

    @TableField(value = "gysname")
    private String gysname;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：供应商名称 Search
	 */
    public String getGysname() {
        return gysname;
    }


    /**
	 * 获取：供应商名称 Search
	 */

    public void setGysname(String gysname) {
        this.gysname = gysname;
    }

}
