package com.hyq.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

/**
 * 基本拦截器
 *
 * @author Lezc
 * @CreateTime Aug 1, 2015 9:23:39 AM
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(CommonInterceptor.class);

    /*@Autowired
    private ConfigService configService;*/

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

        LOG.debug("－－－－－－－－－－－－－－－－－－");
        LOG.debug("请求路径：" + request.getRequestURL());
        LOG.debug("请求客户端：" + request.getHeader("user-agent"));

        int i = 0;

        Set<Map.Entry<String, String[]>> paramEntries = request.getParameterMap().entrySet();
        for (Map.Entry<String, String[]> paramEntry : paramEntries) {
            for (String value : paramEntry.getValue()) {
                LOG.debug("请求参数" + i + ":" + paramEntry.getKey() + "=" + value);
            }
            i++;
        }

        if (Boolean.valueOf(request.getParameter("isView")) && !(request.getRequestURI().equals("/") || request.getRequestURI().equals("")) && !request.getRequestURI().startsWith("/wx")) {

            String realUrl = request.getRequestURL().toString();

            if (StringUtils.isNotBlank(request.getQueryString())) {
                realUrl = realUrl + "?" + request.getQueryString();
            }

            request.setAttribute("realUrl", realUrl);
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }


        // 注入服务器当天时间
        request.setAttribute("currentTime", Calendar.getInstance().getTime());

        String contextPath = request.getContextPath();
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();

        if (!requestURI.equals("/")) {
            requestURL = requestURL.replace(requestURI, "");
        }

        if (requestURL.endsWith("/")) {
            requestURL = requestURL.substring(0, requestURL.length() - 1);
        }

        if (contextPath.equals("/")) {
            contextPath = "";
        }

        request.setAttribute("contextPath", requestURL + contextPath);
        request.setAttribute("resourcePath", requestURL + contextPath + "/resources");

        boolean result = super.preHandle(request, response, handler);

        return result;
    }
}
