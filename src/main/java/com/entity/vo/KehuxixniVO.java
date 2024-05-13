package com.entity.vo;

import com.entity.KehuxixniEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 客户信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("kehuxixni")
public class KehuxixniVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 客户名称 Search
     */

    @TableField(value = "khname")
    private String khname;


    /**
     * 客户性别 Search
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "contact")
    private String contact;


    /**
     * 联系地址
     */

    @TableField(value = "location")
    private String location;


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
	 * 设置：客户名称 Search
	 */
    public String getKhname() {
        return khname;
    }


    /**
	 * 获取：客户名称 Search
	 */

    public void setKhname(String khname) {
        this.khname = khname;
    }
    /**
	 * 设置：客户性别 Search
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：客户性别 Search
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getContact() {
        return contact;
    }


    /**
	 * 获取：联系方式
	 */

    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
	 * 设置：联系地址
	 */
    public String getLocation() {
        return location;
    }


    /**
	 * 获取：联系地址
	 */

    public void setLocation(String location) {
        this.location = location;
    }

}
