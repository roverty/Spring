Para iniciar el servidor de base de datos

```
./start.sh
```

Para configurar la base de datos por primera vez (si no se quiere que se cree la base en la carpeta que asigne por defecto)

```
java -cp h2-*.jar org.h2.tools.Shell
```

* Seguir la guía de configuraciones que proporciona el editor
* El el URL, recordar escribir `jdbc:h2:` seguido de la ruta donde se desea guardar el archivo de la base de datos