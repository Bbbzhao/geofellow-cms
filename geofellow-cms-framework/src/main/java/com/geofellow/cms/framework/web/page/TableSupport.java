package com.geofellow.cms.framework.web.page;

import com.geofellow.cms.common.constant.Constants;
import com.geofellow.cms.common.page.PageDomain;
import com.geofellow.cms.common.utils.ServletUtils;

/**
 * 表格数据处理
 *
 * @author 
 */
public class TableSupport {

    private TableSupport() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest() {
        return getPageDomain();
    }
}
