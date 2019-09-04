package com.ucss.elementary.tnwn.util;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smile on 2018/7/18.
 */
public class CsvUtil {

    /**
     * 读取csv的文件到list中
     *
     * @param hasHeader 是否包含表头
     *                  读取方式为reader.getRawRecord()则为逗号分隔
     */
    public static List<String[]> toJavaData(MultipartFile file, boolean hasHeader) throws Exception {
        List list = new ArrayList();
        InputStreamReader isr = null;
        CsvReader reader = null;
        try {
            isr = new InputStreamReader(file.getInputStream(), Charset.forName("GBK"));
            reader = new CsvReader(isr);
            if (hasHeader) {
                //获取表头
                list.add(reader.getHeaders());
            } else {
                // 跳过表头
                reader.readHeaders();
            }
            while (reader.readRecord()) {
                list.add(reader.getValues());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (isr != null) {
                isr.close();
            }
        }
        return list;
    }

    public static List<String[]> toJavaData(String filePath, boolean hasHeader) throws Exception {
        List list = new ArrayList();
        CsvReader reader = null;
        try {
            reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
            //获取表头
            if (hasHeader) {
                list.add(reader.getHeaders());
            } else {
                // 跳过表头
                reader.readHeaders();
            }
            while (reader.readRecord()) {
                list.add(reader.getValues());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return list;
    }
    //导出模板
    public static void writeCSV(String outPath,String filename, String[] header, List<String[]> list ) throws IOException {
        CsvWriter wr = null;
        File csvFile = null;
        try {
            //创建文件
            csvFile = new File(outPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();
            wr = new CsvWriter(csvFile.getAbsolutePath(), ',', Charset.forName("GBK"));
            //头文件
            if(header!=null&&header.length>0) {
                wr.writeRecord(header);
            }
            //写入内容
            if(list!=null&&list.size()>0) {
                for (int i = 0; i < list.size(); i++) {
                    wr.writeRecord(list.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wr != null) {
                wr.close();
            }
        }
    }
}
