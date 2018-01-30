public class Hero {

    String name;//名字

    float hp;//血量

    float armor;//护甲

    int moveSpeed;//移动速度

    public static void main (String[] args) {
        Hero garen = new Hero();
        garen.name = "盖伦";
        garen.hp = 616.25f;
        garen.armor = 27.345f;
        garen.moveSpeed = 350;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 512.87f;
        teemo.armor = 18.257f;
        teemo.moveSpeed = 345;

        System.out.println("英雄名称：" + garen.name);
        System.out.println("英雄属性：血量 " + garen.hp + "; 护甲 " + garen.armor + "; 移动速度 " + garen.moveSpeed);
        System.out.println();
        System.out.println("英雄名称：" + teemo.name);
        System.out.println("英雄属性：血量 " + teemo.hp + "; 护甲 " + teemo.armor + "; 移动速度 " + teemo.moveSpeed);
    }
}
