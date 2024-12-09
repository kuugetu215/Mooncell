package karazuki.filter;



import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import context.BaseContext;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import result.Result;
import utils.JwtUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取请求url
        String url = req.getRequestURL().toString();
        log.info("URL: {}", url);
        //是否有login，是则放行
        if(url.contains("login")){
            log.info("登录操作");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(url.contains("register")){
            log.info("注册操作");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(url.contains("doc") || url.contains("swagger")){
            log.info("测试操作");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //获取令牌
        String jwt = req.getHeader("token");
        //判断令牌合法性
        if(!StringUtils.hasLength(jwt)){
            log.info("Token is empty");
            Result error = Result.error("not login");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //存在，则进行解析
        try {
            DecodedJWT decode = JwtUtils.decode(jwt);
            Integer id = Integer.valueOf(decode.getClaim("id").asString());
            log.info("当前用户id：{}", id);
            BaseContext.setCurrentId(id);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回失败信息");
            Result error = Result.error("fail to login");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        //放行
        log.info("login successs");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
