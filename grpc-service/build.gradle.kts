plugins {
    id("com.flexport.oteldemo.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation(project(":grpc-api"))

    implementation(Libs.spring.boot.starter.starter)
    implementation(Libs.grpc.springBootStarter)
    implementation(Libs.grpc.kotlinStub)
    testImplementation(Libs.spring.boot.starter.test)
}

application {
    mainClass.set("com.flexport.oteldemo.grpcservice.AppKt")
}
