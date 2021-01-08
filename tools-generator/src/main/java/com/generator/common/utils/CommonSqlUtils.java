package com.generator.common.utils;

import com.generator.client.Client;
import com.generator.service.bo.CommonFileGenerateInBo;
import com.generator.service.bo.TableColumnInfoOutBo;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

public class CommonSqlUtils {
    private static String DEFAULT_SQL_INSERT_COLUMN_TEMP_PATH = "template\\sql\\SqlInsertColumnTemp.txt";
    private static String DEFAULT_SQL_INSERT_COLUMN_VALUE_TEMP_PATH = "template\\sql\\SqlInsertColumnValueTemp.txt";
    private static String DEFAULT_SQL_SELECT_COLUMN_TEMP_PATH = "template\\sql\\SqlSelectColumnTemp.txt";
    private static String DEFAULT_SQL_UPDATE_COLUMN_TEMP_PATH = "template\\sql\\SqlUpdateColumnTemp.txt";

    /**
     * 生成sql select的字段信息
     * @param tableColumnInfoOutBos
     * @return
     */
    public static  String getSelectColumnInfos(List<TableColumnInfoOutBo> tableColumnInfoOutBos) {
        String tempFilePath = DEFAULT_SQL_SELECT_COLUMN_TEMP_PATH;
        if(StringUtils.isBlank(Client.SQL_SELECT_COLUMN_TEMP_PATH)){
            tempFilePath = Client.SQL_SELECT_COLUMN_TEMP_PATH;
        }
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成sql insert的字段信息
            for (TableColumnInfoOutBo tableColumnInfoOutBo : tableColumnInfoOutBos) {
                stringBuffer.append(tempStr1.replace("$ColumnName$", tableColumnInfoOutBo.getColumnName())
                        .replace("$JavaBeanColumnName$", MyStringUtils.toCamelCase(tableColumnInfoOutBo.getColumnName())));
            }
            String resultStr = stringBuffer.toString();
            //去除第一个‘,’号
            resultStr = resultStr.replaceFirst(",", "");
            //去除最后一个换行符
            resultStr = resultStr.substring(0, resultStr.length()-1);
            return resultStr;
        },new File(tempFilePath));
    }

    public static CharSequence getUpdateColumnInfos(CommonFileGenerateInBo inBo) {
        String tempFilePath = DEFAULT_SQL_UPDATE_COLUMN_TEMP_PATH;
        if(StringUtils.isBlank(Client.SQL_UPDATE_COLUMN_TEMP_PATH)){
            tempFilePath = Client.SQL_UPDATE_COLUMN_TEMP_PATH;
        }
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成sql insert的字段信息
            for (TableColumnInfoOutBo tableColumnInfoOutBo : inBo.getTableColumnInfos()) {
                if(tableColumnInfoOutBo.getColumnName().equals(inBo.getTablePrimaryKey())){
                    continue;
                }
                stringBuffer.append(tempStr1.replace("$ColumnName$", tableColumnInfoOutBo.getColumnName())
                        .replace("$JavaBeanColumnName$", MyStringUtils.toCamelCase(tableColumnInfoOutBo.getColumnName())));
            }
            String resultStr = stringBuffer.toString();
            //去除第一个‘,’号
            resultStr = resultStr.replaceFirst(",", "");
            //去除最后一个换行符
            resultStr = resultStr.substring(0, resultStr.length()-1);
            return resultStr;
        },new File(tempFilePath));
    }

    public static CharSequence getInsertColumnInfos(CommonFileGenerateInBo inBo) {
        String tempFilePath = DEFAULT_SQL_INSERT_COLUMN_TEMP_PATH;
        if(StringUtils.isBlank(Client.SQL_INSERT_COLUMN_TEMP_PATH)){
            tempFilePath = Client.SQL_INSERT_COLUMN_TEMP_PATH;
        }
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成sql insert的字段信息
            for (TableColumnInfoOutBo tableColumnInfoOutBo : inBo.getTableColumnInfos()) {
                if(tableColumnInfoOutBo.getColumnName().equals(inBo.getTablePrimaryKey())){
                    continue;
                }
                stringBuffer.append(tempStr1.replace("$ColumnName$", tableColumnInfoOutBo.getColumnName()));
            }
            String resultStr = stringBuffer.toString();
            //去除第一个‘,’号
            resultStr = resultStr.replaceFirst(",", "");
            //去除最后一个换行符
            resultStr = resultStr.substring(0, resultStr.length()-1);
            return resultStr;
        },new File(tempFilePath));
    }

    public static CharSequence getInsertColumnValueInfos(CommonFileGenerateInBo inBo) {
        String tempFilePath = DEFAULT_SQL_INSERT_COLUMN_VALUE_TEMP_PATH;
        if(StringUtils.isBlank(Client.SQL_INSERT_COLUMN_VALUE_TEMP_PATH)){
            tempFilePath = Client.SQL_INSERT_COLUMN_VALUE_TEMP_PATH;
        }
        //字段信息
        return GenerateUtils.getTempFileContent((tempStr1)->{
            StringBuffer stringBuffer = new StringBuffer();
            //生成sql insert的value信息
            for (TableColumnInfoOutBo tableColumnInfoOutBo : inBo.getTableColumnInfos()) {
                if(tableColumnInfoOutBo.getColumnName().equals(inBo.getTablePrimaryKey())){
                    continue;
                }
                stringBuffer.append(tempStr1.replace("$JavaBeanColumnName$", MyStringUtils.toCamelCase(tableColumnInfoOutBo.getColumnName())));
            }
            String resultStr = stringBuffer.toString();
            //去除第一个‘,’号
            resultStr = resultStr.replaceFirst(",", "");
            //去除最后一个换行符
            resultStr = resultStr.substring(0, resultStr.length()-1);
            return resultStr;
        },new File(tempFilePath));
    }
}
