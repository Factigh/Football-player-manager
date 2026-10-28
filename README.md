# Football Player Manager

A console-based Java application that manages football player records using a **custom doubly linked list** (kept in alphabetical order) and a **custom array-based stack**. Built as a term project for *Introduction to OOP* (2024-2025).

## Features

- Load players from a text file
- Add a new player manually (name, surname, birth date, clubs)
- Search and display a player by name and surname
- Remove a player by name and surname
- Print all players A-Z (head to tail) or Z-A (tail to head)
- Copy the list into a stack and print it in LIFO order
- Save the list to a file and exit

Players are always inserted in alphabetical order, by name first and then by surname (case-insensitive).

## Project Structure

```
.
├── players.txt              # Sample input data
├── src/player/
│   ├── Main.java            # Menu, file I/O, user interaction
│   ├── Player.java          # Player model (name, surname, birth date, clubs)
│   ├── Date.java            # Date class (from the textbook "Absolute Java")
│   ├── DoublyLinkedList.java# Sorted doubly linked list with inner Node class
│   └── Stack.java           # Fixed-capacity array-based stack
├── build.xml, nbproject/    # NetBeans / Ant project files
└── docs/                    # Project report
```

## Classes

| Class | Responsibility |
|-------|----------------|
| `Date` | Stores a birth date; validates month/day/year. |
| `Player` | Holds a player's data and provides `toString()`. |
| `DoublyLinkedList` | Sorted insertion (`insert`), removal (`delete`), `printAscending`, `printDescending`. |
| `Stack` | `push`, `pop`, `isEmpty` over an `Object[]` (capacity 100). |
| `Main` | 8-option menu, `loadFile`, `addPlayer`, `showPlayer`, `saveFile`. |

## Input File Format

One player per line, comma separated. The date is `day/month/year`; everything after it is a club.

```
Name,Surname,DD/MM/YYYY,Club1,Club2,...
```

Example:

```
Lionel,Messi,24/06/1987,Barcelona,PSG,Inter Miami
```

## Getting Started

**Requirements:** JDK 8 or newer (developed in Apache NetBeans).

**Option A: NetBeans**
1. `File > Open Project` and select this folder.
2. Make sure `players.txt` is in the project root (the working directory).
3. Press **Run**.

**Option B: Command line**
```bash
mkdir -p out
javac -d out src/player/*.java
java -cp out player.Main
```
Run the command from the folder that contains `players.txt`.

## Usage

```
1) Load players from file
2) Add new player
3) Search and display player
4) Remove player
5) Print A-Z
6) Print Z-A
7) Copy to stack and print
8) Save to file and exit
```

## Authors

- Hasan Can Yıldız
- Fatih Uzer

## Notes

- Option 1 reads `players.txt`; option 8 writes to `text.txt`.
- Invalid dates terminate the program (behaviour inherited from the textbook `Date` class).
