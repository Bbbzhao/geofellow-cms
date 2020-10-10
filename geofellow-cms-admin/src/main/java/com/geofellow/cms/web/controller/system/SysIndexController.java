package com.geofellow.cms.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.geofellow.cms.common.annotation.LoginAuth;
import com.geofellow.cms.common.config.Global;
import com.geofellow.cms.framework.web.base.BaseController;
import com.geofellow.cms.system.domain.SysMenu;
import com.geofellow.cms.system.domain.SysUser;
import com.geofellow.cms.system.service.ISysMenuService;

import java.util.List;

/**
 * 首页 业务处理
 *
 * @author 
 */
@Controller
@LoginAuth
public class SysIndexController extends BaseController {

    private final ISysMenuService menuService;

    @Autowired
    public SysIndexController(ISysMenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 系统首页
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap,SysUser sysUser) {
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(sysUser);
        mmap.put("menus", menus);
        mmap.put("user", sysUser);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        mmap.put("demoEnabled", Global.isDemoEnabled());
        return "index";
    }


    /**
     * 系统介绍
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", Global.getVersion());
        return "main";
    }

    /**
     * 统计模版首页
     *
     * @param mmap ModelMap
     * @return
     */
    @GetMapping("/system/mainV1")
    public String mainV1(ModelMap mmap) {
        mmap.put("version", Global.getVersion());
        return "main_v1";
    }
}
