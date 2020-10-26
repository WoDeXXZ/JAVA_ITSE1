package USER;

public class SystemAdministrator {

    public SystemAdministrator() {
        int ID = 0;
        String password = "";
        String name = "";
        String unit = "";
        int telephone = 0;
        int count = 0;

    }

    public SystemAdministrator(int ID, String password, String name,
                               String unit, int telephone, int count) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.unit = unit;
        this.telephone = telephone;
        this.count = count;
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

    @Override
    public String toString() {
        return "System_Administrator{" +
                "ID=" + ID +
                ", password=" + password  +
                ", name=" + name +
                ", unit=" + unit  +
                ", telephone=" + telephone +
                ", count=" + count +
                '}';
    }

    int ID;
    String password;
    String name;
    String unit;
    int telephone;
    int count;


}
