package controller;

import model.Book;

import java.io.*;
import java.util.ArrayList;

public class BookManagement {
    //管理图书
    //每个图书的书号都是唯一的

    public static ArrayList<Book> bookArrayList;
    //存储数据类型为Book的ArrayList集合

    public static void Read() {
        //读取Book.txt文件到ArrayList集合
        bookArrayList = new ArrayList<>();
        try {
            File file = new File("src\\model\\Book.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                Book book = new Book();
                book.setBookNumber(Integer.parseInt(temp.split(",")[0]));
                book.setTitle(temp.split(",")[1]);
                book.setAuthor(temp.split(",")[2]);
                book.setPress(temp.split(",")[3]);
                book.setCount(Integer.parseInt(temp.split(",")[4]));

                bookArrayList.add(book);
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(ArrayList<Book> bookArrayList) {
        //写入文件Book.txt
        Compare(bookArrayList);
        try {
            FileWriter fileWriter = new FileWriter("src\\model\\Book.txt");
            for (Book book : bookArrayList) {
                fileWriter.write(book.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Input(int bookNumber, String title, String author,
                             String press, int count) {
        //图书信息录入
        Book book = new Book(bookNumber, title, author, press, count);
        Read();
        bookArrayList.add(book);
        Write(bookArrayList);
    }

    public static void Update(int bookNumber, String title, String author,
                              String press, int count) {
        //图书信息修改
        Read();
        for (Book book : bookArrayList) {
            if (bookNumber == book.getBookNumber()) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setPress(press);
                book.setCount(count);
                break;
            }
        }
        Write(bookArrayList);
    }

    public static void Delete(int bookNumber) {
        //图书信息删除
        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookNumber == bookArrayList.get(i).getBookNumber()) {
                bookArrayList.remove(i);
                Write(bookArrayList);
                break;
            }
        }
    }

    public static Book QueryBookNumber(int bookNumber) {
        //书号查询
        Read();
        for (Book book : bookArrayList) {
            if (bookNumber == book.getBookNumber()) {
                return book;
            }
        }
        return null;
    }

    public static Book QueryTitle(String title) {
        //书名查询
        Read();
        for (Book book : bookArrayList) {
            if (title.equals(book.getTitle())) {
                return book;
            }
        }
        return null;
    }

    public static Book QueryAuthor(String author) {
        //作者查询
        Read();
        for (Book book : bookArrayList) {
            if (author.equals(book.getAuthor())) {
                return book;
            }
        }
        return null;
    }

    public static boolean JudgmentAccount(int bookNumber) {
        //判断书号是否存在
        Read();
        for (Book book : bookArrayList) {
            if (bookNumber == book.getBookNumber()) {
                return true;
            }
        }
        return false;
    }

    public static int FindAccountReturnCount(int bookNumber) {
        //查找书号并返回书的数量
        Read();
        for (Book book : bookArrayList) {
            if (bookNumber == book.getBookNumber() && book.getCount() != 0) {
                return book.getCount();
            }
        }
        return 0;
    }

    public static void FindAccountMakeCountPlusOne(int bookNumber) {
        //查找书号并使藏书量加一
        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookNumber == bookArrayList.get(i).getBookNumber()
                    && bookArrayList.get(i).getCount() != 0) {
                bookArrayList.get(i).setCount(bookArrayList.get(i).getCount() + 1);
                Write(bookArrayList);
            }
        }
    }

    public static void FindAccountMakeCountMinusOne(int bookNumber) {
        //查找书号并使藏书量减一
        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookNumber == bookArrayList.get(i).getBookNumber()
                    && bookArrayList.get(i).getCount() != 0) {
                bookArrayList.get(i).setCount(bookArrayList.get(i).getCount() - 1);
                Write(bookArrayList);
            }
        }
    }

    public static void Compare(ArrayList<Book> bookArrayList) {
        //选择排序
        //按照书号bookNumber从小到大开始排序
        for (int i = 0; i < bookArrayList.size(); i++) {
            int temp = i;
            for (int j = i + 1; j < bookArrayList.size(); j++) {
                if (bookArrayList.get(j).getBookNumber() <
                        bookArrayList.get(temp).getBookNumber()) {
                    temp = j;
                }
            }
            Book book = new Book(bookArrayList.get(temp));
            bookArrayList.set(temp, bookArrayList.get(i));
            bookArrayList.set(i, book);
        }
    }
}

