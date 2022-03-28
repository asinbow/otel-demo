package com.flexport.oteldemo.httpservice.configuration

import io.opentelemetry.api.metrics.Meter
import io.opentelemetry.sdk.metrics.SdkMeterProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenTelemetryConfiguration {

    @Bean
    fun meter(): Meter {
        return SdkMeterProvider
            .builder()
            .build()
            .get("oteldemo-http-service")
    }
}
