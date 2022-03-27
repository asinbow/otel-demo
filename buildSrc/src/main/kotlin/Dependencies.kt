
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
}

object Libs {
    object spring {
        object boot {
            object starter {
                const val version = "2.6.5"
                const val starter = "org.springframework.boot:spring-boot-starter:$version"
                const val web = "org.springframework.boot:spring-boot-starter-web:$version"
                const val test = "org.springframework.boot:spring-boot-starter-test:$version"
            }
        }
    }

    object protobuf {
        const val kotlin = "com.google.protobuf:protobuf-kotlin:3.20.0-rc-1"
    }

    object grpc {
        const val protobuf = "io.grpc:grpc-protobuf:1.45.0"
        const val stub = "io.grpc:grpc-stub:1.45.0"
        const val kotlinStub = "io.grpc:grpc-kotlin-stub:1.2.1"
    }

    object jackson {
        object module {
            const val kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2"
        }
    }
}
