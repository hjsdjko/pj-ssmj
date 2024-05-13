package com.entity.vo;

import com.entity.PeijianxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 配件信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("peijianxinxi")
public class PeijianxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


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
     * 价格
     */

    @TableField(value = "money")
    private Double money;


    /**
     * 进货数量
     */

    @TableField(value = "replenish")
    private Integer replenish;


    /**
     * 出售数量
     */

    @TableField(value = "sell")
    private Integer sell;


    /**
     * 库存
     */

    @TableField(value = "repertory")
    private Integer repertory;


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
	 * 设置：价格
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：价格
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：进货数量
	 */
    public Integer getReplenish() {
        return replenish;
    }


    /**
	 * 获取：进货数量
	 */

    public void setReplenish(Integer replenish) {
        this.replenish = replenish;
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
	 * 设置：库存
	 */
    public Integer getRepertory() {
        return repertory;
    }


    /**
	 * 获取：库存
	 */

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

}
