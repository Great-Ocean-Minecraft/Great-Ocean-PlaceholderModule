import org.gradle.jvm.toolchain.JavaLanguageVersion.of

plugins {
	java
	kotlin("jvm") version "1.6.20"
	id("io.papermc.paperweight.userdev") version "1.3.5"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
	maven { url 'https://jitpack.io' }
}

val minecraftVersion = "1.18.2-R0.1-SNAPSHOT"

dependencies {
	implementation 'com.github.Great-Oceans:Great-Oceans-Core:main'
}

tasks {
	compileKotlin { kotlinOptions { jvmTarget = "17" } }
	reobfJar { outputJar.set(file(rootProject.projectDir.absolutePath + "/build/IonModule.jar")) }
	shadowJar { minimize() }
}

java.toolchain.languageVersion.set(of(17))