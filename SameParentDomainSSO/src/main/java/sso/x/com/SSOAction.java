package sso.x.com;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import sso.x.com.util.SSOCheck;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    /**
     * 校验用户名密码
     * @return
     */
    public  String doLogin() {
        boolean ok = SSOCheck.checkLogin(username, password);
        if (ok) {
            Cookie cookie = new Cookie("ssocookie", "yunz");
            cookie.setDomain(".x.com");
            cookie.setPath("/");
            HttpServletResponse response = ServletActionContext.getResponse();
            response.addCookie(cookie);
            return SUCCESS;
        }
        return ERROR;
    }

    private String cookieName;
    private String cookieValue;

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }

    /**
     * 校验cookie,并返回结果
     */
    public void checkCookie() throws IOException {
        boolean ok = SSOCheck.checkCookie(cookieName, cookieValue);
        String result = "0";
        if (ok) {
            result = "1";
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().print(result);
        response.getWriter().close();
    }
}
