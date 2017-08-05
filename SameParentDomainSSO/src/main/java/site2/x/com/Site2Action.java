package site2.x.com;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import site1.x.com.util.Site1Tool;
import site2.x.com.util.Site2Tool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/5 0005.
 */
public class Site2Action extends ActionSupport {
    private String gotoUrl;

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ssocookie")) {
                    String result = Site2Tool.doGet("http://sso.x.com/sso/checkCookie.action",
                            cookie.getName(), cookie.getValue());
                    if (result.equals("1")) {
                        return SUCCESS;
                    }
                }
            }
        }
        gotoUrl = "http://site2.x.com/site2/main.action";
        return ERROR;
    }
}
