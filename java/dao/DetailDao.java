package dao;

import entity.DetailImg;

public interface DetailDao {
    /**
     * 获得商品的uri
     * @return
     */
    public DetailImg getDetailImg(Integer item_id);
}
