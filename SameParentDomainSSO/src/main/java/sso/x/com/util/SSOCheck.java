package sso.x.com.util;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录校验工具类
 * Created by Administrator on 2017/8/3 0003.
 */

public class SSOCheck {
    /** 测试用户名 */
    private static final String USERNAME="user";
    /** 测试密码*/
    private static final String PASSWORD="123456";
    /** Cookie键 */
    private static final String COOKIE_NAME = "ssocookie";
    /** Cookie值*/
    private static final String COOKIE_VALUE = "yunz";

    /**
     * 登录用户名和密码校验
     * @param username 用户名
     * @param password 密码
     * @return true用户名和密码正确；false用户名或密码错误
     */
    public static boolean checkLogin(String username,String password){
        return USERNAME.equalsIgnoreCase(username) && PASSWORD.equalsIgnoreCase(password);
    }

    /**
     * 校验cookie
     * @param cookieName
     * @param cookieValue
     * @return
     */
    public static boolean checkCookie(String cookieName, String cookieValue){
        return COOKIE_NAME.equals(cookieName) && COOKIE_VALUE.equals(cookieValue);
    }
}