package controller;

import model.BookCirculation;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

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
                bookCirculation.setSerialNumber(Integer.parseInt(temp.split(",")[0]));
                bookCirculation.setID(Integer.parseInt(temp.split(",")[1]));
                bookCirculation.setBookNumber(Integer.parseInt(temp.split(",")[2]));
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

    public static void BorrowBook(int ID, int bookNumber) {
        //借书

        //自动生成流水号
        Read();
        int serialNumber;
        if (bookCirculationArrayList.get(bookCirculationArrayList.size() - 1)
                .getSerialNumber() != 0 && bookCirculationArrayList != null) {
            serialNumber = bookCirculationArrayList.get(
                    bookCirculationArrayList.size() - 1).getSerialNumber() + 1;
        } else {
            serialNumber = 1;
        }

        //自动生成当前时间
        String date = GenerateCurrentTime();

        //借还书类型 0是借书 1是还书
        int type = 0;

        //自动生成管理员账号
        int operator = UserManagement.userLoggedIntoThisSystem.getID();

        //使用户借书量减一
        UserManagement.FindIDMakeCountMinusOne(ID);

        //使图书藏书量减一
        BookManagement.FindAccountMakeCountMinusOne(bookNumber);

        BookCirculation bookCirculation = new BookCirculation(
                serialNumber, ID, bookNumber, date, type, operator);
        bookCirculationArrayList.add(bookCirculation);
        Write(bookCirculationArrayList);
    }

    public static void ReturnBook(int serialNumber) {
        //还书

        Read();
        for (int i = 0; i < bookCirculationArrayList.size(); i++) {
            if (serialNumber == bookCirculationArrayList.get(i).getSerialNumber()) {
                BookCirculation bookCirculation = new BookCirculation(
                        bookCirculationArrayList.get(i));

                //借书的账号
                int ID = bookCirculation.getID();

                //所借的书号
                int bookNumber = bookCirculation.getBookNumber();

                //自动生成当前时间
                String date = GenerateCurrentTime();

                //借还书类型 0是借书 1是还书
                int type = 1;

                //自动生成管理员账号
                int operator = UserManagement.userLoggedIntoThisSystem.getID();

                //使用户借书量加一
                UserManagement.FindIDMakeCountPlusOne(ID);

                //使图书藏书量加一
                BookManagement.FindAccountMakeCountPlusOne(bookNumber);

                BookCirculation bookCirculation1 = new BookCirculation(
                        serialNumber, ID, bookNumber, date, type, operator);
                bookCirculationArrayList.add(bookCirculation1);
                Write(bookCirculationArrayList);
                break;
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

    public static boolean JudgmentSerialNumber(int serialNumber) {
        //判断流水号是否存在
        Read();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (serialNumber == bookCirculation.getSerialNumber()) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<BookCirculation> QueryTotal() {
        //总借阅信息查询
        Read();
        return bookCirculationArrayList;
    }

    public static BookCirculation QuerySerialNumber(int serialNumber) {
        //流水号借阅信息查询
        Read();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (serialNumber == bookCirculation.getSerialNumber()) {
                return bookCirculation;
            }
        }
        return null;
    }

    public static ArrayList<BookCirculation> QueryID(int ID) {
        //用户名借阅信息查询
        Read();
        ArrayList<BookCirculation> bookCirculationArrayList1 = new ArrayList<>();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (ID == bookCirculation.getID()) {
                bookCirculationArrayList1.add(bookCirculation);
            }
        }
        return bookCirculationArrayList1;
    }

    public static ArrayList<BookCirculation> QueryBookNumber(int bookNumber) {
        //书号借阅信息查询
        Read();
        ArrayList<BookCirculation> bookCirculationArrayList1 = new ArrayList<>();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (bookNumber == bookCirculation.getBookNumber()) {
                bookCirculationArrayList1.add(bookCirculation);
            }
        }
        return bookCirculationArrayList1;
    }

    public static ArrayList<BookCirculation> QueryType(int type) {
        //借还书类型借阅信息查询
        Read();
        ArrayList<BookCirculation> bookCirculationArrayList1 = new ArrayList<>();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (type == bookCirculation.getType()) {
                bookCirculationArrayList1.add(bookCirculation);
            }
        }
        return bookCirculationArrayList1;
    }

    public static ArrayList<BookCirculation> QueryOperator(int operator) {
        //操作人借阅信息查询
        Read();
        ArrayList<BookCirculation> bookCirculationArrayList1 = new ArrayList<>();
        for (BookCirculation bookCirculation : bookCirculationArrayList) {
            if (operator == bookCirculation.getOperator()) {
                bookCirculationArrayList1.add(bookCirculation);
            }
        }
        return bookCirculationArrayList1;
    }
}