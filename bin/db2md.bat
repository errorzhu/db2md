@echo off
for /r "%~dp0..\" %%f in (*.jar) do (
  java -jar "%%f" %*
)