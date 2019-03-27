package com.lena.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lena
 * @since 2019-03-27
 */
@TableName("t_permission")
public class TPermission extends Model<TPermission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 父菜单id
     */
    private Integer pid;
    /**
     * 描述
     */
    private String descpt;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 图片
     */
    private String icon;
    /**
     * 顺序码
     */
    private Integer order;
    /**
     * 删除标志（0:删除 1：存在）
     */
    @TableField("del_flag")
    private Integer delFlag;
    /**
     * 是否展开
     */
    private Integer spread;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescpt() {
        return descpt;
    }

    public void setDescpt(String descpt) {
        this.descpt = descpt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TPermission{" +
                ", id=" + id +
                ", name=" + name +
                ", pid=" + pid +
                ", descpt=" + descpt +
                ", url=" + url +
                ", icon=" + icon +
                ", order=" + order +
                ", delFlag=" + delFlag +
                ", spread=" + spread +
                "}";
    }
}
