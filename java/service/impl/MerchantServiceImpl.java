package service.impl;

import entity.Item;
import entity.Order;
import entity.Waybill;

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
    List<Order> getOrders(Order order);

    /**
     * 判断订单是否发货
     * @param order
     * @return
     */
    Boolean isOrderSent(Order order);

    /**
     * 上传用户提交的运单信息
     * @param waybill
     * @return
     */
    Boolean updateWaybillInfo(Waybill waybill);

    /**
     * 获得运单详情
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
     * 修改货物信息的方法
     * @param item
     * @return
     */
    Boolean changeItemInfo(Item item);

    /**
     * 下架商品
     * @param item
     * @return
     */
    Boolean downshelfItem(Item item);
}
