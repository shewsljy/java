package cn.jiayuli.polymorphism;

public class Wine {
    public void sayName(){
        System.out.println("Wine");
    }
    public void sayPrice(){
        System.out.println("999");
    }
    public static void main(String[] args){
        Wine wine = new Wine();
        System.out.println("wine : " + wine.getClass());
        wine.sayName();
        wine.sayPrice();
        Wine wine1 = new RedWine();
        System.out.println("wine1 : " + wine1.getClass());
        wine1.sayName();
        wine1.sayPrice();
        ((RedWine) wine1).sayPrice("887");
        ((RedWine) wine1).chargePrice();
        Wine wine2 = new WhileWine();
        System.out.println("wine2 : " + wine2.getClass());
        wine2.sayName();
        wine2.sayPrice();
        ((WhileWine) wine2).sayName("BlueWine");
        ((WhileWine) wine2).chargeName();
    }
}

class RedWine extends Wine {
    @Override
    public void sayName(){
        System.out.println("RedWine");
    }
    @Override
    public void sayPrice(){
        System.out.println("888");
    }
    public void sayPrice(String price){
        System.out.println("sayPrice " + price);
    }
    public void chargePrice(){
        System.out.println("price charge 889");
    }
}

class WhileWine extends Wine {
    @Override
    public void sayName(){
        System.out.println("WhileWine");
    }
    @Override
    public void sayPrice(){
        System.out.println("777");
    }
    public void sayName(String name){
        System.out.println("sayName " + name);
    }
    public void chargeName(){
        System.out.println("name charge BlackWine");
    }
}