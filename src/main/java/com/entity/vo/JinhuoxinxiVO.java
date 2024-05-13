package com.entity.vo;

import com.entity.JinhuoxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 进货信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-02
 */
@TableName("jinhuoxinxi")
public class JinhuoxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 单号
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
     * 进货数量
     */

    @TableField(value = "replenish")
    private Integer replenish;


    /**
     * 供应商 Search
     */

    @TableField(value = "gy_types")
    private Integer gyTypes;


    /**
     * 备注信息
     */

    @TableField(value = "notice_content")
    private String noticeContent;


    /**
     * 经手员工 Search
     */

    @TableField(value = "yg_types")
    private Integer ygTypes;


    /**
     * 进货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
