package controller.merchant;

import com.alibaba.fastjson.JSONObject;
import entity.Item;
import service.MerchantService;
import utils.BaseServlet;
import utils.JSONutil;
import utils.ParamsUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author moxiaoya
 * @date 2019/12/03 20:17
 */
@WebServlet("/sell")
public class SellController extends BaseServlet{
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
            item.setItem_shelves("未上架");
            response.getWriter().write(JSONutil.getJSON(merchantService.getItemInfos(item)).toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 修改商品信息的方法
     * @param request
     * @param response
     */
    public void updateItem(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        boolean bool = false;
        try{
            ParamsUtil paramsUtil = new ParamsUtil(request);
            Item item = paramsUtil.postGetParams(Item.class);
            System.out.println(item.getItem_amount());
            if(item != null) {
                bool = merchantService.changeItemInfo(item);
            }
            response.getWriter().write(JSONutil.getJSON(bool).toString());
        }catch (IOException e) {

        }
    }
    /**
     * 用于预售添加商品
     * @param request
     * @param response
     */
    public void insertItem(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        boolean bool = false;
        try{
            ParamsUtil paramsUtil = new ParamsUtil(request);
            Item item = paramsUtil.postGetParams(Item.class);
            if(item != null) {
                bool = merchantService.insertItem(item);
            }
            response.getWriter().write(JSONutil.getJSON(bool).toString());
        }catch (IOException e) {

        }
    }
    /**
     * 用于上架商品
     * @param request
     * @param response
     */
    public void Item(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");

        boolean bool = false;
        try{
            ParamsUtil paramsUtil = new ParamsUtil(request);
            Item item = paramsUtil.postGetParams(Item.class);
            if(item != null) {
                bool = merchantService.downshelfItem(item);
            }
            response.getWriter().write(JSONutil.getJSON(bool).toString());
        }catch (IOException e) {

        }
    }

}
