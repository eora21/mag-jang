package B208.mag_jang.domain;

public class ChatMessageDTO {
    private String roomId;
    private String writer;
    private String message;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatMessageDTO{" +
                "roomId='" + roomId + '\'' +
                ", writer='" + writer + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
