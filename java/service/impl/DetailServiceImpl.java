package service.impl;

import dao.DetailDao;
import dao.impl.DetailDaoImpl;
import entity.DetailImg;
import service.DetailService;

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
