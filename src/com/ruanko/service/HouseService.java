package com.ruanko.service;

import java.util.ArrayList;
import java.util.List;

import com.ruanko.dao.impl.HouseDaoImpl;
import com.ruanko.daos.HouseDao;
import com.ruanko.model.Constant;
import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.util.AppException;

public class HouseService {

	HouseDao houseDao = new HouseDaoImpl();	
		
	//�û���������
	public boolean createHouse (House house) {	
		boolean flag = false;
		try {
			flag = houseDao.save(house);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return flag;
	}
	
	//ͨ���û�id��ȡ����ķ�����Ϣ
	public List<House> getMyHouse (int userId) {
		List<House> houseList = new ArrayList<House>();
		try {
			houseList = houseDao.findByUserId(userId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return houseList;
	} 
	
	//ͨ���û�id��state������״̬����ȡ����ķ�����Ϣ
	public List<House> getUnpublishedHouse (int userId, int state) {
		List<House> houseList = new ArrayList<House>();
		try {
			houseList = houseDao.findByState(userId, state);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return houseList;
	}
	
	//ͨ���û�id�޸ķ��ݵ�״̬Ϊ�ѷ���
	public int publishHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_PUBLISHED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
		
	//ͨ���û�id�޸ķ��ݵ�״̬Ϊ��˴�����
	public int checkHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_UNPUBLISHED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
	
	//ͨ���û�id�޸ķ��ݵ�״̬Ϊ��˾ܾ�
	public int refuseHouse (int houseId) {
		int num = 0;
		try {
			num = houseDao.updateState(Constant.HOUSE_REFUSED, houseId);
		} catch (AppException e) {
			e.printStackTrace();
		}		
		return num;
	}
	
	//ͨ���������ƺͷ��ݵ�ַ��ѯ������Ϣ
	public List<House> findByName (String searchName){
		List<House> houseList = new ArrayList<House>();
		try {			
			houseList = houseDao.findByName(searchName);
		} catch (AppException e) {
			e.printStackTrace();
		}			
		return houseList;
	} 	
		
	//���ݷ���id�ͷ���״̬��������ѯ���ݺ��û���Ϣ
	public List<HouseBusiModel> findById (int id , int state) {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		try {
			houseBusiList = houseDao.findById(id, state);
		} catch (AppException e) {
			e.printStackTrace();
		}
		return houseBusiList;	
	}
	
	//����״̬��ȡ����˵ķ���
	public List<HouseBusiModel> getUncheckedHouse () throws AppException {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();					
		houseBusiList = houseDao.getByState(Constant.HOUSE_UNCHECKED);
		return houseBusiList;
	}
	
	
}
