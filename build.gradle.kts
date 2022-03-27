buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.protobuf.plugin)
    }
}

plugins {
    id("org.springframework.boot") version "2.6.5"
    kotlin("plugin.spring") version "1.6.10"
}
