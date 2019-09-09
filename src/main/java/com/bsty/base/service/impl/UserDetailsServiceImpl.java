package com.bsty.base.service.impl;

import com.bsty.base.bean.Role;
import com.bsty.base.bean.User;
import com.bsty.base.dao.RoleDao;
import com.bsty.base.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByName(username);
        if (null != user) {
            List<Role> roles = roleDao.getRolesByUserId(user.getId());
            user.setAuthorities(roles);
        }
        return user;
    }
}
