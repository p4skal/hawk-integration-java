plugins {
    id("org.springframework.boot") version "2.6.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    `maven-publish`
    id("com.google.cloud.artifactregistry.gradle-plugin") version "2.1.1"
}

group = "org.datausagetracing.integration"
version = "1.0.0"

repositories {
    maven {
        setUrl("artifactregistry://europe-west3-maven.pkg.dev/cnpe-blue/data-usage-tracing-maven")
    }
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.springframework.boot:spring-boot-starter-webflux")
    implementation(project(":data-usage-tracing-integration-java-common"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

publishing {
    repositories {
        maven {
            setUrl("artifactregistry://europe-west3-maven.pkg.dev/cnpe-blue/data-usage-tracing-maven")
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}