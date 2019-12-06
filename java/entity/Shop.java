package entity;

import java.io.Serializable;

/**
 * @author moxiaoya
 * @data 2019/12/04 21:50
 */
public class Shop implements Serializable {
    /**
     * 商家ID
     */
    private Integer shop_id;

    /**
     * 商家账号
     */
    private String shop_account;

    /**
     * 商家昵称
     */
    private  String shop_nick;

    /**
     * 商家头像
     */
    private String shop_photouri;

    /**
     * 商家地址
     */
    private String shop_location;

    /**
     * 商家法人姓名
     */
    private String shop_realname;

    /**
     * 商家法人身份证号
     */
    private  Integer shop_idnumber;

    /**
     * 商家是否有正常运营的资格
     */
    private Integer shop_isProhibit;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_account() {
        return shop_account;
    }

    public void setShop_account(String shop_account) {
        this.shop_account = shop_account;
    }

    public String getShop_nick() {
        return shop_nick;
    }

    public void setShop_nick(String shop_nick) {
        this.shop_nick = shop_nick;
    }

    public String getShop_photouri() {
        return shop_photouri;
    }

    public void setShop_photouri(String shop_photouri) {
        this.shop_photouri = shop_photouri;
    }

    public String getShop_location() {
        return shop_location;
    }

    public void setShop_location(String shop_location) {
        this.shop_location = shop_location;
    }

    public String getShop_realname() {
        return shop_realname;
    }

    public void setShop_realname(String shop_realname) {
        this.shop_realname = shop_realname;
    }

    public Integer getShop_idnumber() {
        return shop_idnumber;
    }

    public void setShop_idnumber(Integer shop_idnumber) {
        this.shop_idnumber = shop_idnumber;
    }

    public Integer getShop_isProhibit() {
        return shop_isProhibit;
    }

    public void setShop_isProhibit(Integer shop_isProhibit) {
        this.shop_isProhibit = shop_isProhibit;
    }
}
