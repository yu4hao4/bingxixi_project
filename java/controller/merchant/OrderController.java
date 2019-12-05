package controller.merchant;

import com.alibaba.fastjson.JSONObject;
import entity.Order;
import entity.Waybill;
import service.MerchantService;
import service.inf.MerchantServiceInf;
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

    private MerchantServiceInf merchantService = new MerchantService();

    /**
     * 返回订单信息
     * @param request
     * @param response
     */
    public void getOrders(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

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

    /**
     * 用于提交发货信息单
     * @param request
     * @param response
     */
    public void sendOrderInfos(HttpServletRequest request, HttpServletResponse response) {
        Boolean bool = false;
        try {
            JSONObject data = JSONutil. getJSONAsInputStream(request.getInputStream());
            System.out.println(data);
            Waybill waybill = new Waybill();
            waybill.setOrder_id(data.getInteger("order_id"));
            waybill.setDestination(data.getString("destination"));
            waybill.setOriginal(data.getString("original"));
            waybill.setWaybill_id(data.getInteger("waybill_id"));
            bool = merchantService.updateWaybillInfo(waybill);
        } catch (IOException e) {
            System.err.println("参数异常");
        }

        try {
            response.getWriter().write((JSONutil.getJSON(bool).toString()));
        } catch (IOException e) {
            System.err.println("返回时发生错误");
        }
    }

    /**
     * 用来获取运单详情接口
     * @param request
     * @param response
     */
    public void getWaybillInfo (HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        Waybill waybill = new Waybill();
        try {
            JSONObject data = JSONutil. getJSONAsInputStream(request.getInputStream());
            System.out.println(data);
            waybill.setOrder_id(data.getInteger("order_id"));
        } catch (IOException e) {
            System.err.println("参数异常");
        }

        try {
            response.getWriter().write((JSONutil.getJSON(merchantService.getWaybillInfo(waybill)).toString()));
        } catch (IOException e) {
            System.err.println("返回时发生错误");
        }
    }
}
