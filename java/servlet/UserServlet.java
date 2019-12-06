package servlet;

import entity.User;
import entity.UserInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.BaseServlet;
import utils.JDBCUtil;
import utils.ParamsUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws Exception
     */
    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ParamsUtil paramsUtil = new ParamsUtil(request);
        User user = paramsUtil.postGetParams(User.class);
        Boolean bool = userService.userLogin(user,response);
        //将数据发送给前端
        response.getWriter().print(paramsUtil.getJSON(bool));

    }
    /**
     * 用户注册
     * @param request
     * @param response
     * @throws Exception
     */
    public void userRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ParamsUtil paramsUtil = new ParamsUtil(request);
        String user_name = (String)paramsUtil.postGetParams("user_name");
        String user_pass = (String)paramsUtil.postGetParams("user_pass");
        String user_nick = (String)paramsUtil.postGetParams("user_nick");
        Integer user_phone = (Integer)paramsUtil.postGetParams("user_phone");
        User user = new User();
        UserInfo userinfo = new UserInfo();
        user.setUser_name(user_name);
        user.setUser_pass(user_pass);
        userinfo.setUser_nick(user_nick);
        userinfo.setUser_phone(user_phone);
        response.getWriter().print(paramsUtil.getJSON(userService.userRegister(user,userinfo)));

    }
}
