package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("判断二手房否收藏")
public class IsExistEsfSelectParams {

    @ApiModelProperty(value = "用户Id", required = true)
    private long userId;

    @ApiModelProperty(value = "房源类型（ds为电商房源，agt为搜房帮房源，eagt为企业库房源，cfeagt为存房房源，yzwt为业主委托房源，yx为优选房源）")
    private String esfSubType;

    @ApiModelProperty(value = "城市", required = true)
    private String city;

    @ApiModelProperty(value = "楼盘、房源id", required = true)
    private String houseId;

    @ApiModelProperty(value = "物业类型（0住宅  1商铺  2写字楼  3小区  4厂房  5仓库  6车位  7别墅）", required = true)
    private Integer propertyType;

    @ApiModelProperty(value = "优选房源的groupId（esfSubType=='yx'时，此字段才有效）")
    private String groupId;
}