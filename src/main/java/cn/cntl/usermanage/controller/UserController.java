package cn.cntl.usermanage.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class UserController {

    @RequestMapping("users")
    public String toUser(){
        return "users";
    }

}
