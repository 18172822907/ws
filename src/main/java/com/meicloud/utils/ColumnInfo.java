package com.meicloud.utils;

/**
 * @autor:JiaLing Li
 * @decription: 列信息
 */
public class ColumnInfo {

    /**
     * 序号
     */
    private Integer colIndex;
    /**
     * 列名称
     */
    private String colName;

    /**
     * 列类型
     */
    private String colType;


    public Integer getColIndex() {
        return colIndex;
    }

    public void setColIndex(Integer colIndex) {
        this.colIndex = colIndex;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }
}
