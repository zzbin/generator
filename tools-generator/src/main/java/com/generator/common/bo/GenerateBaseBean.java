package com.generator.common.bo;

public class GenerateBaseBean {
    /**
     * 工程路径 既 D:\1zzbin\project\ahbin\Tools\generator\tools-generator\
     */
    private String projectPath;
    /**
     * 工程内部默认路径路径 既\src\main\java
     */
    private String projectIntenerPath;
    /**
     * 模板文件路径
     */
    private String tempFilePath;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 文件名
     */
    private String fileName;

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getProjectIntenerPath() {
        return projectIntenerPath;
    }

    public void setProjectIntenerPath(String projectIntenerPath) {
        this.projectIntenerPath = projectIntenerPath;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }

    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
