package com.t2012e.javaio;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class DemoJavaIO {
    public static void main(String[] args) {
        readFileWithReader();
    }
    static void readFileWithReader() {
        try (
                FileReader fileReader = new FileReader("fileReader.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeFileWithWriter() {
        try (
                FileWriter fileWriter = new FileWriter("fileReader.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            bufferedWriter.write("Text Content");
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readDataWithInputStream() {
        try (
                FileInputStream fileInputStream = new FileInputStream("demo.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ) {
            int result;
            while ((result = bufferedInputStream.read()) != -1) {
                System.out.println((char) result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readDataWithInputStream1() {
        try (
                FileInputStream fileInputStream = new FileInputStream("demo.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ) {
            while (true) {
                int result = bufferedInputStream.read();
                if (result == -1) {
                    break;
                }
                System.out.println((char) result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void writeDataWithOutStream() {
        File fileDemo = new File("demo.txt");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileDemo, true);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ) {
            String content = "Hello Vacxin\n";
            bufferedOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
