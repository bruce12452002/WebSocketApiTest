package bruce.home.WebSocketApiTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "xxx.html";
    }

}
