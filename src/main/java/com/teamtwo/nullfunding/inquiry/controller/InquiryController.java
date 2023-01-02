package com.teamtwo.nullfunding.inquiry.controller;

import com.teamtwo.nullfunding.inquiry.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    private InquiryService inquiryService;

    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/list")
    public ModelAndView inquiryList(ModelAndView mv){


        mv.setViewName("content/inquiry/question");

        return mv;
    }

    @GetMapping("/request")
    public ModelAndView inquiryRequest(ModelAndView mv){

        mv.setViewName("content/inquiry/request");

        return mv;
    }
}