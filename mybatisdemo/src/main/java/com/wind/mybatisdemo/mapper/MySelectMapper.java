package com.wind.mybatisdemo.mapper;

import com.wind.mybatisdemo.bean.MySelect.Entity.MySelectEntity;
import com.wind.mybatisdemo.bean.MySelect.Params.IsExistEsfSelectListParams;
import com.wind.mybatisdemo.bean.MySelect.Params.IsExistNewSelectListParams;
import com.wind.mybatisdemo.bean.MySelect.Params.IsExistRentSelectListParams;

import java.util.List;


public interface MySelectMapper {

    List<MySelectEntity> isExistRentSelectList(IsExistRentSelectListParams params);

    List<MySelectEntity> isExistNewSelectList(IsExistNewSelectListParams params);

    List<MySelectEntity> isExistEsfSelectList(IsExistEsfSelectListParams params);

    Long addSelect(MySelectEntity params);
}