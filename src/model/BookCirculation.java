package model;

import java.io.Serializable;

public class BookCirculation implements Serializable {
    //图书流通类
    //包含图书流通的所有基础信息

    public BookCirculation() {
        //无参构造函数
    }

    public BookCirculation(int serialNumber, int ID, int bookNumber,
                           String date, int type, int operator) {
        //有参构造函数
        this.serialNumber = serialNumber;
        this.ID = ID;
        this.bookNumber = bookNumber;
        this.date = date;
        this.type = type;
        this.operator = operator;
    }

    public BookCirculation(BookCirculation bookCirculation) {
        //复制构造函数
        this.serialNumber = bookCirculation.serialNumber;
        this.ID = bookCirculation.ID;
        this.bookNumber = bookCirculation.bookNumber;
        this.date = bookCirculation.date;
        this.type = bookCirculation.type;
        this.operator = bookCirculation.operator;
    }

    //下面是get和set函数
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
    //上面是get和set函数

    @Override
    public String toString() {
        //覆写toString
        return serialNumber +
                "," + ID +
                "," + bookNumber +
                "," + date +
                "," + type +
                "," + operator + '\n';
    }

    private int serialNumber;//流水号
    private int ID;//用户名
    private int bookNumber;//书号
    private String date;//日期
    private int type;//借还书类型 0是借书 1是还书
    private int operator;//操作人
}