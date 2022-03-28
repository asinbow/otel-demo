
object Plugins {
    object protobuf {
        const val version = "0.8.18"
        const val id = "com.google.protobuf"
        const val plugin = "com.google.protobuf:protobuf-gradle-plugin:$version"
        object protoc {
            const val id = "com.google.protobuf:protoc:3.20.0"
            object gen {
                const val grpc = "io.grpc:protoc-gen-grpc-java:1.45.0"
                const val grpcKt = "io.grpc:protoc-gen-grpc-kotlin:1.2.1:jdk7@jar"
            }
        }
    }
    object spring {
        object boot {
            const val plugin = "org.springframework.boot:spring-boot-gradle-plugin:2.6.5"
        }
    }
}

object Libs {
    const val javaxbApi = "javax.xml.bind:jaxb-api:2.3.1"
    object kotlin {
        const val version = "1.6.10"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        object coroutines {
            const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val reactor = "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$version"
        }
    }
    object spring {
        object boot {
            object starter {
                const val version = "2.6.5"
                const val id = "org.springframework.boot:spring-boot-starter:$version"
                const val dataJpa = "org.springframework.boot:spring-boot-starter-data-jpa:$version"
                const val web = "org.springframework.boot:spring-boot-starter-web:$version"
                const val test = "org.springframework.boot:spring-boot-starter-test:$version"
            }
        }
    }

    object protobuf {
        const val kotlin = "com.google.protobuf:protobuf-kotlin:3.20.0-rc-1"
    }

    object grpc {
        const val version = "1.45.0"
        const val protobuf = "io.grpc:grpc-protobuf:$version"
        const val stub = "io.grpc:grpc-stub:$version"
        const val kotlinStub = "io.grpc:grpc-kotlin-stub:1.2.1"
        const val springBootStarter = "io.github.lognet:grpc-spring-boot-starter:4.6.0"
        object netty {
            const val shaded = "io.grpc:grpc-netty-shaded:$version"
        }
    }

    object jackson {
        object module {
            const val version = "2.13.2"
            const val kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:$version"
        }
    }

    object postgres {
        const val version = "42.3.3"
        const val id = "org.postgresql:postgresql:$version"
    }

    object openTelemetry {
        const val version = "1.12.1"
        const val javaAgent = "io.opentelemetry.javaagent:opentelemetry-javaagent:$version"
    }
}
