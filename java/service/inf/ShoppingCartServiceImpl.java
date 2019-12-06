package service.impl;

import dao.ShoppingCartDao;
import dao.impl.ShoppingCartDaoImpl;
import service.ShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
    /**
     * 将拿到的数据交给Servlet处理
     * @param user_id
     * @return
     */
    @Override
    public List sendItem(Integer user_id) {
        return shoppingCartDao.getItem(user_id);
    }
}
