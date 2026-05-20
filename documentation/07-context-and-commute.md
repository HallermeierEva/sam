# docs/07-context-and-commute.md
**Context & Commute – Sam MVP**

## 1. Scope

Detect commute context and decide when to offer a proactive voice session. Focus on simple morning/evening commute detection.

## 2. Context model

IDLE, MORNING_COMMUTE, EVENING_COMMUTE, MANUAL_SESSION, UNKNOWN.

## 3. Detection strategy

Combine location-based and time-based signals; optional movement hint.

## 4. Home and work setup

Optional during onboarding or later in settings. Store home/work coordinates locally.

## 5. Geofence behavior

Use enter and exit transitions only, with a stable radius.

## 6. Time gating

Geofence transitions alone should not fire prompts; check time/day too.

## 7. Prompt policy

One prompt per commute; silence means do not re-ask.

## 8. Context state machine

IDLE → POSSIBLE_COMMUTE → PROMPT_SHOWN → ACTIVE_SESSION → SESSION_COMPLETED → RETURN_TO_IDLE.

## 9. Permissions and privacy

Location only for commute detection, continue in reduced mode if denied.

## 10. Fallback behavior

Full commute detection, then time-only suggestion, then manual only.
