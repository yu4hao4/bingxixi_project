package entity;

import java.util.Date;

/**
 * @author BlockDusty
 * @date 2019/11/27 13:58
 */
public class Order {
    /**
     * 订单编号
     */
    private Integer order_id;
    /**
     * 订单创建日期
     */
    private Date date;
    /**
     * 用户姓名
     */
    private String user_realname;
    /**
     * 用户昵称
     */
    private String user_nick;
    /**
     * 商品id
     */
    private Integer item_id;
    /**
     * 商品名
     */
    private String item_name;
    /**
     * 购买数量
     */
    private Integer order_count;
    /**
     * 配送地址
     */
    private String order_location;

    public Order() {

    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getOrder_count() {
        return order_count;
    }

    public void setOrder_count(Integer order_count) {
        this.order_count = order_count;
    }

    public String getOrder_location() {
        return order_location;
    }

    public void setOrder_location(String order_location) {
        this.order_location = order_location;
    }
}
