package cn.edu.zufe.web003.bean;

import java.util.Date;

public class User {

    private int id;
    private String userName;
    private String passWord;
    private String sex;
    private String major;
    private boolean usingSeat;
    private int seatId;
    private boolean isLeft;
    private Date timeLeft;
    private int violationCounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isUsingSeat() {
        return usingSeat;
    }

    public void setUsingSeat(boolean usingSeat) {
        this.usingSeat = usingSeat;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
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

    public int getViolationCounts() {
        return violationCounts;
    }

    public void setViolationCounts(int violationCounts) {
        this.violationCounts = violationCounts;
    }
}
