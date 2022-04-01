package com.wind.mybatisdemo.bean.MySelect.Params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("批量判断租房是否收藏")
public class IsExistRentSelectListParams {

    @ApiModelProperty(value = "用户Id", required = true)
    private long userId;

    @ApiModelProperty(value = "数据", required = true)
    private List<IsExistRentSelectDataParams> selectList;

    @ApiModelProperty(value = "表Index", hidden = true)
    private int tbIndex;
}

