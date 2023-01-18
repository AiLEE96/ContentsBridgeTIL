package org.socket.chat.dto;

public class EnterRequest {

    private String userName;

    public EnterRequest() {
    }

    public EnterRequest(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}


