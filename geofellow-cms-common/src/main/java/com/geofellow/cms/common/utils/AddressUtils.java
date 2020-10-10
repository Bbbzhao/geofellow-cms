package com.geofellow.cms.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

import com.geofellow.cms.common.config.Global;
import com.geofellow.cms.common.json.JSON;
import com.geofellow.cms.common.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取地址类
 *
 * @author 
 */
@Slf4j
public class AddressUtils {

    private AddressUtils(){
        throw new IllegalStateException("Utility class");
    }

    private static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php" ;

    public static String getRealAddressByIp(String ip) {
        String address = "XX XX" ;

        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP" ;
        }
        if (Global.isAddressEnabled()) {
            String rspStr = HttpUtil.post(IP_URL, "ip=" + ip);
            if (StrUtil.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}" , ip);
                return address;
            }
            JSONObject obj;
            try {
                obj = JSON.unmarshal(rspStr, JSONObject.class);
                JSONObject data = obj.getObj("data");
                String region = data.getStr("region");
                String city = data.getStr("city");
                address = region + " " + city;
            } catch (Exception e) {
                log.error("获取地理位置异常 {}" , ip);
            }
        }
        return address;
    }
}
