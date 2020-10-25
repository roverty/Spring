#!/bin/bash
url="jdbc:h2:data/ordenes"
driver="org.h2.Driver"

echo "Iniciando DB"
java -cp h2*.jar org.h2.tools.Server