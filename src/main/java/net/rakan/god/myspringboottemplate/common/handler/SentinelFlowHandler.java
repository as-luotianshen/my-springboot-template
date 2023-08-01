package net.rakan.god.myspringboottemplate.common.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import net.rakan.god.myspringboottemplate.common.vo.Result;

/**
 * sentinel流控
 *
 * @Author LiChangRui on 2023/8/1 14:25
 */
public class SentinelFlowHandler {

    /**
     * 注意：
     * 1. 一定要public
     * 2. 返回值一定要和源方法保证一致， 包含源方法的参数。
     * 3. 可以在参数最后添加BlockException 可以区分是什么规则的处理方法
     *
     * @Author LiChangRui on 2023/8/1 14:27
     */
    public static Result resourceName(BlockException blockException) {
        return Result.error("被流控了！");
    }
}
