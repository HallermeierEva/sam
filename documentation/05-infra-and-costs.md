# docs/05-infra-and-costs.md
**Infrastructure & Costs – Sam MVP (Android, local-first)**

## 1. Infrastructure principle

Sam MVP should run without any backend for core usage. Room is for structured local data, DataStore for small preferences.

## 2. Data storage split

- Room for tasks, sessions, user profile.
- DataStore for onboarding and preferences.

## 3. Suggested stack

- UI: Jetpack Compose.
- Local database: Room.
- Preferences: DataStore.
- Voice: Android speech and TTS APIs.
- Analytics: none for v0/v1.

## 4. Cost model

Near-zero infrastructure cost because no servers, APIs, or hosted databases are required.

## 5. Dependency strategy

Keep dependencies small and modular.

## 6. MVP deployment

Android app only; no server, admin dashboard, or cloud sync.

## 7. Future expansion

Optional cloud sync, backup, multi-device accounts, server-side AI orchestration.

## 8. Implementation notes

Use Room entities and DAOs for tasks and sessions. Use DataStore for settings and onboarding state.
