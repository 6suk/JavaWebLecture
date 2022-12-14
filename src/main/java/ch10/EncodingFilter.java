package ch10;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/ch10/*")
public class EncodingFilter extends HttpFilter implements Filter {
	ServletContext context;
	
	public EncodingFilter() {
		super();
		System.out.println("EncodingFilter Constructor");
	}

	public void destroy() {
		System.out.println("EncodingFilter destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("EncodingFilter Before chain.doFiletr()");
		request.setCharacterEncoding("utf8");
		StringBuilder sb = new StringBuilder();
		HttpServletRequest request2 = ((HttpServletRequest)request);
		
		String path = request2.getContextPath();
		String pathinfo = request2.getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String remote = request.getRemoteAddr();
		sb.append("\n").append("Context 정보 : "+ context).append("\n")
		.append("URI 정보 : "+ pathinfo).append("\n")
		.append("물리적 정보 : "+ realPath).append("\n")
		.append("Path 정보 : "+ path).append("\n")
		.append("remote 정보 : "+ remote).append("\n");
		System.out.println(sb);
		
		chain.doFilter(request, response);
		
		long begin = System.currentTimeMillis();
		System.out.println("EncodingFilter After chain.doFiletr()");
		long end = System.currentTimeMillis();
		System.out.println("[작업 시간] : " + (end - begin) + "ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter Init");
	}

}
