@echo off

REM url de conexion: 
SET url=jdbc:h2:data/bookmule
REM Driver:
SET driver=org.h2.Driver

ECHO "iniciando h2"
ECHO "url: %url%"
ECHO "driver: %driver%"

java -cp h2-1.4.187.jar org.h2.tools.Server
