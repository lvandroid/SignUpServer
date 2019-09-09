package com.bsty.base.dao;


import com.bsty.base.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    User findUserByName(@Param("username") String username);

}
