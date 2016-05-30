package com.sms.service;

import com.sms.mapper.RoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by zy on 2016/5/12.
 */
@Service
@CacheConfig(cacheNames =
{ "roleCache" })
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Cacheable(keyGenerator = "wiselyKeyGenerator")
    public Set<String> getRolesByUserName(String username) {
        return roleMapper.findRoles(username);
    }
}
