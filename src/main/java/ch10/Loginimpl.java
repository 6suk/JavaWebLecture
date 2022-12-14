package ch10;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Loginimpl
 *
 */
//@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
		System.out.println("loginImpl Constructor");
	}

	public void sessionCreated(HttpSessionEvent se) {
		++total_user;
		System.out.println("Session Created " + total_user);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destroyed " + total_user);
		--total_user;
	}

}
