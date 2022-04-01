package com.wind.mybatisdemo.bean.MySelect.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("批量增加二手房租房收藏返回参数数据")
public class AddEsfRentSelectDataDTO {

    @ApiModelProperty(value = "收藏Id")
    private Long mySelectId = 0L;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "房源Id")
    private String houseId;

    @ApiModelProperty(value = "是否添加")
    private Boolean isAddSelect = false;

    @ApiModelProperty(value = "消息")
    private String message = "";
}