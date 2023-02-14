package com.example.chatting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type; //메시지 타입,
    private String roomId; //채팅방 ID(룸 번호)
    private String sender; //보내는 사람, 유저 아이디가 된다. 아직 수정 전.
    private String message; //내용
    private String time; //채팅 발송 시간.
}