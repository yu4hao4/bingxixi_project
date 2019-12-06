package dao;


import java.util.List;

public interface ShoppingCartDao {
    /**
     * 获取购物车界面所需数据
     * @return
     */
    public List getItem(Integer user_id);
}
