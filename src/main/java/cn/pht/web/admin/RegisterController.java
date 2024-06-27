package cn.pht.web.admin;

import cn.pht.po.User;
import cn.pht.service.UserService;
import cn.pht.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String RegisterPage() {
        return "admin/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String nickname,
                           @RequestParam String email,
                           HttpSession session,
                           RedirectAttributes attributes) {
        User user = new User();
        if (!username.isEmpty() && !password.isEmpty() && !nickname.isEmpty() && !email.isEmpty()) {
            user.setUsername(username);
            user.setPassword(MD5Utils.code(password));
            user.setNickname(nickname);
            user.setEmail(email);
            user.setType(1);
            user.setAvatar("https://pongbw-learn.oss-cn-chengdu.aliyuncs.com/%E5%A4%B4%E5%83%8F%EF%BC%88%E6%96%B9%EF%BC%89.jpg");
            userService.insertUser(user);
            return "admin/login";
        }else{
            attributes.addFlashAttribute("message", "注册信息不能为空");
            return "redirect:/admin/register";
        }
    }
}
