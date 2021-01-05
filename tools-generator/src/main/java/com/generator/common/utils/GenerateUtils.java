package com.generator.common.utils;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class GenerateUtils {

    /**
     * 根据传入的模板文件路径，生成的文件路径和处理逻辑，生成文件，并返回生成文件路径
     * 处理逻辑主要是，根据需求去替换模板文件的占位符
     * @param function 要生成文件的处理逻辑
     * @param tempPath 模板文件的路径
     * @param generateFilePath 生成文件的路径
     * @return 生成的文件路径
     */
    public static String generateFile(Function<String, String> function, String tempPath, String generateFilePath){
        File tempFile = new File(tempPath);
        File generateFile = new File(generateFilePath);
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(tempFile));
            bw = new BufferedWriter(new FileWriter(generateFile));
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
                stringBuffer.append("\n");
            }
            String writerStr = stringBuffer.toString();
            writerStr = function.apply(writerStr);
            bw.write(writerStr);
            bw.flush();
        } catch (IOException e) {
           e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return generateFile.getAbsolutePath();
    }

    /**
     * 根据传入的模板文件，生成的文件和处理逻辑，生成文件，并返回生成文件路径
     * 处理逻辑主要是，根据需求去替换模板文件的占位符
     * @param function 要生成文件的处理逻辑
     * @param tempFile 模板文件
     * @param generateFile 生成的文件
     * @return 生成的文件路径
     */
    public static String generateFile(Function<String, String> function, File tempFile, File generateFile){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(tempFile));
            bw = new BufferedWriter(new FileWriter(generateFile));
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
                stringBuffer.append("\n");
            }
            String writerStr = stringBuffer.toString();
            writerStr = function.apply(writerStr);
            bw.write(writerStr);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return generateFile.getAbsolutePath();
    }

    /**
     * 获取模板文件内容
     * 处理逻辑主要是，根据需求去替换模板文件的占位符
     * @param function 要生成文件的处理逻辑
     * @param tempFile 模板文件
     * @return 生成的文件路径
     */
    public static String getTempFileContent(Function<String, String> function, File tempFile){
        BufferedReader br = null;
        String writerStr = "";
        try {
            br = new BufferedReader(new FileReader(tempFile));
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            while((str = br.readLine()) != null){
                stringBuffer.append(str);
                stringBuffer.append("\n");
            }
            writerStr = stringBuffer.toString();
            writerStr = function.apply(writerStr);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return writerStr;
    }

    /**
     * 将数据库的数据类型转换为java的数据类型
     * @param dataType
     * @return
     */
    public static String conversionDataType(String dataType) {
        return "String";
    }
}
