package com.example.chatting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.chatting.entity.Member;
import com.example.chatting.model.ChatRoom;
import com.example.chatting.service.service;

import jakarta.servlet.http.HttpSession;

@Controller
public class controller {
    private service test;

	@Autowired
	service memberService;

	@GetMapping("/")
	public String loginGet(Member member) {
		return "index";
	}

    @GetMapping("/room")
	public String rooms(Member member) {
		return "room";
	}

	@PostMapping("/")
	public String loginPost(HttpSession session, Member member) {
		Member memberNow = memberService.findById(member.getId()).get();

		// 로그인 성공
		if (memberNow.getPw().equals(member.getPw())) {
			session.setAttribute("memberId", member.getId());
			System.out.println("로그인에 성공했습니다.");
			return "redirect:/room";
		}

		// 로그인 실패
		else {
			System.out.println("패스워드가 일치하지 않습니다.");
			return "redirect:/";
		}

	}

	@GetMapping("/join")
	public String joinGet(Member member) {
		return "join";
	}

	@PostMapping("/join")
	public String joinPost(Member member) {

		memberService.save(member);
		System.out.println(member + "가 가입되었습니다.");

		return "redirect:/";
	}

    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return test.findAllRoom();
    }
    
    // 채팅방 생성
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return test.createRoom(name);
    }

	@GetMapping("/chat")
	public String chatGET(HttpSession session) {

		System.out.println("@ChatController, chat GET()");

		return "chat";
	}

}