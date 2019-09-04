package com.ucss.elementary.tnwn.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Smile
 * @date 2018/11/7 14:10
 */
public class ExcelUtil {
    //读取excel中的数据
    public static List<List<Object>> toJavaData(MultipartFile file, boolean hasHeader) {
        //region check
        if (file == null || StringHelper.isTrimEmpty(file.getOriginalFilename())) {
            return null;
        }
        //检查文件格式是否正确
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if (!ext.equalsIgnoreCase(".xls") && !ext.equalsIgnoreCase(".xlsx")) {
            return null;
        }
        //endregion
        Workbook workbook;
        try {
            if (".xls".equalsIgnoreCase(ext)) {
                //Excel2003以前（包括2003）的版本(.xls)
                workbook = new HSSFWorkbook(file.getInputStream());
            } else {
                //2007及其之后的版本
                workbook = new XSSFWorkbook(file.getInputStream());
            }
            //得到Excel工作表对象,取出第一个工作表，索引是0
            Sheet sheet = workbook.getSheetAt(0);
            int rownum = hasHeader ? 0 : 1;
            List<List<Object>> list = new ArrayList<>();
            for (int i = rownum; i <= sheet.getLastRowNum(); i++) {
                List<Object> item = new ArrayList<>();
                Row row = sheet.getRow(i);
                for (Cell cell : row) {
                    item.add(getCellValue(cell));
                }
                list.add(item);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据Excel表格中的数据判断类型得到值
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        if (null != cell) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: // 数字
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                        Date theDate = cell.getDateCellValue();
                        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                        cellValue = dff.format(theDate);
                    } else {
                        DecimalFormat df = new DecimalFormat("#.##");
                        cellValue = df.format(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case Cell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;
                case Cell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case Cell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
        }
        return cellValue;
    }

    //生成excel
    public static void importExcel(String filePath, List<List<String>> list) throws Exception {
        try {
            //创建excel工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建工作表sheet
            HSSFSheet sheet = workbook.createSheet();
            //创建第一行
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = null;
            //写入数据
            for (int i = 0; i < list.size(); i++) {
                HSSFRow nrow = sheet.createRow(i);
                for (int j = 0; j < list.get(i).size(); j++) {
                    HSSFCell ncell = nrow.createCell(j);
                    ncell.setCellValue(list.get(i).get(j));
                }
            }
            //将excel表存放在目录下
            File descFile = new File(filePath);
            if (!descFile.exists()) {
                descFile.mkdirs();
            }
            //将excel写入
            FileOutputStream stream = new FileOutputStream(filePath);
            workbook.write(stream);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //生成excel
    public static void importExcel(HttpServletResponse response, String filename, List<List<String>> list) throws Exception {
        //输出Excel文件
        try {
            //创建excel工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建工作表sheet
            XSSFSheet sheet = workbook.createSheet(filename);
            //创建第一行
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = null;
            //写入数据
            for (int i = 0; i < list.size(); i++) {
                XSSFRow nrow = sheet.createRow(i);
                for (int j = 0; j < list.get(i).size(); j++) {
                    XSSFCell ncell = nrow.createCell(j);
                    ncell.setCellValue(list.get(i).get(j));
                }
            }
            //将excel写入
            response.reset(); // 清空response
            response.setHeader("Content-Disposition", "attachment;filename="+new String( (filename+".xlsx").getBytes("gb2312"), "ISO8859-1" ));// 设定输出文件头
            response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型
            //利用输入输出流对文件进行下载
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void importExcel2003(HttpServletResponse response, String filename, List<List<String>> list) throws Exception {
        //输出Excel文件
        try {
            //创建excel工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建工作表sheet
            HSSFSheet sheet = workbook.createSheet(filename);
            //创建第一行
            HSSFRow row = sheet.createRow(0);
            //写入数据
            for (int i = 0; i < list.size(); i++) {
                HSSFRow nrow = sheet.createRow(i);
                for (int j = 0; j < list.get(i).size(); j++) {
                    HSSFCell ncell = nrow.createCell(j);
                    ncell.setCellValue(list.get(i).get(j));
                }
            }
            //将excel写入
           // response.reset(); // 清空response
           // response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename+".xls","UTF-8") );// 设定输出文件头
            response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型

            //利用输入输出流对文件进行下载
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //生成excel-2007
    public static void importExcel(HttpServletResponse response, String filename, List<Map<String,Object>> list,boolean hasHeader) throws Exception {
        //输出Excel文件
        try {
            if(list==null||list.size()==0){
                return;
            }
            //创建excel工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建工作表sheet
            XSSFSheet sheet = workbook.createSheet(filename);
            int dataRowStart=0;//数据开始的行号
            //头文件
            if(hasHeader){
                XSSFRow row = sheet.createRow(0);
                int cellindex=0;
                for(String key : list.get(0).keySet()){
                    XSSFCell cell=row.createCell(cellindex++);
                    cell.setCellValue(key);
                }
                dataRowStart=1;
            }
            //写入数据
            for (Map<String,Object> map:list){
                XSSFRow nrow = sheet.createRow(list.indexOf(map)+dataRowStart);
                int cellindex=0;
                for(String key : map.keySet()){
                    XSSFCell cell=nrow.createCell(cellindex++);
                    cell.setCellValue(StringHelper.toSafeString(map.get(key)));
                }
            }
            //将excel写入
            response.reset(); // 清空response
            response.setHeader("Content-Disposition", "attachment;filename="+new String( (filename+".xlsx").getBytes("gb2312"), "ISO8859-1" ));// 设定输出文件头
            response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型
            //利用输入输出流对文件进行下载
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
