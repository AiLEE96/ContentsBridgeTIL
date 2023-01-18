package org.socket.chat.dto;

public class EnterResponse {

    private String userName;

    public EnterResponse() {
    }

    public static EnterResponse of(final EnterRequest enterRequest) {
        return new EnterResponse(enterRequest.getUserName());
    }

    public EnterResponse(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
