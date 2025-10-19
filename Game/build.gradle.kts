plugins {
    java
    application  // <-- add this
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// Tell Gradle which class contains main()
application {
    mainClass.set("org.example.Main")
}

// Optional: create a runnable jar with dependencies
tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}
