package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("批量判断是新房否收藏参数")
public class IsExistNewSelectDataParams {
    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "楼盘、房源id", required = true)
    private String houseId;

    @ApiModelProperty(value = "户型Id")
    private String roomId;

    @ApiModelProperty(value = "新房房源Id")
    private String fangYuanId;
}