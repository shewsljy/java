package cn.jiayuli.lol;

/**
 * @author jiayu
 * @description
 * @date 2018/2/5 10:23
 */
public class Hero {

    private String name;//名字

    private float hp;//血量

    private float armor;//护甲

    private int moveSpeed;//移动速度

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void keng(){
        System.out.println(name + " 坑队友！");
    }

    public void addSpeed(int speed){
        moveSpeed = moveSpeed + speed;
        System.out.println(name + " 增加速度 " + speed);
    }

    public void legendary(){
        System.out.println(name + " 超神！");
    }

    public void recovery(float blood){
        System.out.println(name + " 回血 " + blood);
    }
}
