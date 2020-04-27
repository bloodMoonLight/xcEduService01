package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * cms 页面查询接口定义
 * @ClassName CmsPageControllerApi
 * @Description TODO
 * @Author 张鸿志
 * @Date 2020年4月27日18:57:27 18:57
 * Version 1.0
 **/
public interface CmsPageControllerApi {
    /**
     * cms分页查询的接口
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 18:58
     * @Return 
     **/
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
