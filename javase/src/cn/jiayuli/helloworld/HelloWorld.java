package cn.jiayuli.helloworld;

public class HelloWorld {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/6 17:50
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        System.out.println("Hello World By IDEA!");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.getClassTest();
    }

    public void getClassTest(){
        System.out.println("toString:" + this.toString());
        System.out.println("getClass:" + this.getClass());
        System.out.println("getClass:" + HelloWorld.class);
        System.out.println("getClass.getClass:" + this.getClass().getClass());
        System.out.println("getClass.getName:" + this.getClass().getName());
        System.out.println("getClass.getSimpleName:" + this.getClass().getSimpleName());
        System.out.println("getClass.getTypeName:" + this.getClass().getTypeName());
        System.out.println("getClass.getCanonicalName:" + this.getClass().getCanonicalName());
        System.out.println("getClassLoader:" + this.getClass().getClassLoader());
    }
}
