package com.generator.common.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyExcelUtils {

    @Test
    public void test(){
        //获取excel所有Sheet的数据
        File file = new File("excel\\test.xls");
        Map<String, List<List>> resultMap = readExcel(file);
        System.out.println("list中的数据打印出来");
        for (String key : resultMap.keySet()) {
            System.out.println("打印Sheet页为”"+ key +"“");
            List<List> excelList = resultMap.get(key);
            for (int i = 0; i < excelList.size(); i++) {
                List list = (List) excelList.get(i);
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j));
                }
                System.out.println();
            }
        }

        //获取指定Sheet页的数据
        List excelList2 = readExcel(file, "request", 1);
        System.out.println("list中的数据打印出来");
        for (int i = 0; i < excelList2.size(); i++) {
            List list = (List) excelList2.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

    /**
     * 获取指定Sheet页的数据
     * @param excelFile excel文件路径
     * @param sheetName 指定Sheet的路径
     * @param skipRow 跳过几行
     * @return List<List<String>> 外层list中的每个元素代表excel中的一行数据，内层List中的每个元素代表一个单元格的数据
     */
    public static List<List<String>> readExcel(File excelFile, String sheetName, int skipRow) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(excelFile.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            Sheet sheet1 = wb.getSheet(sheetName);
            List<List<String>> outerList = new ArrayList<>();
            // 获取指定Sheet页数据
            Sheet sheet = wb.getSheet(sheetName);
            // sheet.getRows()返回该页的总行数
            for (int i = skipRow; i < sheet.getRows(); i++) {
                List<String> innerList = new ArrayList<String>();
                // sheet.getColumns()返回该页的总列数
                for (int j = 0; j < sheet.getColumns(); j++) {
                    String cellinfo = sheet.getCell(j, i).getContents();
                    if(cellinfo.isEmpty()){
                        innerList.add("");
                    }
                    innerList.add(cellinfo);
                }
                outerList.add(i - skipRow, innerList);
            }
            return outerList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取excel所有Sheet的数据
     * @param excelFile excel文件路径
     * @return Map<String, List<List<String>>> Map的key存的是Sheet的名称，value中外层list中的每个元素代表excel中的一行数据，内层List中的每个元素代表一个单元格的数据
     */
    public static Map<String, List<List>> readExcel(File excelFile) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(excelFile.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            Map<String, List<List>> resultMap = new HashMap<>();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                resultMap.put(sheet.getName(), outerList);
            }
            return resultMap;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
