package cn.cntl.usermanage.controller;

        import cn.cntl.usermanage.pojo.EasyUIResult;
        import cn.cntl.usermanage.pojo.User;
        import cn.cntl.usermanage.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.HashMap;
        import java.util.Map;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

/*    @RequestMapping("users")
    public String toUser(){
        return "users";
    }*/
    @RequestMapping("/page/{pageName}")
    public String addUser(@PathVariable("pageName") String pageName){

        return pageName;
    }

/*    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryUsersByPage(@RequestParam("page") Integer pageNum,@RequestParam("rows") Integer pageSize){
        EasyUIResult easyUIResult = this.userService.queryUsersByPage(pageNum, pageSize);
        return easyUIResult;
    }*/

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryEasyUIResult(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer pageSize){
        return this.userService.queryEasyUIResult(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping("save")
    public Map<String , Object> addUser(User user){
        HashMap<String , Object> map = new HashMap<>();
        try {
            Boolean b = this.userService.saveUser(user);
            if(b){
                map.put("status","200");
            }else {
                map.put("status","500");
            }
        } catch (Exception e) {
            map.put("status","500");
            e.printStackTrace();
        }
        return map;
    }



}
