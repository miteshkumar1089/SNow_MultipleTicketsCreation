@echo off
cd /d "C:\Users\miteshkumar\IdeaProjects\SNow_MultipleTicketsCreation"  
REM Change to your project folder
echo Running Selenium Tests...
call mvn clean test  
REM Runs Maven test cases safely
echo Selenium Tests Execution Completed!
pause  
REM Keeps the CMD open after execution
