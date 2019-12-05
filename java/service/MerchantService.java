package service;

import dao.MerchantDao;
import dao.inf.MerchantDaoInf;
import entity.Item;
import entity.Order;
import entity.Shop;
import entity.Waybill;
import service.inf.MerchantServiceInf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:56
 */
public class MerchantService implements MerchantServiceInf {

    private MerchantDaoInf merchantDao;

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
    /**
     * 添加预售商品
     * @param item
     * @return
     */
   public Boolean insertItem(Item item) {

       if(item == null || item.getShop_id() == null) {
           return false;
       }
       Integer item_id = new Random(System.currentTimeMillis()).nextInt(999999999);
       item.setItem_id(item_id);
       System.out.println(item_id);
//       return false;
       return merchantDao.insertItem(item)>0?true:false;
   }

    /**
     * 上架商品
     * @param item
     * @return
     */
    @Override
    public Boolean uppershelfItem(Item item) {
        return false;
    }

    /**
     * 修改商家信息
     * @param  shop
     * @return
     */
    @Override
    public Boolean changeShopInfo(Shop shop) {
        return false;
    }


}
