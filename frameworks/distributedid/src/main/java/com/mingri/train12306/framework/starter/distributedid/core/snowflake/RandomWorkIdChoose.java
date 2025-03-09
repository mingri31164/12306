package com.mingri.train12306.framework.starter.distributedid.core.snowflake;

import com.mingri.train12306.framework.starter.distributedid.core.snowflake.AbstractWorkIdChooseTemplate;
import com.mingri.train12306.framework.starter.distributedid.core.snowflake.WorkIdWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * 使用随机数获取雪花 WorkId
 */
@Slf4j
public class RandomWorkIdChoose extends AbstractWorkIdChooseTemplate implements InitializingBean {

    @Override
    protected WorkIdWrapper chooseWorkId() {
        int start = 0, end = 31;
        return new WorkIdWrapper(getRandom(start, end), getRandom(start, end));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        chooseAndInit();
    }

    private static long getRandom(int start, int end) {
        long random = (long) (Math.random() * (end - start + 1) + start);
        return random;
    }

}
