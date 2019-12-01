package dao.impl;

import entity.Item;
import entity.Order;
import entity.Waybill;

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
    List<Order> getOrders(Order order);

    /**
     * 获取订单id在运单表中出现的次数
     * @param order
     * @return
     */
    Integer getWayBillCountByOrderId(Order order);

    /**
     * 上传运单信息
     * @param waybill
     * @return
     */
    Integer updateWaybillInfo(Waybill waybill);

    /**
     * 获得订单信息
     * @param waybill
     * @return
     */
    Waybill getWaybillInfo(Waybill waybill);

    /**
     * 获得商品信息的方法
     * @param item
     * @return
     */
    List<Item> getItemInfos(Item item);

    /**
     * 修改商品信息的方法
     * @param item
     * @return
     */
    Integer updateItemInfo(Item item);
}
