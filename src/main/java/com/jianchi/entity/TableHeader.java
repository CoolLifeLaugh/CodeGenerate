package com.jianchi.entity;


/**
 * Created by fulushou on 2018/4/4.
 */
public class TableHeader {

    // 列名
    private String columnName;
    //列数据类型
    private String dataType;
    //列描述
    private String columnComment;

    private boolean isShow;

    // 获取首字母大写的列
    public String getColumnName() {
        String[] strings = columnName.split("_");
        if(strings.length == 1){
            return columnName;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0]);
        for(int i = 1; i < strings.length; i++){
            stringBuilder.append(strings[i].substring(0,1).toUpperCase() + strings[i].substring(1));
        }
        return stringBuilder.toString();
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
//        if(columnComment.indexOf(";") == 0) return null;
        //列描述以分号分隔，作为表头
         return columnComment.split(";")[0];
//        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    @Override
    public String toString() {
        return "Header{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
