package me.yunz.sso.action;

import com.opensymphony.xwork2.ActionSupport;
import me.yunz.sso.util.LoginCheck;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/5 0005.
 */
public class SSOAction extends ActionSupport {
    private String username;
    private String password;
    private String gotoUrl;

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  String doLogin() {
        boolean ok = LoginCheck.checkLogin(username, password);
        if (ok) {
            Cookie cookie = new Cookie("ssocookie", "me/me.yunz/sso1");
            cookie.setPath("/");
            HttpServletResponse response = ServletActionContext.getResponse();
            response.addCookie(cookie);
            return SUCCESS;
        }
        return ERROR;
    }
}
