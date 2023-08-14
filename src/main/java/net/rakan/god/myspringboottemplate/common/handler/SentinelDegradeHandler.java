package net.rakan.god.myspringboottemplate.common.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import net.rakan.god.myspringboottemplate.common.vo.Result;

/**
 * sentinel熔断
 *
 * @Author LiChangRui on 2023/8/2 10:06
 */
public class SentinelDegradeHandler {

    /**
     * 熔断方法
     *
     * @Author LiChangRui on 2023/8/2 10:06
     */
    public static Result blockHandlerForFb(BlockException ex) {
        return Result.error("被熔断了！");
    }
}
