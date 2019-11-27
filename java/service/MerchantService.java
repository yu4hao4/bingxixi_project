package service;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import entity.Order;
import service.impl.MerchantServiceImpl;

import java.util.List;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:56
 */
public class MerchantService implements MerchantServiceImpl {

    private MerchantDaoImpl merchantDao;

    public MerchantService() {
        this.merchantDao = new MerchantDao();
    }

    /**
     * 获得所有的订单信息
     * @param order
     * @return
     */
    @Override
    public List<Order> getOrders(Order order) {
        if(order == null || order.getShop_id()==null) {
            return null;
        }
        return merchantDao.getOrders(order);
    }
}
