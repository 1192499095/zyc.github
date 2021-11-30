import java.util.Random;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop=true;
        System.out.println("输入店铺余额： ");
        int balance=sc.nextInt();
        MyCatCafe mycatcafe = new MyCatCafe(balance);
        String key=" ";
        do {
            System.out.println("=======猫咖菜单=======");
            System.out.println("\t\t 1 /买猫");
            System.out.println("\t\t 2 /有顾客");
            System.out.println("\t\t 3 /输出猫列表");
            System.out.println("\t\t 4 /下班");
            Scanner sc1 = new Scanner(System.in);
            key = sc1.nextLine();
            switch (key) {
                case "1":
                    System.out.println("输入猫名：");
                    String name=sc1.nextLine();
                    System.out.println("输入性别：");
                    String sex=sc1.nextLine();
                    System.out.println("输入年龄：");
                    int old=sc1.nextInt();
                    sc1.nextLine();
                    System.out.println("胖吗?(true or false)：");
                    String isFat_=sc1.nextLine();
                    boolean isFat=Boolean.parseBoolean(isFat_);
                    System.out.println("输入品种(orange or black)：");
                    String obj=sc1.nextLine();
                    mycatcafe.newCat(name,sex,old,isFat,obj);
                    break;
                case "2":
                    System.out.println("输入用户名：");
                    String CustomerName=sc1.nextLine();
                    System.out.println("输入撸猫次数：");
                    int rua=sc1.nextInt();
                    mycatcafe.Customer(CustomerName,rua);
                    break;
                case "3":
                    for (Object o : mycatcafe.getCatlist()) {
                        System.out.println(o);
                    }
                    break;
                case "4":
                    System.out.println("下 班");
                    System.out.println("确定下班吗？(y/n)");
                    String sure=sc1.nextLine();
                    if (sure.equals("y")) {
                        loop = false;
                        mycatcafe.rest();
                    }
                    break;
                default :
            }
        }while(loop);

    }


}
