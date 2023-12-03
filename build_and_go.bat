@echo off
@setlocal

call :entrypoint || call :onerror
exit /b

:onerror
echo Error[%ERRORLEVEL%]
exit /b

:entrypoint
    cls || exit /b !ERRORLEVEL!
    javac -d bin -sourcepath src ./src/jReversi.java -encoding UTF8  || exit /b !ERRORLEVEL!
    java -cp bin jReversi || exit /b !ERRORLEVEL!
exit /b

