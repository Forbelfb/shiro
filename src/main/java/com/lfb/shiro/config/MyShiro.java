/*
package com.lfb.shiro.config;

import com.lfb.shiro.config.realms.MyShiroRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
*/
/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/31 0:47
 * @Description:
 *//*

@Configuration
public class MyShiro {
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
       // autoProxyCreator.setUsePrefix(true);
        return autoProxyCreator;
    }

        //注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
        @Bean
        public Realm realm() {
            return new MyShiroRealm();
        }


       */
/* @Bean
        public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
            DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
            *//*
*/
/**
             * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
             * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
             * 加入这项配置能解决这个bug
             *//*
*/
/*
            creator.setUsePrefix(true);
            return creator;
        }*//*


        */
/**
         * 这里统一做鉴权，即判断哪些请求路径需要用户登录，哪些请求路径不需要用户登录。
         * 这里只做鉴权，不做权限控制，因为权限用注解来做。
         * @return
         *//*

        @Bean
        public ShiroFilterChainDefinition shiroFilterChainDefinition() {
            DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
            //哪些请求可以匿名访问
            chain.addPathDefinition("/login", "anon");
            //除了以上的请求外，其它请求都需要登录
           chain.addPathDefinition("/**", "anon");

            return chain;
        }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
*/
