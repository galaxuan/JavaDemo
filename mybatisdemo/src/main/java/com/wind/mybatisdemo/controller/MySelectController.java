package com.wind.mybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.wind.mybatisdemo.bean.MySelect.DTO.*;
import com.wind.mybatisdemo.bean.MySelect.Params.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wind.mybatisdemo.service.MySelectService;
import com.wind.mybatisdemo.util.NumberUtil;
import com.wind.mybatisdemo.util.Result;
import com.wind.mybatisdemo.util.ResultGenerator;
import com.wind.mybatisdemo.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/mySelect")
@Api(tags = "MySelectController", description = "我的收藏", value = "")
public class MySelectController {

    private static final Logger logger = LoggerFactory.getLogger(MySelectController.class);

    @Resource
    private MySelectService mySelectService;

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public Result<String> Test(@RequestParam(value = "str", defaultValue = "test") String str) {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        logger.info(str + " " + sdf.format(date));
        return ResultGenerator.getSingleton().genSuccessResult(str + " " + sdf.format(date));
    }

    @RequestMapping(value = "/isExistRentSelectList", method = {RequestMethod.POST})
    @ApiOperation("我的收藏-批量判断租房是否收藏")
    public Result<IsExistRentSelectListDTO> isExistRentSelectList(@RequestBody IsExistRentSelectListParams params) {

        if (params.getUserId() < 1) {
            return ResultGenerator.getSingleton().genFailResult("userId无效！");
        }
        if (params.getSelectList() == null || params.getSelectList().size() < 1) {
            return ResultGenerator.getSingleton().genFailResult("selectList参数无效！");
        } else {
            int count = 100;
            if (params.getSelectList().size() > count) {
                return ResultGenerator.getSingleton().genFailResult(MessageFormat.format("selectList最大支持{0}组数据查询！", count));
            } else {
                for (IsExistRentSelectDataParams item : params.getSelectList()) {
                    if (!StringUtil.isEmptyOrNull(item.getEsfSubType()) && "yx".equals(item.getEsfSubType()) && StringUtil.isEmptyOrNull(item.getGroupId())) {
                        return ResultGenerator.getSingleton().genFailResult("优选GroupId参数无效！");
                    }
                    if (StringUtil.isEmptyOrNull(item.getCity()) || StringUtil.isEmptyOrNull(item.getEsfSubType())
                            || StringUtil.isEmptyOrNull(item.getHouseId()) || NumberUtil.isEmptyOrNull(item.getPropertyType())) {
                        return ResultGenerator.getSingleton().genFailResult("参数不能为空！");
                    }
                }
            }
        }
        try {
            IsExistRentSelectListDTO result = mySelectService.isExistRentSelectList(params);
            return ResultGenerator.getSingleton().genSuccessResult(result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResultGenerator.getSingleton().genFailResult();
        }
    }

    @RequestMapping(value = "/isExistNewSelectList", method = {RequestMethod.POST})
    @ApiOperation("我的收藏-批量判断新房是否收藏")
    public Result<IsExistNewSelectListDTO> isExistNewSelectList(@RequestBody IsExistNewSelectListParams params) {
        if (params.getUserId() < 1) {
            return ResultGenerator.getSingleton().genFailResult("userId无效！");
        }
        if (params.getSelectList() == null || params.getSelectList().size() < 1) {
            return ResultGenerator.getSingleton().genFailResult("selectList参数无效！");
        } else {
            int count = 100;
            if (params.getSelectList().size() > count) {
                return ResultGenerator.getSingleton().genFailResult(MessageFormat.format("selectList最大支持{0}组数据查询！", count));
            } else {
                for (IsExistNewSelectDataParams item : params.getSelectList()) {
                    if (StringUtil.isEmptyOrNull(item.getHouseId())) {
                        return ResultGenerator.getSingleton().genFailResult("参数houseId不能为空！");
                    } else if (StringUtil.isEmptyOrNull(item.getCity())) {
                        if (!StringUtil.isEmptyOrNull(item.getRoomId()) && StringUtil.isEmptyOrNull(item.getFangYuanId())) {
                            return ResultGenerator.getSingleton().genFailResult("参数city不能为空！");
                        } else if (StringUtil.isEmptyOrNull(item.getRoomId()) && !StringUtil.isEmptyOrNull(item.getFangYuanId())) {
                            return ResultGenerator.getSingleton().genFailResult("参数city不能为空！");
                        }
                    }
                }
            }
        }
        try {
            IsExistNewSelectListDTO result = mySelectService.isExistNewSelectList(params);
            return ResultGenerator.getSingleton().genSuccessResult(result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResultGenerator.getSingleton().genFailResult();
        }
    }

    @RequestMapping(value = "/isExistEsfSelectList", method = {RequestMethod.POST})
    @ApiOperation("我的收藏-批量判断二手房是否收藏")
    public Result<IsExistEsfSelectListDTO> isExistEsfSelectList(@RequestBody IsExistEsfSelectListParams params) {

        if (params.getUserId() < 1) {
            return ResultGenerator.getSingleton().genFailResult("userId无效！");
        }
        if (params.getSelectList() == null || params.getSelectList().size() < 1) {
            return ResultGenerator.getSingleton().genFailResult("selectList参数无效！");
        } else {
            int count = 100;
            if (params.getSelectList().size() > count) {
                return ResultGenerator.getSingleton().genFailResult(MessageFormat.format("selectList最大支持{0}组数据查询！", count));
            } else {
                for (IsExistEsfSelectDataParams item : params.getSelectList()) {
                    if (!StringUtil.isEmptyOrNull(item.getEsfSubType()) && "yx".equals(item.getEsfSubType()) && StringUtil.isEmptyOrNull(item.getGroupId())) {
                        return ResultGenerator.getSingleton().genFailResult("优选GroupId参数无效！");
                    }
                    if (StringUtil.isEmptyOrNull(item.getCity()) || StringUtil.isEmptyOrNull(item.getHouseId()) || NumberUtil.isEmptyOrNull(item.getPropertyType())) {
                        return ResultGenerator.getSingleton().genFailResult("参数不能为空！");
                    }
                }
            }
        }
        try {
            IsExistEsfSelectListDTO result = mySelectService.isExistEsfSelectList(params);
            return ResultGenerator.getSingleton().genSuccessResult(result);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResultGenerator.getSingleton().genFailResult();
        }
    }

    @RequestMapping(value = "/addNewSelectList", method = {RequestMethod.POST})
    @ApiOperation("我的收藏-批量增加新房收藏")
    public Result<AddNewSelectListDTO> addNewSelectList(@RequestBody AddNewSelectListParams params) {
        if (params.getUserId() < 1) {
            return ResultGenerator.getSingleton().genFailResult("userId无效！");
        } else if (StringUtil.isEmptyOrNull(params.getUserName())) {
            return ResultGenerator.getSingleton().genFailResult("userName无效！");
        } else if (params.getAddSelectList() == null || params.getAddSelectList().size() < 1) {
            return ResultGenerator.getSingleton().genFailResult("addSelectList参数无效！");
        } else {
            int count = 50;
            if (params.getAddSelectList().size() > count) {
                return ResultGenerator.getSingleton().genFailResult(MessageFormat.format("addSelectList最大支持{0}组数据查询！", count));
            } else {
                for (AddNewSelectDataParams item : params.getAddSelectList()) {
                    if (NumberUtil.isEmptyOrNull(item.getPropertyType()) || StringUtil.isEmptyOrNull(item.getCity())
                            || StringUtil.isEmptyOrNull(item.getHouseId()) || StringUtil.isEmptyOrNull(item.getName()) || StringUtil.isEmptyOrNull(item.getLinkUrl())) {
                        return ResultGenerator.getSingleton().genFailResult("addSelectList有非空数据！");
                    }
                }
                try {
                    AddNewSelectListDTO result = mySelectService.addNewSelectList(params);
                    return ResultGenerator.getSingleton().genSuccessResult(result);
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                    return ResultGenerator.getSingleton().genFailResult();
                }
            }
        }
    }

    @RequestMapping(value = "/addEsfRentSelectList", method = {RequestMethod.POST})
    @ApiOperation("我的收藏-批量增加二手房租房收藏")
    public Result<AddEsfRentSelectListDTO> addEsfRentSelectList(@RequestBody AddEsfRentSelectListParams params) {
        System.out.println(JSON.toJSON(params));
        if (params.getUserId() < 1) {
            return ResultGenerator.getSingleton().genFailResult("userId无效！");
        } else if (StringUtil.isEmptyOrNull(params.getUserName())) {
            return ResultGenerator.getSingleton().genFailResult("userName无效！");
        } else if (StringUtil.isEmptyOrNull(params.getType()) || !(params.getType().equals("esf") || params.getType().equals("rent"))) {
            return ResultGenerator.getSingleton().genFailResult("type参数无效！");
        } else if (params.getAddSelectList() == null || params.getAddSelectList().size() < 1) {
            return ResultGenerator.getSingleton().genFailResult("addSelectList参数无效！");
        } else {
            int count = 50;
            if (params.getAddSelectList().size() > count) {
                return ResultGenerator.getSingleton().genFailResult(MessageFormat.format("addSelectList最大支持{0}组数据查询！", count));
            } else {
                for (AddEsfRentSelectDataParams item : params.getAddSelectList()) {
                    if (NumberUtil.isEmptyOrNull(item.getPropertyType()) || StringUtil.isEmptyOrNull(item.getCity())
                            || StringUtil.isEmptyOrNull(item.getHouseId()) || StringUtil.isEmptyOrNull(item.getName())
                            || StringUtil.isEmptyOrNull(item.getLinkUrl())) {
                        return ResultGenerator.getSingleton().genFailResult("addSelectList有非空数据！");
                    }
                    if (params.getType().equals("rent") && StringUtil.isEmptyOrNull(item.getEsfSubType())) {
                        return ResultGenerator.getSingleton().genFailResult("esfSubType参数不能为空！");
                    }
                }
                try {
                    AddEsfRentSelectListDTO result = mySelectService.addEsfRentSelectList(params);
                    return ResultGenerator.getSingleton().genSuccessResult(result);
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                    return ResultGenerator.getSingleton().genFailResult();
                }
            }
        }
    }
}