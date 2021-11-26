public class BlackCat extends Cat {
    public static double money=350;

    @Override
    public double getMoney() {
        return money;
    }

    public BlackCat(String name, int old, String sex, double money) {
        super(name, old, sex, money);
    }

    @Override
    public String toString() {
        return super.toString()+" 品种： 黑猫";
    }
}
