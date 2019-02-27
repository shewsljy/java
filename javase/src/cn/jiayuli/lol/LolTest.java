package cn.jiayuli.lol;

public class LolTest {
    public static void main(String[] args){

        Hero garen = new Hero();
        garen.setName("盖伦");
        garen.setHp(616.25f);
        garen.setArmor(27.345f);
        garen.setMoveSpeed(350);
        garen.addSpeed(100);
        garen.keng();
        garen.legendary();
        garen.recovery(200f);

        Hero teemo = new Hero();
        teemo.setName("提莫");
        teemo.setHp(512.87f);
        teemo.setArmor(18.257f);
        teemo.setMoveSpeed(345);

        System.out.println();
        System.out.println("英雄名称：" + garen.getName());
        System.out.println("英雄属性：血量 " + garen.getHp() + "; 护甲 " + garen.getArmor() + "; 移动速度 " + garen.getMoveSpeed());
        System.out.println();
        System.out.println("英雄名称：" + teemo.getName());
        System.out.println("英雄属性：血量 " + teemo.getHp() + "; 护甲 " + teemo.getArmor() + "; 移动速度 " + teemo.getMoveSpeed());
        System.out.println();

        Item potion = new Item();
        potion.setName("血瓶");
        potion.setPrice(50);

        Item sandals = new Item();
        sandals.setName("草鞋");
        sandals.setPrice(300);

        Item swords = new Item();
        swords.setName("长剑");
        swords.setPrice(350);

        System.out.println("物品名称：" + potion.getName());
        System.out.println("物品属性：价格 " + potion.getPrice());
        System.out.println();
        System.out.println("物品名称：" + sandals.getName());
        System.out.println("物品属性：价格 " + sandals.getPrice());
        System.out.println();
        System.out.println("物品名称：" + swords.getName());
        System.out.println("物品属性：价格 " + swords.getPrice());
    }
}
