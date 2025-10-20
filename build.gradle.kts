plugins {
    java
    id("com.gradleup.shadow") version "8.3.2"
}

repositories {
    mavenLocal()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://repo.maven.apache.org/maven2/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("com.github.SlimeFun-Lab:Slimefun4:3ea21da")

    implementation("com.github.SlimeFun-Lab:InfinityLib:d0cae07713")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("commons-lang:commons-lang:2.6")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
}

group = "io.github.seggan.slimefunwarfare"
version = "UNOFFICIAL"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.shadowJar {
    archiveClassifier = ""

    relocate("io.github.mooy1.infinitylib", "io.github.seggan.slimefunwarfare.infinitylib")
}
