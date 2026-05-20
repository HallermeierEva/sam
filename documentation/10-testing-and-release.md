# docs/10-testing-and-release.md
**Testing & Release – Sam MVP**

## 1. Scope

Testing, validation, and release for a reliable driving-use MVP.

## 2. Test strategy

Unit, repository, UI, integration, instrumentation.

## 3. What to test

Onboarding, languages, persona, permissions, sessions, persistence, commute prompts.

## 4. Unit tests

Pure logic, prompt selection, state transitions, notification eligibility.

## 5. Repository tests

Room and DataStore behavior, migrations.

## 6. Compose UI tests

Onboarding, language picker, settings, tasks, fallback UI.

## 7. Voice and flow tests

Adapters and fakes for speech and TTS.

## 8. WorkManager tests

Constraint simulation and delayed work.

## 9. Instrumentation tests

Full onboarding, permissions, local database, notifications.

## 10. Test data

Deterministic fixtures for prompts, transcripts, tasks, contexts.

## 11. Release process

Run tests, build release, verify on device, ship only after critical flows pass.
