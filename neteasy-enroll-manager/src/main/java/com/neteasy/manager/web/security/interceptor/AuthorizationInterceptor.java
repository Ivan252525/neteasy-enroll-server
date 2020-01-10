package com.neteasy.manager.web.security.interceptor;


import com.neteasy.common.utils.string.StringUtils;
import com.neteasy.manager.modules.sys.entity.SysUserEntity;
import com.neteasy.manager.modules.sys.service.SysUserService;
import com.neteasy.manager.web.annotation.Login;
import com.neteasy.manager.web.exception.BaseException;
import com.neteasy.manager.web.exception.message.ErrorInfo;
import com.neteasy.manager.web.security.jwt.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆验证
 *
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    SysUserService sysUserService;

    @SuppressWarnings("unchecked")
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
    	Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

//        if(annotation == null){
//            return true;
//        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(jwtUtils.getHeader());
        }

        //凭证为空
        if(StringUtils.isEmpty(token)){
            if (annotation != null) {
                throw new BaseException(ErrorInfo.NOT_LOGIN);
            }
        } else {
            Claims claims = jwtUtils.getClaimByToken(token);
            if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
                if (annotation != null) {
                    throw new BaseException(ErrorInfo.NOT_LOGIN);
                }
            } else {
                //把user放到request中
                String subject = claims.getSubject();
                Long userId = Long.parseLong(subject);
                SysUserEntity userEntity = sysUserService.getById(userId);
                request.setAttribute("sysUserEntity", userEntity);
            }
        }

        return true;
    }
}
