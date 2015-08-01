#!/bin/bash
#url de conexion: 
url="jdbc:h2:data/bookmule"
#Driver:
driver="org.h2.Driver"

echo "iniciando h2"
echo "url: $url"
echo "driver: $driver"

java -cp h2*.jar org.h2.tools.Server
