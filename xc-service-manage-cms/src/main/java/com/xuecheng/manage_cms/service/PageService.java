package com.xuecheng.manage_cms.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 分页的业务层
 * @ClassName PageService
 * @Description TODO
 * @Author 张鸿志
 * @Date 2020年4月27日22:01:24 22:01
 * Version 1.0
 **/
@Service
public class PageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;
    /**
     * 页面列表分页查询
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 22:02
     * @Return 
     **/
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        if(page <= 0){
            page = 1;
        }
        //mongoDB接口下标需要减1
        page = page -1;
        //定义分页对象
        Pageable pageable = new PageRequest(page,size);
        /** 查询出来的Page对象中包含了数据的长度，就不需要再查count了 */
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
