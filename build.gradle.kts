plugins {
    kotlin("jvm") version "1.3.61"
    //id("com.github.spacialcircumstances.gradle-cucumber-reporting") version "0.1.15"
    id("de.javaansehz.cluecumber-report-gradle-plugin") version "1.1.4"
}

group = "de.viaboxx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
    testImplementation("io.cucumber", "cucumber-java","5.1.2")
    testImplementation("io.cucumber", "cucumber-junit", "5.1.2")
    testImplementation("io.cucumber", "cucumber-junit-platform-engine", "5.1.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:3.8.1")
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
    test {
        doLast{
            reportTask.run()
        }
    }

}

sourceSets {
    create("integrationTest") {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("src/integration-tests/kotlin")
            resources.srcDir("src/integration-tests/resources")
            compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
            runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
        }
    }
}


val reportTask= task<de.javaansehz.CluecumberReportTask>("report"){
    // ;
}


val integrationTest = task<Test>("selenium") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath
    shouldRunAfter("test")
    finalizedBy(reportTask)
}

configure<de.javaansehz.CluecumberReportExtension> {
    sourceJsonReportDirectory = buildDir.path + "/cucumber-report.json"
    generatedHtmlReportDirectory =  buildDir.path + "/cucumber-report"
    //expandBeforeAfterHooks=true
    expandStepHooks=true
    expandDocStrings=true
}



