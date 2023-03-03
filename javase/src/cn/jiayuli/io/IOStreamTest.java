package cn.jiayuli.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class IOStreamTest {
    public static void main(String[] args) throws IOException {
        IOStreamTest ioStreamTest = new IOStreamTest();
        System.out.println("======================");
        System.out.println("fileInputPrint:");
        ioStreamTest.fileInputPrint();
        System.out.println("======================");
        System.out.println("fileReaderPrint:");
        ioStreamTest.fileReaderPrint();
        System.out.println("======================");
        System.out.println("fileInputBytePrint:");
        ioStreamTest.fileInputBytePrint();
        System.out.println("======================");
        System.out.println("fileReaderCharPrint:");
        ioStreamTest.fileReaderCharPrint();
        System.out.println("======================");
        System.out.println("fileInputWrite:");
        ioStreamTest.fileInputWrite();
        System.out.println("======================");
        System.out.println("fileReaderWrite:");
        ioStreamTest.fileReaderWrite();
        System.out.println("======================");
        System.out.println("fileInputByteWrite:");
        ioStreamTest.fileInputByteWrite();
        System.out.println("======================");
        System.out.println("fileReaderCharWrite:");
        ioStreamTest.fileReaderCharWrite();
        System.out.println("======================");
        System.out.println("fileOutput:");
        ioStreamTest.fileOutput();
        System.out.println("======================");
        System.out.println("fileReaderStreamWrite:");
        ioStreamTest.fileReaderStreamWrite();
        System.out.println("======================");
        System.out.println("fileBufferedInputWrite:");
        ioStreamTest.fileBufferedInputWrite();
        System.out.println("======================");
        System.out.println("fileWrite:");
        ioStreamTest.fileWrite();
        System.out.println("======================");
        System.out.println("printFile:");
        ioStreamTest.printFile();
        System.out.println("======================");
        System.out.println("fileBufferedReaderWrite:");
        ioStreamTest.fileBufferedReaderWrite();
        System.out.println("======================");
        System.out.println("fileBufferedReaderLineWrite:");
        ioStreamTest.fileBufferedReaderLineWrite();
        System.out.println("======================");
        System.out.println("encodeAndDecode:");
        ioStreamTest.encodeAndDecode();
        System.out.println("======================");
        //stream.keyInAndPrintConsole();
    }

    private void fileInputPrint() throws IOException {
        FileInputStream fis = new FileInputStream("inputFile.txt");
        int a;
        while ((a = fis.read()) != -1) {
            System.out.print((char) a);
        }
        System.out.println();
        fis.close();
    }

    private void fileReaderPrint() throws IOException {
        FileReader file = new FileReader("inputFile.txt");
        int a;
        while ((a = file.read()) != -1) {
            System.out.print((char) a);
        }
        System.out.println();
        file.close();
    }

    private void fileInputBytePrint() throws IOException {
        FileInputStream fis = new FileInputStream("inputFile.txt");
        int a;
        byte[] bytes = new byte[2];
        while ((a = fis.read(bytes)) != -1) {
            System.out.print(new String(bytes,0,a));
        }
        System.out.println();
        fis.close();
    }

    private void fileReaderCharPrint() throws IOException {
        FileReader file = new FileReader("inputFile.txt");
        int a;
        char[] chars = new char[2];
        while ((a = file.read(chars)) != -1) {
            System.out.print(new String(chars,0,a));
        }
        System.out.println();
        file.close();
    }


    private void fileInputWrite() throws IOException {
        FileInputStream fis = new FileInputStream("inputFile.txt");
        FileOutputStream fos = new FileOutputStream("inputFileWrite.txt");
        int a;
        while ((a = fis.read()) != -1) {
            fos.write(a);
        }
        fos.close();
        fis.close();
    }

    private void fileBufferedInputWrite() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("inputFile.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bufferedInputFileWrite.txt"));
        int a;
        while ((a = bis.read()) != -1) {
            bos.write(a);
        }
        bos.close();
        bis.close();
    }

    private void fileReaderWrite() throws IOException {
        FileReader fileReader = new FileReader("inputFile.txt");
        FileWriter fileWriter = new FileWriter("writeFileWrite.txt");
        int a;
        while ((a = fileReader.read()) != -1) {
            fileWriter.write(a);
        }
        fileWriter.close();
        fileReader.close();
    }

    private void fileBufferedReaderWrite() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputFile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedWriteFileWrite.txt"));
        int a;
        while ((a = bf.read()) != -1) {
            bw.write(a);
        }
        bw.close();
        bf.close();
    }

    private void fileBufferedReaderLineWrite() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputFile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedLineWriteFileWrite.txt"));
        String str;
        boolean flag = true;
        while ((str = bf.readLine()) != null) {
            if (!flag){
                bw.newLine();
            } else {
                flag = false;
            }
            bw.write(str);
        }
        bw.close();
        bf.close();
    }

    private void fileInputByteWrite() throws IOException {
        FileInputStream fis = new FileInputStream("inputFile.txt");
        FileOutputStream fos = new FileOutputStream("inputFileByteWrite.txt");
        int a;
        byte[] bytes = new byte[1024];
        while ((a = fis.read(bytes)) != -1) {
            fos.write(bytes,0,a);
        }
        fos.close();
        fis.close();
    }

    private void fileReaderCharWrite() throws IOException {
        FileReader fileReader = new FileReader("inputFile.txt");
        FileWriter fileWriter = new FileWriter("writeFileCharWrite.txt");
        int a;
        char[] chars = new char[2];
        while ((a = fileReader.read(chars)) != -1) {
            fileWriter.write(chars,0,a);
        }
        fileWriter.close();
        fileReader.close();
    }

    private void fileReaderStreamWrite() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream("inputFileGBK.txt"),"GBK");
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("writeFileStreamWriteGBK.txt"),"GBK");
        int a;
        while ((a = streamReader.read()) != -1) {
            streamWriter.write(a);
        }
        streamWriter.close();
        streamReader.close();
    }

    private void fileOutput() throws IOException {
        String str1 = "outputFile你好";
        String str2 = "\r\n";
        String str3 = "outputFileInputStream";
        FileOutputStream fos = new FileOutputStream("outputFile.txt");
        byte[] bytes = str1.getBytes();
        fos.write(bytes);
        bytes = str2.getBytes();
        fos.write(bytes);
        bytes = str3.getBytes();
        fos.write(bytes);
        fos.close();
    }

    private void fileWrite() throws IOException {
        String str1 = "writeFile你好";
        String str2 = "\r\n";
        String str3 = "outputFileWrite";
        FileWriter file = new FileWriter("writeFile.txt");
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] chars3 = str3.toCharArray();
        file.write(chars1);
        file.write(chars2);
        file.write(chars3);
        file.close();
    }

    private void printFile() throws IOException {
        PrintStream printStream = new PrintStream(new FileOutputStream("outputPrintFile.txt"),true,"UTF-8");
        printStream.write(97);
        printStream.print("aaa");
        printStream.println(88);
        printStream.close();
        PrintWriter printWriter = new PrintWriter(new FileWriter("writePrintFile.txt"),true);
        printWriter.write(97);
        printWriter.print("aaa");
        printWriter.println(88);
        printWriter.close();
    }

    private void encodeAndDecode() throws IOException {
        String str = "abc小写";
        byte[] bytes1 = str.getBytes();
        System.out.println(Arrays.toString(bytes1));
        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        String string1 = new String(bytes1);
        System.out.println(string1);
        String string2 = new String(bytes2);
        System.out.println(string2);

    }

    private void keyInAndPrintConsole() throws IOException {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            System.out.println("请输入:");
            writer = new PrintWriter(System.out, true);
            reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("exit")) {
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
