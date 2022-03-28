plugins {
    id("com.flexport.oteldemo.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation(project(":grpc-api"))

    implementation(Libs.kotlin.coroutines.core)
    implementation(Libs.kotlin.coroutines.reactor)

    implementation(Libs.spring.boot.starter.id)
    implementation(Libs.spring.boot.starter.web)
    implementation(Libs.jackson.module.kotlin)

    implementation(Libs.protobuf.kotlin)
    implementation(Libs.grpc.kotlinStub)
    implementation(Libs.grpc.netty.shaded)

    implementation(platform(Libs.openTelemetry.bom))
    implementation(Libs.openTelemetry.api)
    implementation(Libs.openTelemetry.extensionAnnotations)

    testImplementation(Libs.spring.boot.starter.test)
}

application {
    mainClass.set("com.flexport.oteldemo.httpservice.AppKt")
}
