
@echo off
setlocal
cd /d "%~dp0"

echo ========================================
echo   FoodShare - Supabase PostgreSQL
echo   Maven-free launcher
echo ========================================
echo.

REM Check environment variables first
if not defined SUPABASE_JDBC_URL (
    echo ERROR: SUPABASE_JDBC_URL is not set.
    goto :error
)
if not defined SUPABASE_DB_USER (
    echo ERROR: SUPABASE_DB_USER is not set.
    goto :error
)
if not defined SUPABASE_DB_PASSWORD (
    echo ERROR: SUPABASE_DB_PASSWORD is not set.
    goto :error
)

REM Check Java compiler and runtime
where javac >nul 2>nul
if errorlevel 1 (
    echo ERROR: JDK not found. Install a JDK and configure PATH.
    goto :error
)

where java >nul 2>nul
if errorlevel 1 (
    echo ERROR: Java runtime not found. Configure PATH.
    goto :error
)

REM Check source directory
if not exist "src" (
    echo ERROR: src folder not found.
    goto :error
)

REM Prepare JDBC driver
if not exist "lib" mkdir "lib"

if not exist "lib\postgresql-42.7.5.jar" (
    echo Downloading PostgreSQL JDBC driver...
    powershell -NoProfile -ExecutionPolicy Bypass -Command "try { Invoke-WebRequest -UseBasicParsing 'https://repo.maven.apache.org/maven2/org/postgresql/postgresql/42.7.5/postgresql-42.7.5.jar' -OutFile 'lib\postgresql-42.7.5.jar' } catch { Write-Error $_; exit 1 }"
    if errorlevel 1 (
        echo ERROR: JDBC driver download failed.
        goto :error
    )
)

REM Collect Java source files
if exist "sources.txt" del "sources.txt"
dir /s /b "src\*.java" > "sources.txt"

for %%A in (sources.txt) do if %%~zA EQU 0 (
    echo ERROR: No Java source files found in src.
    goto :error
)

REM Remove old compiled classes
if exist "out" rmdir /s /q "out"
mkdir "out"

echo.
echo Compiling Java files...
javac --release 11 -encoding UTF-8 -cp "lib\postgresql-42.7.5.jar" -d out @sources.txt

if errorlevel 1 (
    echo ERROR: Compilation failed. Check the errors above.
    goto :error
)

del "sources.txt"

echo.
echo Starting FoodShare...
echo.

java -cp "out;resources;lib\postgresql-42.7.5.jar" com.foodshare.Main

if errorlevel 1 (
    echo.
    echo Application exited with an error.
    pause
    exit /b 1
)

exit /b 0

:error
if exist "sources.txt" del "sources.txt"
echo.
pause
exit /b 1
