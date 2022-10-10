plugins {
    val kotlinVersion = "1.6.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.12.3"
}

group = "xyz.jxmm"
version = "0.1.1"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    maven("https://maven.aliyun.com/repository/google")
    mavenLocal()
    mavenCentral()
}
dependencies {
    implementation("com.google.code.gson:gson:2.9.1")
    implementation("org.json:json:20220924")
}
