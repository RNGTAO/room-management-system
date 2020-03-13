package com.ruanko.daos;

import java.util.List;

import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.util.AppException;

public interface HouseDao {

	//�����û��������Ϣ
	public boolean save(House house) throws AppException;
	
	//ͨ���û�id��ȡ����ķ�����Ϣ
	public List<House> findByUserId (int userId) throws AppException; 	
	
	//ͨ���û�id��state������״̬����ȡ����ķ�����Ϣ
	public List<House> findByState (int userId, int state) throws AppException; 	
	
	//ͨ������id�޸ķ��ݵ�״̬
	public int updateState (int setState, int houseId) throws AppException; 	
		
	//ͨ���������ƺͷ��ݵ�ַ��ѯ������Ϣ
	public List<House> findByName (String searchName) throws AppException; 	
		
	//���ݷ���id�ͷ���״̬��������ѯ���ݺ��û���Ϣ
	public List<HouseBusiModel> findById (int id , int state) throws AppException; 
		
	//����״̬��ȡ����˵ķ���
	public List<HouseBusiModel> getByState (int state) throws AppException;
	
}
