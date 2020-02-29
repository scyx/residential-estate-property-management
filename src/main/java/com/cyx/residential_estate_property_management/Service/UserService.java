package com.cyx.residential_estate_property_management.Service;

import com.cyx.residential_estate_property_management.Bean.User;
import com.cyx.residential_estate_property_management.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyx
 * @data 2020/1/6 12:53
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user) {
        return userDao.login(user);
    }

    /**
     *
     * @param token 生成的随机UUID串
     * @return
     */
    public Cookie generateCookie(String token) {
        Cookie cookie = new Cookie("token",token);
        cookie.setPath("/");
        cookie.setMaxAge(3600*24*5);
        return cookie;
    }

}
