package com.lena.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统管理员帐号
 * </p>
 *
 * @author lena
 * @since 2019-03-26
 */
@TableName("t_user")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 系统用户名称
     */
    @TableField("sys_user_name")
    private String sysUserName;
    /**
     * 系统用户密码
     */
    @TableField("sys_user_pwd")
    private String sysUserPwd;
    /**
     * 角色
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 手机号
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 登记时间
     */
    @TableField("reg_time")
    private String regTime;
    /**
     * 状态（0：无效；1：有效）
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 邮箱
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 所属部门
     */
    @TableField("user_dept")
    private String userDept;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TUser{" +
        ", id=" + id +
        ", sysUserName=" + sysUserName +
        ", sysUserPwd=" + sysUserPwd +
        ", roleId=" + roleId +
        ", userPhone=" + userPhone +
        ", regTime=" + regTime +
        ", userStatus=" + userStatus +
        ", userEmail=" + userEmail +
        ", userDept=" + userDept +
        "}";
    }
}
