package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 客户信息
 *
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("kehuxixni")
public class KehuxixniEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuxixniEntity() {

	}

	public KehuxixniEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
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
