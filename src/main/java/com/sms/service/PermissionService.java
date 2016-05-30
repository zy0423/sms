package com.sms.service;

import com.sms.mapper.PermissionMapper;

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
{ "permissionCache" })
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Cacheable(keyGenerator = "wiselyKeyGenerator")
    public Set<String> getPermissionsByUserName(String username) {
        System.out.println("初始化 permissioncache");
        return permissionMapper.findPermissions(username);
    }
}
