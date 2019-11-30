package entity;

import java.io.Serializable;

/**
 * @author BlockDusty
 * @date 2019/11/30 15:57
 */
public class Item implements Serializable {
    /**
     * 商品编号
     */
    private Integer item_id;
    /**
     * 所属店铺id
     */
    private Integer shop_id;
    /**
     * 商品名
     */
    private String item_name;
    /**
     * 商品类型
     */
    private String item_type;
    /**
     * 商品价格
     */
    private Float item_price;
    /**
     * 是否下架的信息
     */
    private String item_shelves;
    /**
     * 商品主图
     */
    private String item_photouri;
    /**
     * 审核状态
     */
    private String item_statu;
    /**
     * 商品余量
     */
    private Integer item_amount;

    public Item() {

    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Float getItem_price() {
        return item_price;
    }

    public void setItem_price(Float item_price) {
        this.item_price = item_price;
    }

    public String getItem_shelves() {
        return item_shelves;
    }

    public void setItem_shelves(String item_shelves) {
        this.item_shelves = item_shelves;
    }

    public String getItem_photouri() {
        return item_photouri;
    }

    public void setItem_photouri(String item_photouri) {
        this.item_photouri = item_photouri;
    }

    public String getItem_statu() {
        return item_statu;
    }

    public void setItem_statu(String item_statu) {
        this.item_statu = item_statu;
    }

    public Integer getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(Integer item_amount) {
        this.item_amount = item_amount;
    }
}
