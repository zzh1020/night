package com.example.book.data;

import com.example.book.bean.VipInfo;

import java.util.ArrayList;
import java.util.List;

public class VipDatasource {

    public static List<VipInfo> getUser(){
        List<VipInfo> userInfoList=new ArrayList<>();
        userInfoList.add(new VipInfo("张三","123"));
        userInfoList.add(new VipInfo("李四","123"));
        userInfoList.add(new VipInfo("王五","123"));
        return userInfoList;
    }
}
