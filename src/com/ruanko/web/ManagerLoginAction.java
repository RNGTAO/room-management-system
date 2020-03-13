package com.ruanko.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruanko.dao.impl.ManagerDaoImpl;
import com.ruanko.daos.ManagerDao;
import com.ruanko.model.Manager;
import com.ruanko.service.ManagerService;

public class ManagerLoginAction extends ActionSupport implements ModelDriven<Manager>{

	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	   
	ManagerService managerService = new ManagerService();
	ManagerDao managerDao = new ManagerDaoImpl();
	Manager managers = new Manager();
	
	@Override
	public String execute() throws Exception {
		if (managers.getName()==null ||  managers.getPassword()==null || managers.getName().equals("") ||  managers.getPassword().equals("")) {			
			request.setAttribute("message", "�û��������벻��Ϊ�գ�");
			request.setAttribute("name", managers.getName());
			request.setAttribute("pass", managers.getPassword());
			return "fail";
		} else {
			int id = managerService.login(managers.getName(), managers.getPassword());		
			if (id > 0) {
				Manager manager = managerDao.getManager(id);
				session.setAttribute("manager", manager);
				return "succ";					
			} else {
				request.setAttribute("message", "�û������������");
				request.setAttribute("name", managers.getName());
				request.setAttribute("pass", managers.getPassword());
				return "fail";
			}								
		}	
	
	}

	
	@Override
	public Manager getModel() {
		return managers;
	}

	
	
}
