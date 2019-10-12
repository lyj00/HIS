package com.zhiyou100.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    private Integer id;

    private String user_name;

    private String password;
    
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    private Integer status;

    private String real_name;

    private String email;
    
    private Role role;
    
    private Permission permission;
    
//    private List<Permission> listPermission;
    

	public Role getRole() {
		return role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

//	public List<Permission> getListPermission() {
//		return listPermission;
//	}
//
//	public void setListPermission(List<Permission> listPermission) {
//		this.listPermission = listPermission;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", update_time=" + update_time
				+ ", status=" + status + ", real_name=" + real_name + ", email=" + email + ", role=" + role
				+ ", permission=" + permission + "]";
	}

    
}