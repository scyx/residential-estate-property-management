package com.cyx.residential_estate_property_management.Service.Common;

import com.cyx.residential_estate_property_management.Bean.User;
import com.cyx.residential_estate_property_management.Dao.Common.UserDao;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.Cookie;
import java.security.MessageDigest;


/**
 * @author cyx
 * @data 2020/1/6 12:53
 */
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    BaseMysqlCRUDManager baseMysqlCRUDManager;
    @Autowired
    UserDao userDao;

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                MD5(user.getPassword())
        );
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            logger.error("账号或密码错误");
            return null;
        }catch (AuthorizationException e) {
            logger.error("没有权限");
            return null;
        }
        return getUser(user);
    }

    private User getUser(User user) {
        user.setPassword(MD5(user.getPassword()));
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

    /**
     * 获取用户列表
     * @param query
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return
     */
    public PageInfo<User> getUserList(String query, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(userDao.getUserList(query));
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    public Integer resetPasswordByUserId(int id) {
        String md5Pswd = MD5("123456");
        return userDao.resetPasswordByUserId(id,md5Pswd);
    }
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public int addUser(User user) {
        user.setPassword(MD5(user.getPassword()));
        return baseMysqlCRUDManager.save(user);
    }

    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public Integer save(User user) {
        return baseMysqlCRUDManager.save(user);
    }

    public int checkUserNameisExist(String userName) {
        return userDao.checkUserNameisExist(userName);
    }

    public Integer distributeGroup(Integer userId, Integer groupId) {
        return userDao.distributeGroup(userId,groupId);
    }
}
