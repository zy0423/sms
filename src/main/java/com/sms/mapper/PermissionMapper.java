package com.sms.mapper;

import com.sms.bean.Permission;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/5/11.
 */
@Lazy(true)
public interface PermissionMapper {

    public Permission findPermissionById(Integer id);

    public Set<String> findPermissions(String username);

    public List<Permission> selectAll();

    public int add(Permission permission);

    public void delete(Integer id);

    public int update(Permission permission);
}
