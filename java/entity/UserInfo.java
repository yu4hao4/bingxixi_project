package entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Integer user_id;
    private String user_nick;
    private String user_descrip;
    private String user_photouri;
    private String user_realname;
    private String user_location;
    private Integer user_idnumber;
    private Integer user_isProhibit;
    private Integer user_phone;

    public UserInfo() {}

    public Integer getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(Integer user_phone) {
        this.user_phone = user_phone;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_descrip() {
        return user_descrip;
    }

    public void setUser_descrip(String user_descrip) {
        this.user_descrip = user_descrip;
    }

    public String getUser_photouri() {
        return user_photouri;
    }

    public void setUser_photouri(String user_photouri) {
        this.user_photouri = user_photouri;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
        this.user_location = user_location;
    }

    public Integer getUser_idnumber() {
        return user_idnumber;
    }

    public void setUser_idnumber(Integer user_idnumber) {
        this.user_idnumber = user_idnumber;
    }

    public Integer getUser_isProhibit() {
        return user_isProhibit;
    }

    public void setUser_isProhibit(Integer user_isProhibit) {
        this.user_isProhibit = user_isProhibit;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id=" + user_id +
                ", user_nick='" + user_nick + '\'' +
                ", user_descrip='" + user_descrip + '\'' +
                ", user_photouri='" + user_photouri + '\'' +
                ", user_realname='" + user_realname + '\'' +
                ", user_location='" + user_location + '\'' +
                ", user_idnumber=" + user_idnumber +
                ", user_isProhibit=" + user_isProhibit +
                '}';
    }
}
