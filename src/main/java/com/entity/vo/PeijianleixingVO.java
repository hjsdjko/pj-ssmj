package com.entity.vo;

import com.entity.PeijianleixingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 配件类型
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("peijianleixing")
public class PeijianleixingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 配件类型 Search
     */

    @TableField(value = "pjname")
    private String pjname;


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
	 * 设置：配件类型 Search
	 */
    public String getPjname() {
        return pjname;
    }


    /**
	 * 获取：配件类型 Search
	 */

    public void setPjname(String pjname) {
        this.pjname = pjname;
    }

}
