package dao.inf;

import entity.User;
import entity.UserInfo;

public interface UserDao {
    /**
     * user登录
     * @param user
     * @return
     */
     public User userLogin(User user);

    /**
     * 注册(user)
     * @param user
     * @return
     */
     public Integer userRegister(User user);
    /**
     * 注册(userinfo)
     * @param userinfo
     * @return
     */
    public Integer userInfoRegister(UserInfo userinfo);
    /**
     * 删除(user)
     * @param user
     * @return
     */
    public Integer userDel(User user);
    /**
     * 删除(userinfo)
     * @param user
     * @return
     */
    public Integer userInfoDel(User user);

    /**
     * 查询用户名是否重复
     * @param user_name
     * @return
     */
    public Integer isRepeat(String user_name);

}
