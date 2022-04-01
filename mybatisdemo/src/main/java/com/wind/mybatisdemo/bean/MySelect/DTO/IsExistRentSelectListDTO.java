package com.wind.mybatisdemo.bean.MySelect.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("批量判断租房是否收藏返回数据")
public class IsExistRentSelectListDTO {

    @ApiModelProperty(value = "用户Id", required = true)
    private Long userId;

    @ApiModelProperty(value = "数据")
    private List<IsExistRentSelectDataDTO> list;
}