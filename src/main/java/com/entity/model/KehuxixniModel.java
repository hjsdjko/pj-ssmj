package com.entity.model;

import com.entity.KehuxixniEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 客户信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-02
 */
public class KehuxixniModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


    /**
     * 客户名称 Search
     */
    private String khname;


    /**
     * 客户性别 Search
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String contact;


    /**
     * 联系地址
     */
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
