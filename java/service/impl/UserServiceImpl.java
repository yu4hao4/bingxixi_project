package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import entity.UserInfo;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * user登录
     * @param user
     * @return
     */
    public Boolean userLogin(User user, HttpServletResponse response) {

        Boolean bool = false;
        User u = userDao.userLogin(user);
        //有user_id表示成功登陆
        response.addCookie(new Cookie("user_id",u.getUser_id().toString()));
        if(u != null) {
            bool = true;
        }
        return bool;
    }
    /**
     * user注册
     * @param user
     * @return
     */
    public Boolean userRegister(User user, UserInfo userinfo) {
//        if(!user.getUser_name().matches("/^[-_a-zA-Z0-9]{4,16}$/")) {
//            return false;
//        }else if(!user.getUser_pass().matches("/(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$@!%*#?&])[A-Za-z\\d$@!%*#?&]{6,}$/")) {
//            return false;
//        }else if(userDao.isRepeat(user.getUser_name()) > 0) {
//            return false;
//        }
        Integer num1 = userDao.userRegister(user);
        Integer num2 = userDao.userInfoRegister(userinfo);
        if(num1 == 0||num2 == 0) {
            userDao.userDel(user);
            userDao.userInfoDel(user);
            return false;
        }
        return true;
    }
}
