package service;

import entity.User;
import entity.UserInfo;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * user登录
     * @param user
     * @return
     */
    public Boolean userLogin(User user, HttpServletResponse response);
    /**
     * user注册
     * @param user
     * @return
     */
    public Boolean userRegister(User user, UserInfo userinfo);
}
