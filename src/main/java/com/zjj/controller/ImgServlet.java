package com.zjj.controller;

import com.zjj.constants.SysConstant;
import com.zjj.utils.ImgCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @auth yunsll
 * @date 2020/3/17 20:49
 * @Descripiton 测试类
 */
@WebServlet("/login/getPic")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImgCodeUtil imgCodeUtil = new ImgCodeUtil();
        //获取验证码图片
        BufferedImage image = imgCodeUtil.getImage();

        //获取验证码文本内容
        String code = imgCodeUtil.getText();
        //把图片验证码的文本内容存入session
        HttpSession session = req.getSession();
        session.setAttribute(SysConstant.SESSION_PIC_CODE,code);

        // 禁止图像缓存
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        //这里的0就是取消等待出现的时间.点击验证码图片能够更换
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        //将图像输出到Servlet输出流中,然后显示到前端页面上,每次点击都会更改图片
        ServletOutputStream sos = resp.getOutputStream();
        //用图片的io流(图片,格式,servlet输出流(输出方式))
        ImageIO.write(image,"jpeg",sos);
        sos.flush();
        sos.close();

    }
}
