# LDTS_G0901 - Formula Zero

**Try to survive the longest on a fast paced circuit filled with dangerous obstacles.** 
The game has a series of tracks with increasing difficulty in which the player needs to avoid the coming cars to stay alive.

This project was developed in January 2022 by André Barbosa (up202007398@edu.fe.up.pt), [Guilherme Almeida](https://github.com/theguilhermealmeida) (up202008866@edu.fe.up.pt) and [José Luís Rodrigues](https://github.com/jlcrodrigues) (up202008462@edu.fe.up.pt) for LDTS 2021/22.

## Table of Contents
 * [Implemented Features](#implemented-features)
 * [Planned Features](#planned-features)
 * [Design](#design)
    * [Architecture](#architecture)
    * [State](#state)
    * [Factory](#factory)
    * [Template](#template)
    * [Music](#music)
 * [Code Smells and Refactors](#code-smells-and-refactors)
 * [Testing](#testing)
 * [Self Evaluation](#self-evaluation)

## Implemented Features

### Car Movement
 - The user can use the keys to move the car left and right between the availabe lanes. This way, the position of the car is limited to 3 places only.

<p align="center">
    <img width=450 src="src/car_movement.gif">
</p>


### Track Displaying 
 - The track is rendered using pseudo 3d graphics. We also simulate it's movement so it appears the player is moving foward.

<p align="center">
    <img width=450 src="src/track_movement.gif">
</p>

### Enemies generation
 - During gameplay, the user will approach different cars and needs to avoid them to stay alive. These enemies are randomly placed in the track.

<p align="center">
    <img width=450 src="src/enemies.gif">
</p>

### Score
 - The scoring system considers the number of enemies you avoid. For each avoided car you gain 10 points.

<p align="center">
    <img width=450 src="src/score.gif">
</p>
 
### Menu
 - When the application starts, a menu is prompted. This allows the user to navigate through different tabs.

<p align="center">
    <img width=450 src="src/menu.png">
</p>

### Track Selection
 - Tracks are stored in .txt files. This way, it's really easy to add new tracks, which allows a faster expansion of the game. To choose between the different tracks, a menu is displayed before the game starts.

<p align="center">
    <img width=450 src="src/track_selection.gif">
</p>

## Planned Features

### High score
 - Store scores in files so they can be displayed in-game later in order to make the game more challenging.

### Turns
 - Tracks will have different turns so the game is more unpredictable. We can even simulate the curvature in real world tracks.


## Design

### Architecture

#### Problem in Context

To complete the game, we need to define it's data structures, display this data and be able to controll it according to user action.

#### The Pattern

To solve this problem, we separated the program into Model, View, and Controller, as the **MVC** pattern suggests. This allows us to separate each concern into its own class.

#### Implementation

 <p align="center">
    <img width=450 src="src/mvc_design.png">
</p>

#### Consequences

* Facilitates Test Driven Development.
* Accelerates the program development.
* Separate different parts of the code into different objects.

### State

#### Problem in Context

The games needs to iterate through the different menu tabs and the game itself. Before the game starts, the track selection is prompted and after the game is over it changes to a different Game Over tab.
This way, we need a way to manage which image is being displayed and how the game can behave accordingly.

<p align="center">
    <img width=450 src="src/states_design.png">
</p>

#### The Pattern

The **State** pattern allows us to separate the state specific behaviour into different classes. This way, the main Application has a reference to the current state but doesn't have to worry about each state's implementation.

#### Implementation

<p align="center">
    <img width=450 src="src/states_uml.png">
</p>

#### Consequences

 * Easily add new states without changing the existing ones.
 * No need for flags or conditionals with numerous branches.
 * Allows a strict separations of specific code into different classes.

### Factory

#### Problem in Context

#### The Pattern

#### Implementation

#### Consequences

### Template

#### Problem in Context

#### The Pattern

#### Implementation

#### Consequences

### Music

#### Problem in context

To make the game more fun and interesting we wanted to add music. Our idea was to add a theme soundtrack in the Menu tab and a more fast paced music when racing. To accomplish this we add to think of a simple way to play the right music according to the state we're in.

#### The pattern

With the **Observer** pattern it's possible for the subject to notify all the observers whenever something important happens, in our case when the application's state changes. A subject can also 'cut relations' with a subject to stop receiving notifications at all, although we do not make use of this functionality. <br />
We ended up making use of only the observer Music.

#### Implementation

<p align="center">
    <img width=450 src="src/observer_uml.png">
</p>

#### Consequences

* Facilitates adding new musics to the other states.
* Makes sure that no other class has to deal with music related code.
* It's possible to add/remove observers if we need to.

## Code Smells and Refactors

### Bloaters

#### Long Parameter List

Some methods in our code base have a long list of parameters. We can see this in [View.drawSprite()](../src/main/java/game/view/View.java) and [View.drawMenu()](../src/main/java/game/view/View.java). It happens here because of the different displaying options these methods are trying to provide.  
A way to solve this problem would be to replace some of these parameters with an object. For instance, creating a custom Sprite class would help mitigate the problem as the information used to draw a sprite could be grouped there. Another way to improve would be replacing some of the parameters with a method call. A case in point is the screen parameter that could be replaced by a call to the gui.

### Object-Orientation Abusers

#### Switch Statements

After the Controller receives an action from View it needs to decide what to do for all the different action types. This results in long switch statements in places like [MenuController.step()](../src/main/java/game/control/menu/MenuController.java) or [GUI.getAction()](../src/main/java/game/gui/GUI.java). This way, every time we add a condition all the switch statement code has to be modified.

## Testing

### Coverage

<p align="center">
    <img width=450 src="src/coverage.png">
</p>

<p align="center">
   <a href="reports/coverage/index.html">Coverage Report</a>
</p>

### Mutation Testing

<p align="center">
   <img width=450 src="src/pitest.png">
</p>
<p align="center">
   <a href="reports/pitest/index.html">Pitest Mutation Report</a>
</p>

## Self Evaluation

- André Barbosa: 10%
- José Luís Rodrigues: 45%
- Guilherme Almeida: 45%
