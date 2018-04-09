package com.jianchi.service;

import com.jianchi.dao.TableHeaderMapper;
import com.jianchi.entity.TableHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulushou on 2018/4/4.
 */
@Component
public class BucketHeaderService {

    private final static List<TableHeader> bucketTableHeaderList = new ArrayList<>();

    private final static String TABLE_BUCKET = "bucket";

    @Autowired
    private TableHeaderMapper tableHeaderMapper;

    @PostConstruct
    private void init(){
        initBucketHTMLTableHeader();
    }

    private void initBucketHTMLTableHeader(){
        List<TableHeader> tableHeaders = tableHeaderMapper.selectTableHeaders(TABLE_BUCKET);
        for (TableHeader tableHeader : tableHeaders) {
            if(tableHeader.getColumnComment() == null) continue;
            bucketTableHeaderList.add(tableHeader);
        }
    }


    public List<TableHeader> getBucketTableHeaderMap(){
        return bucketTableHeaderList;
    }


}
