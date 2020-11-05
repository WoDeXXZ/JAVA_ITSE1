package model;

public class BookCirculation {
    //图书流通类
    //包含图书流通的所有基础信息

    public BookCirculation() {
        //无参构造函数
    }

    public BookCirculation(int serial_number, int ID, int book_number,
                           String date, int type, int operator) {
        //有参构造函数
        this.serial_number = serial_number;
        this.ID = ID;
        this.book_number = book_number;
        this.date = date;
        this.type = type;
        this.operator = operator;
    }

    public BookCirculation(BookCirculation bookCirculation) {
        //复制构造函数
        this.serial_number = bookCirculation.serial_number;
        this.ID = bookCirculation.ID;
        this.book_number = bookCirculation.book_number;
        this.date = bookCirculation.date;
        this.type = bookCirculation.type;
        this.operator = bookCirculation.operator;
    }

    //下面是get和set函数
    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBook_number() {
        return book_number;
    }

    public void setBook_number(int book_number) {
        this.book_number = book_number;
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
        return serial_number +
                "," + ID +
                "," + book_number +
                "," + date +
                "," + type +
                "," + operator + '\n';
    }

    private int serial_number;//流水号
    private int ID;//用户名
    private int book_number;//书号
    private String date;//日期
    private int type;//借还书类型
    private int operator;//操作人
}