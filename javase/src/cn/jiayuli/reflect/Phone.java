package cn.jiayuli.reflect;

/**
 * ClassName: Phone <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/12/11
 */
public class Phone {

    private String name;

    private int price;

    public Phone() {
    }

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private void printName() {
        System.out.println(name);
    }
}
