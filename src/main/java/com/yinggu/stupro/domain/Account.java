package com.yinggu.stupro.domain;
/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 */
public class Account {
	
	private int ID;
	private String username;
	private String password;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + ID + ", username=" + username + ", password=" + password + "]";
	}

}
