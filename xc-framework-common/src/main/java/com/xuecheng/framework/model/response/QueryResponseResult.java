package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;
/**
 * 响应结果类型，分页查询结果统一用该类
 * @Description TODO
 * @params
 * @Author 张鸿志
 * @Date 2020/4/27 18:54
 * @Return
 **/
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
