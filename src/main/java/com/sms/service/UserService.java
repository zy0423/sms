package com.sms.service;

import com.github.pagehelper.PageHelper;
import com.sms.bean.User;
import com.sms.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zy on 2016/5/11.
 */
@Service
@CacheConfig(cacheNames =
{ "userCache" })
public class UserService
{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Cacheable(keyGenerator = "wiselyKeyGenerator")
	public User getUserById(Long id, String province, String city)
	{
		return new User();
	}

	@Cacheable(keyGenerator = "wiselyKeyGenerator")
	public User getUserByName(String name)
	{
		return userMapper.findUserByName(name);
	}

	@Cacheable(keyGenerator = "wiselyKeyGenerator")
	public List<User> getAll(User user)
	{
		if (user.getPage() != null && user.getRows() != null)
		{
			PageHelper.startPage(user.getPage(), user.getRows(), "id");
		}
		return userMapper.selectAll();
	}
}
