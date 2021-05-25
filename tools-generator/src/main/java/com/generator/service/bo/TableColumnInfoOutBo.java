package com.generator.service.bo;

public class TableColumnInfoOutBo {
    /**
     * 字段名称
     */
    private String columnName;
    /**
     * 字段描述
     */
    private String columnComment;
    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 是否必填
     * @return
     */
    private String isNull;

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "TableColumnInfo{" +
                "columnName='" + columnName + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
