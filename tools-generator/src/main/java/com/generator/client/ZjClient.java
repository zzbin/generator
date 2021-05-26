package com.generator.client;

import com.generator.common.utils.MyExcelUtils;
import com.generator.common.utils.MyStringUtils;
import com.generator.service.TableColumnInfoService;
import com.generator.service.ZjJsFileGenerateService;
import com.generator.service.ZjJspFileGenerateService;
import com.generator.service.bo.CommonFileGenerateInBo;
import com.generator.service.bo.TableColumnInfoOutBo;
import com.generator.service.bo.ZjJsFileGenerateInBo;
import com.generator.service.bo.ZjJspFileGenerateInBo;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ZjClient {
    //excel模板文件path
    private static String EXCEL_TEMP_FILE_PATH = "excel\\issued_report_list.xls";
    // 表名
    private static String TABLE_NAME = "mtl_rm";
    // 表主键 可为空，为空的话默认取查询出来的第一个字段
    private static String TABLE_PRIMARY_KEY = "id";
    // 页面标识
    private static String PAGE_MARK = "IssuedReportList";
    // 页面名称
    private static String PAGE_NAME = "已生成报告";
    // 包路径
    private static String PACKAGE_PATH = "report/reportmanage/";

    /**
     * JSP文件相关配置
     */
    private static String JSP_FILE_NAME = "issued_report_list";
    private static String JSP_FILE_PATH = "E:\\project\\qclims\\trunk\\module_report\\src\\main\\resources\\META-INF\\resources\\report\\reportmanage";
    private static String JSP_TEMP_FILE_PATH = "template\\ZjJspFileTemp.txt";

    /**
     * JSP文件相关配置
     */
    private static String JS_FILE_NAME = JSP_FILE_NAME;
    private static String JS_FILE_PATH = JSP_FILE_PATH;
    private static String JS_TEMP_FILE_PATH = "template\\ZjJsFileTemp.txt";

    @Test
    public void generatorCodeWithExcel(){
        //获取excel所有Sheet的数据
        File file = new File(EXCEL_TEMP_FILE_PATH);
        List<List<String>> queryParamList = MyExcelUtils.readExcel(file, "query", 1);
        List<List<String>> tableParamList = MyExcelUtils.readExcel(file, "table", 1);
        List<List<String>> formParamList = MyExcelUtils.readExcel(file, "form", 1);
        List<List<String>> tableBtnParamList = MyExcelUtils.readExcel(file, "tableButton", 1);
        System.out.println(queryParamList);
        System.out.println(tableParamList);
        System.out.println(formParamList);
        // 生成jsp文件
        ZjJspFileGenerateInBo zjJspFileGenerateInBo = new ZjJspFileGenerateInBo();
        zjJspFileGenerateInBo.setFileName(JSP_FILE_NAME);
        zjJspFileGenerateInBo.setFilePath(JSP_FILE_PATH);
        zjJspFileGenerateInBo.setTempFilePath(JSP_TEMP_FILE_PATH);
        zjJspFileGenerateInBo.setPageMark(PAGE_MARK);
        zjJspFileGenerateInBo.setPageName(PAGE_NAME);
        zjJspFileGenerateInBo.setPackagePath(PACKAGE_PATH);
        String jspFile = zjJspFileGenerateService.generatoJspFile(zjJspFileGenerateInBo);
        System.out.println(jspFile);

        // 生成js文件
        ZjJsFileGenerateInBo zjJsFileGenerateInBo = new ZjJsFileGenerateInBo();
        zjJsFileGenerateInBo.setFileName(JS_FILE_NAME);
        zjJsFileGenerateInBo.setFilePath(JS_FILE_PATH);
        zjJsFileGenerateInBo.setTempFilePath(JS_TEMP_FILE_PATH);
        zjJsFileGenerateInBo.setPageMark(PAGE_MARK);
        zjJsFileGenerateInBo.setPageName(PAGE_NAME);
        zjJsFileGenerateInBo.setQueryParamList(queryParamList);
        zjJsFileGenerateInBo.setFormParamList(formParamList);
        zjJsFileGenerateInBo.setTableParamList(tableParamList);
        zjJsFileGenerateInBo.setTableBtnParamList(tableBtnParamList);
        String jsFile = zjJsFileGenerateService.generatoJsFile(zjJsFileGenerateInBo);
        System.out.println(jsFile);
    }

    @Test
    public void temp(){

        System.out.println(Arrays.asList("1","2","3").contains("0"));
    }

    /**
     * 查询表字段信息sql
     */
    private static String QUERY_COLUMN_INFO_SQL = "SELECT\n" +
            "  c.relname 表名称,\n" +
            "  A.attname AS columnName,\n" +
            "  col_description(A.attrelid,A.attnum) AS columnComment,\n" +
            "  format_type ( A.atttypid, A.atttypmod ) AS dataType,\n" +
            "  CASE WHEN A.attnotnull='f' THEN '否' ELSE '是' END AS isNull,\n" +
            " a.attnum 序号\n" +
            "FROM\n" +
            " pg_class AS c,\n" +
            " pg_attribute AS a\n" +
            "WHERE\n" +
            " A.attrelid = C.oid \n" +
            " AND A.attnum > 0\n" +
            " and c.relname='"+ TABLE_NAME +"'\n" +
            " ORDER BY c.relname,a.attnum;";
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
    /**
     * junit test的配置信息
     */
    private static String DOS_TEST_PATH = "com.generator.test";
    private static String DOS_TEST_TEMP_FILE_PATH = "template\\JunitTestTemp.txt";

    @Autowired
    private ZjJspFileGenerateService zjJspFileGenerateService;

    @Autowired
    private ZjJsFileGenerateService zjJsFileGenerateService;

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
    }

}
