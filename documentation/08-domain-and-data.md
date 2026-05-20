# docs/08-domain-and-data.md
**Domain & Data – Sam MVP**

## 1. Scope

Store, transform, and expose app data while keeping business rules separate from persistence and UI.

## 2. Domain principles

Domain owns meaning of user actions.

## 3. Main domain objects

Task, Session, UserProfile, CommuteContext, ConversationResult.

## 4. Room data model

tables: tasks, sessions, user_profile.

## 5. DAO responsibilities

Insert, query, update, delete for tasks, sessions, profile.

## 6. DataStore responsibilities

Onboarding completed, selected language, persona, proactivity flag.

## 7. State flow

UI emits event → ViewModel → domain use case → repository → storage → ViewModel → Compose.

## 8. Repository layer

TaskRepository, SessionRepository, UserProfileRepository, SettingsRepository.

## 9. Use cases

CreateTasksFromConversation, ClosePlanningSession, UpdateLanguagePreference.

## 10. Mapping rules

Convert model output to tasks, then to Room entities.

## 11. Migration strategy

Version Room schema carefully; define migration paths.

## 12. Compose integration

Compose consumes ViewModel state, not storage directly.
