package com.ruanko.service;

import com.ruanko.dao.impl.ManagerDaoImpl;
import com.ruanko.daos.ManagerDao;

public class ManagerService {

	ManagerDao managerDao = new ManagerDaoImpl();
	
	//����Ա��¼
	public int login (String name, String password) {
		int id = 0;			
		id = managerDao.login(name, password);								
		return id;		
	}
	
	
}
