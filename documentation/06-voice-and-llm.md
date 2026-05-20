# docs/06-voice-and-llm.md
**Voice & LLM – Sam MVP**

## 1. Scope

Speech input, speech output, and dialogue orchestration stack for Sam’s MVP. English and French from day one.

## 2. Voice input strategy

Use Android SpeechRecognizer, prefer on-device recognition when available, fallback to system recognition, then manual input.

## 3. Speech input lifecycle

Permission, availability, language selection, single-turn recognition, stop, pass to dialogue layer.

## 4. Speech output strategy

Use Android TextToSpeech with language and voice selection, and shutdown cleanly.

## 5. Language routing

Same configured language list drives recognition, prompts, and TTS.

## 6. Dialogue orchestration

Take transcript, detect session type, build prompt, call model, parse output into tasks and summary.

## 7. Prompt design

Localized prompt templates externalized from business logic.

## 8. Local model assumptions

Lightweight on-device model or offline-compatible inference engine.

## 9. Permissions and manifest

Microphone permission required; location only for commute detection.

## 10. Reliability and fallback rules

Recognition unavailable → manual input. TTS unavailable → text on screen.

## 11. Persona and voice tone

Sam speaks warm, neutral, concise.

## 12. MVP exclusions

No cloud STT/TTS, no hotword, no background recording.
