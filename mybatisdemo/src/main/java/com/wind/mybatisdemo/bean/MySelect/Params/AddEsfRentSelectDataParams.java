package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("批量增加二手房租房收藏参数")
public class AddEsfRentSelectDataParams {

    @ApiModelProperty(value = "物业类型（0住宅  1商铺  2写字楼  3小区  4厂房  5仓库  6车位  7别墅）", required = true)
    private Integer propertyType;

    @ApiModelProperty(value = "二手房：ds为电商房源，agt为搜房帮房源，eagt为企业库房源，cfeagt为存房房源，yzwt为业主委托房源，yx为优选房源  " +
            "租房：agt为经纪人房源，jx为个人房源，ppgy为租房品牌公寓，eagt为企业库房源，cfeagt为存房房源，yx为优选房源", required = true)
    private String esfSubType;

    @ApiModelProperty(value = "电商房源类型")
    private String channelType;

    @ApiModelProperty(value = "城市", required = true)
    private String city;

    @ApiModelProperty(value = "区域")
    private String district;

    @ApiModelProperty(value = "商圈")
    private String area;

    @ApiModelProperty(value = "楼盘、房源id", required = true)
    private String houseId;

    @ApiModelProperty(value = "楼盘Id")
    private long newCode;

    @ApiModelProperty(value = "楼盘名称")
    private String projName = "";

    @ApiModelProperty(value = "优选房源的groupId（esfSubType=='yx'时，此字段才有效）")
    private String groupId;

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

    @ApiModelProperty(value = "二手房、租房优选房源；房源类型（如agt、jp（外部竞品）、ds 等）")
    private String subSubType;
}

