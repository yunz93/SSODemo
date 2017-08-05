package me.yunz.demo2;

import com.opensymphony.xwork2.ActionSupport;
import me.yunz.sso.util.LoginCheck;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/5 0005.
 */
public class Demo2Action extends ActionSupport {
    private String gotoUrl;

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public String main() {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (LoginCheck.checkCookie(request)) {
            return SUCCESS;
        }
        gotoUrl = "/demo2/main.action";
        return ERROR;
    }
}
