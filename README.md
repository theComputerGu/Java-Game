# Java-Game
A classic Arkanoid-style game built in Java. The game features multiple levels, score tracking, and end screens for both "Game Over" and "You Win" scenarios.

## Features
- **Multiple Levels:** Play through levels with unique layouts and increasing difficulty.
- **Score Tracking:** Track your score throughout the game, displayed at the end.
- **End Screens:** Clear all levels to see a "You Win" screen with your final score, or a "Game Over" screen if you lose.
- **Pause Functionality:** Pause the game anytime by pressing the P key.
## Gameplay

### First Level - ![Screenshot 2024-10-31 162713](https://github.com/user-attachments/assets/21792f3f-a571-4a0b-9fbd-52a0300fdce0)

### Second Level - ![Screenshot 2024-10-31 162730](https://github.com/user-attachments/assets/f7513579-124c-40d8-acd5-9b21aa3909cc)

### Third Level - ![Screenshot 2024-10-31 162823](https://github.com/user-attachments/assets/43ab1aef-4974-459f-87da-7acfb379599d)

### You Win Screen - ![Screenshot 2024-10-31 163215](https://github.com/user-attachments/assets/82c680c4-c154-470a-a29b-6c44826d1657)

### You Lose Screen - ![Screenshot 2024-10-31 162833](https://github.com/user-attachments/assets/4585bcb3-2622-43d0-9afd-9fc85333ee3f)

### You Pause Screen - ![Screenshot 2024-10-31 162848](https://github.com/user-attachments/assets/62ddf464-2deb-4dcc-af97-771fa4504269)


## How to Run
Running the Game with Default Levels
To start the game with the default three levels, run:

```sh
java -jar ArkanoidGame.jar
```
Running the Game with Specific Levels
Specify levels by providing the level numbers as arguments:

```sh
java -jar ArkanoidGame.jar 1 3 2
```
This command runs the game with levels 1, 3, and 2 in that order. Invalid level numbers will be ignored.

Run only level 3:
```sh
java -jar ArkanoidGame.jar 3
```

Run levels 1, 2, and 3:

```sh
java -jar ArkanoidGame.jar 1 2 3
```

## Game Controls
- **Left Arrow Key:** Move the paddle to the left.
- **Right Arrow Key:** Move the paddle to the right.
- **Space Key:** Start or continue the level.
- **P Key:** Pause the game.
- **Q Key:** Quit the game.
## code Structure
- **Ass6Game:** Main class that runs the game. Handles command line arguments and initializes levels.
- **GameLevel:** Manages the setup and execution of individual levels.
- **KeyPressStoppableAnimation:** Decorator class for key press events, stopping animations for pause, game over, and win screens.
