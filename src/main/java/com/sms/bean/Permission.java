package com.sms.bean;

import java.io.Serializable;

public class Permission extends BaseEntity
{

	private static final long serialVersionUID = 8883796644126844355L;

	/**
	 * 权限标识
	 */
	private String permission;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 是否可用
	 */
	private Boolean available = Boolean.FALSE; 

	public Permission()
	{
	}

	public Permission(String permission, String description, Boolean available)
	{
		this.permission = permission;
		this.description = description;
		this.available = available;
	}

	public String getPermission()
	{
		return permission;
	}

	public void setPermission(String permission)
	{
		this.permission = permission;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Boolean getAvailable()
	{
		return available;
	}

	public void setAvailable(Boolean available)
	{
		this.available = available;
	}

}
