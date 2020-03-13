package com.ruanko.daos;

import com.ruanko.model.User;
import com.ruanko.util.AppException;

public interface UserDao {
	
	//�ж��û����Ƿ��Ѿ�����
	public boolean isExist(String name) throws AppException;
	//�����û��������Ϣ
	public boolean save(User user) throws AppException;
	//�����û����������ѯ�û����
	public int login(String name, String password) throws AppException;
	//��ѯ�Ƿ���ƥ����û������򷵻��û���ϢUser�����
	public User getUser (int id) throws AppException;
	
	
}
