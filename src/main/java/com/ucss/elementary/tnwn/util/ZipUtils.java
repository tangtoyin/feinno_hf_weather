package com.ucss.elementary.tnwn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    /**
     * 将多个压缩文件为一个zip文件
     * @param zipFilePath 压缩后存放的路径
     * @param fileList  要压缩的文件集合
     */
    public static  void mutileFileToGzip(String zipFilePath,List<String> fileList) throws IOException{
        File file = new File(zipFilePath);
        //判断是否存在旧的压缩文件，若存在则删除
        if (file.exists()) {
            file.delete();
        }
        //判断该压缩路径是否存在，若不存在则创建该压缩文件所在的所有目录
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ArrayList<File> files=new ArrayList<File>();
            for(String fileName:fileList){
                //判断该文件是否存在
                if(!new File(fileName).exists()) {
                    continue;
                }
                //剔除重复的文件
                if(files.contains(new File(fileName))) {
                    continue;
                }
                files.add(new File(fileName));
            }
            for (int i = 0; i < files.size(); i++) {
                FileInputStream fis = new FileInputStream(files.get(i));
                zos.putNextEntry(new ZipEntry(files.get(i).getName()));
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
        } catch (IOException ioe) {
            String t=ioe.getMessage();
        }
    }
}