package com.videoweb.ccassign2.controller;

import com.google.gson.Gson;
import com.videoweb.ccassign2.entity.Response;
import com.videoweb.ccassign2.entity.User;
import com.videoweb.ccassign2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletResponse httpServletResponse, @RequestBody User user){
        Boolean b = userService.loginValidation(user.getUserName(),user.getPassword());
        if(b)
        {
            Cookie cookie = new Cookie("username",user.getUserName());
            cookie.setPath("/");
            cookie.setMaxAge(3600);
            httpServletResponse.addCookie(cookie);
            String welcome = "Login Success! Welcome back "+ user.getUserName();
            return new Gson().toJson(new Response(true,welcome));
        }
        else
        {
            return new Gson().toJson(new Response(false,"Username or password is incorrect!"));
        }
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestBody @Valid User user, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return new Gson().toJson(new Response(false,"Invalid Information"));
        }
        Boolean b = userService.createUser(user);
        if(b)
        {
            return new Gson().toJson(new Response(true,"Register Success!"));
        }
        else
        {
            return new Gson().toJson(new Response(false,"User already exist！"));
        }
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest)
    {
        Cookie[] cookies = httpServletRequest.getCookies();
        {
            for(int i=0;i<cookies.length;i++)
            {
                // delete all the cookies
                cookies[i].setMaxAge(0);
            }
        }
        return new Gson().toJson(new Response(true,"Logout Success"));
    }

}
