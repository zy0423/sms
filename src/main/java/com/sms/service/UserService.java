package com.sms.service;

import com.sms.bean.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zy on 2016/5/27.
 */
@Service
@CacheConfig(cacheNames = "userCache")
public class UserService {

    @Cacheable(keyGenerator = "wiselyKeyGenerator")
    public User getUserByName(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

}
