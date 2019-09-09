package com.bsty.base.dao;

import com.bsty.base.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {
    List<Role> getRolesByUserId(@Param("userId") Long userId);
}
