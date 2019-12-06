package entity;

import java.io.Serializable;

public class DetailImg implements Serializable {
    private Integer item_id;
    private String item_bigimageuri;
    private String item_smallimageuri1;
    private String item_smallimageuri2;
    private String item_smallimageuri3;
    private String item_smallimageuri4;
    private String item_smallimageuri5;

    public DetailImg() {}

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_bigimageuri() {
        return item_bigimageuri;
    }

    public void setItem_bigimageuri(String item_bigimageuri) {
        this.item_bigimageuri = item_bigimageuri;
    }

    public String getItem_smallimageuri1() {
        return item_smallimageuri1;
    }

    public void setItem_smallimageuri1(String item_smallimageuri1) {
        this.item_smallimageuri1 = item_smallimageuri1;
    }

    public String getItem_smallimageuri2() {
        return item_smallimageuri2;
    }

    public void setItem_smallimageuri2(String item_smallimageuri2) {
        this.item_smallimageuri2 = item_smallimageuri2;
    }

    public String getItem_smallimageuri3() {
        return item_smallimageuri3;
    }

    public void setItem_smallimageuri3(String item_smallimageuri3) {
        this.item_smallimageuri3 = item_smallimageuri3;
    }

    public String getItem_smallimageuri4() {
        return item_smallimageuri4;
    }

    public void setItem_smallimageuri4(String item_smallimageuri4) {
        this.item_smallimageuri4 = item_smallimageuri4;
    }

    public String getItem_smallimageuri5() {
        return item_smallimageuri5;
    }

    public void setItem_smallimageuri5(String item_smallimageuri5) {
        this.item_smallimageuri5 = item_smallimageuri5;
    }

    @Override
    public String toString() {
        return "DetailImg{" +
                "item_id=" + item_id +
                ", item_bigimageuri='" + item_bigimageuri + '\'' +
                ", item_smallimageuri1='" + item_smallimageuri1 + '\'' +
                ", item_smallimageuri2='" + item_smallimageuri2 + '\'' +
                ", item_smallimageuri3='" + item_smallimageuri3 + '\'' +
                ", item_smallimageuri4='" + item_smallimageuri4 + '\'' +
                ", item_smallimageuri5='" + item_smallimageuri5 + '\'' +
                '}';
    }
}
