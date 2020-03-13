package com.ruanko.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ruanko.model.House;
import com.ruanko.model.HouseBusiModel;
import com.ruanko.service.HouseService;
import com.ruanko.util.AppException;

public class HouseAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	
	HouseService houseService = new HouseService();
	
	//ͨ���������ƺͷ��ݵ�ַ��ѯ������Ϣ
	public String search () {		
		String searchName = request.getParameter("searchName");		
		if (searchName == null) {
			searchName = "";
		}
		List<House> houseList = new ArrayList<House>();	
		houseList = houseService.findByName(searchName);
		request.setAttribute("houseList", houseList);
		request.setAttribute("searchName", searchName);
		return "search_succ";
	}
	
	//���ݷ���id�ͷ���״̬��������ѯ���ݺ��û���Ϣ
	public String getHouseById () {
		int id = Integer.parseInt((String) request.getParameter("id"));	
		int state = Integer.parseInt((String) request.getParameter("state"));	
		if (id != 0 && state == 3) {
			List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
			houseBusiList = houseService.findById(id, state);
			request.setAttribute("houseBusiList", houseBusiList);
			return "getHouseById_succ";
		} else {
			return "getHouseById_fail";
		}
					
	} 
	
	//����״̬��ȡ����˵ķ���
	public String toUnchecked () {
		List<HouseBusiModel> houseBusiList = new ArrayList<HouseBusiModel>();			
		try {
			houseBusiList = houseService.getUncheckedHouse();
		} catch (AppException e) {			
			e.printStackTrace();
		}
		request.setAttribute("houseBusiList", houseBusiList);		
		return "toUnchecked_succ";
	}
	
	//ͨ���û�id�޸ķ��ݵ�״̬Ϊ��˴�����
	public String check () {
		String houseId = request.getParameter("houseId");
		houseService.checkHouse(Integer.parseInt(houseId));	
		return "check_succ";
	}
		
	//ͨ���û�id�޸ķ��ݵ�״̬Ϊ��˾ܾ�
	public String refuse () {
		String houseId = request.getParameter("houseId");
		houseService.refuseHouse(Integer.parseInt(houseId));	
		return "refuse_succ";	
	}
	
}
