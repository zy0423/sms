package com.sms.bean;

import java.io.Serializable;

public class Role extends BaseEntity
{

	private static final long serialVersionUID = 6196156477243618204L;

	/**
	 * 角色标识符
	 */
	private String role;

	/**
	 * 描述
	 */
	private String description;

	/**
	 *是否可用
	 */
	private Boolean available = Boolean.FALSE; 

	public Role()
	{
	}

	public Role(String role, String description, Boolean available)
	{
		this.role = role;
		this.description = description;
		this.available = available;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
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
