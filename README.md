Training: Persistence
===================

El ejemplo muestra las notas para un usuario identificado con un **nickname**.
Al ingresar un nuevo usuario, se modifica el saludo de la app. Actualmente, se muestra un listado de notas default.

Se necesita persistir información de la app, para esto:
- Se deberá almacenar en SQLite las notas asociadas a una persona (según el **nickname**).
- Cuando se modifique el nick, se deberán mostrar las notas asociadas a dicho nuevo usuario, si es que existen.
- Al abrir la aplicación se deberá mostrar el saludo precargado con el último nick ingresado.
