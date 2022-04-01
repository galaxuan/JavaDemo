package com.wind.mybatisdemo.bean.MySelect.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MySelectEntity {

    @ApiModelProperty(value = "用户Id")
    private Long userId;

    @ApiModelProperty(value = "头图")
    private String face;

    @ApiModelProperty(value = "收藏名称", required = true)
    private String name;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "价格")
    private Float price = 0F;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "链接地址")
    private String linkUrl;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "价格单位")
    private String priceType;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "楼盘、房源id")
    private String houseId;

    @ApiModelProperty(value = "居室数")
    private String roomNum;

    private String id;

    @ApiModelProperty(value = "我的收藏Id")
    private Long mySelectId;

    @ApiModelProperty(value = "物业类型（0住宅  1商铺  2写字楼  3小区  4厂房  5仓库  6车位  7别墅）")
    private int propertyType;

    @ApiModelProperty(value = "坐标X")
    private String coordX;

    @ApiModelProperty(value = "坐标Y")
    private String coordY;

    @ApiModelProperty(value = "挂牌量")
    private Integer guaPaiLiang;

    @ApiModelProperty(value = "服务名")
    private String service;

    @ApiModelProperty(value = "二手房：ds为电商房源，agt为搜房帮房源，eagt为企业库房源，cfeagt为存房房源，yzwt为业主委托房源，yx为优选房源   租房：agt为经纪人房源，jx为个人房源，ppgy为租房品牌公寓，eagt为企业库房源，cfeagt为存房房源，yx为优选房源")
    private String esfSubType;

    @ApiModelProperty(value = "电商房源类型")
    private String channelType;

    @ApiModelProperty(value = "新房房源Id")
    private String fangYuanId;

    @ApiModelProperty(value = "户型Id")
    private String roomId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "设计师Id/工长Id/灵感专辑Id/我的灵感专辑Id")
    private String homeId;

    @ApiModelProperty(value = "服务区域（关注设计师/工长时的参数，收藏灵感专辑不需要该参数）")
    private String serviceArea;

    @ApiModelProperty(value = "商圈")
    private String area;

    @ApiModelProperty(value = "区域")
    private String district;

    @ApiModelProperty(value = "户型")
    private String huXing;

    @ApiModelProperty(value = "面积")
    private String mianJi;

    @ApiModelProperty(value = "施工案例/设计作品个数")
    private Integer caseCount;

    @ApiModelProperty(value = "价格类型")
    private String priceCategory;

    @ApiModelProperty(value = "知识收藏 标签")
    private String knowledgeTag;

    @ApiModelProperty(value = "咨询摘要")
    private String summary;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "备注标签")
    private String remarkTags;

    @ApiModelProperty(value = "当前价格")
    private Float housePrice;

    @ApiModelProperty(value = "当前状态")
    private Integer houseStatus;

    @ApiModelProperty(value = "修改时间")
    private String priceUpdateTime;

    @ApiModelProperty(value = "楼盘Id")
    private Long newCode = 0L;

    @ApiModelProperty(value = "楼盘名称")
    private String projName = "";

    private String nowCity;

    private String pageId;

    private String ext;

    @ApiModelProperty(value = "二手房、租房优选房源；房源类型（如agt、jp（外部竞品）、ds 等）")
    private String subSubType;

    @ApiModelProperty(value = "表Index", hidden = true)
    private int tbIndex;
}
