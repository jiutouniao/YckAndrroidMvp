package com.soft.yck.home.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 * 作者：shenrunzhou
 * 时间： 2017-05-11 10:50
 */
public class Bookbean implements Serializable, Parcelable {
  /**
   * author : 温新权
   * collection_count : 0
   * comment_count : 0
   * cost_days : 15
   * count : 0
   * create_time : 2017-05-09 10:02:08.0
   * head_image : /user/zxf/icon.jpg
   * is_free : 1
   * is_read : 0
   * nickname : dddddddddttttttt
   * original_path : type_08/978-7-121-07895-8.pdf
   * press : 电子工业出版社
   * price : 26
   * publisher : 电子工业出版社
   * read_progress : 0
   * report_count : 0
   * resource_browse_count : 0
   * resource_id : ebook_00008189
   * resource_list : []
   * resource_name : 数码彩色电视机维修技能与实训
   * resource_score : 0
   * resource_type : 0
   * thumb_pic : type_08/978-7-121-07895-8.jpg
   */

  private String author;
  private int card_count;
  private int collection_count;
  private int comment_count;
  private int cost_days;
  private int count;
  private String create_time;
  private String end_time_read;
  private String fans;
  private String head_image;
  private String is_free;
  private String is_read;
  private String nickname;
  private String original_path;
  private String press;
  private String price;
  private String publisher;
  private String read_duration;
  private float read_progress;
  private int report_count;
  private int resource_browse_count;
  private String resource_desc;
  private String resource_id;
  private String resource_name;
  private int resource_score;
  private String resource_type;
  private String score;
  private String start_time_read;
  private String thumb_pic;
  private List<?> resource_list;

  public float getRead_progress() {
    return read_progress;
  }

  public void setRead_progress(float read_progress) {
    this.read_progress = read_progress;
  }

  public String getEnd_time_read() {
    return end_time_read;
  }

  public void setEnd_time_read(String end_time_read) {
    this.end_time_read = end_time_read;
  }

  public String getFans() {
    return fans;
  }

  public void setFans(String fans) {
    this.fans = fans;
  }

  public String getRead_duration() {
    return read_duration;
  }

  public void setRead_duration(String read_duration) {
    this.read_duration = read_duration;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getStart_time_read() {
    return start_time_read;
  }

  public void setStart_time_read(String start_time_read) {
    this.start_time_read = start_time_read;
  }

  public int getCard_count() {
    return card_count;
  }

  public void setCard_count(int card_count) {
    this.card_count = card_count;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getCollection_count() {
    return collection_count;
  }

  public void setCollection_count(int collection_count) {
    this.collection_count = collection_count;
  }

  public int getComment_count() {
    return comment_count;
  }

  public void setComment_count(int comment_count) {
    this.comment_count = comment_count;
  }

  public int getCost_days() {
    return cost_days;
  }

  public void setCost_days(int cost_days) {
    this.cost_days = cost_days;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public String getHead_image() {
    return head_image;
  }

  public void setHead_image(String head_image) {
    this.head_image = head_image;
  }

  public String getIs_free() {
    return is_free;
  }

  public void setIs_free(String is_free) {
    this.is_free = is_free;
  }

  public String getIs_read() {
    return is_read;
  }

  public void setIs_read(String is_read) {
    this.is_read = is_read;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getOriginal_path() {
    return original_path;
  }

  public void setOriginal_path(String original_path) {
    this.original_path = original_path;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getReport_count() {
    return report_count;
  }

  public void setReport_count(int report_count) {
    this.report_count = report_count;
  }

  public int getResource_browse_count() {
    return resource_browse_count;
  }

  public void setResource_browse_count(int resource_browse_count) {
    this.resource_browse_count = resource_browse_count;
  }

  public String getResource_desc() {
    return resource_desc;
  }

  public void setResource_desc(String resource_desc) {
    this.resource_desc = resource_desc;
  }

  public String getResource_id() {
    return resource_id;
  }

  public void setResource_id(String resource_id) {
    this.resource_id = resource_id;
  }

  public String getResource_name() {
    return resource_name;
  }

  public void setResource_name(String resource_name) {
    this.resource_name = resource_name;
  }

  public int getResource_score() {
    return resource_score;
  }

  public void setResource_score(int resource_score) {
    this.resource_score = resource_score;
  }

  public String getResource_type() {
    return resource_type;
  }

  public void setResource_type(String resource_type) {
    this.resource_type = resource_type;
  }

  public String getThumb_pic() {
    return thumb_pic;
  }

  public void setThumb_pic(String thumb_pic) {
    this.thumb_pic = thumb_pic;
  }

  public List<?> getResource_list() {
    return resource_list;
  }

  public void setResource_list(List<?> resource_list) {
    this.resource_list = resource_list;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.author);
    dest.writeInt(this.card_count);
    dest.writeInt(this.collection_count);
    dest.writeInt(this.comment_count);
    dest.writeInt(this.cost_days);
    dest.writeInt(this.count);
    dest.writeString(this.create_time);
    dest.writeString(this.end_time_read);
    dest.writeString(this.fans);
    dest.writeString(this.head_image);
    dest.writeString(this.is_free);
    dest.writeString(this.is_read);
    dest.writeString(this.nickname);
    dest.writeString(this.original_path);
    dest.writeString(this.press);
    dest.writeString(this.price);
    dest.writeString(this.publisher);
    dest.writeString(this.read_duration);
    dest.writeFloat(this.read_progress);
    dest.writeInt(this.report_count);
    dest.writeInt(this.resource_browse_count);
    dest.writeString(this.resource_desc);
    dest.writeString(this.resource_id);
    dest.writeString(this.resource_name);
    dest.writeInt(this.resource_score);
    dest.writeString(this.resource_type);
    dest.writeString(this.score);
    dest.writeString(this.start_time_read);
    dest.writeString(this.thumb_pic);
  }

  public Bookbean() {
  }

  protected Bookbean(Parcel in) {
    this.author = in.readString();
    this.card_count = in.readInt();
    this.collection_count = in.readInt();
    this.comment_count = in.readInt();
    this.cost_days = in.readInt();
    this.count = in.readInt();
    this.create_time = in.readString();
    this.end_time_read = in.readString();
    this.fans = in.readString();
    this.head_image = in.readString();
    this.is_free = in.readString();
    this.is_read = in.readString();
    this.nickname = in.readString();
    this.original_path = in.readString();
    this.press = in.readString();
    this.price = in.readString();
    this.publisher = in.readString();
    this.read_duration = in.readString();
    this.read_progress = in.readFloat();
    this.report_count = in.readInt();
    this.resource_browse_count = in.readInt();
    this.resource_desc = in.readString();
    this.resource_id = in.readString();
    this.resource_name = in.readString();
    this.resource_score = in.readInt();
    this.resource_type = in.readString();
    this.score = in.readString();
    this.start_time_read = in.readString();
    this.thumb_pic = in.readString();
  }

  public static final Creator<Bookbean> CREATOR = new Creator<Bookbean>() {
    @Override public Bookbean createFromParcel(Parcel source) {
      return new Bookbean(source);
    }

    @Override public Bookbean[] newArray(int size) {
      return new Bookbean[size];
    }
  };

  @Override public boolean equals(Object obj) {
    if (obj instanceof Bookbean) {
      return resource_name.equals(((Bookbean) obj).resource_name) && author.equals(
          ((Bookbean) obj).author);
    }
    return false;
  }

  @Override public int hashCode() {
    return resource_name.hashCode() + author.hashCode();
  }
}