import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("com.flexport.oteldemo.kotlin-library-conventions")
    id(Plugins.protobuf.id)
}

dependencies {
    implementation(Libs.protobuf.kotlin)
    implementation(Libs.grpc.protobuf)
    implementation(Libs.grpc.stub)
    implementation(Libs.grpc.kotlinStub)
}

protobuf {
    protoc {
        artifact = Plugins.protobuf.protoc.id
    }
    plugins {
        id("grpc") {
            artifact = Plugins.protobuf.protoc.gen.grpc
        }
        id("grpckt") {
            artifact = Plugins.protobuf.protoc.gen.grpcKt
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach { task ->
            task.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}

sourceSets {
    main {
        java {
            setSrcDirs(
                listOf(
                    "build/generated/source/proto/main/grpc",
                    "build/generated/source/proto/main/java",
                    "build/generated/source/proto/main/grpckt"
                )
            )
        }
    }
}
