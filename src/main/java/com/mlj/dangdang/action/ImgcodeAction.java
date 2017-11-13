package com.mlj.dangdang.action;

import com.mlj.dangdang.util.ImageUtil;
import com.mlj.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgcodeAction extends ActionSupport {

    private InputStream inputStream;
    private String number;//验证码
    private String checkImginfo;

    public String getCheckImginfo() {
        return checkImginfo;
    }

    public void setCheckImginfo(String checkImginfo) {
        this.checkImginfo = checkImginfo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 获取验证码
     *
     * @return
     */
    public String imgCode() {
        String imgcode = ImageUtil.getNumber(4);
        Struts2ScopeUtil.setSessionAttribute("imgCode", imgcode);//验证码
        try {
            byte[] attr = ImageUtil.getInstance(100, 30, 4, imgcode);
            inputStream = new ByteArrayInputStream(attr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 验证验证码
     */
    public void checkImg() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");

        String myCode = Struts2ScopeUtil.getSessionAttribute("imgCode").toString();
        if (myCode.equals(number)) {
            try {
                response.getWriter().print("1");//验证码正确
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print("0");//验证码错误
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
