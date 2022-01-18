public class OrangeCat extends Cat{
    private boolean isFat;
    public static double money=200;

    public OrangeCat(String name, int old, String sex, double money, boolean isFat) {
        super(name, old, sex, money);
        this.isFat = isFat;
    }

    public boolean isFat() {
        return isFat;
    }

    @Override
    public String toString() {
        return super.toString()+" 品种： 橘猫";
    }

    @Override
    public double getMoney() {
        return money;
    }
}
