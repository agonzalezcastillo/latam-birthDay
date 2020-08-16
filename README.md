# API servicio Cumpleaños

Servicio Cumpleaños requiere [JAVA](https://www.java.com/ES/download/) v8+ para ejecutarse.

1.- Clonar Proyecto en carpeta de su preferencia
```sh
$ git clone https://github.com/agonzalezcastillo/latam-birthDay.git
```

2.- Acceder a la carpeta, construir aplicación e iniciar servidor
```sh
$ cd /carpeta
$ gradlew build 
$ gradlew bootRun
```

3.- Verificar correcto funcionamiento del Servicio
```sh
[POST] localhost:8080/birthday
```
Payload: ejemplo de json de consulta
```sh
{
    "name": "alejandro isaias gonzalez castillo",
    "birthDay" : "16-08-1990"
}
```
el sistema deberia retornar un JSON con la siguiente estructura
```sh
{
    "name": "alejandro gonzalez",
    "age": 30,
    "daysToBirthday": 0,
    "poem": "Poema Random"
}
```



