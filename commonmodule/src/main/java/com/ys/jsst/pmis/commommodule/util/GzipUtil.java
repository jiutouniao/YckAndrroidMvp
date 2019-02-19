package com.ys.jsst.pmis.commommodule.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 描述：
 * 作者：yuyanjun
 * 时间： 2017-7-24 10:46
 */
public class GzipUtil {
    /**
     * 解压gzip压缩格式文件 eg：123.mms
     *
     * @param source
     *            源文件
     * @param target
     *            目标文件
     */
    public static void unGZipFile(File source, String target) throws Exception { // 解压文件
        FileInputStream fin = new FileInputStream(source); // 得以文件输入流
        GZIPInputStream gzin = new GZIPInputStream(fin); // 得到压缩输入流
        FileOutputStream fout = new FileOutputStream(target); // 得到文件输出流
        byte[] buf = new byte[1024]; // 缓冲区大小
        int num;
        while ((num = gzin.read(buf, 0, buf.length)) != -1)
        { // 如果文件未读完
            fout.write(buf, 0, num); // 写入缓冲数据到输出流
        }
        gzin.close(); // 关闭压缩输入流
        fout.close(); // 关闭文件输出流
        fin.close(); // 关闭文件输入流
    }

    /**
     * gzip压缩文件
     *
     * @param source
     *            源文件
     * @param target
     *            压缩后文件.mms格式
     * @throws Exception
     */
    public static void gZipFile(File source, File target) throws Exception {
        FileInputStream fin = new FileInputStream(source);
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream(target)));
        int c = -1;
        while ((c = fin.read()) != -1)
        {
            out.write(c);
        }
        fin.close();
        out.close();
    }


}

