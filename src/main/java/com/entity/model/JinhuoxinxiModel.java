package com.entity.model;

import com.entity.JinhuoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 进货信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-02
 */
public class JinhuoxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


    /**
     * 单号
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
     * 进货数量
     */
    private Integer replenish;


    /**
     * 供应商 Search
     */
    private Integer gyTypes;


    /**
     * 备注信息
     */
    private String noticeContent;


    /**
     * 经手员工 Search
     */
    private Integer ygTypes;


    /**
     * 进货时间
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
	 * 设置：单号
	 */
    public String getNumbered() {
        return numbered;
    }


    /**
	 * 获取：单号
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
	 * 设置：供应商 Search
	 */
    public Integer getGyTypes() {
        return gyTypes;
    }


    /**
	 * 获取：供应商 Search
	 */

    public void setGyTypes(Integer gyTypes) {
        this.gyTypes = gyTypes;
    }
    /**
	 * 设置：备注信息
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：备注信息
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    /**
	 * 设置：经手员工 Search
	 */
    public Integer getYgTypes() {
        return ygTypes;
    }


    /**
	 * 获取：经手员工 Search
	 */

    public void setYgTypes(Integer ygTypes) {
        this.ygTypes = ygTypes;
    }
    /**
	 * 设置：进货时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：进货时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
