# Compose Keyboard IME

This project is a prototype of an Android Keyboard Input Method Editor (IME) built using Jetpack Compose. It demonstrates how to host a Compose-based UI within the traditional Android `InputMethodService` architecture.

## Project Overview

- **Main Technology:** Android (Kotlin), Jetpack Compose
- **Key Libraries:** 
    - `androidx.compose` (UI framework)
    - `androidx.lifecycle` (lifecycle management in service)
    - `com.louiscad.splitties` (system services and view helpers)
- **Architecture:** 
    - The IME UI is implemented in `KeyboardScreen.kt` using Compose.
    - `ComposeKeyboardView.kt` acts as a bridge, extending `AbstractComposeView` to allow the keyboard UI to be used as a regular Android `View`.
    - `IMEService.kt` is the main service class, extending `LifecycleInputMethodService`. It handles the lifecycle of the IME and manages the connection to the target input field.
    - `LifecycleInputMethodService.kt` provides the necessary lifecycle events to make Compose and ViewModel work within a Service environment.

## Key Files

- `app/src/main/java/com/example/composeime/IMEService.kt`: The main entry point for the keyboard service.
- `app/src/main/java/com/example/composeime/KeyboardScreen.kt`: The Compose UI for the keyboard.
- `app/src/main/java/com/example/composeime/ComposeKeyboardView.kt`: Wraps the Compose UI into an Android View.
- `app/src/main/java/com/example/composeime/LifecycleInputMethodService.kt`: Base class for adding lifecycle support to `InputMethodService`.
- `app/src/main/java/com/example/composeime/MainActivity.kt`: A companion activity to enable the keyboard and select it in system settings.

## Building and Running

### Prerequisites
- Android SDK with API 36 (compileSdk)
- Gradle 9.3.1 (specified in the wrapper)

### Key Commands
- **Build the project:** `./gradlew assembleDebug`
- **Run tests:** `./gradlew test` (unit tests) or `./gradlew connectedCheck` (instrumented tests)
- **Clean the build:** `./gradlew clean`
- **Check code style:** `./gradlew lint` or `./gradlew check` (if configured)

## Development Conventions

- **Compose:** Use Jetpack Compose for all keyboard UI elements.
- **Service Lifecycle:** Always inherit from `LifecycleInputMethodService` if the IME service needs lifecycle awareness (e.g., for `rememberLauncherForActivityResult` or `ViewModel`).
- **Input Connection:** Use `currentInputConnection` from the `IMEService` to interact with the input field (committing text, deleting characters, etc.).
- **Styling:** Adhere to the `ComposeIMETheme` defined in `ui/Theme.kt`.

## Troubleshooting

- **Kotlin Options:** Ensure that `kotlinOptions` in `app/build.gradle` (if added) is placed correctly within the `android` block and uses the correct Gradle syntax for the current AGP version.
- **IME Lifecycle:** Be aware that IMEs have a unique lifecycle and are not traditional activities.
