package com.product.license;

import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LicenseFilter
 */
@Slf4j
public class LicenseFilter implements Filter {

	@Autowired
	private LicenseVertify licenseVertify;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器销毁");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		int valid = licenseVertify.vertify();
//
//		if(0==valid){
			chain.doFilter(request, response);
//		}else if(1==valid){//过期
//			request.getRequestDispatcher("overdue.jsp").forward(request,response);
//		}else if(2==valid){
//			throw new ServletException("证书错误");
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
//		boolean init = licenseVertify.setParam();
//		if(init){
//			System.out.println("过滤器初始化成功");
//		}else{
//			throw new ServletException();
//		}

	}

}
