package controller.merchant;

import com.alibaba.fastjson.JSONObject;
import entity.Order;
import service.MerchantService;
import service.impl.MerchantServiceImpl;
import utils.BaseServlet;
import utils.JSONutil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author BlockDusty
 * @date 2019/11/27 14:37
 */
@WebServlet("/order")
public class OrderController extends BaseServlet {

    private MerchantServiceImpl merchantService = new MerchantService();

    /**
     * 返回订单信息
     * @param request
     * @param response
     */
    public void getOrders(HttpServletRequest request, HttpServletResponse response) {
        String item_name = null;
        String user_realname = null;
        Integer shop_id = null;
        try {
            JSONObject data = JSONutil.getJSONAsInputStream(request.getInputStream());
            item_name = data.getString("item_name");
            user_realname = data.getString("user_realname");
            shop_id = data.getInteger("shop_id");
        } catch (IOException e) {
            System.err.println("参数异常");
        }

        Order order = new Order();
        order.setItem_name(item_name);
        order.setUser_realname(user_realname);
        order.setShop_id(shop_id);

        List<Order> orders = merchantService.getOrders(order);
        try {
            response.getWriter().write(JSONutil.getJSON(orders).toString());
        } catch (IOException e) {
            System.err.println("返回时发生错误");
        }
    }
}
