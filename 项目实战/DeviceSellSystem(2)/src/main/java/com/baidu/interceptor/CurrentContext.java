package com.baidu.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baidu.dto.User;

/**
 * 当前线程上下文的状态参数，主要是当前用户身份信息 注意：如果在一个请求处理线程中又开启新的线程，上下文信息将拷贝到新线程中，但在子线程中加入或修改的数据不会复制回父线程
 * 
 * @author songyz
 * @createTime 2020-01-16 18:15:04
 */
public final class CurrentContext {

    private static ThreadLocal<Context> threadLocal = new InheritableThreadLocal<Context>();

    private CurrentContext() {
    }

    private static Context getContext() {
        Context context = threadLocal.get();
        if (Objects.isNull(context)) {
            context = new Context();
            threadLocal.set(context);
        }

        return context;
    }

    static void init(HttpServletRequest request) {
        Context context = getContext();
        context.setPath(request);
    }

    public static Context get() {
        return getContext();
    }

    public static User getUser() {
        return getContext().user;
    }

    public static class Context {
        HttpSession session;
        String path = "";
        User user;

        void setPath(HttpServletRequest request) {

            this.path = request.getRequestURI();

            this.session = request.getSession();
            this.user = (User) request.getSession().getAttribute("currentUser");
        }
    }
}
