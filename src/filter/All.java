package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.FindToken;
import entity.User;

public class All implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		int idUser = 0;
		String token = "";
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("idEShop")) {
					idUser = Integer.valueOf(c.getValue());
				}
				
				if (c.getName().equals("tokenLoginEShop")) {
					token = c.getValue();
				}
			}
		}
		
		try {
			User user = FindToken.findToken(idUser, token);
			
			if (user != null) {
				HttpSession session = req.getSession();
				
				session.setAttribute("user", user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
