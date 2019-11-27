package dao.impl;

import entity.Order;

import java.util.List;

/**
 * @Author BlockDusty
 * @Date 2019/11/27 18:58
 */
    public interface MerchantDaoImpl {
    /**
     * 用于获取订单信息的方法
     * @param order
     * @return
     */
    public List<Order> getOrders(Order order);
}
