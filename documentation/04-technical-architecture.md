# docs/04-technical-architecture.md
**Technical Architecture – Sam MVP (Android, v0 + v1)**

## 1. Objectives

- Local-first.
- On-device LLM.
- Local TTS.
- Multilingual by design.
- Modular architecture.

## 2. Module overview

- ui
- voice
- nlp
- context
- domain
- data

## 3. UI layer

- Kotlin + Jetpack Compose recommended.
- Core screens: onboarding, main, settings, tasks.
- Responsive portrait/landscape layouts.

## 4. Multilingual architecture

- Configurable list of supported languages.
- Initial MVP list: English, Français.
- Strings and prompts externalized by language.

## 5. Voice I/O layer

- AudioRecorder.
- SpeechRecognizer.
- TextToSpeechEngine.

## 6. Conversation / LLM layer

- PromptProvider.
- ConversationManager.
- LocalLlmEngine.

## 7. Context layer

- CommuteDetector.
- DriveSessionManager.

## 8. Domain layer

- TaskManager.
- SessionManager.
- UserProfileManager.

## 9. Data layer

- Room database.
- DataStore for settings.

## 10. End-to-end flow examples

- Morning planning.
- Evening debrief.

## 11. Extensibility

- More languages.
- Cloud agents.
- News, email, Android Auto, iOS.
