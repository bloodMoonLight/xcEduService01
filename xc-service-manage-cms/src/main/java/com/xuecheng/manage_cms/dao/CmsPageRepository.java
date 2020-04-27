package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Cms的Repository，与Mybatis-plus的repository层差不多，都是继承一个接口，传入操作的类型以及主键类型
 * @ClassName CmsPageRepository
 * @Description TODO
 * @Author 张鸿志
 * @Date 2020年4月27日21:23:48 21:23
 * Version 1.0
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    /* 自定义DAO层方法 */
    /**
     * 根据页面名称查询
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 21:57
     * @Return
     **/
    CmsPage findByPageName(String pageName);

    /**
     * 根据页面名称和页面类型查询
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 21:58
     * @Return
     **/
    CmsPage findByPageNameAndPageType(String pageName,String pageType);
    /**
     * 根据站点id和页面类型查询条数
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 21:59
     * @Return
     **/
    int findBySiteIdAndPageType(String siteId,String pageType);
    /**
     *  根据站点id和页面类型查询分页数据
     * @Description TODO
     * @params
     * @Author 张鸿志
     * @Date 2020/4/27 22:00
     * @Return
     **/
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);

}
