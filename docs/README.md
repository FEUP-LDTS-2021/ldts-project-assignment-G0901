## LDTS_G0901 - <PROJECT NAME>

In this game you can drive a car, avoiding to hit against some obstacles, and controlling its speed.

This project was developed by André Barbosa (up202007398@edu.fe.up.pt), Guilherme Almeida and José Luís Rodrigues for LDTS 2021/22


### IMPLEMENTED FEATURES

- **Car Model** - A default car is shown.
- **Track Model** - A default track is shown.
- **Car Movement** - The car have 3 different positions to be on track, most-left, middle and most-right. 
- **Track Movement** - The track moves simulating the progression of the car at a default speed.
[TrackMovement] (https://github.com/FEUP-LDTS-2021/ldts-project-assignment-G0901/tree/feature/docs/docs/src/track_movement.gif)

### PLANNED FEATURES
- **Acceleration** - The track will move faster or slower according to users input.
- **Obstacles** - There will be random obstacles updated on track while the car is moving.


### DESIGN

#### GENERAL PATTERN ON THE PROGRAM

**Problem in Context**

We had to find a way of organising all the different classes on the program.

**The Pattern**

We have applied the **MVC** (Model-view-controller) pattern. This pattern allowed us to separate all classes in 3 different groups, one for each part of the project.

**Implementation**

We don't have UML representation yet.

**Consequences**

The use of the CMV Pattern in the current design allows the following benefits:

- Have a place of code containing only objects and informations about them(Model), that can be used for any other kind of program.
- Makes easier the Test Driven Development.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS


### TESTING


### SELF-EVALUATION

- André Barbosa: 10%
- José Luís Rodrigues: 45%
- Guilherme Almeida: 45%