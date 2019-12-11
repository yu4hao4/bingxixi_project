package service.inf;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 将拿到的数据交给Servlet处理
     * @param user_id
     * @return
     */
    public List sendItem(Integer user_id);
}
