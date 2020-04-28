package com.cyx.residential_estate_property_management.Service.Authority;

import com.cyx.residential_estate_property_management.Bean.User;
import com.cyx.residential_estate_property_management.Dao.Common.UserDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.mgt.AuthorizingSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cyx
 * @data 2020/4/28 13:27
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    UserDao userDao;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录，开始认证");
        String userName = authenticationToken.getPrincipal().toString();
        System.out.println("userName:" + userName);
        User user = userDao.getUserByUserName(userName);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),user.getName());
            return authenticationInfo;
        }
        System.out.println("用户名或者密码错误");
        return null;
    }
}
