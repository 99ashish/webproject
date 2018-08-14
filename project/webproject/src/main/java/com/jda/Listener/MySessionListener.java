
package com.jda.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class MySessionListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("Session Created:: ID=" + sessionEvent.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("Session Destroyed:: ID=" + sessionEvent.getSession().getId());
	}
}
