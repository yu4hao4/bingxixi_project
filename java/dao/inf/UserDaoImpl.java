package dao.impl;

import dao.UserDao;
import entity.User;
import entity.UserInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * user登录
     * @param user
     * @return
     */
    public User userLogin(User user) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JDBCUtil.getConn();

        String sql = "select * from user where user_name=? and user_pass=?";
        User u = null;
        try {
            u = queryRunner.query(connection,sql,new BeanHandler<User>(User.class),user.getUser_name(),user.getUser_pass());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
        return u;
    }

    /**
     * 注册(user)
     * @param user
     * @return
     */
    public Integer userRegister(User user) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "insert into user(user_name,user_pass) values (?,?)";
        int num = 0;
        try {
            num = qr.update(conn,sql,user.getUser_name(),user.getUser_pass());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return num;
    }

    /**
     * 注册(userinfo)
     * @param userinfo
     * @return
     */
    public Integer userInfoRegister(UserInfo userinfo) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "insert into user_info(user_id,user_nick,user_phone) " +
                "values (?,?,?)";
        int num = 0;
        try {
            num = qr.update(conn,sql,userinfo.getUser_id(),userinfo.getUser_nick(),userinfo.getUser_phone());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return num;
    }
    /**
     * 删除(userinfo)
     * @param user
     * @return
     */
    public Integer userInfoDel(User user) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "delete from user where user_id is null";
        int num = 0;
        try {
            num = qr.update(conn,sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return num;
    }
    /**
     * 删除(user)
     * @param user
     * @return
     */
    public Integer userDel(User user) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "delete from user where user_name=?";
        int num = 0;
        try {
            num = qr.update(conn,sql,user.getUser_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return num;

    }

    /**
     * 判断用户名是否重复
     * @param user_name
     * @return
     */
    public Integer isRepeat(String user_name) {
        Connection conn = JDBCUtil.getConn();
        QueryRunner qr = new QueryRunner();
        String sql = "select count(*) from user where user_name=?";
        int num = 0;
        try {
            num = qr.update(conn,sql,user_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return num;
    }

}
