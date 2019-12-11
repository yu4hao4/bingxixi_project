package servlet;

import service.inf.ShoppingCartService;
import service.ShoppingCartServiceImpl;
import utils.BaseServlet;
import utils.ParamsUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/myShoppingCartServlet")
public class MyShoppingCartServlet extends BaseServlet {
    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    /**
     * 将数组用JSON格式发送给前端
     * @param request
     * @param response
     * @throws Exception
     */
    public void userShoppingCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ParamsUtil paramsUtil = new ParamsUtil(request);

        /**
         * 获得cookie中的user_id
         */
        Cookie[] cookies = request.getCookies();
        Integer user_id = null;
        for (Cookie cookie:
                cookies) {
            if(cookie.getName().equals("user_id")) {
                user_id = Integer.parseInt(cookie.getValue());
                break;
            }
        }
        if(user_id == null) {
            return;
        }
        List list = shoppingCartService.sendItem(user_id);
        response.getWriter().print(paramsUtil.getJSON(list));

    }
}
