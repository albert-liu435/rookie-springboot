package com.rookie.bigdata.boot.autoconfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.annotation.Configurations;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Class MyAutoConfigurationTest
 * @Description Tests for {@link AutoConfigurations}.
 * @Author rookie
 * @Date 2024/6/27 10:17
 * @Version 1.0
 */
class AutoConfigurationsTests {

    @Test
    void ofShouldCreateOrderedConfigurations() {
        Configurations configurations = AutoConfigurations.of(AutoConfigureA.class, AutoConfigureB.class);
        assertThat(Configurations.getClasses(configurations)).containsExactly(AutoConfigureB.class,
                AutoConfigureA.class);
    }

    @AutoConfigureAfter(AutoConfigureB.class)
    static class AutoConfigureA {

    }

    static class AutoConfigureB {

    }

}
