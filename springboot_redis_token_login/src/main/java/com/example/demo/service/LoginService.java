package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    RedisService redisService;

    /**
     * 进行登录操作，如果用户名和密码正确，使用UUID一个字符串作为token
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password){
        if(username.equals("liu")&&password.equals("123")){
            String token = UUID.randomUUID().toString();
            redisService.set(token,username);
            return username+"登录成功，token是："+token;
        }else {
            return "用户名或密码错误";
        }

    }

    /**
     * 进行注销操作，实质是删除redis和token中的缓存
     * @param httpServletRequest
     * @return
     */
    public String logout(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        boolean delete = redisService.delete(token);
        if (delete){
            return "注销成功";
        }else {
            return "注销失败";
        }
    }


}
