package com.onlinebookstore.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public ApplicationMetrics applicationMetrics(MeterRegistry meterRegistry) {
        return new ApplicationMetrics(meterRegistry);
    }

    public static class ApplicationMetrics {
        private final MeterRegistry meterRegistry;

        public ApplicationMetrics(MeterRegistry meterRegistry) {
            this.meterRegistry = meterRegistry;
            // Register custom metrics here
            meterRegistry.gauge("custom_metric_example", 1);
        }
    }
}
