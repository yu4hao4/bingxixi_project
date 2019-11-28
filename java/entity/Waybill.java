package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author BlockDusty
 * @Date 2019/11/27 21:02
 * 用于存放运单信息
 */
public class Waybill implements Serializable {
    /**
     * 运单号
     */
    private Integer waybill_id;
    /**
     * 订单号
     */
    private Integer order_id;
    /**
     * 目的地
     */
    private String destination;
    /**
     * 始发地
     */
    private String original;
    /**
     * 收货时间
     */
    private Date get_date_resourse;
    private String get_date;
    /**
     * 发货时间
     */
    private Date send_date_resourse;
    private String send_date;

    public Waybill() {
    }

    public Integer getWaybill_id() {
        return waybill_id;
    }

    public void setWaybill_id(Integer waybill_id) {
        this.waybill_id = waybill_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getGet_date() {
        return get_date;
    }

    public String getSend_date() {
        return send_date;
    }

    public Date getGet_date_resourse() {
        return get_date_resourse;
    }

    public void setGet_date_resourse(Date get_date_resourse) {
        this.get_date_resourse = get_date_resourse;
        this.get_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(get_date_resourse);
    }

    public void setGet_date(String get_date) {
        this.get_date = get_date;
    }

    public Date getSend_date_resourse() {
        return send_date_resourse;
    }

    public void setSend_date_resourse(Date send_date_resourse) {
        this.send_date_resourse = send_date_resourse;
        this.send_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(send_date_resourse);
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }
}
