package com.cyx.residential_estate_property_management.estate.property.management;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResidentialEstatePropertyManagementApplicationTests {
//	@Test
//	void contextLoads() {
//
//	}
//	@Test
//	public void testHelloWorld() {
//		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//		IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
//		defaultSecurityManager.setRealm(iniRealm);
//		SecurityUtils.setSecurityManager(defaultSecurityManager);
//		Subject subject = SecurityUtils.getSubject();
//		//
//		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//		try {
//			//4、登录，即身份验证
//			subject.login(token);
//		} catch (AuthenticationException e) {
//			//5、身份验证失败
//		}
//		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
//		//6、退出
//		subject.logout();
//	}

}
