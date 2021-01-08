package com.generator.service.impl;

import com.generator.common.utils.*;
import com.generator.service.CommonFileGenerateService;
import com.generator.service.bo.CommonFileGenerateInBo;
import com.generator.service.bo.TableColumnInfoOutBo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonFileGenerateServiceImpl implements CommonFileGenerateService {

    @Override
    public String generatoDosImplFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getDosImplPackageName();
        String fileName = inBo.getDosFileMarkName();
        // 要生成的文件路径
        String outBoFilePath = inBo.getDataProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName + "DosImpl.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$FileNameToFirstLower$", MyStringUtils.firsToLowerCase(fileName))
                    .replace("$PackageName$", packageName) //包名
                    .replace("$DosXmlPackageName$", inBo.getDosXmlPackageName())
                    .replace("$DosInfPackageName$", inBo.getDosInfPackageName())
                    .replace("$InBoPackageName$", inBo.getInBoPackageName())
                    .replace("$OutBoPackageName$", inBo.getOutBoPackageName());
            return tempStr;
        }, new File( inBo.getDosImplTempFilePath()), new File(outBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoDosInfFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getDosInfPackageName();
        String fileName = inBo.getDosFileMarkName();
        // 要生成的文件路径
        String outBoFilePath = inBo.getDataProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = "I" + fileName + "Dos.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$InBoPackageName$", inBo.getInBoPackageName())
                    .replace("$OutBoPackageName$", inBo.getOutBoPackageName());
            return tempStr;
        },new File( inBo.getDosInfTempFilePath()),new File(outBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoDosXmlFile(CommonFileGenerateInBo inBo) throws IOException {
        String packageName = inBo.getDosXmlPackageName();
        String fileName = inBo.getDosFileMarkName();
        String tablePrimaryKey = inBo.getTablePrimaryKey();
        List<TableColumnInfoOutBo> tableColumnInfos = inBo.getTableColumnInfos();
        // 要生成的文件路径
        String outBoFilePath = inBo.getDataProjectPath() + inBo.getProjectIntenerResourcePath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = "sqlmap_creditcard_" + MyStringUtils.firsToLowerCase(fileName)+ ".xml";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$FileNameToFirstLower$", MyStringUtils.firsToLowerCase(fileName))
                    .replace("$PackageName$", packageName) //包名
                    .replace("$TableName$", inBo.getTableName())
                    .replace("$TablePrimaryKey$", tablePrimaryKey)
                    .replace("$TablePrimaryKeyToCamel$", MyStringUtils.toCamelCase(tablePrimaryKey))
                    .replace("$SelectColumns$", CommonSqlUtils.getSelectColumnInfos(tableColumnInfos))
                    .replace("$UpdateColumns$", CommonSqlUtils.getUpdateColumnInfos(inBo))
                    .replace("$InsertColumns$", CommonSqlUtils.getInsertColumnInfos(inBo))
                    .replace("$InsertColumnsValues$", CommonSqlUtils.getInsertColumnValueInfos(inBo))
                    .replace("$InBoPackageName$", inBo.getInBoPackageName())
                    .replace("$OutBoPackageName$", inBo.getOutBoPackageName());
            return tempStr;
        }, new File( inBo.getDosXmlTempFilePath()), new File(outBoFilePath, generateName));
//        //获取SqlMapConfig.xml文件内容
//        Files.copy(Paths.get(Client.SQL_MAP_CONFIG_FILE_PATH), Paths.get(Client.SQL_MAP_CONFIG_FILE_PATH_TEMP));
//        String sqlMapConfigFilePath = GenerateUtils.generateFile((tempStr)->{
//            if(tempStr.contains("sqlmap_creditcard_" + MyStringUtils.firsToLowerCase(fileName) + ".xml")){
//                return tempStr;
//            }
//            tempStr = tempStr.replace("<!--  sqlMap  -->", "<!--  sqlMap  -->\n\t<sqlMap resource=\"" + packageName.replace(".", "/") + "/sqlmap_creditcard_" + MyStringUtils.firsToLowerCase(fileName) + ".xml\"/>");
//            return tempStr;
//        }, new File(Client.SQL_MAP_CONFIG_FILE_PATH_TEMP), new File(Client.SQL_MAP_CONFIG_FILE_PATH));
//        Files.delete(Paths.get(Client.SQL_MAP_CONFIG_FILE_PATH_TEMP));
        return generateFilePath;
    }

    @Override
    public String generatoInBoFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getInBoPackageName();
        String fileName = inBo.getDosFileMarkName();
        List<TableColumnInfoOutBo> tableColumnInfoOutBos = inBo.getTableColumnInfos();
        // 要生成的文件路径
        String inBoFilePath = inBo.getDataProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName + "InBo.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$FieldInfos$", CommonBeanUtils.getBeanColumnInfo(tableColumnInfoOutBos))
                    .replace("$FieldGetAndSetMethod$", CommonBeanUtils.getBeanGetAndSetMethods(tableColumnInfoOutBos));
            return tempStr;
        }, new File(inBo.getInBoTempFilePath()), new File(inBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoDosTestFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getDosTestPackageName();
        String fileName = inBo.getDosFileMarkName();
        List<TableColumnInfoOutBo> tableColumnInfos = inBo.getTableColumnInfos();
        // 要生成的文件路径
        String outBoFilePath = inBo.getTestProjectPath() + inBo.getProjectIntenerTestJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName+ "DosImplTest.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$FileNameToFirstLower$", MyStringUtils.firsToLowerCase(fileName))
                    .replace("$DosXmlPackageName$", inBo.getDosXmlPackageName())
                    .replace("$SetValue$", CommonBeanUtils.getBeanSetValue(tableColumnInfos, "inBo"))
                    .replace("$InBoPackageName$", inBo.getInBoPackageName())
                    .replace("$OutBoPackageName$", inBo.getOutBoPackageName());
            return tempStr;
        }, new File( inBo.getDosTestTempFilePath()), new File(outBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoOutBoFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getOutBoPackageName();
        String fileName = inBo.getDosFileMarkName();
        List<TableColumnInfoOutBo> tableColumnInfoOutBos = inBo.getTableColumnInfos();
        // 要生成的文件路径
        String outBoFilePath = inBo.getDataProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName + "OutBo.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$FieldInfos$", CommonBeanUtils.getBeanColumnInfo(tableColumnInfoOutBos))
                    .replace("$FieldGetAndSetMethod$", CommonBeanUtils.getBeanGetAndSetMethods(tableColumnInfoOutBos));
            return tempStr;
        },new File( inBo.getOutBoTempFilePath()),new File(outBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoInVoFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getInVoPackageName();
        String fileName = inBo.getTransferId();
        Map<String, String> tansferMap = MyExcelUtils.readExcelReturnMap(inBo.getAccessExcelTempFile(), inBo.getExcelRequestSheetName());
        // 要生成的文件路径
        String inBoFilePath = inBo.getServiceProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName + "InVo.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$FieldInfos$", CommonBeanUtils.getBeanColumnInfo(tansferMap))
                    .replace("$FieldGetAndSetMethod$", CommonBeanUtils.getBeanGetAndSetMethods(tansferMap));
            return tempStr;
        }, new File(inBo.getInVoTempFilePath()), new File(inBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoOutVoFile(CommonFileGenerateInBo inBo) {
        String packageName = inBo.getOutVoPackageName();
        String fileName = inBo.getTransferId();
        Map<String, String> tansferMap = MyExcelUtils.readExcelReturnMap(inBo.getAccessExcelTempFile(), inBo.getExcelResponseSheetName());
        // 要生成的文件路径
        String inBoFilePath = inBo.getServiceProjectPath() + inBo.getProjectIntenerJavaPath() + File.separator + packageName.replace(".", "\\");
        // 文件名称
        String generateName = fileName + "OutVo.java";
        // 生成文件
        String generateFilePath = GenerateUtils.generateFile((tempStr)->{
            tempStr = tempStr.replace("$FileName$", fileName) //文件名
                    .replace("$PackageName$", packageName) //包名
                    .replace("$FieldInfos$", CommonBeanUtils.getBeanColumnInfo(tansferMap))
                    .replace("$FieldGetAndSetMethod$", CommonBeanUtils.getBeanGetAndSetMethods(tansferMap));
            return tempStr;
        }, new File(inBo.getOutVoTempFilePath()), new File(inBoFilePath, generateName));
        return generateFilePath;
    }

    @Override
    public String generatoServiceInfFile(CommonFileGenerateInBo inBo) {
        return null;
    }

    @Override
    public String generatoServiceImplFile(CommonFileGenerateInBo inBo) {
        return null;
    }

    @Override
    public String generatoServiceTestFile(CommonFileGenerateInBo inBo) {
        return null;
    }

    @Override
    public String generatoBsInfFile(CommonFileGenerateInBo inBo) {
        return null;
    }

    @Override
    public String generatoBsImplFile(CommonFileGenerateInBo inBo) {
        return null;
    }
}
