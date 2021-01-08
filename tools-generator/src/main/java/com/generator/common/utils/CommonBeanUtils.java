package com.generator.common.utils;

import com.generator.client.Client;
import com.generator.service.bo.TableColumnInfoOutBo;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CommonBeanUtils {
    private static String DEFAULT_BEAN_FIELD_TEMP_PATH = "template\\bean\\BeanColumnInfoTemp.txt";
    private static String DEFAULT_BEAN_GET_AND_SET_METHOD_TEMP_PATH = "template\\bean\\BeanGetAndSetMethodTemp.txt";
    private static String DEFAULT_BEAN_SET_VALUE_TEMP_PATH = "template\\bean\\BeanSetValueTemp.txt";

    /**
     * 获取bean的set Value的方法
     * @param tableColumnInfoOutBos
     * @return
     */
    public static  String getBeanSetValue(List<TableColumnInfoOutBo> tableColumnInfoOutBos, String prifix) {
        String tempFilePath = DEFAULT_BEAN_SET_VALUE_TEMP_PATH;
        if(StringUtils.isBlank(Client.BEAN_SET_VALUE_TEMP_PATH)){
            tempFilePath = Client.BEAN_SET_VALUE_TEMP_PATH;
        }
        //get/set方法
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成get\set方法
            for (TableColumnInfoOutBo tableColumnInfoOutBo : tableColumnInfoOutBos) {
                stringBuffer.append(tempStr1.replace("$Prefix$", prifix)
                        .replace("$ColumnComment$", tableColumnInfoOutBo.getColumnComment())
                        .replace("$ColumnNameToUpper$", MyStringUtils.tableNameConvesionObjectName(tableColumnInfoOutBo.getColumnName())));
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }

    /**
     * 获取bean的get\set方法
     * @param tableColumnInfoOutBos
     * @return
     */
    public static  String getBeanGetAndSetMethods(List<TableColumnInfoOutBo> tableColumnInfoOutBos) {
        String tempFilePath = DEFAULT_BEAN_GET_AND_SET_METHOD_TEMP_PATH;
        if(StringUtils.isBlank(Client.BEAN_GET_AND_SET_METHOD_TEMP_PATH)){
            tempFilePath = Client.BEAN_GET_AND_SET_METHOD_TEMP_PATH;
        }
        //get/set方法
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成get\set方法
            for (TableColumnInfoOutBo tableColumnInfoOutBo : tableColumnInfoOutBos) {
                stringBuffer.append(tempStr1.replace("$FiledName$", MyStringUtils.tableNameConvesionObjectName(tableColumnInfoOutBo.getColumnName()))
                        .replace("$FiledNameToCamelCase$", MyStringUtils.toCamelCase(tableColumnInfoOutBo.getColumnName())));
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }

    /**
     * 获取bean的字段信息
     * @param tableColumnInfoOutBos
     * @return
     */
    public static String getBeanColumnInfo(List<TableColumnInfoOutBo> tableColumnInfoOutBos) {
        String tempFilePath = DEFAULT_BEAN_FIELD_TEMP_PATH;
        if(StringUtils.isBlank(Client.BEAN_FIELD_TEMP_PATH)){
            tempFilePath = Client.BEAN_FIELD_TEMP_PATH;
        }
        //字段信息
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成字段信息
            for (TableColumnInfoOutBo tableColumnInfoOutBo : tableColumnInfoOutBos) {
                stringBuffer.append(tempStr1.replace("$FieldContent$", tableColumnInfoOutBo.getColumnComment())
                        .replace("$FieldName$", MyStringUtils.toCamelCase(tableColumnInfoOutBo.getColumnName()))
                        .replace("$FileType$", GenerateUtils.conversionDataType(tableColumnInfoOutBo.getDataType())));
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }

    /**
     * 获取bean的字段信息
     * @return
     */
    public static String getBeanColumnInfo(Map<String, String> tansferMap) {
        String tempFilePath = DEFAULT_BEAN_FIELD_TEMP_PATH;
        if(StringUtils.isBlank(Client.BEAN_FIELD_TEMP_PATH)){
            tempFilePath = Client.BEAN_FIELD_TEMP_PATH;
        }
        //字段信息
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成字段信息
            for (String key : tansferMap.keySet()) {
                stringBuffer.append(tempStr1.replace("$FieldContent$", tansferMap.get(key))
                        .replace("$FieldName$", key)
                        .replace("$FileType$", GenerateUtils.conversionDataType("")));
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }

    public static CharSequence getBeanGetAndSetMethods(Map<String, String> tansferMap) {
        String tempFilePath = DEFAULT_BEAN_GET_AND_SET_METHOD_TEMP_PATH;
        if(StringUtils.isBlank(Client.BEAN_GET_AND_SET_METHOD_TEMP_PATH)){
            tempFilePath = Client.BEAN_GET_AND_SET_METHOD_TEMP_PATH;
        }
        //get/set方法
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成get\set方法
            for (String key : tansferMap.keySet()) {
                stringBuffer.append(tempStr1.replace("$FiledName$", MyStringUtils.tableNameConvesionObjectName(key))
                        .replace("$FiledNameToCamelCase$", MyStringUtils.toCamelCase(key)));
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        },new File(tempFilePath));
    }
}
