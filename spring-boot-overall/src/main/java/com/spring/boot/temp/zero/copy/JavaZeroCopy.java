package com.spring.boot.temp.zero.copy;

import java.io.*;
import java.net.Socket;
import java.nio.channels.FileChannel;

/**
 * @ClassName JavaZeroCopy
 * @Description Java零拷贝实现 transferTo
 * @Author xuery
 * @Date 2019/6/28 10:34
 * @Version 1.0
 */
public class JavaZeroCopy {

    public static void main(String[] args) {

    }

    //1.传统的方式
    public void readAndWriteFile(String fname) throws Exception{

        Socket socket = new Socket("127.0.0.1",9999);

        InputStream inputStream = new FileInputStream(fname);

        OutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        long start = System.currentTimeMillis();

        byte[] b = new byte[4096];

        long read = 0, total = 0;
        while((read = inputStream.read(b)) >= 0){
            total += read;
            outputStream.write(b);
        }
    }

    //2. sendfile:zero-copy技术
    public void zeroCpoy(String inputFile, String outputFile) throws  Exception{
        long fsize = 183678375L, sendszie = 4094;

        FileChannel fc = new FileInputStream(inputFile).getChannel();

        FileChannel outf = new FileOutputStream(outputFile).getChannel();

        long start = System.currentTimeMillis();

        long nsent = 0, curnset = 0;
        curnset = fc.transferTo(0,fsize, outf);
    }
}
