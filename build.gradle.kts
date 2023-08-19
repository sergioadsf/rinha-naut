plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.10"
    id("io.micronaut.test-resources") version "3.7.10"
}

version = "0.1"
group = "br.com.rinha"

val kotlinVersion = project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {

    //criteria
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    //redis
    implementation("io.micronaut.redis:micronaut-redis-lettuce")

    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")

    //flyway
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    runtimeOnly("org.postgresql:postgresql")

    //kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    //r2dbc
    implementation("io.micronaut.data:micronaut-data-r2dbc")
    runtimeOnly("org.postgresql:r2dbc-postgresql")

    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-r2dbc
//    implementation("org.springframework.data:spring-data-r2dbc:3.0.3")

//    api("org.springframework.data:spring-data-r2dbc")
    //postgres
//    runtimeOnly("io.r2dbc:r2dbc-postgresql")
    runtimeOnly("io.r2dbc:r2dbc-pool")
    testResourcesService("org.postgresql:postgresql")
}


application {
    mainClass.set("br.com.rinha.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("kotest5")
    processing {
        incremental(true)
        annotations("br.com.rinha.*")
    }
    testResources {
        additionalModules.add("r2dbc-postgresql")
    }
}



