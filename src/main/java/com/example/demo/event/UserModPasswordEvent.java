package com.example.demo.event;

public class UserModPasswordEvent {
    private Long userId;
    private String oldPwd;
    private String newPwd;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        return "UserModPasswordEvent{" + "userId=" + userId + ", oldPwd='" + oldPwd + '\'' + ", newPwd='" + newPwd
               + '\'' + '}';
    }
}
