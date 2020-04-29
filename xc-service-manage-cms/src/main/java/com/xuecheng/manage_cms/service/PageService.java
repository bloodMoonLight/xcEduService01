package com.xuecheng.manage_cms.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        //条件匹配器,设置某一个域的匹配方式
        ExampleMatcher matching = ExampleMatcher.matching().withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage = new CmsPage();
        //判断传入的参数对象不为null时创造封装条件
        if(!StringUtils.isEmpty(queryPageRequest)){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
            cmsPage.setPageName(queryPageRequest.getPageName());
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
            cmsPage.setPageId(queryPageRequest.getPageId());
        }
        //创建条件实例
        Example<CmsPage> of = Example.of(cmsPage, matching);
        //定义分页对象
        Pageable pageable = new PageRequest(page-1,size);
        /** 查询出来的Page对象中包含了数据的长度，就不需要再查count了 */
        Page<CmsPage> all = cmsPageRepository.findAll(of,pageable);
        //创建保存分页查询对象，最后该对象要存入返回对象中去
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
