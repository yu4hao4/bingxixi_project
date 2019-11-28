package dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import dao.impl.MerchantDaoImpl;
import entity.Order;
import entity.Waybill;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:58
 */
public class MerchantDao implements MerchantDaoImpl {
    /**
     * 用于获取订单信息的方法
     * @param order
     * @return
     */
    @Override
    public List<Order> getOrders(Order order) {
        List<Order> orders = new ArrayList<Order>();
        StringBuffer sql = new StringBuffer("select orders.order_id as order_id,orders.date as date," +
                "user_info.user_realname as user_realname,user_info.user_nick as user_nick," +
                "item.item_id as item_id,item.item_name as item_name,orders.order_count as order_count," +
                "orders.order_location as order_location,orders.is_send as is_send " +
                "from orders,item,user_info " +
                "where orders.item_id=item.item_id and orders.user_id=user_info.user_id and item.shop_id=?");
        String user_realname = order.getUser_realname();
        String item_name = order.getItem_name();
        /**
         * 判断是否有参数
         */
        if(user_realname != null && !user_realname.isEmpty()) {
            sql.append(" and user_info.user_realname like '%"+user_realname+"%'");
        }
        if(item_name != null && !item_name.isEmpty()) {
            sql.append(" and item.item_name like '%"+item_name+"%'");
        }
        QueryRunner queryRunner = new QueryRunner();
        /**
         * 获得数据库链接
         */
        Connection connection = JDBCUtil.getConn();
        try {
            System.out.println(sql.toString());
            System.out.println("param:"+order.getShop_id());
            orders = queryRunner.query(connection,sql.toString(),new BeanListHandler<Order>(Order.class),order.getShop_id());
        }catch (SQLException e) {
            System.err.println("未知异常");
            return orders;
        }finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return orders;
    }

    /**
     * 判断订单是否发货
     * @param order
     * @return
     */
    @Override
    public Integer getWayBillCountByOrderId(Order order) {
        String sql = "select count(*) from waybill where order_id=?";
        Connection conn = JDBCUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        Long count = 0l;
        try {
            count = queryRunner.query(conn,sql,new ScalarHandler<Long>(),order.getOrder_id());
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(count.toString());
    }

    /**
     * 上传运单信息
     * @param waybill
     * @return
     */
    @Override
    public Integer updateWaybillInfo(Waybill waybill) {
        String sql = "insert into waybill (order_id,destination,original,waybill_id,send_date) " +
                "values (?,?,?,?,?)";
        String onInsert = "update orders set is_send='已发货' where order_id=?";
        Connection conn = JDBCUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        int updateLine1 = 0;
        int updateLine2 = 0;
        int updateLine = 0;
        try {
            conn.setAutoCommit(false);
            updateLine1 = queryRunner.update(conn,sql,waybill.getOrder_id(),waybill.getDestination()
                    ,waybill.getOriginal(),waybill.getWaybill_id(),new Date());
            updateLine2 = queryRunner.update(conn,onInsert,waybill.getOrder_id());
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(updateLine1 > 0 && updateLine2 > 0) {
                    conn.commit();
                    updateLine = 1;
                }else {
                    conn.rollback();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return updateLine;
    }

    /**
     * 获得订单信息
     * @param waybill
     * @return
     */
    @Override
     public Waybill getWaybillInfo(Waybill waybill) {
         String sql = "select * from waybill where order_id=?";

         QueryRunner queryRunner = new QueryRunner();
         Connection conn = JDBCUtil.getConn();
         List<Waybill> waybills = null;
         try {
              waybills = queryRunner.query(conn,sql,new BeanListHandler<Waybill>(Waybill.class),waybill.getOrder_id());
         }catch (SQLException e) {
             e.printStackTrace();
         }finally {
             try {
                 if(conn != null) {
                     conn.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         if(waybills!=null && !waybills.isEmpty()) {
             return waybills.get(0);
         }else {
             return null;
         }
     }
}
