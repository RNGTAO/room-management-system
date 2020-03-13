package com.ruanko.daos;

import com.ruanko.model.Order;

public interface OrderDao {

	//���¶���״̬
	public boolean updateState (int setState,int orderid, int state);
	
	//��ö�����Ϣ
	public Order getOrderById (int orderid);
	
	//�ı��ͻ����״̬
	public boolean updateConflictOrderByState (Order order, int state);
	
	
}
