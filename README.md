When running

```shell
./gradlew test
```

a ` java.lang.InstantiationError at Mockk832.kt:33` should occur.

Changing `build.gradle` to

```groovy
kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}
```

solves the issue.

To keep java 17, one needs to downgrade to Kotlin 1.6.x
