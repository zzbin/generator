package com.generator.client;

import com.generator.service.*;
import com.generator.service.bo.*;
import com.generator.common.utils.MyStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Client {
    /**
     * 表名
     */
    private static String TABLE_NAME = "orders";
    /**
     * 表主键 可为空，为空的话默认取查询出来的第一个字段
     */
    private static String TABLE_PRIMARY_KEY = "id";
    /**
     * mysql查询表字段信息sql
     */
    private static String QUERY_COLUMN_INFO_SQL = "select COLUMN_NAME as columnName, DATA_TYPE as dataType, COLUMN_COMMENT as columnComment from columns where TABLE_SCHEMA = 'springmvc' and table_name='" + TABLE_NAME + "';";
    /**
     * common bean 配置
     * 如果不配置，会使用默认的
     */
    public static String BEAN_FIELD_TEMP_PATH = "template\\BeanColumnInfoTemp.txt";
    public static String BEAN_GET_AND_SET_METHOD_TEMP_PATH = "template\\BeanGetAndSetMethodTemp.txt";
    public static String BEAN_SET_VALUE_TEMP_PATH = "template\\BeanSetValueTemp.txt";
    /**
     * common sql 模板 配置
     * 如果不配置，会使用默认的
     */
    public static String SQL_INSERT_COLUMN_TEMP_PATH = "template\\SqlInsertColumnTemp.txt";
    public static String SQL_INSERT_COLUMN_VALUE_TEMP_PATH = "template\\SqlInsertColumnValueTemp.txt";
    public static String SQL_SELECT_COLUMN_TEMP_PATH = "template\\SqlSelectColumnTemp.txt";
    public static String SQL_UPDATE_COLUMN_TEMP_PATH = "template\\SqlUpdateColumnTemp.txt";

    //private static String PROJECT_PATH = new File("").getAbsolutePath();
    //当前工程的路径
    private static String PROJECT_PATH = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator";
    //service工程的路径
    private static String SERVICE_PROJECT_PATH = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator";
    //data工程的路径
    private static String DATA_PROJECT_PATH = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator";
    //test工程的路径
    private static String TEST_PROJECT_PATH = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator";
    private static String JAVA_PATH = "\\src\\main\\java";
    private static String TEST_JAVA_PATH = "\\src\\main\\java";
    private static String RESOUCE_PATH = "\\src\\main\\resources";
    private static String TEST_RESOUCE_PATH = "\\src\\main\\resources";
    /**
     * Inbo的配置信息
     */
    private static String INBO_PATH = "com.generator.po";
    private static String INBO_TEMP_FILE_PATH = "template\\InBoClassTemp.txt";
    /**
     * Outbo的配置信息
     */
    private static String OUTBO_PATH = "com.generator.po";
    private static String OUTBO_TEMP_FILE_PATH = "template\\OutBoClassTemp.txt";
    /**
     * dos 接口的配置信息
     */
    private static String DOS_INF_PATH = "com.generator.dos.inf";
    private static String DOS_INF_TEMP_FILE_PATH = "template\\DosInfClassTemp.txt";
    /**
     * dos impl的配置信息
     */
    private static String DOS_IMPL_PATH = "com.generator.dos.impl";
    private static String DOS_IMPL_TEMP_FILE_PATH = "template\\DosImplClassTemp.txt";
    /**
     * dos xml的配置信息
     */
    private static String DOS_XML_PATH = "com.generator.dos.impl";
    private static String DOS_XML_TEMP_FILE_PATH = "template\\DosXmlClassTemp.txt";
//    /**
//     * SqlMapConfig.xml的文件路径 如果生成dos xml, 文件新增最新的xml文件配置
//     */
//    public static String SQL_MAP_CONFIG_FILE_PATH = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator\\src\\main\\resources\\SqlMapConfig.xml";
//    // 临时文件路径
//    public static String SQL_MAP_CONFIG_FILE_PATH_TEMP = "D:\\1zzbin\\project\\ahbin\\Tools\\generator\\tools-generator\\src\\main\\resources\\SqlMapConfig2.xml";
    /**
     * junit test的配置信息
     */
    private static String DOS_TEST_PATH = "com.generator.test";
    private static String DOS_TEST_TEMP_FILE_PATH = "template\\JunitTestTemp.txt";

    @Autowired
    private CommonFileGenerateService commonFileGenerateService;

    @Autowired
    private TableColumnInfoService tableColumnInfoService;

    private static CommonFileGenerateInBo inBo = new CommonFileGenerateInBo();
    @BeforeClass
    public static void beforeClass(){
        // 设置工程路径信息
        inBo.setProjectPath(PROJECT_PATH);
        inBo.setDataProjectPath(DATA_PROJECT_PATH);
        inBo.setServiceProjectPath(SERVICE_PROJECT_PATH);
        inBo.setProjectIntenerJavaPath(JAVA_PATH);
        inBo.setProjectIntenerTestJavaPath(TEST_JAVA_PATH);
        inBo.setProjectIntenerResourcePath(RESOUCE_PATH);
        inBo.setProjectIntenerTestResourcePath(TEST_RESOUCE_PATH);

        // 表设计信息
        inBo.setTableName(TABLE_NAME);
        inBo.setTablePrimaryKey(TABLE_PRIMARY_KEY);

        // 生成的文件配置信息
        inBo.setInBoPackageName(INBO_PATH);
        inBo.setInBoTempFilePath(INBO_TEMP_FILE_PATH);
        inBo.setOutBoPackageName(OUTBO_PATH);
        inBo.setOutBoTempFilePath(OUTBO_TEMP_FILE_PATH);
        inBo.setDosInfPackageName(DOS_INF_PATH);
        inBo.setDosInfTempFilePath(DOS_INF_TEMP_FILE_PATH);
        inBo.setDosImplPackageName(DOS_IMPL_PATH);
        inBo.setDosImplTempFilePath(DOS_IMPL_TEMP_FILE_PATH);
        inBo.setDosXmlPackageName(DOS_XML_PATH);
        inBo.setDosXmlTempFilePath(DOS_XML_TEMP_FILE_PATH);
        inBo.setDosTestPackageName(DOS_TEST_PATH);
        inBo.setDosTestTempFilePath(DOS_TEST_TEMP_FILE_PATH);
    }

    @Test
    public void testFileReader() throws IOException {
        List<TableColumnInfoOutBo> tableColumnInfoOutBos = tableColumnInfoService.getTableColumnInfos(QUERY_COLUMN_INFO_SQL);
        String objName = MyStringUtils.tableNameConvesionObjectName(TABLE_NAME);
        inBo.setDosFileMarkName(objName);
        inBo.setTableColumnInfos(tableColumnInfoOutBos);
        String generatoInBoFile = commonFileGenerateService.generatoInBoFile(inBo);
        System.out.println(generatoInBoFile);
        String generatoOutBoFile = commonFileGenerateService.generatoOutBoFile(inBo);
        System.out.println(generatoOutBoFile);
        String generatoDosInfFile = commonFileGenerateService.generatoDosInfFile(inBo);
        System.out.println(generatoDosInfFile);
        String generatoDosImplFile = commonFileGenerateService.generatoDosImplFile(inBo);
        System.out.println(generatoDosImplFile);
        String generatoDosXmlFile = commonFileGenerateService.generatoDosXmlFile(inBo);
        System.out.println(generatoDosXmlFile);
        String generatoDosTestFile = commonFileGenerateService.generatoDosTestFile(inBo);
        System.out.println(generatoDosTestFile);
    }

}
