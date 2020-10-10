package com.geofellow.cms.web.controller.tool;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geofellow.cms.framework.web.base.BaseController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * build 表单构建
 *
 * @author 
 */
@Controller
@RequestMapping("/tool/build")
@ApiIgnore(value = "表单构建")
public class BuildController extends BaseController {

    @RequiresPermissions("tool:build:view")
    @GetMapping()
    public String build() {
        String prefix = "tool/build";
        return prefix + "/build";
    }
}
