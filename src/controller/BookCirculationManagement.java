package controller;

import model.BookCirculation;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
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

        while (!UserManagement.FindAccount(ID)) {
            System.out.println("此账号不存在，请重新输入账号");
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
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DATE);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        String date = y + "年" + m + "月" + d + "日" + h + "时" + mi + "分" + s + "秒";

        int type = 0;

        //检测管理员账号
        System.out.println("请输入管理员账号");
        scanner = new Scanner(System.in);
        int operator = scanner.nextInt();

        while (!UserManagement.FindAccount(ID)
                && UserManagement.FindAccountReturnType(ID) == 2) {
            System.out.println("此账号不存在或此账号不是管理员，请重新输入账号");
            scanner = new Scanner(System.in);
            operator = scanner.nextInt();
        }
        BookCirculation bookCirculation = new BookCirculation(
                serial_number, ID, book_number, date, type, operator);
        bookCirculationArrayList.add(bookCirculation);
        Write(bookCirculationArrayList);
    }
}


/*
2. 还书处理
3. 借阅信息查询
0. 返回主菜单
*/

/*
流水号 自动生成
serialNo

用户名 检测
id

书号 检测
no

日期  自动生成
date

借还书类型
type

操作人  检测
operator

 */