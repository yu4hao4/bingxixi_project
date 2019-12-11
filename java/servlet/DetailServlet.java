package servlet;

import entity.DetailImg;
import service.inf.DetailService;
import service.DetailServiceImpl;
import utils.BaseServlet;
import utils.ParamsUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detailServlet")
public class DetailServlet extends BaseServlet {
    private DetailService detailService = new DetailServiceImpl();

    /**
     * 将商品的uri以JOSN格式发送给前端
     * @param request
     * @param response
     * @throws Exception
     */
    public void detailServlet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamsUtil paramsUtil = new ParamsUtil(request);
        DetailImg uri = detailService.getDetailImg(1);
    }
}
