import java.time.LocalDate;

public class Customer {
    String name;
    int rua;
    LocalDate Date;

    public Customer(String name, int rua, LocalDate date) {
        this.name = name;
        this.rua = rua;
        Date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "顾客： " +"\n"+
                "姓名： " + name + '\'' +
                ", RUA猫次数： " + rua +
                ", 日期： " + Date ;
    }
}
