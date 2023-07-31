package net.rakan.god.myspringboottemplate.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import net.rakan.god.myspringboottemplate.common.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

public class ToolUtils {

    /**
     * 验证参数是否为空
     *
     * @param: keys 参与验证的字段
     * @param: params 参数
     * @author LiChangRui (1924097082@qq.com) on 2023/3/9
     */
    public static void checkParam(String[] keys, JSONObject params) {
        for (String key : keys) {
            if (ObjectUtil.isEmpty(params.get(key)) || StringUtils.isBlank(params.getString(key))) {
                throw new ServiceException("The field " + key + " cannot be empty！");
            }
        }
    }
}
