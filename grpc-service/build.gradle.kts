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

    runtimeOnly(Libs.postgres.id)
    runtimeOnly(Libs.javaxbApi)
    runtimeOnly(Libs.kotlin.reflect)

    testImplementation(Libs.spring.boot.starter.test)
}

application {
    mainClass.set("com.flexport.oteldemo.grpcservice.AppKt")
}
