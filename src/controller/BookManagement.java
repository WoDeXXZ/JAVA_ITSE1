package controller;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
                book.setBook_number(Integer.parseInt(temp.split(",")[0]));
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

    public static void Input() {
        //图书信息录入
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        while (FindAccount(book_number)) {
            System.out.println("此书号已存在，请输入新的书号");
            scanner = new Scanner(System.in);
            book_number = scanner.nextInt();
        }

        System.out.println("请输入书名");
        scanner = new Scanner(System.in);
        String title = scanner.next();

        System.out.println("请输入作者");
        scanner = new Scanner(System.in);
        String author = scanner.next();

        System.out.println("请输入出版社");
        scanner = new Scanner(System.in);
        String press = scanner.next();

        System.out.println("请输入藏书量");
        scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Book book = new Book(book_number, title, author, press, count);
        Read();
        bookArrayList.add(book);
        Write(bookArrayList);
    }

    public static void Update() {
        //图书信息修改
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();

        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (book_number == bookArrayList.get(i).getBook_number()) {
                System.out.println("请输入书名");
                scanner = new Scanner(System.in);
                bookArrayList.get(i).setTitle(scanner.next());

                System.out.println("请输入作者");
                scanner = new Scanner(System.in);
                bookArrayList.get(i).setAuthor(scanner.next());

                System.out.println("请输入出版社");
                scanner = new Scanner(System.in);
                bookArrayList.get(i).setPress(scanner.next());

                System.out.println("请输入藏书量");
                scanner = new Scanner(System.in);
                bookArrayList.get(i).setCount(scanner.nextInt());
                Write(bookArrayList);
                break;
            }
            if (i == bookArrayList.size() - 1) {
                System.out.println("没有找到" + book_number + "书号");
            }
        }
    }

    public static void QueryBookNumber() {
        //书号查询
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();
        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (book_number == bookArrayList.get(i).getBook_number()) {
                System.out.println(bookArrayList.get(i).toString());
                break;
            }
            if (i == bookArrayList.size() - 1) {
                System.out.println("没有找到" + book_number + "书号");
            }
        }
    }

    public static void QueryTitle() {
        //书名查询
        Scanner scanner;
        System.out.println("请输入书名");
        scanner = new Scanner(System.in);
        String title = scanner.next();
        Read();
        int temp = 0;
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (title.equals(bookArrayList.get(i).getTitle())) {
                System.out.println(bookArrayList.get(i).toString());
                temp++;
            }
            if (temp == 0 && i == bookArrayList.size() - 1) {
                System.out.println("没有找到" + title + "书名");
            }
        }
    }

    public static void QueryAuthor() {
        //作者查询
        Scanner scanner;
        System.out.println("请输入作者");
        scanner = new Scanner(System.in);
        String author = scanner.next();
        Read();
        int temp = 0;
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (author.equals(bookArrayList.get(i).getAuthor())) {
                System.out.println(bookArrayList.get(i).toString());
                temp++;
            }
            if (temp == 0 && i == bookArrayList.size() - 1) {
                System.out.println("没有找到" + author + "作者");
            }
        }
    }

    public static boolean FindAccount(int book_number) {
        //查找书号
        Read();
        for (Book book : bookArrayList) {
            if (book_number == book.getBook_number()) {
                return true;
            }
        }
        return false;
    }

    public static int FindAccountReturnCount(int book_number) {
        //查找书号并返回书的数量
        Read();
        for (Book book : bookArrayList) {
            if (book_number == book.getBook_number() && book.getCount() != 0) {
                return book.getCount();
            }
        }
        return 0;
    }


    public static void Delete() {
        //图书信息删除
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();
        Read();
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (book_number == bookArrayList.get(i).getBook_number()) {
                bookArrayList.remove(i);
                Write(bookArrayList);
                break;
            }
            if (i == bookArrayList.size() - 1) {
                System.out.println("没有找到" + book_number + "书号");
            }
        }
    }

    public static void Compare(ArrayList<Book> bookArrayList) {
        //选择排序
        //按照书号book_number从小到大开始排序
        for (int i = 0; i < bookArrayList.size(); i++) {
            int temp = i;
            for (int j = i + 1; j < bookArrayList.size(); j++) {
                if (bookArrayList.get(j).getBook_number() <
                        bookArrayList.get(temp).getBook_number()) {
                    temp = j;
                }
            }
            Book book = new Book(bookArrayList.get(temp));
            bookArrayList.set(temp, bookArrayList.get(i));
            bookArrayList.set(i, book);
        }
    }
}

