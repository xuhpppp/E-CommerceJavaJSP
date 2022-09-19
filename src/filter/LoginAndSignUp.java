package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

//@WebFilter(filterName = "LoginAndSignUp")
public class LoginAndSignUp implements Filter {

    public LoginAndSignUp() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse rep = (HttpServletResponse) response;
			
			rep.sendRedirect("home");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
