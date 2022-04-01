package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("批量增加新房收藏参数")
public class AddNewSelectDataParams {

//    @ApiModelProperty(value = "类型", required = true)
//    private String type;

    @ApiModelProperty(value = "物业类型（0住宅  1商铺  2写字楼  3小区  4厂房  5仓库  6车位  7别墅）", required = true)
    private Integer propertyType;

    @ApiModelProperty(value = "城市", required = true)
    private String city;

    @ApiModelProperty(value = "区域")
    private String district;

    @ApiModelProperty(value = "商圈")
    private String area;

    @ApiModelProperty(value = "楼盘、房源id", required = true)
    private String houseId;

    @ApiModelProperty(value = "户型Id")
    private String roomId;

    @ApiModelProperty(value = "收藏名称", required = true)
    private String name;

    @ApiModelProperty(value = "头图")
    private String face = "http://img.fang.com/newhousedata/images/My/Resource/Image/default_img.png";

    @ApiModelProperty(value = "价格")
    private float price;

    @ApiModelProperty(value = "价格单位")
    private String priceType;

    @ApiModelProperty(value = "链接地址", required = true)
    private String linkUrl;

    @ApiModelProperty(value = "户型")
    private String huXing;

    @ApiModelProperty(value = "面积")
    private String mianJi;

    @ApiModelProperty(value = "服务名")
    private String service;

    private String nowCity;

    private String pageId;

    private String ext;
}

