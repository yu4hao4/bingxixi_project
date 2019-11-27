package service.impl;

import entity.Order;

import java.util.List;

/**
 * @Author BlockDusty
 * @Date 2019/11/27 19:01
 */
public interface MerchantServiceImpl {
    /**
     * 获得所有的订单信息
     * @param order
     * @return
     */
    public List<Order> getOrders(Order order);
}
