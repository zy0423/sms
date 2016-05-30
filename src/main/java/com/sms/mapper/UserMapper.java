package com.sms.mapper;

import com.sms.bean.User;
import org.springframework.context.annotation.Lazy;
import java.util.List;

@Lazy(true)//因为集成shiro的原因需要延迟加载--shiro加载在bean加载之前
public interface UserMapper
{
	public User findUserById(Integer id);

	public User findUserByName(String name);

	public int add(User user);

	public List<User> selectAll();

	public void delete(Integer id);

	public int update(User user);
}
