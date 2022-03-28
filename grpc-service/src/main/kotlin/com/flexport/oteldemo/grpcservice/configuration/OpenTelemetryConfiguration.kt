package com.flexport.oteldemo.grpcservice.configuration

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
            .get("oteldemo-grpc-service")
    }
}
