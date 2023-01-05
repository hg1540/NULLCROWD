package com.teamtwo.nullfunding.member.controller;

import com.teamtwo.nullfunding.member.dto.MemberDTO;
import com.teamtwo.nullfunding.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/member")
public class MemberController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PasswordEncoder passwordEncoder;
    private MemberService memberService;

    @Autowired
    public MemberController(PasswordEncoder passwordEncoder, MemberService memberService) {
        this.passwordEncoder = passwordEncoder;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String goLogIn(){
        return "content/member/login";
    }

    @GetMapping("/memberList")
    public String getMeberList(Model model){

        log.info("회원목록요청");

        List<MemberDTO> memberList = memberService.getMemberList();

        model.addAttribute("title", "회원목록조회");
        model.addAttribute("memberList", memberList);

        return "memer/memberList";
    }
//
//    @GetMapping("/signup")
//    public String signup(){  }
}

