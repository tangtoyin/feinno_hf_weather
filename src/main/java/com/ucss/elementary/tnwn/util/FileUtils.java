package com.ucss.elementary.tnwn.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.UUID;

public class FileUtils {
    /**
     * springMVC 处理文件上传
     * @param partFile 上传的文件
     * @param rootPath 文件存放的目录 例如:/mnt/file/
     * @return 传入的文件参数若为空，或者传入的文件名称为空时返回值为null,否则返回文件在数据库中存储的相对路径+文件名称
     *         返回值(存储的相对路径+文件名称)=当前年月+随机数
     *         文件存放的绝对路径+文件名称=rootPath+当前年月+随机数
     *         例如：上传的文件类型为jpg rootPath:/mnt/file/ 当前年月为 :201611 生成随机数为:7a932fe2-61a1-4fd8-ad56-385b289c9cd3
     *               返回值(存储的相对路径+文件名称)=201611/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     *               文件存放的绝对路径+文件名称=/mnt/file/201611/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     * @throws IOException
     * @throws IllegalStateException
     */
    public String uploadFile(MultipartFile partFile, String rootPath) throws IllegalStateException, IOException {

        if(partFile!=null&&partFile.getOriginalFilename()!=null&&partFile.getOriginalFilename().length()>0){
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            String filePath=rootPath+year+month+"/";
            File dir=new File(filePath);
            if(!dir.isDirectory()) {
                dir.mkdir();
            }

            String fileOriginalName=partFile.getOriginalFilename();
            String newFileName= UUID.randomUUID()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            File file=new File(filePath+newFileName);
            //文件写入磁盘
            partFile.transferTo(file);
            //返回存储的相对路径+文件名称
            return ""+year+month+"/"+newFileName;
        }
        else {
            return null;
        }
    }
    /**
     * @param partFile 上传的文件
     * @param rootPath 文件存放的目录 例如:/mnt/file/
     * @return 传入的文件参数若为空，或者传入的文件名称为空时返回值为null,否则返回文件在数据库中存储的绝对路径，且不修改目录结构和文件名称
     * */
    public static String uploadFile2(MultipartFile partFile, String rootPath) throws IllegalStateException, IOException {

        try {
            if (partFile != null && partFile.getOriginalFilename() != null && partFile.getOriginalFilename().length() > 0) {
                File dir = new File(rootPath);
                if (!dir.isDirectory()) {
                    dir.mkdir();
                }
                File file = new File(rootPath + "/" + partFile.getOriginalFilename());
                if(file.exists()){
                    file.delete();
                }
                //文件写入磁盘
                partFile.transferTo(file);
                //返回存储的相对路径+文件名称
                return file.getAbsolutePath();
            } else {
                return null;
            }
        }catch (Exception e){
            System.out.print(e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param realPath   文件的真实路径
     * @param request
     * @param response
     */
    public static void downloadFile(String realPath, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        File file = new File(realPath);
        //获取到文件名称
        String fileName =  file.getName();
        if (file.exists()) {
            String userAgent = request.getHeader("User-Agent");
            // 针对IE或者以IE为内核的浏览器：
            try {
                if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                    fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
                } else {
                    // 非IE浏览器的处理：
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
                }
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            //设置响应
            response.setCharacterEncoding("utf-8");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));// 设置文件名
            response.addHeader("Content-Length", String.valueOf(file.length()));
            //设置缓冲区
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
