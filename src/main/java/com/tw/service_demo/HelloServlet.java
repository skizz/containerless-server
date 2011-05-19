package com.tw.service_demo;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private final String message;

	public HelloServlet(String message) {
		this.message = message;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setStatus(200);
		PrintStream out = new PrintStream(resp.getOutputStream());
		out.println(message);
		out.close();
	}

	
	
}
