package com.rookie.bigdata.retry.config;

import com.rookie.bigdata.retry.annotation.EnableRetry;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;

/**
 * @Class AutoProxySelector
 * @Description
 * @Author rookie
 * @Date 2024/1/2 14:04
 * @Version 1.0
 */
public class AutoProxySelector extends AdviceModeImportSelector<EnableRetry> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
                return new String[]{AutoProxyRegistrar.class.getName(),
                        ProxyRetryConfiguration.class.getName()};
            case ASPECTJ:
                throw new UnsupportedOperationException("unsupport operation");
            default:
                return null;
        }
    }
}
