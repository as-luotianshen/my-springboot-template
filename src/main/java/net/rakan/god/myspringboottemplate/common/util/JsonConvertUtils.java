package net.rakan.god.myspringboottemplate.common.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author LiChangRui on 2023/7/13 9:58
 */
public class JsonConvertUtils {

    /**
     * 将get请求入参转JsonObject
     *
     * @Author LiChangRui on 2023/7/13 10:01
     */
    public static JSONObject queryString(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        Enumeration paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = req.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            jsonObject.put(paramName, sb.toString());
        }
        return jsonObject;
    }
}
