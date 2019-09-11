package com.baidu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {

        Demo demo = new Demo();
        demo.intputstreamweiter();

        List<String> list = new ArrayList<String>();
        File file = new File("d:\\day");
        demo.Seach(file, list);

        Iterator<String> it = list.listIterator();

        System.out.println("便利制定目录下所有的Java文件");
        while (it.hasNext())
            System.out.println(it.next());
    }

    /**
     * Java 1.7之后，针对IO进行了优化，在try后添加一对小括号，在括号内部，创建输入流，输出流，等，
     * 当执行完try内的代码，不论是否发生异常，都会执行close，借以实现finally中的操作，既精简了代码，又保证了关流的一系列异常。
     * 这种新的写法，称之为，TWR(Try-with-resources)，其实java从1.6之后的版本中，版本的更新除了效率的提升，更大的改变是让代码更优雅！！！
     * 
     * 关于TWR，能放在小括号中定义的变量，主要是因为，Java1.7之后，新增了一个接口，AutoCloseable，（可以简单翻译为自动关闭），
     * 只要是AutoCloseable的实现类，都可以在执行完try代码块后，自动被调用close方法。
     * 
     * 后话：通常除了IO操作，后期自己也会写一些类，例如关于网络连接操作等，需要释放资源的操作，可以封装到close方法中，通过使用TWR方式，自动释放
     * 
     */
    public void twr() {
        File file = new File("c:\\ran.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                BufferedReader br = new BufferedReader(new FileReader(file))) {
            bw.write("陈文庆在练习转换流");
            System.out.println(br.readLine());
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    // 转换流的应用
    public void intputstreamweiter() {
        File file = new File("c:\\ran.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

            bw.write("陈文庆在练习转换流");
            bw.close();
            br = new BufferedReader(new FileReader(file));
            System.out.println(br.readLine());

        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        finally {
            try {
                if (br != null)
                    br.close();

            }
            catch (IOException e2) {
                System.out.println(e2.toString());
            }
        }

        // FileReader read = new FileReader(file);
        // BufferedReader buf = new BufferedReader(read);
        // System.out.println(buf.readLine());
    }

    // 搜索某个盘符下所有的Java文件 使用递归
    public void Seach(File file, List<String> list) {
        @SuppressWarnings("static-access")
        File[] dir = file.listFiles();
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isDirectory())
                Seach(dir[i], list);
            else if (dir[i].getName().endsWith(".java"))
                list.add(dir[i].getAbsolutePath());
        }
    }

}
