package com.entity.model;

import com.entity.XiaoshouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 销售信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-02
 */
public class XiaoshouxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


    /**
     * 出售单号
     */
    private String numbered;


    /**
     * 配件名称 Search
     */
    private String name;


    /**
     * 配件类型 Search
     */
    private Integer pjTypes;


    /**
     * 出售数量
     */
    private Integer sell;


    /**
     * 提供客户 Search
     */
    private Integer khTypes;


    /**
     * 负责员工
     */
    private Integer ygTypes;


    /**
     * 出售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


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
