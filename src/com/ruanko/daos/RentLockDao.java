package com.ruanko.daos;

import java.util.List;
import com.ruanko.model.Order;
import com.ruanko.model.OrderBusiModel;
import com.ruanko.model.RentLock;

public interface RentLockDao{
	
	//��ȡ��Ӧʱ����ڷ��ݳ���״̬��¼
	public List<RentLock> getRentLock (Order order, int state);
	
	//���涩����Ϣ
	public boolean save (Order order);
		
	//��ѯ��������
	public List<OrderBusiModel> getHostUncheckedOrder (int userid, int state);
	
	//���淿����ס״̬��Ϣ
	public boolean save (RentLock rentLock);
	
	//��ѯ��������
	public List<OrderBusiModel> getHostCheckedOrder (int userid, int state);
	
	//ȡ������
	public boolean abolishOrder (int setState, int orderid, int state);
	
	//�˶�����
	public boolean unsubscribeOrder (int setState, int orderid, int state);
	
}
