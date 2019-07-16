package com.meicloud.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor:JiaLing Li
 * @decription:json 格式转换根据类
 * @date: 2017-09-05
 */
public class BasicDataUtil {

    private List<ColumnInfo> metadata = new ArrayList<>();
    private Long totalRows = 0L;
    private List<Object> resultSet = new ArrayList<>();

    public BasicDataUtil(){}

    public BasicDataUtil(List<ColumnInfo> metadata,Long totalRows,List<Object> resultSet){
        this.metadata = metadata;
        this.totalRows = totalRows;
        this.resultSet = resultSet;
    }

    /**
     *
     * @param t 对象
     * @param objList 对象集合
     * @param count 对象数量
     * @param type json格式类型 type假如为null 则使用数组嵌数组的格式，如果不为空，则使用数组嵌对象的格式
     */
    public BasicDataUtil(Object t, List<Object> objList,Long count,String type){
        try {
            //加载数据列
            getCol(t);
            //加载数据总数
            this.totalRows = count!=null?count:0L;
            //加载数据列详情
            if(null!=type){
                resultSet.addAll(objList);
            }else{
                getColDetail(objList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /**
     * 获取列的属性信息
     * @param t
     */
    private  void  getCol(Object t){

        Field[] fields = t.getClass().getDeclaredFields();
        int m=1;
        for (Field field: fields) {
            if(field.getName().equals("serialVersionUID"))
                continue;
            ColumnInfo col = new ColumnInfo();
            col.setColIndex(m); //序列
            col.setColName(field.getName()); //属性名称

            String classType = field.getType().toString();
            int lastIndex = classType.lastIndexOf(".");
            col.setColType(classType.substring(lastIndex + 1)); //属性的列
            this.metadata.add(col);
            m++;
        }
    }

    /**
     * 获取列的属性详细信息
     * @param tList
     */
    private  void  getColDetail(List<Object> tList) throws IllegalAccessException {

        if(null!=tList){
            for(Object obj : tList){
                List<Object> newList = new ArrayList<>();
                Field[] fields = obj.getClass().getDeclaredFields();
                for (Field field: fields) {
                    if(field.getName().equals("serialVersionUID"))
                        continue;
                    field.setAccessible(true); //设置些属性是可以访问的
                    newList.add(field.get(obj));//得到此属性的值
                }
                resultSet.add(newList);
            }
        }
    }


    public List<ColumnInfo> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<ColumnInfo> metadata) {
        this.metadata = metadata;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public List<Object> getResultSet() {
        return resultSet;
    }

    public void setResultSet(List<Object> resultSet) {
        this.resultSet = resultSet;
    }
}
