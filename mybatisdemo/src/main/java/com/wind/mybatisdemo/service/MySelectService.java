package com.wind.mybatisdemo.service;

import com.wind.mybatisdemo.bean.MySelect.DTO.*;
import com.wind.mybatisdemo.bean.MySelect.Params.*;
import com.wind.mybatisdemo.bean.MySelect.Entity.MySelectEntity;
import com.wind.mybatisdemo.mapper.MySelectMapper;
import com.wind.mybatisdemo.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MySelectService {
    @Resource
    private MySelectMapper mySelectMapper;

    public IsExistRentSelectListDTO isExistRentSelectList(IsExistRentSelectListParams params) {
        int tbIndex = Math.toIntExact(params.getUserId() % 10);
        params.setTbIndex(tbIndex);

        List<MySelectEntity> mySelectEntityList = mySelectMapper.isExistRentSelectList(params);

        IsExistRentSelectListDTO dto = new IsExistRentSelectListDTO();
        dto.setUserId(params.getUserId());

        List<IsExistRentSelectDataDTO> dataDTOList = new ArrayList<>();
        for (IsExistRentSelectDataParams item : params.getSelectList()) {

            IsExistRentSelectDataDTO isExistRentSelectDataDTO = new IsExistRentSelectDataDTO();
            BeanUtils.copyProperties(item, isExistRentSelectDataDTO);

            List<MySelectEntity> mySelectEntities = mySelectEntityList.stream()
                    .filter(s -> !StringUtil.isEmptyOrNull(s.getCity()) && s.getCity().equals(item.getCity())
                            && !StringUtil.isEmptyOrNull(s.getHouseId()) && s.getHouseId().equals(item.getHouseId())
                            && !StringUtil.isEmptyOrNull(s.getEsfSubType()) && s.getEsfSubType().equals(item.getEsfSubType())
                            && s.getPropertyType() == item.getPropertyType()).collect(Collectors.toList());

            if (!StringUtil.isEmptyOrNull(item.getEsfSubType()) && item.getEsfSubType().equals("yx") && !StringUtil.isEmptyOrNull(item.getGroupId())) {
                mySelectEntities = mySelectEntities.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getSummary()) && s.getSummary().equals(item.getGroupId())).collect(Collectors.toList());
            }

            if (mySelectEntities.size() > 0) {
                MySelectEntity mySelectEntity = mySelectEntities.get(0);
                isExistRentSelectDataDTO.setIsSelect(true);
                isExistRentSelectDataDTO.setMySelectId(mySelectEntity.getMySelectId());
            }

            dataDTOList.add(isExistRentSelectDataDTO);
        }
        dto.setList(dataDTOList);

        return dto;
    }

    public IsExistNewSelectListDTO isExistNewSelectList(IsExistNewSelectListParams params) {
        int tbIndex = Math.toIntExact(params.getUserId() % 10);
        params.setTbIndex(tbIndex);

        List<MySelectEntity> mySelectEntityList = mySelectMapper.isExistNewSelectList(params);

        IsExistNewSelectListDTO dto = new IsExistNewSelectListDTO();
        dto.setUserId(params.getUserId());

        List<IsExistNewSelectDataDTO> dataDTOList = new ArrayList<>();
        for (IsExistNewSelectDataParams item : params.getSelectList()) {

            IsExistNewSelectDataDTO isExistNewSelectDataDTO = new IsExistNewSelectDataDTO();
            BeanUtils.copyProperties(item, isExistNewSelectDataDTO);

            List<MySelectEntity> mySelectEntities = mySelectEntityList.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getHouseId()) && s.getHouseId().equals(item.getHouseId())).collect(Collectors.toList());
            if (!StringUtil.isEmptyOrNull(item.getRoomId())) {
                mySelectEntities = mySelectEntityList.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getCity()) && s.getCity().equals(item.getCity())
                        && !StringUtil.isEmptyOrNull(s.getRoomId()) && s.getRoomId().equals(item.getRoomId())).collect(Collectors.toList());
            } else if (!StringUtil.isEmptyOrNull(item.getFangYuanId())) {
                mySelectEntities = mySelectEntityList.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getCity()) && s.getCity().equals(item.getCity())
                        && !StringUtil.isEmptyOrNull(s.getFangYuanId()) && s.getFangYuanId().equals(item.getFangYuanId())).collect(Collectors.toList());
            }
            if (mySelectEntities.size() > 0) {
                MySelectEntity mySelectEntity = mySelectEntities.get(0);
                isExistNewSelectDataDTO.setIsSelect(true);
                isExistNewSelectDataDTO.setMySelectId(mySelectEntity.getMySelectId());
            }

            dataDTOList.add(isExistNewSelectDataDTO);
        }
        dto.setList(dataDTOList);

        return dto;
    }

    public IsExistEsfSelectListDTO isExistEsfSelectList(IsExistEsfSelectListParams params) {
        int tbIndex = Math.toIntExact(params.getUserId() % 10);
        params.setTbIndex(tbIndex);

        List<MySelectEntity> mySelectEntityList = mySelectMapper.isExistEsfSelectList(params);

        IsExistEsfSelectListDTO dto = new IsExistEsfSelectListDTO();
        dto.setUserId(params.getUserId());

        List<IsExistEsfSelectDataDTO> dataDTOList = new ArrayList<>();
        for (IsExistEsfSelectDataParams item : params.getSelectList()) {

            IsExistEsfSelectDataDTO isExistEsfSelectDataDTO = new IsExistEsfSelectDataDTO();
            BeanUtils.copyProperties(item, isExistEsfSelectDataDTO);

            List<MySelectEntity> mySelectEntities = mySelectEntityList.stream()
                    .filter(s -> !StringUtil.isEmptyOrNull(s.getHouseId()) && s.getHouseId().equals(item.getHouseId())
                            && s.getPropertyType() == item.getPropertyType()).collect(Collectors.toList());

            if (!StringUtil.isEmptyOrNull(item.getEsfSubType())) {
                mySelectEntities = mySelectEntities.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getEsfSubType()) && s.getEsfSubType().equals(item.getEsfSubType())).collect(Collectors.toList());

                if (item.getEsfSubType().equals("yx") && !StringUtil.isEmptyOrNull(item.getGroupId())) {
                    mySelectEntities = mySelectEntities.stream().filter(s -> !StringUtil.isEmptyOrNull(s.getSummary()) && s.getSummary().equals(item.getGroupId())).collect(Collectors.toList());
                }
            }

            if (mySelectEntities.size() > 0) {
                MySelectEntity mySelectEntity = mySelectEntities.get(0);
                isExistEsfSelectDataDTO.setIsSelect(true);
                isExistEsfSelectDataDTO.setMySelectId(mySelectEntity.getMySelectId());
            }

            dataDTOList.add(isExistEsfSelectDataDTO);
        }
        dto.setList(dataDTOList);

        return dto;
    }

    public Boolean isExistNewSelect(IsExistNewSelectParams params) {

        List<IsExistNewSelectDataParams> isExistNewSelectDataParamsList = new ArrayList<>();
        IsExistNewSelectDataParams dataParams = new IsExistNewSelectDataParams();
        BeanUtils.copyProperties(params, dataParams);
        isExistNewSelectDataParamsList.add(dataParams);

        IsExistNewSelectListParams isExistNewSelectListParams = new IsExistNewSelectListParams();
        isExistNewSelectListParams.setUserId(params.getUserId());
        isExistNewSelectListParams.setSelectList(isExistNewSelectDataParamsList);

        IsExistNewSelectListDTO result = this.isExistNewSelectList(isExistNewSelectListParams);

        if (result != null && result.getList() != null) {
            IsExistNewSelectDataDTO dataDTO = result.getList().get(0);
            return dataDTO.getIsSelect();
        }

        return false;
    }

    public Boolean isExistEsfSelect(IsExistEsfSelectParams params) {

        List<IsExistEsfSelectDataParams> isExistEsfSelectDataParamsList = new ArrayList<>();
        IsExistEsfSelectDataParams dataParams = new IsExistEsfSelectDataParams();
        BeanUtils.copyProperties(params, dataParams);
        isExistEsfSelectDataParamsList.add(dataParams);

        IsExistEsfSelectListParams isExistEsfSelectListParams = new IsExistEsfSelectListParams();
        isExistEsfSelectListParams.setUserId(params.getUserId());
        isExistEsfSelectListParams.setSelectList(isExistEsfSelectDataParamsList);

        IsExistEsfSelectListDTO result = this.isExistEsfSelectList(isExistEsfSelectListParams);

        if (result != null && result.getList() != null) {
            IsExistEsfSelectDataDTO dataDTO = result.getList().get(0);
            return dataDTO.getIsSelect();
        }

        return false;
    }

    public Boolean isExistRentSelect(IsExistRentSelectParams params) {

        List<IsExistRentSelectDataParams> isExistRentSelectDataParamsList = new ArrayList<>();
        IsExistRentSelectDataParams dataParams = new IsExistRentSelectDataParams();
        BeanUtils.copyProperties(params, dataParams);
        isExistRentSelectDataParamsList.add(dataParams);

        IsExistRentSelectListParams isExistRentSelectListParams = new IsExistRentSelectListParams();
        isExistRentSelectListParams.setUserId(params.getUserId());
        isExistRentSelectListParams.setSelectList(isExistRentSelectDataParamsList);

        IsExistRentSelectListDTO result = this.isExistRentSelectList(isExistRentSelectListParams);

        if (result != null && result.getList() != null) {
            IsExistRentSelectDataDTO dataDTO = result.getList().get(0);
            return dataDTO.getIsSelect();
        }

        return false;
    }

    public AddNewSelectListDTO addNewSelectList(AddNewSelectListParams params) {

        List<AddNewSelectDataDTO> addNewSelectDataDTOList = new ArrayList<>();
        for (AddNewSelectDataParams item : params.getAddSelectList()) {

            AddNewSelectDataDTO dataDTO = new AddNewSelectDataDTO();
            BeanUtils.copyProperties(item, dataDTO);

            if (!StringUtil.isEmptyOrNull(item.getRoomId()) && (StringUtil.isEmptyOrNull(item.getHuXing()) || StringUtil.isEmptyOrNull(item.getMianJi()))) {
                dataDTO.setMessage("收藏户型时,户型,面积不能为空");
            } else {
                IsExistNewSelectParams isExistNewSelectParams = new IsExistNewSelectParams();
                BeanUtils.copyProperties(item, isExistNewSelectParams);
                isExistNewSelectParams.setUserId(params.getUserId());

                boolean isSelect = this.isExistNewSelect(isExistNewSelectParams);
                if (isSelect) {
                    dataDTO.setMessage("已存在");
                } else {
                    MySelectEntity mySelectEntityParams = new MySelectEntity();
                    BeanUtils.copyProperties(item, mySelectEntityParams);

                    int tbIndex = Math.toIntExact(params.getUserId() % 10);
                    mySelectEntityParams.setTbIndex(tbIndex);
                    mySelectEntityParams.setUserId(params.getUserId());
                    mySelectEntityParams.setUserName(params.getUserName());
                    mySelectEntityParams.setType("new");

                    try {
                        Long mySelectId = mySelectMapper.addSelect(mySelectEntityParams);
                        if (mySelectId > 0) {
                            dataDTO.setMySelectId(mySelectEntityParams.getMySelectId());
                            dataDTO.setIsAddSelect(true);
                        } else {
                            dataDTO.setMessage("增加失败");
                        }
                    } catch (Exception ex) {
                        dataDTO.setMessage("增加失败");
                    }
                }
            }

            addNewSelectDataDTOList.add(dataDTO);
        }

        AddNewSelectListDTO result = new AddNewSelectListDTO();
        result.setUserId(params.getUserId());
        result.setList(addNewSelectDataDTOList);

        return result;
    }

    public AddEsfRentSelectListDTO addEsfRentSelectList(AddEsfRentSelectListParams params) {

        List<AddEsfRentSelectDataDTO> addEsfRentSelectDataDTOList = new ArrayList<>();
        for (AddEsfRentSelectDataParams item : params.getAddSelectList()) {

            AddEsfRentSelectDataDTO dataDTO = new AddEsfRentSelectDataDTO();
            BeanUtils.copyProperties(item, dataDTO);

            if (!StringUtil.isEmptyOrNull(item.getEsfSubType()) && item.getEsfSubType().equals("xy") && StringUtil.isEmptyOrNull(item.getGroupId())) {
                dataDTO.setMessage("优选房源的groupId不能为空");
            } else {

                boolean isSelect = false;
                if (params.getType().equals("esf")) {

                    IsExistEsfSelectParams isExistEsfSelectParams = new IsExistEsfSelectParams();
                    BeanUtils.copyProperties(item, isExistEsfSelectParams);
                    isExistEsfSelectParams.setUserId(params.getUserId());
                    isSelect = this.isExistEsfSelect(isExistEsfSelectParams);
                } else if (params.getType().equals("rent")) {

                    IsExistRentSelectParams isExistRentSelectParams = new IsExistRentSelectParams();
                    BeanUtils.copyProperties(item, isExistRentSelectParams);
                    isExistRentSelectParams.setUserId(params.getUserId());
                    isSelect = this.isExistRentSelect(isExistRentSelectParams);
                }

                if (isSelect) {
                    dataDTO.setMessage("已存在");
                } else {
                    MySelectEntity mySelectEntityParams = new MySelectEntity();
                    BeanUtils.copyProperties(item, mySelectEntityParams);

                    int tbIndex = Math.toIntExact(params.getUserId() % 10);
                    mySelectEntityParams.setTbIndex(tbIndex);
                    mySelectEntityParams.setUserId(params.getUserId());
                    mySelectEntityParams.setUserName(params.getUserName());
                    mySelectEntityParams.setType(params.getType());
                    mySelectEntityParams.setSummary(item.getGroupId());

                    try {
                        Long mySelectId = mySelectMapper.addSelect(mySelectEntityParams);
                        if (mySelectId > 0) {
                            dataDTO.setMySelectId(mySelectEntityParams.getMySelectId());
                            dataDTO.setIsAddSelect(true);
                        } else {
                            dataDTO.setMessage("增加失败");
                        }
                    } catch (Exception ex) {
                        dataDTO.setMessage("增加失败");
                    }
                }
            }

            addEsfRentSelectDataDTOList.add(dataDTO);
        }

        AddEsfRentSelectListDTO result = new AddEsfRentSelectListDTO();
        result.setUserId(params.getUserId());
        result.setList(addEsfRentSelectDataDTOList);

        return result;
    }
}