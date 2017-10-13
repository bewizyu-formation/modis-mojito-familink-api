package org.gestion.web.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gestion.utils.Tokens;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ValidationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("***************Interceptor fonctionne*****************");
		System.out.println(request.getRequestURL());
		String token = request.getHeader("Authorization");
		if (Tokens.isValid(token)){
		return true;
		}
		else {
			System.out.println("************ERROR***************");
			System.out.println(request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath() + "/mvc/user/");
			response.sendRedirect(request.getScheme() + "://" + request.getHeader("Host") + request.getContextPath() + "/mvc/user/");
			return false;
		}
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}
	
	

}
