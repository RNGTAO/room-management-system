package com.ruanko.daos;

import com.ruanko.model.Manager;

public interface ManagerDao {
	

	//�����û����������ѯ����Ա���
	public int login (String name, String password);
		
	//��ѯ�Ƿ���ƥ��Ĺ���Ա�����򷵻ع���Ա��Ϣ
	public Manager getManager (int id);
	
}
