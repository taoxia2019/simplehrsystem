package com.lena.mapper;

import com.lena.entity.TPermission;
import com.lena.entity.TRole;
import com.lena.entity.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统管理员帐号 Mapper 接口
 * </p>
 *
 * @author lena
 * @since 2019-03-26
 */
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    @Select("select id,password,user_name as userName,remarks from t_user where user_name=#{username}")
    TUser selectByName(@Param("username") String username);

    @Select("select r.id,r.remarks,role_name as roleName from t_role r,t_user_role ur "+
            "where r.id=ur.role_id and user_id=#{id}")
    List<TRole> findRoleByTUserId(Integer id);

    @Select("select p.id,p.permission_name as permissionName,p.remarks " +
            "from t_user u " +
            "LEFT JOIN t_user_role ur on u.id= ur.user_id " +
            "LEFT JOIN t_role r on ur.role_id=r.id " +
            "LEFT JOIN t_role_permission rp on rp.role_id=r.id " +
            "LEFT JOIN t_permission p on p.id =rp.permission_id " +
            "where u.id=#{id}")
    List<TPermission> findPermissionByUserId(Integer id);

}
