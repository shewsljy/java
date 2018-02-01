package v1ch02.welcome;

/**
 * @author jiayu
 * @description
 * @date 2018/2/1 12:47
 */
public class Welcome {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/1 14:46
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        String corejava = "Welcome to Core Java!";
        System.out.println(corejava);
        for (int i = 0; i < corejava.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
