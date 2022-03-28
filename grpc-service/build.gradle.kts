plugins {
    id("com.flexport.oteldemo.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation(project(":grpc-api"))

    implementation(Libs.spring.boot.starter.id)
    implementation(Libs.spring.boot.starter.dataJpa)

    implementation(Libs.grpc.springBootStarter)
    implementation(Libs.grpc.kotlinStub)

    implementation(platform(Libs.openTelemetry.bom))
    implementation(platform(Libs.openTelemetry.bomAlpha))
    implementation(Libs.openTelemetry.api)
    implementation(Libs.openTelemetry.sdk.metrics)
    implementation(Libs.openTelemetry.sdk.logs)
    implementation(Libs.openTelemetry.exporter.otlp.id)
    implementation(Libs.openTelemetry.exporter.otlp.metrics)
    implementation(Libs.openTelemetry.exporter.otlp.logs)
    implementation(Libs.openTelemetry.extension.annotations)
    implementation(Libs.openTelemetry.extension.kotlin)

    runtimeOnly(Libs.postgres.id)
    runtimeOnly(Libs.javaxbApi)
    runtimeOnly(Libs.kotlin.reflect)

    implementation(Libs.kotlinLogging.id)

    testImplementation(Libs.spring.boot.starter.test)
}

application {
    mainClass.set("com.flexport.oteldemo.grpcservice.AppKt")
}
