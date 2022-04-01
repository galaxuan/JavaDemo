package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("批量判断是租房否收藏参数")
public class IsExistRentSelectDataParams {
    @ApiModelProperty(value = "房源类型（agt为经纪人房源，jx为个人房源，ppgy为租房品牌公寓，eagt为企业库房源，cfeagt为存房房源，yx为优选房源）", required = true)
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