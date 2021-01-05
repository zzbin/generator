package com.generator.common.utils;

import org.junit.Test;

public class MyStringUtils {

    /**
     * 根据表的名称转换成对应的对象名称 例如 USER_TABLE  -->  UserName
     * @param tableName 表名
     * @return 返回对象名
     */
    public static String tableNameConvesionObjectName(String tableName){
        String[] arr = tableName.split("_");
        String resultStr = "";
        for (String s1 : arr) {
            resultStr += s1.substring(0,1).toUpperCase() + s1.substring(1).toLowerCase();
        }
       return resultStr;
    }

    /**
     * 表字段转驼峰 例如 USER_TABLE  -->  userName
     * @param tableName 表名
     * @return 返回对象名
     */
    public static String toCamelCase(String tableName){
        String resultStr = tableNameConvesionObjectName(tableName);
        resultStr = resultStr.substring(0,1).toLowerCase() + resultStr.substring(1);
        return resultStr;
    }

    /**
     * 第一个字母转小写  UserName --> userName
     * @param str 表名
     * @return 返回对象名
     */
    public static String firsToLowerCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }
}
