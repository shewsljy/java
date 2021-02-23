package cn.jiayuli.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStream {
    public static void main(String[] args) throws IOException{
        InputStream stream = new InputStream();
        stream.keyInAndPrintConsole();
    }

    private void keyInAndPrintConsole() throws IOException {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            System.out.println("请输入:");
            writer = new PrintWriter(System.out,true);
            reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = reader.readLine()) != null){
                if (line.equals("exit")){
                    System.exit(1);
                }
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            reader.close();
        }
    }
}
