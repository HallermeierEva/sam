# docs/13-architecture-principles.md
**Architecture Principles – Sam MVP**

## 1. Scope

Rules for keeping the codebase small, understandable, testable, and evolvable.

## 2. Core principles

Separation of concerns, dependency inversion, high cohesion, low coupling, testability, replaceable infrastructure, local-first defaults.

## 3. Layer model

UI, domain, data.

## 4. Module model

app, core modules, feature modules.

## 5. Dependency direction

Dependencies point inward toward stable abstractions.

## 6. Feature boundaries

Each module owns one user task or cohesive flow.

## 7. Shared code rules

Shared code must be genuinely reusable and not a junk drawer.

## 8. Interface-first design

Define interfaces at boundaries between layers and modules.

## 9. Dependency injection

Use DI to keep construction explicit and testable.

## 10. State ownership

Each piece of state has one clear owner.

## 11. Compose architecture

Stateless screens, ViewModel-driven state.

## 12. Business logic placement

Keep logic in domain use cases or services.

## 13. Testability rules

Design for unit, UI, integration, and mockable tests.

## 14. Expansion strategy

Add modules or interfaces rather than widening existing ones too early.
