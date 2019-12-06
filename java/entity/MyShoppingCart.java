package entity;

import java.io.Serializable;

public class MyShoppingCart implements Serializable {
    private String item_photouri;
    private String item_name;
    private Integer item_num;
    private String item_selected;
    private String item_description;
    private Float item_price;
    public MyShoppingCart() {

    }

    public Integer getItem_num() {
        return item_num;
    }

    public void setItem_num(Integer item_num) {
        this.item_num = item_num;
    }

    public String getItem_selected() {
        return item_selected;
    }

    public void setItem_selected(String item_selected) {
        this.item_selected = item_selected;
    }

    public String getItem_photouri() {
        return item_photouri;
    }

    public void setItem_photouri(String item_photouri) {
        this.item_photouri = item_photouri;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public Float getItem_price() {
        return item_price;
    }

    public void setItem_price(Float item_price) {
        this.item_price = item_price;
    }
}
