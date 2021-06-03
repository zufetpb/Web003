package cn.edu.zufe.web003.bean;

import java.util.Date;

public class Seat {
    private int id;
    private boolean beUsing;
    private int userId;
    private String userName;
    private boolean isLeft;
    private Date timeLeft;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBeUsing() {
        return beUsing;
    }

    public void setBeUsing(boolean beUsing) {
        this.beUsing = beUsing;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public Date getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Date timeLeft) {
        this.timeLeft = timeLeft;
    }
}
