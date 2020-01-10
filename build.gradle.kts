plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.spacialcircumstances.gradle-cucumber-reporting") version "0.1.15"
}

group = "de.viaboxx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
    testImplementation("io.cucumber", "cucumber-java","5.0.0-RC4")
    testImplementation("io.cucumber", "cucumber-junit", "5.0.0-RC4")
    testImplementation("io.cucumber", "cucumber-junit-platform-engine", "5.0.0-RC4")
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

configure<com.github.spacialcircumstances.gradle.ReportsPluginExtension> {      // JN -> The old groovy way also works   "cucumberReports {  "
    outputDir = file("build/")
    buildId = "0"
    reports = files("build/cucumber/cucumber-report.json")
}

