package com.sms.mapper;

import com.sms.bean.Role;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/5/11.
 */
@Lazy(true)
public interface RoleMapper {

    public Role findRoleById(Integer id);

    public Set<String> findRoles(String username);

    public List<Role> selectAll();

    public int add(Role role);

    public void delete(Integer id);

    public int update(Role role);
}
