package com.first.common.controller;

import com.first.common.model.dto.UserDTO;
import com.first.common.model.entity.User;
import com.first.common.service.LoginService;
import com.first.common.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;//@Autowired 필드 주입 (편리한 것 외에 장점없음, Spring 4.3부터 사용하지 않는 것 권장) -> 생성자 주입
//    private final Status status;

    @GetMapping("/login")
    public String userLogin()
    {
        return "/user/login";

    }

    @GetMapping("/login/error")
    public String loginerror(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인 하세요");
        return "user/login";
    }

    @GetMapping("/user")
    public String userUser()
    {
        return "/user/user";

    }

    //회원가입
    @GetMapping("/signup")
    public String signUp() {
        return "/user/signup";
    }

    @PostMapping("/singup")
    @ResponseBody
    public int signUp(@ModelAttribute UserDTO user) {

       int result = service.signUp(user);

       if (result == 0) {
           return Status.ZERO;
       }
       return Status.FIRST;
    }

}
