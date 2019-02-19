package com.soft.xiren.db.ebook.bean;

import org.litepal.crud.DataSupport;

/**
 * Description:
 * Date: 2017-8-24  14:15
 * User: zengzheng
 */
public class SaoyisaoBookBean extends DataSupport{
  String book_id;
  String isbn;
  String title;
  String author;
  String price;
  String publisher;
  String publish_date;

  public String getBook_id() {
    return book_id;
  }

  public void setBook_id(String book_id) {
    this.book_id = book_id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
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

  public String getPublish_date() {
    return publish_date;
  }

  public void setPublish_date(String publish_date) {
    this.publish_date = publish_date;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getThumb_url() {
    return thumb_url;
  }

  public void setThumb_url(String thumb_url) {
    this.thumb_url = thumb_url;
  }

  public String getBook_url() {
    return book_url;
  }

  public void setBook_url(String book_url) {
    this.book_url = book_url;
  }

  String category;
  String thumb_url;
  String book_url;
}
