package service;

import dao.inf.DetailDao;
import dao.DetailDaoImpl;
import entity.DetailImg;
import service.inf.DetailService;

public class DetailServiceImpl implements DetailService {
    DetailDao detailDao = new DetailDaoImpl();
    /**
     * 获取商品的uri
     * @param item_id
     * @return
     */
    public DetailImg getDetailImg(Integer item_id) {
        return detailDao.getDetailImg(item_id);
    }
}
