repositories {
    mavenCentral()
}

val toLibs by configurations.creating

dependencies {
    toLibs(Libs.openTelemetry.javaAgent)
}

tasks.register("build", Copy::class) {
    from(toLibs)
    into("build/libs")
}
