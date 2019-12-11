package service.inf;

import entity.DetailImg;

public interface DetailService {
    /**
     * 获取商品的uri
     * @param item_id
     * @return
     */
    public DetailImg getDetailImg(Integer item_id);
}
