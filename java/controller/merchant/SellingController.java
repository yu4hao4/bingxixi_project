package controller.merchant;

import com.alibaba.fastjson.JSONObject;
import entity.Item;
import service.MerchantService;
import utils.BaseServlet;
import utils.JSONutil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author BlockDusty
 * @date 2019/11/30 15:53
 */
@WebServlet("/selling")
public class SellingController extends BaseServlet {
    MerchantService merchantService = new MerchantService();

    /**
     * 获得商品信息
     * @param request
     * @param response
     */
    public void getItems(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        try {
            JSONObject param = JSONutil.getJSONAsInputStream(request.getInputStream());
            String shop_id = (String)param.get("shop_id");
            String item_name = (String)param.get("item_name");
            System.out.println(shop_id+","+item_name);
            Item item = new Item();
            item.setShop_id(Integer.parseInt(shop_id));
            item.setItem_name(item_name);
            response.getWriter().write(JSONutil.getJSON(merchantService.getItemInfos(item)).toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
