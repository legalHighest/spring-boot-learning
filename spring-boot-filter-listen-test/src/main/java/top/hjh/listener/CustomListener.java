package top.hjh.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author huang
 * @Description
 * @Date 2023 03 27 15 58
 **/
@WebListener
@Slf4j
public class CustomListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, HttpSessionAttributeListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("context创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("context销毁");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request创建");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("request销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("Session销毁");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("attrubute add");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("attrubute remove");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("attribute replace");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeRemoved(se);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
    }
}
