# Massive Motion Star System Simulation

## Overview
This project implements a Java-based simulation of a star system, featuring dynamically animated celestial bodies (stars and comets) on a two-dimensional canvas. The simulation is built for academic demonstration of polymorphism, encapsulation, custom data structures, and object-oriented design principles. The project may fulfill the requirements set by CS 245 - Project 2, Fall 2025.

- **Technologies:** Java, Swing (AWT), Custom List Implementations
- **Main Features:** Animation of star and comets
- **Key Concepts:** Polymorphism, Data Structures (ArrayList, LinkedList, DoublyLinkedList, DummyHeadLinkedList)
- **Configurable:** Uses a property file (`MassiveMotion.txt`) for simulation parameters

## Directory Structure
```
project/
├── MassiveMotion.java            # Main simulation logic and GUI
├── SpaceObject.java              # Abstract class for celestial bodies
├── Star.java                     # Star class, extends SpaceObject
├── Comet.java                    # Comet class, extends SpaceObject
├── utils/                        # Custom list implementations
│   ├── ArrayList.java
│   ├── LinkedList.java
│   ├── DoublyLinkedList.java
│   ├── DummyHeadLinkedList.java
│   └── List.java                 # List interface
├── ArrayListCheck.java           # Test/check for ArrayList
├── DoublylinkedListCheck.java    # Test/check for DoublyLinkedList
├── Helper.java                   # Utility functions
├── MassiveMotion.txt             # Property file for configuration
├── WhyThisOverThat.txt / whyThisOverThat.txt # Implementation and design justifications
└── README.md                     # Project documentation
```

## Getting Started
### Prerequisites
- Java 8 or higher installed
- IDE (IntelliJ IDEA, VS Code, CLion, or similar Java IDE)
 
### Compilation & Execution
1. **Clone the Repository**
2. **Configure Properties:** Edit `MassiveMotion.txt` as needed to set simulation parameters (window size, body velocities, star position, list type, etc).
3. **Compile Java Code:**
    ```bash
    javac MassiveMotion.java
    ```
4. **Run Simulation:**
    ```bash
    java MassiveMotion MassiveMotion.txt
    ```
    The simulation window will appear as specified in the config file.

## Configuration
Properties are defined in `MassiveMotion.txt`. Example:
```
timer_delay = 75
list = arraylist
window_size_x = 1024
window_size_y = 768
gen_x = 0.06
gen_y = 0.06
body_size = 10
body_velocity = 3
star_position_x = 512
star_position_y = 384
star_size = 30
star_velocity_x = 0
star_velocity_y = 0
```
- **timer_delay:** milliseconds between canvas updates
- **list:** Which List implementation to use (`arraylist`, `single`, `double`, `dummyhead`)
- **canvas size:** `window_size_x`, `window_size_y`
- **star and body properties:** position, velocity, size, etc

## Custom List Implementations
All List types conform to the `List` interface found in `utils/List.java`:
- **ArrayList:** Dynamic resizing array
- **LinkedList:** Singly linked list
- **DoublyLinkedList:** Doubly linked list
- **DummyHeadLinkedList:** Linked list with dummy head node

Justification for design choices available in `WhyThisOverThat.txt`.

## Code Structure & Major Classes
- **MassiveMotion.java:** Entry point; loads config, initializes GUI and simulation.
- **SpaceObject.java:** Abstract class for all celestial bodies. Defines position, velocity, drawing logic.
- **Star.java and Comet.java:** Extend SpaceObject, customize movement and properties.
- **utils/**: List implementations, each providing add, remove, get, and size methods as required by the project.
- **Helper.java:** Contains utility/support functions where needed.

## How Correctness Was Determined
- Visual verification of animation & object creation/removal
- Unit tests (see *_Check.java files) confirming correctness of List operations
- Console output for debugging and verification

## Efficiency & Performance
- **ArrayList** grows geometrically (x1.5 or x2) for fewer resizes and better performance when many objects are present.
- **System.arraycopy** and **Arrays.copyOf** ensure rapid insertions and clarity.
- List removals are optimized based on underlying structure.
- Probability-based object spawning keeps computation light.

## Object-Oriented Design Principles
- Encapsulation: Each class manages its own data and behavior
- Inheritance: Star and Comet extend SpaceObject
- Polymorphism: SpaceObject references can point to Star or Comet, unified in the List
- Decomposition: GUI, simulation logic, and data structures split into focused classes

## Extensibility
- Gravity and collision logic can be added by extending SpaceObject and MassiveMotion
- Additional celestial body types are easy to add via subclasses

## Comments & Documentation
- All public methods use Javadoc comments per project requirements
- Non-obvious logic is documented with inline comments
- Rationale and design decisions included (see `WhyThisOverThat.txt`)

## Author
- Code by Student: Rudraraj
- Developed for CS 245, University of San Francisco, Fall 2025

## References
- Project PDF: See full requirements, config, and rubric
- YouTube Tutorials: How to create a Java animation/canvas
