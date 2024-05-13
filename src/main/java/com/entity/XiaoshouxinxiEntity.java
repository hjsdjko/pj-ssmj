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
 * 销售信息
 *
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("xiaoshouxinxi")
public class XiaoshouxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoshouxinxiEntity() {

	}

	public XiaoshouxinxiEntity(T t) {
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
     * 出售单号
     */
    @TableField(value = "numbered")
    private String numbered;


    /**
     * 配件名称 Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 配件类型 Search
     */
    @TableField(value = "pj_types")
    private Integer pjTypes;


    /**
     * 出售数量
     */
    @TableField(value = "sell")
    private Integer sell;


    /**
     * 提供客户 Search
     */
    @TableField(value = "kh_types")
    private Integer khTypes;


    /**
     * 负责员工
     */
    @TableField(value = "yg_types")
    private Integer ygTypes;


    /**
     * 出售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 总价
     */
    private Double maxmoney;


    public Double getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(Double maxmoney) {
        this.maxmoney = maxmoney;
    }

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
	 * 设置：出售单号
	 */
    public String getNumbered() {
        return numbered;
    }


    /**
	 * 获取：出售单号
	 */

    public void setNumbered(String numbered) {
        this.numbered = numbered;
    }
    /**
	 * 设置：配件名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：配件名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：配件类型 Search
	 */
    public Integer getPjTypes() {
        return pjTypes;
    }


    /**
	 * 获取：配件类型 Search
	 */

    public void setPjTypes(Integer pjTypes) {
        this.pjTypes = pjTypes;
    }
    /**
	 * 设置：出售数量
	 */
    public Integer getSell() {
        return sell;
    }


    /**
	 * 获取：出售数量
	 */

    public void setSell(Integer sell) {
        this.sell = sell;
    }
    /**
	 * 设置：提供客户 Search
	 */
    public Integer getKhTypes() {
        return khTypes;
    }


    /**
	 * 获取：提供客户 Search
	 */

    public void setKhTypes(Integer khTypes) {
        this.khTypes = khTypes;
    }
    /**
	 * 设置：负责员工
	 */
    public Integer getYgTypes() {
        return ygTypes;
    }


    /**
	 * 获取：负责员工
	 */

    public void setYgTypes(Integer ygTypes) {
        this.ygTypes = ygTypes;
    }
    /**
	 * 设置：出售时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：出售时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
