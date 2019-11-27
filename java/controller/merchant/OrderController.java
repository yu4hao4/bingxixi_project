package controller.merchant;

import entity.Order;
import service.MerchantService;
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
    private MerchantService merchantService = new MerchantService();

    public void getOrders(HttpServletRequest request, HttpServletResponse response) {
        String user_realname = request.getParameter("user_realname");
        String item_name = request.getParameter("item_name");

        Order order = new Order();
        order.setItem_name(item_name);
        order.setUser_realname(user_realname);

        List<Order> orders = merchantService.getOrders(order);
        try {
            response.getWriter().write(JSONutil.getJSON(orders).toString());
        } catch (IOException e) {
            System.err.println("返回时发生错误");
        }
    }
}
