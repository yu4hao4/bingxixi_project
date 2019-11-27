package service;

import dao.MerchantDao;
import entity.Order;

import java.util.List;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:56
 */
public class MerchantService {
    private MerchantDao merchantDao;
    public MerchantService() {
        this.merchantDao = new MerchantDao();
    }

    public List<Order> getOrders(Order order) {
        if(order == null) {
            return null;
        }
        return merchantDao.getOrders(order);
    }
}
