package com.rui.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 基础类提供域对象
 * @author: caihongrui
 * @createtime: 2019-11-15 17:06
 **/
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    protected String companyId="1";// 必须从登陆的用户中得到
    protected String companyName="传智播客";// 必须从登陆的用户中得到

    @ModelAttribute
    public void SetReqAndResp(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }
}
