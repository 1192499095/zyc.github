public abstract class Cat {
    protected String name;
    protected int old;
    protected String sex;
    protected double money;

    public Cat(String name, int old, String sex, double money) {
        this.name = name;
        this.old = old;
        this.sex = sex;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "(>^ω^<)：" + "\n" +
                "名字： '" + name + '\'' +
                ", 年龄： " + old +
                ", 性别： '" + sex + '\'' +
                ", 价格： " + money;

    }
}


