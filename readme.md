# Desktop Trains
## Short overview of the code and idea
### The idea was to create a simple 2D game where the player can hop between rails to avoid obstacles, collect various items and unlock new trains, maps.
### Current functionality:
- Multiple moving backgrounds
- Responsive user-controlled locomotive with smooth animations
- Randomly generated obstacles (no collisions)
- Increasing game speed every 10 seconds, up to a limit
### Planned functionality:
- Everything else (a lot)
### File/code description:
- Main.java - Creates GameFrame, sets various properties
- GameFrame.java - Sets up the GamePanel and starts a thread
- GamePanel.java - Main class for loading pre-requisites and various animation, creation, conversion methods
- GameLoop.java - Continuously running and updating game loop, timing related logic
- InputReader.java - Event listeners for key inputs
- Locomotive.java - Class for creating different locomotives with various attributes
- Obstacle.java - Class for creating different obstacles
- GeneratedObstacle.java - Creates a list of obstacles with randomly generated position
### Issues/questions/things to be improved
- Should sort and structure the methods better, some may be misplaced or unnecessarily long
- Should convert most numeric values to variables for further use in gameplay
- File structure could be improved
- Functionality. Needs more.
### Used libraries/software
- Java libraries: Swing, Awt, IO, ImageIO
- IDE: IntelliJ IDEA
- Other: pixilart.com, chat.openai.com, Adobe Photoshop
- JDK 18.0.2
### Conclusions
Took me an eternity to grasp the concept of Java Swing and working with visual objects. I think I've built a decent base for this idea and will definitely work on it more in my free time. Tried to use as much of my knowledge of Java as I can, alongside a little bit of artistic skills. Could always start this kind of work earlier.
All graphics are made by myself.
Rainers Strads IT1