package com.ssdy.people.read.login.bean;

/**
 * 登录的返回信息
 */
public class LoginBean {

    /**
     * 用户的头像
     */
    private String head_image;
    private String retCode;
    //用户ID
    private String user_id;
    //密码
    private String password;
    //用户昵称
    private String nickname;
    //token
    private String token;
    //用户性别
    private String sex;
    //用户的自我介绍
    private String self_introduction;
    //经验值
    private int experience;
    //基本
    private int score;

    private int golden_bell;

    private int silver_bell;
    //VIP天数
    private String vip_day;

    //阅读时间
    private int read_time;
    //阅读次数
    private int read_count;
    //做的测试卷次数
    private int test_count;
    /**
     * sign_count : 1
     * sign_days : 20170510,20170516,20170516,20170516
     */

    private String sign_count;
    private String sign_days;
    private String co_id;


    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGolden_bell() {
        return golden_bell;
    }

    public void setGolden_bell(int golden_bell) {
        this.golden_bell = golden_bell;
    }

    public int getSilver_bell() {
        return silver_bell;
    }

    public void setSilver_bell(int silver_bell) {
        this.silver_bell = silver_bell;
    }

    public String getVip_day() {
        return vip_day;
    }

    public void setVip_day(String vip_day) {
        this.vip_day = vip_day;
    }

    public int getRead_time() {
        return read_time;
    }

    public void setRead_time(int read_time) {
        this.read_time = read_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getTest_count() {
        return test_count;
    }

    public void setTest_count(int test_count) {
        this.test_count = test_count;
    }

    public String getSign_count() {
        return sign_count;
    }

    public void setSign_count(String sign_count) {
        this.sign_count = sign_count;
    }

    public String getSign_days() {
        return sign_days;
    }

    public void setSign_days(String sign_days) {
        this.sign_days = sign_days;
    }


    public String getCo_id() {
        return co_id;
    }

    public void setCo_id(String co_id) {
        this.co_id = co_id;
    }
}
