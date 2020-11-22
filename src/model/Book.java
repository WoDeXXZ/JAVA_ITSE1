package model;

import java.io.Serializable;

public class Book implements Serializable {
    //图书类
    //包含图书的所有基础信息

    public Book() {
        //无参构造函数
    }

    public Book(int bookNumber, String title, String author,
                String press, int count) {
        //有参构造函数
        this.bookNumber = bookNumber;
        this.title = title;
        this.author = author;
        this.press = press;
        this.count = count;
    }

    public Book(Book book) {
        //复制构造函数
        this.bookNumber = book.bookNumber;
        this.title = book.title;
        this.author = book.author;
        this.press = book.press;
        this.count = book.count;
    }

    //下面是get和set函数
    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
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

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //上面是get和set函数

    @Override
    public String toString() {
        //覆写toString
        return bookNumber +
                "," + title +
                "," + author +
                "," + press +
                "," + count + '\n';
    }

    private int bookNumber;//书号
    private String title;//书名
    private String author;//作者
    private String press;//出版社
    private int count;//藏书量
}