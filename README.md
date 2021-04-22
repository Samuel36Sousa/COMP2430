# COMP-2430-WDE Final Project WINTER 2021
# Title: Battle Buddies!
## By Samuel Sousa and Jacob Lavoie
## Hatch Your Own Virtual Pet!

### ===== TABLE OF CONTENTS =====
1. Configuration Instructions
2. Installation Instructions
3. Operating Instructions
4. Manifest
5. Copyright Information
6. Bug List
7. Troubleshooting Tips and Help
8. Credits and Acknowledgements
### =============================


#### -----------------------------
1. Configuration Instructions
#### -----------------------------

The following instructions have been divided into 6 easy to follow steps

STEP 1 -> Download and install Android Studio ver 4.1.2 // Runtime ver 1.8.0_242-release-1644-b01 amd64
          Build # AI-201.8743.12.41.7042882 -- built on December 19, 2020
          The Virtual Machine running should be OpenJDK 64-Bit Server VM by JetBrains s.r.o // powered by open-source software
          Android Studio is distributed by JetBrains LTD and can be found under their web address jetbrains.com 

STEP 2 -> Configure the Virtual Machine to run on your current version of Windows
          This can be done by entering the system BIOS and enabling VM capabilities
          This step will be complete after a system restart

STEP 3 -> Create a new Kotlin project from within the Android Studio launcher and import the kt file into the current runtime
          This will allow the compiler to run the current build of Battle Buddies

STEP 4 -> Create a new instance of a Virtual Device for the code to properly run onto
          ( Preferably a modern build such as Google Pixel 3 or above )
	  This may take a moment to complete
	
STEP 5 -> Run the instance of the code within the VM build and wait for the OS to complete runtime configuration
	  One the app loads the VM will take over the runtime
					
STEP 6 -> Enjoy the game!
	  In order to exit simply click the little "X" button in the VM sub-menu
	  Or click the red stop button in the actual compiler

#### -----------------------------
2. Installation Instructions
#### -----------------------------

The following instructions have been divided into 5 easy to follow steps

STEP 1 -> Download all of the app files from this gitHub
		( See Section "4. Manifest" for complete list of all needed files )

STEP 2 -> Follow the first 4 steps from Section "1. Configuration Instructions" in order to set up the compiler and VM

STEP 3 -> Allocate the files into a readible directory for the compiler to locate in order to properly import
					
STEP 4 -> Add all neccessary files into the comipler / VM 

STEP 5 -> Run the VM in order to complete the runtime setup
		 ( See steps 5 and 6 in Section "1. Configuration Instructions" for basic VM controls )
					
#### -----------------------------
3. Operating Instructions
#### -----------------------------

SUB-SECTIONS
#### **********
1. MAIN SCREEN
2. FOOD CORNER
3. MINIGAME
#### **********

1. MAIN SCREEN -> 
   The opening screen of the app, the first thing the player sees.  
	 It is a welcoming sight set inside of a home with furniture sprawled about.  
	 There will be an egg which the player is incentivised to tap on in order to hatch their "Buddy".  
	 	- User activity by tapping the screen.  
	 After the egg is hatched, the "Buddy" will be able to partake in the events of feeding and playing.  
	 This screen acts as a main hub for the player to gaze upon their "Buddy" and take a pause every now and again.
	 
2. FOOD CORNER -> 
	 The following screen is the secondary function of the game, one of the two activities currently available to the player.  
	 The player is incentivised to level their "Buddy" by the process of feeding it a multitude of foods.  
	 	- User activity by tapping the screen, dragging food.  
	 After the "Buddy" has been fed, the player can choose to leave the screen or continue to feed the "Buddy".  
	 Feeding increases the happiness of your "Buddy" and is highly encouraged.
	 
3. MINIGAME -> 
   	 The following screen is the tertiary function of the game, the second of the two activities available to the player.  
	 This acts as an endurance test for the "Buddy" as the objective is to navigate through narrow openings.  
	 	- User activity by correctly timing tapping the screen.  
	 As the player successfully dodges the barriers, the score will increase as well as the speed of which the "Buddy" glides.  
	 Playing this minigame increases the overall gliding speed and agility of the "Buddy" and is also highly encouraged.  
	 
#### -----------------------------
4. Manifest -- List of all Neccessary Files for Operation
#### -----------------------------

LIST OF DIRECTORIES:

/apps/src/main/res/drawable/ -> Directory containing all custom images used in the project

FoodFragment.kt -> Kotlin code for the logic behind the Food fragment

fragment_food.xml -> xml code for the layout of the food fragment

GameFragment.kt -> Kotlin code for the logic behind the game fragment.  Includes a coroutine for the game logic such as moving the bird and the obstacles.  Also includes a class 		     called GamePet for creating objects that will fall, be able to flap, and collide with the onstacles.

fragment_game.xml -> xml code for the layout of the game fragment

HomeFragment.kt -> Kotlin code for the logic bahind the home fragment.  Initializes the global variable isEgg which tracks whether the pet is still in an egg.  Also includes the 		     code which allows the user to hatch the egg by tapping it.

fragment_home.xml -> xml code for the layout of the home fragment

MainActivity.kt -> Kotlin code for the logic behind the mainActivity.  The mainActivity method contains the 3 fragments for the other game screens and manages the interactions 	           between them.

activity_main.xml -> xml code for the layout of the mainActivity.  Contains the other three fragments used in the app.

#### -----------------------------
5. Copyright Information
#### -----------------------------

			CopyRight of Samuel Sousa and Jacob Lavoie -- "Battle Buddies" for android -- April 22, 2021
			
#### -----------------------------
6. Bug List
#### -----------------------------

Current number of known bugs: 2

1. Food Corner -> 
   - The current screen for the food corner is defunct for food selection, there is only one type of food to choose from and selecting it does nothing.
   
2. Minigame Bug ->
   - When the player is in the minigame, if the player loses, switches to the home screen, then hatches the egg again in that order,
     switching back to the minigame will result in a softlock where the game assumes the player has already lost and will become stuck
     in an infinite loop.

#### -----------------------------
7. Troubleshooting Tips and Help
#### -----------------------------

SUB-SELECTION

1. VM trouble -> 
	I. Loading -> 
		If the VM is not loading properly, simply delete the instance and create a new one, restart if nesseccary -- 
		
	II. Softlock -> 
		If the VM softlocks and runs in an unbreakable loop, delete the instance and create a new one -- 
		
	III. Gradle Error ->
		If the VM crashes on open, create a new instance and run from the new one
	
2. Compiler Error -> 
	I. IDE error -> 
		If the IDE experiences an error, reformat the code in a new project file -- 
		
	II. Missing imports -> 
		If for some treason the IDE is missing (an) import(s) simply hit ctrl + alt + enter and apply any changes -- 
		
	III. Syntax -> 
		If the code is missing syntax redownload the files from gitHub and create a new directory for stroing them, then run

#### -----------------------------
8. Credits and Acknowledgements
#### -----------------------------

PROJECT DIRECTORS: Samuel Sousa and Jacob Lavoie

COMPILER USED FOR CODE RUNTIME: Android Studio 4.1.2 // Distributed and Created by JetBrains LTD as of December 19, 2020

SOFTWARE USED FOR ARTWORK: Aseprite 1.2.16 // Distributed by Igara Studio // Created by David Capello and Gaspar Capello
	 

![Pet hatching](https://github.com/Samuel36Sousa/COMP2430/blob/96bcc3a3c4ce372056a1322da7629a238c1ded98/ReadMe%20media/Hatching.gif)

![Game being played](https://github.com/Samuel36Sousa/COMP2430/blob/a571e77b4aef7accdd90baf59a179a1d19c617c6/ReadMe%20media/Playing.gif)

![Food screen](https://github.com/Samuel36Sousa/COMP2430/blob/5e7c8f845f885e7c633b933808ece2e9dd3eba6e/ReadMe%20media/Feed.PNG)
