plugins {
    id("com.flexport.oteldemo.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
}

application {
    mainClass.set("com.flexport.oteldemo.httpservice.AppKt")
}
