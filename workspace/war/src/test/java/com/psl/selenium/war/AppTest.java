package com.psl.selenium.war;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.easymock.EasyMock.*;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;

import org.junit.Before;

import org.junit.Test;


public class AppTest {

HttpServletRequest mockReq = null;

HttpServletResponse mockRes = null;

PrintWriter mockPW = null;

@Before

public void setUp() throws Exception {

mockReq = EasyMock.createNiceMock(HttpServletRequest.class);

mockRes = EasyMock.createNiceMock(HttpServletResponse.class);

mockPW = EasyMock.createNiceMock(PrintWriter.class);

}

@Test

public void testdoGet() throws IOException, ServletException{

Hello h = new Hello();

EasyMock.expect(mockRes.getWriter()).andReturn(mockPW);

EasyMock.replay(mockRes);

h.doGet(mockReq, mockRes);

}

}

