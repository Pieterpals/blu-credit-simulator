@echo off
setlocal

set APP_DIR=%~dp0..
set JAR_FILE=%APP_DIR%\target\blu-credit-simulator.jar

if not exist "%JAR_FILE%" (
    echo Error: Application JAR not found! Run 'mvn clean package' first.
    pause
    exit /b 1
)

java -jar "%JAR_FILE%" %*

echo.
echo Press any key to exit...
pause >nul
