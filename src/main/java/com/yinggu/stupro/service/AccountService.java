package com.yinggu.stupro.service;

import org.junit.Test;

import com.yinggu.stupro.dao.AccountDao;
import com.yinggu.stupro.domain.Account;
/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 */
public class AccountService {

	@Test
	public void testDao1() {

		try {
			
			AccountDao dao = new AccountDao();
			Account account = dao.querySingle("select * from account where id=?", 1);
			System.out.println(account);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
