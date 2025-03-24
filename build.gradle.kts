import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    id("com.vexillum.plugincore.plugin") version "0.0.5"
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

group = "com.example"
version = "0.0.1"

val jvmTarget = "17"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0-RC2")
    // Testing
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

pluginCore {
    projectName = "ExamplePlugin"
    apiVersion = "1.19"
    pluginCoreVersion = "0.1.5"
    spigotVersion = "1.21.4-R0.1-SNAPSHOT"
    publish {
        gitHub {
            publish = true
            githubURL = "https://github.com/vexillum-studio/plugin-template"
        }
        local {
            publish = false
        }
    }
}

detekt {
    autoCorrect = true
    buildUponDefaultConfig = true
    config = files("$projectDir/detekt.yml")
    source = files("src/main/kotlin", "src/test/kotlin")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = jvmTarget
}
