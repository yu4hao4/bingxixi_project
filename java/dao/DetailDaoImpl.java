package dao;

import dao.inf.DetailDao;
import entity.DetailImg;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtil;

import java.sql.Connection;

public class DetailDaoImpl implements DetailDao {
    /**
     * 从数据库中获得对应商品的uri
     * @return
     */
    @Override
    public DetailImg getDetailImg(Integer item_id) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from item_images where item_id=?";
        DetailImg img = null;
        try{
            img = qr.query(conn,sql,new BeanHandler<DetailImg>(DetailImg.class),item_id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}
