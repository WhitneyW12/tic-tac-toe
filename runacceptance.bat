cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;C:\RobotFramework\swinglibrary-1.9.4.jar;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..