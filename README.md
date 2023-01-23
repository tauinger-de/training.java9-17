# Java Neuerung in den Versionen 9 - 17

## IDE Setup

### Eclipse

Dieses Projekt enthält (noch) Eclipse `.project` und `.classpath` Dateien. Damit lassen sich die
Projekte einfach in Eclipse öffnen. Ich empfehle die Nutzung von Eclipse 2022-12.

### Intellij

Zur Nutzung in Intellij:

1. das Verzeichnis als Projekt öffnen
2. über Rechtsklick auf das Projekt die "Module Settings" öffnen
3. auf das "+" für "Add Module" klicken
4. "Import Module"
5. das Projektverzeichnis wählen
6. dann "Import from external model" > "Eclipse"
7. weitere Dialoge bestätigen
8. abschließend Java 17 als SDK wählen

## Ausführung Ant Skripe in IDE

### Eclipse

Rechtsklick auf build.xml und "Run as" > "Ant Build".

### Intellij

Dies scheint tatsächlich etwas umständlich zu sein. Folgende Schritte sind auszuführen:

1. Rechtsklick auf die auszuführende `build.xml` Datei > "Add as Ant Build File"
2. Das Ant Tool Window sollte sichtbar werden
3. Selektion der build.xml Datei dort
4. Auf Properties Icon dort klicken und die Checkboxen von "Make Build in Background"
sowie "Collapse finished targets" deselektieren
5. Auf Play Icon klicken