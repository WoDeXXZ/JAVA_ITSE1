package controller;

import model.BookCirculation;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class BookCirculationManagement {
    //管理图书流通
    //每个图书流通的流水号都是唯一的

    public static ArrayList<BookCirculation> bookCirculationArrayList;
    //存储数据类型为BookCirculation的ArrayList集合

    public static void Read() {
        //读取BookCirculation.txt文件到ArrayList集合
        bookCirculationArrayList = new ArrayList<>();
        try {
            File file = new File("src\\model\\BookCirculation.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                BookCirculation bookCirculation = new BookCirculation();
                bookCirculation.setSerial_number(Integer.parseInt(temp.split(",")[0]));
                bookCirculation.setID(Integer.parseInt(temp.split(",")[1]));
                bookCirculation.setBook_number(Integer.parseInt(temp.split(",")[2]));
                bookCirculation.setDate(temp.split(",")[3]);
                bookCirculation.setType(Integer.parseInt(temp.split(",")[4]));
                bookCirculation.setOperator(Integer.parseInt(temp.split(",")[5]));

                bookCirculationArrayList.add(bookCirculation);
            }
            reader.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write(ArrayList<BookCirculation> bookCirculationArrayList) {
        //写入文件BookCirculation.txt
        try {
            FileWriter fileWriter = new FileWriter("src\\model\\BookCirculation.txt");
            for (BookCirculation bookCirculation : bookCirculationArrayList) {
                fileWriter.write(bookCirculation.toString());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void BorrowBooks() {
        //借书

        //自动生成流水号
        Read();
        int serial_number = 0;
        if (bookCirculationArrayList.get(bookCirculationArrayList.size() - 1).getSerial_number() != 0) {
            serial_number = bookCirculationArrayList.get(
                    bookCirculationArrayList.size() - 1).getSerial_number() + 1;
        } else {
            serial_number = 1;
        }

        //检测借书账号
        Scanner scanner;
        System.out.println("请输入借书账号");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();

        while (!UserManagement.FindAccount(ID) && Objects.requireNonNull(
                UserManagement.FindAccountReturnUser(ID)).getCount() != 0) {
            System.out.println("此账号不存在或此账号借书达到最大，请重新输入账号");
            scanner = new Scanner(System.in);
            ID = scanner.nextInt();
        }

        //检测书号是否存在及该书是否被借完
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();
        while (!BookManagement.FindAccount(book_number) &&
                BookManagement.FindAccountReturnCount(book_number) != 0) {
            System.out.println("此书号不存在或此书号的书已借完，请输入新的书号");
            scanner = new Scanner(System.in);
            book_number = scanner.nextInt();
        }
        //自动生成当前时间
        String date = GenerateCurrentTime();

        //借还书类型 0是借书 1是还书
        int type = 0;

        //自动生成管理员账号
        int operator = UserManagement.user_logged_into_this_system.getID();

        BookCirculation bookCirculation = new BookCirculation(
                serial_number, ID, book_number, date, type, operator);
        bookCirculationArrayList.add(bookCirculation);
        Write(bookCirculationArrayList);
    }

    public static void ReturnBook() {
        //还书

        Read();

        //检测流水号
        Scanner scanner;
        System.out.println("请输入流水号");
        scanner = new Scanner(System.in);
        int serial_number = scanner.nextInt();
        BookCirculation bookCirculation;
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (serial_number == bookCirculationArrayList.get(i).getSerial_number()) {
                bookCirculation = new BookCirculation(bookCirculationArrayList.get(i));

                //借书账号
                int ID = bookCirculation.getID();

                //借的书号
                int book_number = bookCirculation.getBook_number();

                //自动生成当前时间
                String date = GenerateCurrentTime();

                //借还书类型 0是借书 1是还书
                int type = 1;

                //自动生成管理员账号
                int operator = UserManagement.user_logged_into_this_system.getID();

                BookCirculation bookCirculation1 = new BookCirculation(
                        serial_number, ID, book_number, date, type, operator);
                bookCirculationArrayList.add(bookCirculation1);
                Write(bookCirculationArrayList);
                break;
            }
            if (i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + serial_number + "流水号");
            }
        }

    }

    public static String GenerateCurrentTime() {
        //自动生成当前时间
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DATE);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        return y + "年" + m + "月" + d + "日" + h + "时" + mi + "分" + s + "秒";
    }


    public static void QueryBookCirculation() {
        //总借阅信息查询
        Read();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            System.out.println(bookCirculation.toString());
        }
    }

    public static void QueryBookCirculationSerial_Number() {
        //流水号借阅信息查询
        Scanner scanner;
        System.out.println("请输入流水号");
        scanner = new Scanner(System.in);
        int serial_number = scanner.nextInt();
        Read();
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (serial_number == bookCirculationArrayList.get(i).getSerial_number()) {
                System.out.println(bookCirculationArrayList.get(i).toString());
                break;
            }
            if (i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + serial_number + "流水号");
            }
        }
    }

    public static void QueryBookCirculationID() {
        //用户名借阅信息查询
        Scanner scanner;
        System.out.println("请输入用户名");
        scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        Read();
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (ID == bookCirculationArrayList.get(i).getID()) {
                System.out.println(bookCirculationArrayList.get(i).toString());
                break;
            }
            if (i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + ID + "用户名");
            }
        }
    }

    public static void QueryBookCirculationBook_Number() {
        //书号借阅信息查询
        Scanner scanner;
        System.out.println("请输入书号");
        scanner = new Scanner(System.in);
        int book_number = scanner.nextInt();
        Read();
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (book_number == bookCirculationArrayList.get(i).getBook_number()) {
                System.out.println(bookCirculationArrayList.get(i).toString());
                break;
            }
            if (i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + book_number + "书号");
            }
        }
    }

    public static void QueryBookCirculationType() {
        //借还书类型借阅信息查询
        Scanner scanner;
        System.out.println("请输入借还书类型");
        scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        Read();
        int temp = 0;
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (type == bookCirculationArrayList.get(i).getType()) {
                System.out.println(bookCirculationArrayList.get(i).toString());
                temp++;
            }
            if (temp == 0 && i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + type + "借还书类型");
            }
        }
    }

    public static void QueryBookCirculationOperator() {
        //操作人借阅信息查询
        Scanner scanner;
        System.out.println("请输入操作人");
        scanner = new Scanner(System.in);
        int operator = scanner.nextInt();
        Read();
        int temp = 0;
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (operator == bookCirculationArrayList.get(i).getOperator()) {
                System.out.println(bookCirculationArrayList.get(i).toString());
                temp++;
            }
            if (temp == 0 && i == bookCirculationArrayList.size() - 1) {
                System.out.println("没有找到" + operator + "操作人");
            }
        }
    }
}