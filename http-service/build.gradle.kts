plugins {
    id("com.flexport.oteldemo.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))

    implementation(Libs.spring.boot.starter.starter)
    implementation(Libs.spring.boot.starter.web)
    implementation(Libs.jackson.module.kotlin)
    testImplementation(Libs.spring.boot.starter.test)
}

application {
    mainClass.set("com.flexport.oteldemo.httpservice.AppKt")
}
