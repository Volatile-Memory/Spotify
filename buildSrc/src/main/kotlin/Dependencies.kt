import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
        const val CORE = "androidx.core:core-ktx:${Versions.AndroidX.CORE}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.Compose.ACTIVITY_COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.Compose.CORE}"
        const val UI = "androidx.compose.ui:ui:${Versions.Compose.CORE}"
        const val UI_TEST_JUNIT4 = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.CORE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.Compose.CORE}"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.CORE}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Versions.Google.MATERIAL}"
    }

    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    }

    object Test {
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        }

        object Integration {
            const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT_INTEGRATION}"
        }
    }

    fun DependencyHandlerScope.common() {
        "implementation"(AndroidX.CORE)
        "implementation"(Google.MATERIAL)
        "implementation"(Kotlin.STDLIB)
        commonIntegrationTest()
        compose()
    }

    private fun DependencyHandlerScope.commonIntegrationTest() {
        "androidTestImplementation"(Test.Integration.ESPRESSO_CORE)
        "androidTestImplementation"(Test.Integration.JUNIT)
    }

    private fun DependencyHandlerScope.compose() {
        "implementation"(Compose.ACTIVITY_COMPOSE)
        "implementation"(Compose.MATERIAL)
        "implementation"(Compose.UI)
        composeTest()
        composeTooling()
    }

    private fun DependencyHandlerScope.composeTest() {
        "androidTestImplementation"(Compose.UI_TEST_JUNIT4)
    }

    private fun DependencyHandlerScope.composeTooling() {
        "debugImplementation"(Compose.UI_TOOLING)
        "implementation"(Compose.UI_TOOLING_PREVIEW)
    }
}
