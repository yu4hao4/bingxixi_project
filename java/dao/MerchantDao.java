package dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import entity.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:58
 */
public class MerchantDao {
    /**
     * 用于获取订单信息的方法
     * @param order
     * @return
     */
    public List<Order> getOrders(Order order) {
        List<Order> orders = new ArrayList<Order>();
        StringBuffer sql = new StringBuffer("select orders.order_id as order_id,orders.date as date," +
                "user_info.user_realname as user_realname,user_info.user_nick as user_nick," +
                "item.item_id as item_id,item.item_name as item_name,order.order_count as order_count," +
                "order.order_location as order_location " +
                "from orders,item,user_info " +
                "where orders.item_id=item.item_id and orders.user_id=user_info.user_id");
        String user_realname = order.getUser_realname();
        String item_name = order.getItem_name();
        /**
         * 判断是否有参数
         */
        if(user_realname != null && !user_realname.isEmpty()) {
            sql.append(" and user_info.user_realname like '%?%'");
        }
        if(item_name != null && !item_name.isEmpty()) {
            sql.append(" and item.item_name like '%?%'");
        }
        QueryRunner queryRunner = new QueryRunner();
        /**
         * 获得数据库链接
         */
        Connection connection = JDBCUtil.getConn();
        try {
            /**
             * 通过传入的参数调用不同的方法
             */
            if(user_realname != null && !user_realname.isEmpty() && item_name != null && !item_name.isEmpty()) {
                orders = queryRunner.query(connection,sql.toString(),new BeanListHandler<Order>(Order.class),user_realname,item_name);
            }else if(user_realname != null && !user_realname.isEmpty()) {
                orders = queryRunner.query(connection,sql.toString(),new BeanListHandler<Order>(Order.class),user_realname);
            }else if(item_name != null && !item_name.isEmpty()) {
                orders = queryRunner.query(connection,sql.toString(),new BeanListHandler<Order>(Order.class),item_name);
            }else {
                orders = queryRunner.query(connection,sql.toString(),new BeanListHandler<Order>(Order.class));
            }
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
}
