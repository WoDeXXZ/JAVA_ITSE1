package USER;

public class User {

    public User() {
        //无参构造函数
    }

    public User(int type, int ID, String password, String name,
                String unit, int telephone, int count) {
        //有参构造函数
        this.type = type;
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.unit = unit;
        this.telephone = telephone;
        this.count = count;
    }

    //下面是get和set函数
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
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
        return type +
                "," + ID +
                "," + password +
                "," + name +
                "," + unit +
                "," + telephone +
                "," + count + '\n';
    }

    private int type;//账号类型
    private int ID;//账号名
    private String password;//密码
    private String name;//姓名
    private String unit;//单位
    private int telephone;//电话
    private int count;//可借书数
}