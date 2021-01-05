package com.generator.service.bo;

import java.util.List;

public class CommonFileGenerateInBo {
    /**
     * 工程路径 既 D:\1zzbin\project\ahbin\Tools\generator\tools-generator\
     */
    private String projectPath;
    /**
     * 工程路径 既 D:\1zzbin\project\ahbin\Tools\generator\tools-generator\
     */
    private String dataProjectPath;
    /**
     * 工程路径 既 D:\1zzbin\project\ahbin\Tools\generator\tools-generator\
     */
    private String serviceProjectPath;
    /**
     * 工程路径 既 D:\1zzbin\project\ahbin\Tools\generator\tools-generator\
     */
    private String testProjectPath;
    /**
     * java工程内部默认路径路径 既\src\main\java
     */
    private String projectIntenerJavaPath;
    /**
     * resour工程内部默认路径路径 既\src\main\resource
     */
    private String projectIntenerResourcePath;
    /**
     * java工程内部默认路径路径 既\src\main\java
     */
    private String projectIntenerTestJavaPath;
    /**
     * resour工程内部默认路径路径 既\src\main\resource
     */
    private String projectIntenerTestResourcePath;
    /**
     * dos文件标识名，既只要是生成和dos相关的文件，都要包含这个标识
     */
    private String dosFileMarkName;

    /**
     * inBo的包路径
     */
    private String inBoPackageName;
    /**
     * inBo模板文件路径
     */
    private String inBoTempFilePath;
    /**
     * outBo的包路径
     */
    private String outBoPackageName;
    /**
     * outBo模板文件路径
     */
    private String outBoTempFilePath;
    /**
     * dos 接口的包路径
     */
    private String dosInfPackageName;
    /**
     * dos 接口模板文件路径
     */
    private String dosInfTempFilePath;
    /**
     * dos xml的包路径
     */
    private String dosXmlPackageName;
    /**
     * dos xml模板文件路径
     */
    private String dosXmlTempFilePath;
    /**
     * dos impl的包路径
     */
    private String dosImplPackageName;
    /**
     * dos impl模板文件路径
     */
    private String dosImplTempFilePath;
    /**
     * dos test的包路径
     */
    private String dosTestPackageName;
    /**
     * dos test模板文件路径
     */
    private String dosTestTempFilePath;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表主键
     */
    private String tablePrimaryKey;
    /**
     * 表字段信息列表
     */
    private List<TableColumnInfoOutBo> tableColumnInfos;

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }


    public String getServiceProjectPath() {
        return serviceProjectPath;
    }

    public void setServiceProjectPath(String serviceProjectPath) {
        this.serviceProjectPath = serviceProjectPath;
    }

    public String getProjectIntenerJavaPath() {
        return projectIntenerJavaPath;
    }

    public void setProjectIntenerJavaPath(String projectIntenerJavaPath) {
        this.projectIntenerJavaPath = projectIntenerJavaPath;
    }

    public String getProjectIntenerResourcePath() {
        return projectIntenerResourcePath;
    }

    public void setProjectIntenerResourcePath(String projectIntenerResourcePath) {
        this.projectIntenerResourcePath = projectIntenerResourcePath;
    }

    public String getDosFileMarkName() {
        return dosFileMarkName;
    }

    public void setDosFileMarkName(String dosFileMarkName) {
        this.dosFileMarkName = dosFileMarkName;
    }

    public String getInBoPackageName() {
        return inBoPackageName;
    }

    public void setInBoPackageName(String inBoPackageName) {
        this.inBoPackageName = inBoPackageName;
    }

    public String getInBoTempFilePath() {
        return inBoTempFilePath;
    }

    public void setInBoTempFilePath(String inBoTempFilePath) {
        this.inBoTempFilePath = inBoTempFilePath;
    }

    public String getOutBoPackageName() {
        return outBoPackageName;
    }

    public void setOutBoPackageName(String outBoPackageName) {
        this.outBoPackageName = outBoPackageName;
    }

    public String getOutBoTempFilePath() {
        return outBoTempFilePath;
    }

    public void setOutBoTempFilePath(String outBoTempFilePath) {
        this.outBoTempFilePath = outBoTempFilePath;
    }

    public String getDosInfPackageName() {
        return dosInfPackageName;
    }

    public void setDosInfPackageName(String dosInfPackageName) {
        this.dosInfPackageName = dosInfPackageName;
    }

    public String getDosInfTempFilePath() {
        return dosInfTempFilePath;
    }

    public void setDosInfTempFilePath(String dosInfTempFilePath) {
        this.dosInfTempFilePath = dosInfTempFilePath;
    }

    public String getDosXmlPackageName() {
        return dosXmlPackageName;
    }

    public void setDosXmlPackageName(String dosXmlPackageName) {
        this.dosXmlPackageName = dosXmlPackageName;
    }

    public String getDosXmlTempFilePath() {
        return dosXmlTempFilePath;
    }

    public void setDosXmlTempFilePath(String dosXmlTempFilePath) {
        this.dosXmlTempFilePath = dosXmlTempFilePath;
    }

    public String getDosImplPackageName() {
        return dosImplPackageName;
    }

    public void setDosImplPackageName(String dosImplPackageName) {
        this.dosImplPackageName = dosImplPackageName;
    }

    public String getDosImplTempFilePath() {
        return dosImplTempFilePath;
    }

    public void setDosImplTempFilePath(String dosImplTempFilePath) {
        this.dosImplTempFilePath = dosImplTempFilePath;
    }

    public String getDosTestPackageName() {
        return dosTestPackageName;
    }

    public void setDosTestPackageName(String dosTestPackageName) {
        this.dosTestPackageName = dosTestPackageName;
    }

    public String getDosTestTempFilePath() {
        return dosTestTempFilePath;
    }

    public void setDosTestTempFilePath(String dosTestTempFilePath) {
        this.dosTestTempFilePath = dosTestTempFilePath;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTablePrimaryKey() {
        return tablePrimaryKey;
    }

    public void setTablePrimaryKey(String tablePrimaryKey) {
        this.tablePrimaryKey = tablePrimaryKey;
    }

    public List<TableColumnInfoOutBo> getTableColumnInfos() {
        return tableColumnInfos;
    }

    public void setTableColumnInfos(List<TableColumnInfoOutBo> tableColumnInfos) {
        this.tableColumnInfos = tableColumnInfos;
    }

    public String getDataProjectPath() {
        return dataProjectPath;
    }

    public void setDataProjectPath(String dataProjectPath) {
        this.dataProjectPath = dataProjectPath;
    }

    public String getProjectIntenerTestJavaPath() {
        return projectIntenerTestJavaPath;
    }

    public void setProjectIntenerTestJavaPath(String projectIntenerTestJavaPath) {
        this.projectIntenerTestJavaPath = projectIntenerTestJavaPath;
    }

    public String getProjectIntenerTestResourcePath() {
        return projectIntenerTestResourcePath;
    }

    public void setProjectIntenerTestResourcePath(String projectIntenerTestResourcePath) {
        this.projectIntenerTestResourcePath = projectIntenerTestResourcePath;
    }

    public String getTestProjectPath() {
        return testProjectPath;
    }

    public void setTestProjectPath(String testProjectPath) {
        this.testProjectPath = testProjectPath;
    }
}
