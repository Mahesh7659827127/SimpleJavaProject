
//This controller layer to accept and respond to the client
package com.telusko.simpleWebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//so by using this RestController we are transferring the data not layout
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to my world 2";
    }

    @RequestMapping("/about") //here the navigation name and method name need not to be same, can be different
    public String about(){
        return "I am learning more effectively";
    }
}
//In this controller we can accept the request and respond so that is why it is special class