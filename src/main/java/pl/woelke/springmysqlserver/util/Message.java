package pl.woelke.springmysqlserver.util;

public class Message {

    private int failCode;
    private String message;

    public Message(int failCode, String message) {
        this.failCode = failCode;
        this.message = message;
    }

    public int getFailCode() {
        return failCode;
    }

    public void setFailCode(int failCode) {
        this.failCode = failCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
