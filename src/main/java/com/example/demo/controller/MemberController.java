package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/member/list")
    public Map<String,Object> findMemberList(Model model){
        List<MemberDTO> list=memberService.findMemberList();
        Map<String,Object> map=new HashMap<>();
        map.put("list", list);
        return map;
    }

    @PostMapping("/member")
    public void registerMember(@RequestBody MemberDTO memberDTO){
        memberService.registerMember(memberDTO);
    }

    @PutMapping("/member")
    public void modifyMember(@RequestBody MemberDTO memberDTO){
        memberService.modifyMember(memberDTO);
    }

    @DeleteMapping ("/member/{id}")
    public void removeMember(@PathVariable String id){
        memberService.removeMember(id);
    }
}