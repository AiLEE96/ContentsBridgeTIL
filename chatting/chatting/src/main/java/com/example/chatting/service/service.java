package com.example.chatting.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatting.entity.Member;
import com.example.chatting.model.ChatRoom;
import com.example.chatting.repository.repository;

import jakarta.annotation.PostConstruct;
@Service
public class service {
    @Autowired
    repository memberRepository;
    
    public void save(Member member) {
        memberRepository.save(member);
    }
    
    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
        //초기화
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 생성
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

     //채팅방 하나 불러오기
    /*public ChatRoom findById(String roomId) {
        return chatRooms.get(roomId);
    }*/
}