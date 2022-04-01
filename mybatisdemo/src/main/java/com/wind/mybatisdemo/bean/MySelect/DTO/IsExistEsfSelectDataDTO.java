package com.wind.mybatisdemo.bean.MySelect.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("批量判断二手房是否收藏返回参数数据")
public class IsExistEsfSelectDataDTO {

    @ApiModelProperty(value = "收藏Id")
    private Long mySelectId = 0L;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "房源Id")
    private String houseId;

    @ApiModelProperty(value = "是否收藏")
    private Boolean isSelect = false;
}