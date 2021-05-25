package com.generator.service.bo;

import java.util.List;

public class ZjJsFileGenerateInBo {
    // 文件名称
    private String fileName;
    // 文件路径
    private String filePath;
    // 模板文件路径
    private String tempFilePath;
    // 页面名称
    private String pageName;
    // 页面标识
    private String pageMark;
    //请求参数列表  搜索框使用
    private List<List<String>> queryParamList;
    //表格参数列表  表格使用
    private List<List<String>> tableParamList;
    //表格按钮参数列表  表格内嵌的操作按钮使用
    private List<List<String>> tableBtnParamList;
    //表单参数列表  表单使用
    private List<List<String>> formParamList;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageMark() {
        return pageMark;
    }

    public void setPageMark(String pageMark) {
        this.pageMark = pageMark;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    public List<List<String>> getQueryParamList() {
        return queryParamList;
    }

    public void setQueryParamList(List<List<String>> queryParamList) {
        this.queryParamList = queryParamList;
    }

    public List<List<String>> getTableParamList() {
        return tableParamList;
    }

    public void setTableParamList(List<List<String>> tableParamList) {
        this.tableParamList = tableParamList;
    }

    public List<List<String>> getFormParamList() {
        return formParamList;
    }

    public void setFormParamList(List<List<String>> formParamList) {
        this.formParamList = formParamList;
    }

    public List<List<String>> getTableBtnParamList() {
        return tableBtnParamList;
    }

    public void setTableBtnParamList(List<List<String>> tableBtnParamList) {
        this.tableBtnParamList = tableBtnParamList;
    }
}
