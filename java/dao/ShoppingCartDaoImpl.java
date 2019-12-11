package dao;

import dao.inf.ShoppingCartDao;
import entity.MyShoppingCart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

    /**
     * 获取购物车界面所需数据
     * @return
     */
    @Override
    public List getItem(Integer user_id) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql ="select item_selected,item_photouri,item_name,item_description,item_num,item_price" +
                " from cart a join item b on a.item_id = b.item_id " +
                "where a.user_id=?";
        List list = new ArrayList();
        MyShoppingCart item = new MyShoppingCart();
        try{
            list = qr.query(conn,sql,new BeanListHandler<MyShoppingCart>(MyShoppingCart.class),user_id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
