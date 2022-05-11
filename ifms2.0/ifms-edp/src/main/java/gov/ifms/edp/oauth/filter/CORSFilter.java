package gov.ifms.edp.oauth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import gov.ifms.edp.oauth.util.OAuthConstant;

/**
 * The Class CORSFilter.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

	private static final String OPTIONS = "OPTIONS";
	private static final String ORIGIN = "Origin";

	/**
	 * Inits the.
	 *
	 * @param filterConfig the filter config
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//it is init method
	}

	/**
	 * Do filter.
	 *
	 * @param servletRequest the servlet request
	 * @param servletResponse the servlet response
	 * @param chain the chain
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		/*
		 * response.setHeader(OAuthConstant.ACCESS_CONTROL_ALLOW_ORIGN,request.getHeader
		 * (ORIGIN));
		 */
		response.setHeader(OAuthConstant.ACCESS_CONTROL_ALLOW_METHODS, OAuthConstant.HTTP_METHOD);
		response.setHeader(OAuthConstant.ACCESS_CONTROL_MAX_AGE, OAuthConstant.ACCESS_CONTROL_MAX_AGE_VALUE);
		response.setHeader(OAuthConstant.ACCESS_CONTROL_ALLOW_HEADER, OAuthConstant.ACCESS_CONTROL_ALLOW_HEADER_VALUE);
		if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}

	}

	/**
	 * Destroy.
	 */
	@Override
	public void destroy() {
		//It is destroy method
	}

}