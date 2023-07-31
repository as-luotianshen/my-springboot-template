package net.rakan.god.myspringboottemplate.common.manager.factory;


import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @Author LiChangRui on 2023/7/11 17:07
 */
public class AsyncFactory {

    /**
     * 测试方法
     *
     * @Author LiChangRui on 2023/7/11 17:07
     */
    public static TimerTask example(String str) throws InterruptedException {
        return new TimerTask() {
            @Override
            public void run() {
                System.out.println(str);
            }
        };
    }
}
