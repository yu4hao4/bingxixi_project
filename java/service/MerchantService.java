package service;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import entity.Item;
import entity.Order;
import entity.Waybill;
import service.impl.MerchantServiceImpl;

import java.util.ArrayList;
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

    /**
     * 获取订单id在运单表中出现的次数
     * @param order
     * @return
     */
    @Override
    public Boolean isOrderSent(Order order) {
        Boolean bool = false;
        if(order == null || order.getOrder_id() == null) {
            return bool;
        }
        if(merchantDao.getWayBillCountByOrderId(order) > 0) {
            bool = true;
        }
        return bool;
    }

    /**
     * 上传用户提交的运单信息
     * @param waybill
     * @return
     */
    @Override
    public Boolean updateWaybillInfo(Waybill waybill) {
        boolean bool = false;
        Order order = new Order();
        order.setOrder_id(waybill.getOrder_id());
        if(isOrderSent(order)) {
            return bool;
        }
        if(merchantDao.updateWaybillInfo(waybill)>0) {
            bool = true;
        }
        return bool;
    }

    /**
     * 获得运单详情
     * @param waybill
     * @return
     */
    @Override
    public Waybill getWaybillInfo(Waybill waybill) {
        if(waybill == null || waybill.getOrder_id() == null) {
            return null;
        }
        return merchantDao.getWaybillInfo(waybill);
    }


    /**
     * 获得商品信息的方法
     * @param item
     * @return
     */
    @Override
    public List<Item> getItemInfos(Item item) {
        if(item != null && item.getShop_id() != null) {
            return merchantDao.getItemInfos(item);
        }else {
            return new ArrayList<Item>();
        }
    }

    /**
     * 修改货物信息的方法
     * @param item
     * @return
     */
    @Override
    public Boolean changeItemInfo(Item item) {
        if(item == null || item.getShop_id() == null || item.getItem_id() == null) {
            return false;
        }
        return merchantDao.updateItemInfo(item)>0?true:false;
    }

    /**
     * 下架商品
     * @param item
     * @return
     */
    @Override
    public Boolean downshelfItem(Item item) {
        if(item == null || item.getShop_id() == null || item.getItem_id() == null) {
            return false;
        }
        return merchantDao.downshelfItem(item)>0?true:false;
    }
}
