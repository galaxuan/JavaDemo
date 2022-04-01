package com.wind.mybatisdemo.bean.MySelect.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("批量增加新房收藏返回参数数据")
public class AddNewSelectDataDTO {

    @ApiModelProperty(value = "收藏Id")
    private Long mySelectId = 0L;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "楼盘、房源id")
    private String houseId;

    @ApiModelProperty(value = "户型Id")
    private String roomId;

    @ApiModelProperty(value = "是否添加")
    private Boolean isAddSelect = false;

    @ApiModelProperty(value = "消息")
    private String message = "";
}