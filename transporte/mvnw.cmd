@echo off
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
  mvn %*
) else (
  echo Maven no esta instalado. Instala Maven o ejecuta el proyecto desde Visual Studio Code con Extension Pack for Java.
  exit /b 1
)
