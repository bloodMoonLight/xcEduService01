package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 为了实现后期扩展需求，继承RequestData
 * @ClassName QueryPageRequest   查询条件类型
 * @Description TODO
 * @Author 张鸿志
 * @Date 2020年4月27日18:50:02 18:49
 * Version 1.0
 **/
@Data
public class QueryPageRequest extends RequestData {
        /** 站点Id */
        @ApiModelProperty(name = "站点Id")
        private String siteId;
        /** 页面id */
        @ApiModelProperty(name = "页面Id")
        private String pageId;
        /** 页面名称 */
        @ApiModelProperty(name = "页面名称")
        private String pageName;
        /** 页面别名 */
        @ApiModelProperty(name = "页面别名")
        private String pageAliase;
        /** 模板Id */
        @ApiModelProperty(name = "模板Id")
        private String templateId;
}
