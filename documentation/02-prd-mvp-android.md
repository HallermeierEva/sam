# docs/02-prd-mvp-android.md
**PRD – MVP Android**

## 1. Scope

Ce PRD couvre le MVP Android téléphone, en deux étapes : v0 prototype local manuel, puis v1 MVP commute avec détection simple domicile ↔ travail. Le tout reste sans backend, sans cloud, et avec UI multilangue dès le départ.

## 2. Objectifs MVP

### 2.1 v0
- Permettre à l’utilisateur de lancer une session manuellement.
- Lui faire vivre une expérience vocale simple et utile.
- Extraire des tâches et les stocker en local.

### 2.2 v1
- Détecter automatiquement les trajets matin/soir.
- Proposer une conversation utile au bon moment.
- Gérer planning du matin et débrief du soir.
- Rester entièrement local.

## 3. Langues

### 3.1 UI
- English
- Français

### 3.2 Conversation
- La langue choisie pilote les prompts, la voix, les scripts et les réponses système.

### 3.3 Language picker
- Le sélecteur doit être basé sur une liste configurable.
- Au lancement, cette liste contient seulement English et Français.

## 4. v0 – Prototype manuel

### 4.1 Fonctionnalités
- L’utilisateur ouvre l’app.
- Il choisit la langue.
- Il choisit Sam.
- Il démarre une session manuelle.
- Sam l’aide à structurer une liste de tâches ou un court débrief.
- Les tâches sont sauvegardées localement.

### 4.2 Écrans v0
- Splash.
- Language picker.
- Persona picker.
- Permission micro.
- Home screen simple.
- Tasks screen simple.

### 4.3 Exclusions v0
- Pas de détection de trajet.
- Pas de proactivité.
- Pas de backend.
- Pas d’emails.
- Pas de news.

## 5. v1 – Commute MVP

### 5.1 Fonctionnalités
- Détection simple du commute matin/soir.
- Une proposition vocale par trajet.
- Planning le matin.
- Débrief le soir.
- Sauvegarde locale des tâches.

### 5.2 Comportement attendu
- Une seule proposition par trajet.
- Si refus ou silence, plus aucune relance.
- Le système respecte la langue choisie par l’utilisateur pour toute la session.

### 5.3 Exclusions v1
- Pas de cloud.
- Pas d’emails.
- Pas de news.
- Pas d’Android Auto.
- Pas d’iOS.

## 6. Onboarding

1. Choix de la langue via liste.
2. Choix de la persona.
3. Permissions micro.
4. Permissions localisation pour v1.
5. Définition home/work optionnelle.
6. Activation/désactivation de la proactivité.

## 7. UI responsiveness

- Support portrait et landscape.
- Layouts adaptatifs.
- Pas de pixels fixes pour les composants critiques.
- Les écrans restent lisibles sur petits et grands téléphones.

## 8. Acceptance criteria

- L’utilisateur peut choisir English ou Français.
- La langue UI et la langue conversation suivent ce choix.
- Les écrans restent propres en portrait et landscape.
- Le produit reste simple, fluide et sans backend.
