package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * cms 页面查询接口定义
 * @ClassName CmsPageControllerApi
 * @Description TODO
 * @Author 张鸿志
 * @Date 2020年4月27日18:57:27 18:57
 * Version 1.0
 **/
@Api(value = "cms页面管理接口", description = "cms页面管理接口，增、删、改、查")
public interface CmsPageControllerApi {
    /**
     * cms分页查询的接口
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 18:58
     * @Return 
     **/
    @ApiOperation(value = "分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",required = true,paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size",value = "查询条数",required = true,paramType = "path",dataType = "int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
