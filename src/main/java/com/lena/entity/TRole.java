package com.lena.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统用户角色表
 * </p>
 *
 * @author lena
 * @since 2019-03-26
 */
@TableName("t_role")
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
    /**
     * 角色描述
     */
    @TableField("role_desc")
    private String roleDesc;
    /**
     * 权限
     */
    private String permissions;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private String createTime;
    /**
     * 顺序码
     */
    private Integer order;
    /**
     * 1：有效 
            0：无效
     */
    @TableField("role_status")
    private Integer roleStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TRole{" +
        ", id=" + id +
        ", roleName=" + roleName +
        ", roleDesc=" + roleDesc +
        ", permissions=" + permissions +
        ", createTime=" + createTime +
        ", order=" + order +
        ", roleStatus=" + roleStatus +
        "}";
    }
}
