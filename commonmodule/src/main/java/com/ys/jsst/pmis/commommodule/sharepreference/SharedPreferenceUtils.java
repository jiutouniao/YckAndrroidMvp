package com.ys.jsst.pmis.commommodule.sharepreference;

import android.util.Log;

/**
 * description: 存储基本的个人信息
 * Date: 2016/7/14 10:30
 * User: shaobing
 */
public class SharedPreferenceUtils {

  public static final String LOG_TAG = SharedPreferenceUtils.class.getSimpleName();
  //软件初次打开标志
  public static final String IS_FIRST_ENTER = "is_first_enter";
  //用户账号
  public static final String USER_ID = "user_id";
  //用户密码加密后字符串
  public static final String PASSWORD = "password";
  //验证字符
  public static final String TOKEN = "token";
  //当前正在处理的书本ID
  public static final String CURRENT_BOOK_ID = "book_id";
  public static final String PDF_CURRENT_BOOK_ID = "pdf_book_id";
  public static final String PDF_BOOK_NAME = "pdf_book_name";
  public static final String PDF_BOOK_IMGS = "pdf_book_imgs";
  public static final String PDF_BOOK_AUTHOR= "pdf_book_author";
  //是否保存密码
  public static final String CHECK_REMEMBER_PASSWORD = "check_remember_password";
  //用户昵称
  public static final String NICK_NAME = "nick_name";
  //用户头像连接
  public static final String HEAD_IMAGE = "head_image";
  //用户性别
  public static final String SEX = "sex";
  //个人介绍
  public static final String SELF_INTRODUCTION = "self_introduction";
  //经验值
  public static final String EXPERIENCE = "experience";
  //当前经验值
  public static final String SCORE = "score";
  //
  public static final String GOLDEN_BELL = "golden_bell";
  public static final String SILVER_BELL = "silver_bell";
  public static final String VIP_DAY = "vip_day";
  public static final String SIGN_COUNT = "sign_count";
  public static final String RESOURCE_ID = "resource_id";
  public static final String SIGN_DAYS = "sign_days";
  public static final String JOIN_BOOK_BAR = "join_book_bar";
  public static final String CO_ID = "co_id";

  //总阅读时间
  public static final String READ_TIME = "read_time_time";
  //阅读数量
  public static final String READ_COUNT = "read_count";
  //测试数量
  public static final String TEST_COUNT = "test_count";

  //头条下拉时间
  public static final String HEADLINE_TIME = "headline_time";
  public static final String TOPIC_COMMENT_LIST_TIME = "topic_comment_list_time";
  public static final String STACK_BOOK_TIME = "stack_book_time";
  public static final String MONTH_BOOK_TIME = "month_book_time";

  //我的读书计划
  public static final String MY_PLAN_TIME = "my_plan_time";

  //社区往期活动更多
  public static final String COMMUNITY_TIME = "community_time";

  //书吧详情评论下拉时间
  public static final String BOOKBAR_DETAIL_COMMENT_TIME = "bookbar_detail_comment_time";
  //书吧下拉时间
  public static final String BOOKBAR_DETAIL_TIME = "bookbar_detail_time";
  //头条详情下拉时间
  public static final String HEADLINE_DETAIL_TIME = "headline_detail_time";
  //讲书下拉时间
  public static final String TEACHER_TIME = "teacher_time";
  //我的计划时间
  public static final String PLAN_MY_TIME = "plan_my_time";
  //全部的计划时间
  public static final String PLAY_ALL_TIME = "plan_all_time";
  //圈子书吧
  public static final String CIRCLE_BOOK_BAR = "circle_book_bar";
  //圈子频道
  public static final String CIRCLE_CHANNEL = "circle_channel";
  //我的消息
  public static final String MESSAGE_TIME = "message_time";
  //扫描
  public static final String SCAN_BOOK = "scan_book";
  //存储当前网络版本号
  public static final String NET_VERSION_CODE = "net_version_code";
  //存储当前网络版本路径
  public static final String NET_VERSION_PATH = "net_version_path";
  private static final String DEVEICEID = "deveiceid";


  /**
   * 保存是否记住密码状态
   * @param isSave 状态
   * */
  public static void saveCheckRememberPasswordState(boolean isSave){
    SharePreferenceHelper.getInstance().setBooleanValue(CHECK_REMEMBER_PASSWORD, isSave);
  }

  /**
   * 获取记住密码状态
   * */
  public static Boolean getCheckRememberPasswordState(){
    return SharePreferenceHelper.getInstance().getBooleanValue(CHECK_REMEMBER_PASSWORD);
  }


  /**
   * 保存当前网络版本号
   */
  public static void saveVersion(String version) {
    SharePreferenceHelper.getInstance().setStringValue(NET_VERSION_CODE, version);
  }

  /**
   *获取当前网络版本号
   */
  public static String getVersion() {
    return SharePreferenceHelper.getInstance().getStringValue(NET_VERSION_CODE);
  }

  /**
   * 保存当前网络版本号路径
   */
  public static void saveVersionPath(String path) {
    SharePreferenceHelper.getInstance().setStringValue(NET_VERSION_PATH, path);
  }

  /**
   *获取当前网络版本号路径
   */
  public static String getVersionPath() {
    return SharePreferenceHelper.getInstance().getStringValue(NET_VERSION_PATH);
  }

    /**
   * 存储软件初次打开标志
   */
  public static void saveIsFirst(boolean isFirst) {
    SharePreferenceHelper.getInstance().setBooleanValue(IS_FIRST_ENTER, isFirst);
  }

  /**
   * 获取软件初次打开标志
   */
  public static boolean getIsFirst() {
    return SharePreferenceHelper.getInstance().getBooleanValue(IS_FIRST_ENTER, false);
  }

  //书库请求的type
  public static final String STACK_TYPE = "type";
  /**
   * 0  包月   1  书籍详情购买  2 pdf整本书  3pdf章节付费    4活动付费  5购买图书    6.购买整本电子书  7.购买但章节电子书
   * 8  计划付费
   */
  public static final String PAY_TYPE = "pay_type";

  //书库请求的self
  public static final String SELF = "self";

  //切换分类数组
  public static final String CGARRAY = "changearray";
  public static final String CGARRAYLENGTH = "changearrayl";

  //更多分类数组
  public static final String MOREARRAY = "morearray";
  public static final String MOREARRAYLENGTH = "morearrayl";
  public static final String ORDER_ID = "order_id";

  //切换分类数组
  public static void saveChangeArray(String[] stringArray) {

    SharePreferenceHelper.getInstance().saveStringArray(CGARRAY, stringArray);
  }

  public static String[] getChangeArray(int arrayLength) {

    return SharePreferenceHelper.getInstance().getStringArray(CGARRAY, arrayLength);
  }

  //存储切换分类数组长度
  public static void saveChangeArrayLength(int arraylength) {
    SharePreferenceHelper.getInstance().setIntValue(CGARRAYLENGTH, arraylength);
  }

  public static int getChangeArrayLength() {
    return SharePreferenceHelper.getInstance().getIntValue(CGARRAYLENGTH);
  }

  //更多分类数组
  public static void saveMoreArray(String[] stringArray) {

    SharePreferenceHelper.getInstance().saveStringArray(MOREARRAY, stringArray);
  }

  public static String[] getMoreArray(int arrayLength) {

    return SharePreferenceHelper.getInstance().getStringArray(MOREARRAY, arrayLength);
  }

  //存储更多分类数组长度
  public static void saveMoreArrayLength(int arraylength) {
    SharePreferenceHelper.getInstance().setIntValue(MOREARRAYLENGTH, arraylength);
  }

  public static int getMoreArrayLength() {
    return SharePreferenceHelper.getInstance().getIntValue(MOREARRAYLENGTH);
  }

  /**
   * 保存登陆的账户
   */
  public static void saveUser_id(String user_id) {
    SharePreferenceHelper.getInstance().setStringValue(USER_ID, user_id);
  }

  /**
   * 获取登陆的账户
   */
  public static String getUser_id() {
    return SharePreferenceHelper.getInstance().getStringValue(USER_ID);
  }


  /**
   * 保存订单id
   */
  public static void saveOrder_id(String order_id) {
    SharePreferenceHelper.getInstance().setStringValue(ORDER_ID, order_id);
  }

  /**
   * 获取订单id
   */
  public static String getOrder_id() {
    return SharePreferenceHelper.getInstance().getStringValue(ORDER_ID);
  }

  /**
   * 保存验证字符
   */
  public static void saveToken(String token) {
    SharePreferenceHelper.getInstance().setStringValue(TOKEN, token);
  }

  /**
   * 获取验证字符
   */
  public static String getToken() {
    return SharePreferenceHelper.getInstance().getStringValue(TOKEN);
  }

  /*
 保存用户密码
  */
  public static void savePassWord(String password) {
    SharePreferenceHelper.getInstance().setStringValue(PASSWORD, password);
  }

  /**
   * 获取用户密码
   */
  public static String getPassWord() {
    return SharePreferenceHelper.getInstance().getStringValue(PASSWORD);
  }

  /**
   * 保存书本ID
   */
  public static void saveBookId(String book_id) {
    SharePreferenceHelper.getInstance().setStringValue(CURRENT_BOOK_ID, book_id);
  }

  //保存加入阅读的书本ID
  public static void saveAddBookId( String key ,String book_id){

    SharePreferenceHelper.getInstance().setStringValue(key, book_id);

  }
  /**
   * 获取加入阅读的书本ID
   */
  public static String getAddBookId(String key) {
    return SharePreferenceHelper.getInstance().getStringValue(key);
  }

  //保存设备号
  public static void saveDeveiceId(String book_id){

    SharePreferenceHelper.getInstance().setStringValue(DEVEICEID, book_id);

  }
  /**
   * 获取加入阅读的书本ID
   */
  public static String getDeveiceId() {
    return SharePreferenceHelper.getInstance().getStringValue(DEVEICEID);
  }

  /**
   * 获取支付类型
   */
  public static int getPayType() {
    return SharePreferenceHelper.getInstance().getIntValue(PAY_TYPE);
  }



  /**
   * 保存支付类型
   */
  public static void savePayType(int pay_type) {
    SharePreferenceHelper.getInstance().setIntValue(PAY_TYPE, pay_type);
  }

  /**
   * 获取书本ID
   */
  public static String getBookId() {
    return SharePreferenceHelper.getInstance().getStringValue(CURRENT_BOOK_ID);
  }

  /*
 保存用户昵称
  */
  public static void saveNickName(String nick_name) {
    SharePreferenceHelper.getInstance().setStringValue(NICK_NAME, nick_name);
  }

  /**
   * 获取用户昵称
   */
  public static String getNickName() {
    return SharePreferenceHelper.getInstance().getStringValue(NICK_NAME);
  }

  /*
  保存用户头像
  */
  public static void saveHeadImage(String head_image) {
    SharePreferenceHelper.getInstance().setStringValue(HEAD_IMAGE, head_image);
  }

  /**
   * 获取用户头像
   */
  public static String getHeadImage() {
    return SharePreferenceHelper.getInstance().getStringValue(HEAD_IMAGE);
  }

  /*
  保存用户性别
  */
  public static void saveSex(String sex) {
    SharePreferenceHelper.getInstance().setStringValue(SEX, sex);
  }

  /**
   * 获取用户性别
   */
  public static String getSex() {
    return SharePreferenceHelper.getInstance().getStringValue(SEX);
  }

  /*
  保存用户个人介绍
  */
  public static void saveSelfIntroduction(String self_introduction) {
    SharePreferenceHelper.getInstance().setStringValue(SELF_INTRODUCTION, self_introduction);
  }

  /**
   * 获取用户个人介绍
   */
  public static String getSelfIntroduction() {
    return SharePreferenceHelper.getInstance().getStringValue(SELF_INTRODUCTION);
  }

  /*
  保存用户经验值
  */
  public static void saveExperience(String experience) {
    SharePreferenceHelper.getInstance().setStringValue(EXPERIENCE, experience);
  }

  /**
   * 获取用户经验值
   */
  public static String getExperience() {
    return SharePreferenceHelper.getInstance().getStringValue(EXPERIENCE);
  }

  /*
  保存用户经验值
  */
  public static void saveScore(String score) {
    SharePreferenceHelper.getInstance().setStringValue(SCORE, score);
  }

  /**
   * 获取用户经验值
   */
  public static String getScore() {
    return SharePreferenceHelper.getInstance().getStringValue(SCORE);
  }

  /*
  GOLDEN_BELL
  */
  public static void saveGoldenBell(String golden_bell) {
    SharePreferenceHelper.getInstance().setStringValue(GOLDEN_BELL, golden_bell);
  }

  /**
   * GOLDEN_BELL
   */
  public static String getGoldenBell() {
    return SharePreferenceHelper.getInstance().getStringValue(GOLDEN_BELL);
  }

  /**
   * SilverBell
   */
  public static String getSilverBell() {
    return SharePreferenceHelper.getInstance().getStringValue(SILVER_BELL);
  }

  /**
   * SilverBell
   */
  public static void saveSilverBell(String silver_bell) {
    SharePreferenceHelper.getInstance().setStringValue(SILVER_BELL, silver_bell);
  }

  /**
   * 获取剩余的VIP天数
   */
  public static void saveVipDay(String vip_day) {
    SharePreferenceHelper.getInstance().setStringValue(VIP_DAY, vip_day);
  }

  /**
   * 获取剩余的VIP天数
   */
  public static String getVipDay() {
    return SharePreferenceHelper.getInstance().getStringValue(VIP_DAY);
  }

  /*
 保存用户阅读时间
 */
  public static void saveReadTime(String Read_time) {
    SharePreferenceHelper.getInstance().setStringValue(READ_TIME, Read_time);
  }

  /**
   * 获取用户阅读时间
   */
  public static String getReadTime() {
    return SharePreferenceHelper.getInstance().getStringValue(READ_TIME);
  }

  /*
    保存用户阅读数量
    */
  public static void saveReadCount(String Read_count) {
    SharePreferenceHelper.getInstance().setStringValue(READ_COUNT, Read_count);
  }

  /**
   * 获取用户阅读数量
   */
  public static String getReadCount() {
    return SharePreferenceHelper.getInstance().getStringValue(READ_COUNT);
  }

  /*
    保存用户测试数量
    */
  public static void saveTestCount(String test_count) {
    SharePreferenceHelper.getInstance().setStringValue(TEST_COUNT, test_count);
  }

  /**
   * 获取用户测试数量
   */
  public static String getTestCount() {
    return SharePreferenceHelper.getInstance().getStringValue(TEST_COUNT);
  }

  /**
   * 保存type
   */
  public static void saveType(String tpye) {
    SharePreferenceHelper.getInstance().setStringValue(STACK_TYPE, tpye);
  }

  /**
   * 获取type
   */
  public static String getType() {
    return SharePreferenceHelper.getInstance().getStringValue(STACK_TYPE);
  }

  /**
   * 保存self
   */
  public static void saveSelf(String self) {
    SharePreferenceHelper.getInstance().setStringValue(SELF, self);
  }

  /**
   * 获取self
   */
  public static String getSelf() {
    return SharePreferenceHelper.getInstance().getStringValue(SELF);
  }

  /**
   * 保存连续签到天数
   */
  public static void saveSignCount(String self) {
    SharePreferenceHelper.getInstance().setStringValue(SIGN_COUNT, self);
  }


  /**
   * 保存书架书籍
   */
  public static void saveBookShelf(String self) {
    SharePreferenceHelper.getInstance().setStringValue(RESOURCE_ID, self);
  }

  /**
   * 获取连续签到天数
   */
  public static String getSignCount() {
    return SharePreferenceHelper.getInstance().getStringValue(SIGN_COUNT);
  }

  /**
   * 保存签到日期
   */
  public static void saveSignDays(String self) {
    SharePreferenceHelper.getInstance().setStringValue(SIGN_DAYS, self);
  }

  /**
   * 获取签到日期
   */
  public static String getSignDays() {
    return SharePreferenceHelper.getInstance().getStringValue(SIGN_DAYS);
  }


  /**
   * 保存组织机构id
   */
  public static void saveDoId(String self) {
    SharePreferenceHelper.getInstance().setStringValue(CO_ID, self);
  }

  /**
   * 获取组织机构id
   */
  public static String getDoId() {
    return SharePreferenceHelper.getInstance().getStringValue(CO_ID);
  }

  public static  long getRefreshTime(String value){
    return  SharePreferenceHelper.getInstance().getLongValue(value);

  }
  public static  void setRefreshTime(String value,long time){
      SharePreferenceHelper.getInstance().setLongValue(value,time);

  }
  public static  String getCpu(String value){
    return  SharePreferenceHelper.getInstance().getStringValue(value);
  }
  public static  void setCpu(String value, String time){
    SharePreferenceHelper.getInstance().setStringValue(value,time);

  }
  /**
   *
   *  panduan dang qian  shu ben  shi fou  wei sao miao
   */
  public static void saveScanBook(String book) {
    SharePreferenceHelper.getInstance().setStringValue(SCAN_BOOK, book);
  }

  /**
   * huo qu  shu  扫描书本
   */
  public static String getScanBook() {
    return SharePreferenceHelper.getInstance().getStringValue(SCAN_BOOK);
  }
//  /**
//   * 获取是否加入贴吧
//   */
//  public static String getJoinBookBar() {
//    return SharePreferenceHelper.getInstance().getStringValue(JOIN_BOOK_BAR);
//  }
//  /**
//   * 设置是否加入贴吧
//   */
//  public static void setJoinBookBar(String b) {
//     SharePreferenceHelper.getInstance().setStringValue(JOIN_BOOK_BAR,b);
//  }

  /**
   * 保存书本ID
   */
  public static void savePDFBookId(String book_id) {
    SharePreferenceHelper.getInstance().setStringValue(PDF_CURRENT_BOOK_ID, book_id);
  }
  public static  String getPDFBookId(){
    return  SharePreferenceHelper.getInstance().getStringValue(PDF_CURRENT_BOOK_ID);
  }


  /**
   * 保存书本ID
   */
  public static void savePDFBookName(String book_id) {
    SharePreferenceHelper.getInstance().setStringValue(PDF_BOOK_NAME, book_id);
  }
  public static  String getPDFBookName(){
    return  SharePreferenceHelper.getInstance().getStringValue(PDF_BOOK_NAME);
  }

  public static void savePDFBookImgs(String book_id) {
    SharePreferenceHelper.getInstance().setStringValue(PDF_BOOK_IMGS, book_id);
  }
  public static  String getPDFBookImgs(){
    return  SharePreferenceHelper.getInstance().getStringValue(PDF_BOOK_IMGS);
  }

  public static void savePDFBookAuthor(String book_id) {
    SharePreferenceHelper.getInstance().setStringValue(PDF_BOOK_AUTHOR, book_id);
  }
  public static  String getPDFBookAuthor(){
    return  SharePreferenceHelper.getInstance().getStringValue(PDF_BOOK_AUTHOR);
  }
}
