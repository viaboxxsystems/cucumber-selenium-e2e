plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.5.2")
    testImplementation("junit", "junit", "4.12")
    //testImplementation("io.github.bonigarcia:selenium-jupiter:3.3.2")
    testImplementation("io.cucumber", "cucumber-java","5.0.0-RC2")
    testImplementation("io.cucumber", "cucumber-junit", "5.0.0-RC2")
    testImplementation("io.cucumber", "cucumber-junit-platform-engine", "5.0.0-RC2")
    testImplementation("io.github.bonigarcia:webdrivermanager:3.7.1")
    testImplementation("com.fasterxml.jackson.core", "jackson-databind", "2.10.0")
    testImplementation("org.seleniumhq.selenium", "selenium-java", "3.141.59")
    testImplementation("org.seleniumhq.selenium", "selenium-support", "3.141.59")
}


tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "12"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "12"
    }

}


tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

