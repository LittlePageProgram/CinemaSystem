//package com.littlepage.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//
///**
// * 编码过滤器
// * @author 74302
// *
// */
//@Component
//@WebFilter("/templates")
//public class CodingFilter implements Filter{
//
//	private final String[] IGNORE_URI = {"/static"};
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req =  (HttpServletRequest)request;
//		HttpServletResponse resp = (HttpServletResponse)response;
//		
//		String uri = req.getRequestURI();
//		
//		boolean pass = canPassIgnore(uri);
//		if (pass) {
//			chain.doFilter(request, response);
//			return;
//		}
//		System.out.println("----filter----" + uri);
//		chain.doFilter(request, response);
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		chain.doFilter(request, response);
//	}
//
//	/**
//	 * 放行
//	 * @param uri
//	 * @return
//	 */
//	private boolean canPassIgnore(String uri) {
//		for (String val : IGNORE_URI) {
//			
//			if(uri.contains(val)) {
//				return true;
//			};
//		}
//		return false;
//	}
//}
