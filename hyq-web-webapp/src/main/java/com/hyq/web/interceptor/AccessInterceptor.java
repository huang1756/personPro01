package com.hyq.web.interceptor;


import com.aiton.framework.base.utils.EncodeUtils;
import com.aiton.framework.ueditor.JSONUtils;
import com.aiton.framework.web.SessionContext;
import com.aiton.framework.web.annotation.NotNeedLogin;
import com.hyq.api.model.UserModel;
import com.hyq.web.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录过滤器
 * @author Lezc
 * @CreateTime : Nov 2, 2014 4:45:46 PM
 * @Description : XXX
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
     * preHandle (javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        SessionContext sessionContext = SessionContext.getSessionContext(request);

        if (sessionContext.isLoginFlag()) {
            UserModel userModel = sessionContext.getAttribute(Constants.SESSION_KEY_USER);
            request.setAttribute("user", userModel);
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object controller = handlerMethod.getBean();

        NotNeedLogin notNeedLogin = controller.getClass().getAnnotation(NotNeedLogin.class);
        if (notNeedLogin == null) {
            notNeedLogin = handlerMethod.getMethod().getAnnotation(NotNeedLogin.class);
        }

        if (notNeedLogin != null) {
            return true;
        }

        ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
        if (responseBody != null) {

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("success", false);
            resultMap.put("message", "请先登录！");

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();

                out.append(JSONUtils.json(resultMap).toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }

        } else {

            String targetUrl = request.getRequestURL().toString();
            if (StringUtils.isNotBlank(request.getQueryString())) {
                targetUrl += ("?" + request.getQueryString());
            }

            response.sendRedirect(request.getAttribute("contextPath") + "/login?redirectUrl="
                    + EncodeUtils.urlEncode(targetUrl));
        }

        return false;
   }

}
