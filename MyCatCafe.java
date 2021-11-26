import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double balance;
    private List<Cat> catlist = new ArrayList();
    private List<Customer> customerlist = new ArrayList();
    private LocalDate localDate;

    public MyCatCafe(double balance) {
        this.balance = balance;
    }

    public void newCat(String name, String sex, int old, boolean isFat, String obj) {
        obj = obj.toUpperCase();
        if (obj.equals("ORANGE")) {
            try {
                double OrangeCat_money=OrangeCat.money;
                OrangeCat Orangecat = new OrangeCat(name, old, sex, OrangeCat_money, isFat);
                if (balance < Orangecat.getMoney()) {
                    throw new InsufficientBalanceException("店铺没钱了");
                } else {
                    catlist.add(Orangecat);
                    balance = balance - Orangecat.getMoney();
                }
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        } else if (obj.equals("BLACK")) {
            try {
                double BlackCat_money= BlackCat.money;
                BlackCat Blackcat = new BlackCat(name, old, sex, BlackCat_money);
                if(balance<Blackcat.getMoney()){
                    throw new InsufficientBalanceException("店铺没钱了");
                }
                else {
                    catlist.add(Blackcat);
                    balance = balance - Blackcat.getMoney();
                }
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void Customer(String name, int rua) {
        try {
            if (catlist.isEmpty()) {
                throw new CatNotFoundException("没有猫");
            } else {
                localDate = LocalDate.now();
                Customer customer = new Customer(name, rua, localDate);
                customerlist.add(customer);
                Random random = new Random();
                for (int i = 0; i < rua; i++) {
                    int randomcat = random.nextInt(catlist.size() - 1);
                    System.out.println(catlist.get(randomcat));
                }
                balance = balance + rua * 15;
            }
        } catch (CatNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void rest() {
        double todaygain = 0;
        LocalDate now = LocalDate.now();
        System.out.println("==========");
        System.out.println("当日顾客名单：");
        for (Customer i : customerlist) {
            if (i.getDate().isEqual(now)) {
                System.out.println(i);
                todaygain += i.getRua() * 15;
            }

        }
        System.out.println("获利： ");
        System.out.println(todaygain + " 元");
    }

    public double getBalance() {
        return balance;
    }

    public List getCatlist() {
        return catlist;
    }

    public List getCustomerlist() {
        return customerlist;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCatlist(List<Cat> catlist) {
        this.catlist = catlist;
    }

    public void setCustomerlist(List<Customer> customerlist) {
        this.customerlist = customerlist;
    }

}
