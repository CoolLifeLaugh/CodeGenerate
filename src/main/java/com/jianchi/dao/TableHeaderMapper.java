package com.jianchi.dao;

import com.jianchi.entity.TableHeader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fulushou on 2018/4/4.
 */
public interface TableHeaderMapper {

    /**
     * 通过表名获取comment的表描述，作为表头显示
     * @param tableName
     * @return
     */
    List<TableHeader> selectTableHeaders(@Param("tableName") String tableName);
}
