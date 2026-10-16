# library-management-java

Console application in Java for managing a library, built as an object-oriented programming and
UML design assignment.

## What it does

- Manage books, users and loans from a text menu (`src/main.java`).
- Two user types: `Utilisateur` and `UtilisateurPremium` (inheritance).
- Core classes: `Livre`, `Utilisateur`, `UtilisateurPremium`, `Emprunt`, `Bibliotheque`.
- Business scenarios modelled in the UML diagrams: borrowing a book, returning late, managing penalties.

## UML design

`docs/uml/` contains the class diagram and sequence/activity diagrams produced during the design phase.

## Run

Requires a JDK (11+).

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out main
```
