# TT-Combat-Emulator
A command-line combat emulator inspired by tabletop rpgs. Implemented with the help of ChatGPT for the CSC207 AI-assisted project.

This project was developed using Java 11, specifically the Amazon Corretto 11 JDK. Testing was done using JUnit.

This combat emulator allows the user to simulate classic tabletop rpg combat between multiple characters. 
A dice system and a spellcasting system has been implemented as additional features on top of the basic combat functionality. Damage has been randomized, and relies on hidden dice rolls based on
the "xdy" system, where y is the size of a die and x is the number of times to roll that die. The damage dealt is the sum of those rolls.

User stories:
Primary User story: The user wants to use this tabletop rpg battle emulator as an aid for a game campaign they are running. They want to place a predetermined set of characters in the scenario.
When the battle starts, initiative should be rolled for each character and turn order should be determined using a descending ranking of initiative.
At the beginning of each turn, key information about the battle scenario is given. This key information includes the names of living characters, their health, the round number
and the name of the character whose turn it currently is.

The user can control the actions of each character on the character’s turn using typed commands: “attack” + the target character’s name to attack that target,
“spellbook” to display their available spells(at which point they can type the name of a spell and a target to cast the spell at the target),
or “skip” to skip the current character’s turn.If the user types “exit”, the battle ends.


Second User Story: The user wants to generate their own characters for the battle before it starts. They are given the option to do so before the battle, or start a battle with default characters.
If they choose to do so, they are lead through a few prompts that have them input the required information to create a character. They can choose the character's race(e.g. Orc or Human, which determines their stats), 
archetype(e.g. Paladin or Druid, giving them access to archetype spells), name and level. They can make as many characters as they want.*

* The character creation is implemented using an abstract factory, and the entire system follows Clean Architecture and SOLID principles, so more classes and archetypes can be added.
* In the future, the same system can allow the creation of custom characters as well.

CA Violations: While most of the program was designed in such a way as to follow the CA hierarchy, some domain
objects(such as the spell and character classes, communicate information to(but not from) the terminal directly. This unfortunately had to be the case as moving said communication through
multiple layers would have either introduced dependencies that would have violated the dependency inversion principle, 
or introduced enough additional classes and logic to go beyond the ability of chatGPT to accurately remember.
