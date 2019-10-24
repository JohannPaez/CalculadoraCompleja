# Numeros-Complejos
 
 Este proyecto is una calculadora de numeros complejos, y sus operaciones básicas.
 
 ## Prerequisitos
 
 Conocimientos basicos sobre numeros complejos, vectores complejos y matrices complejas.
 
 - Numeros Complejos
     - Sumar
     - Restar 
     - Multiplicar
     - Dividir
     - Modulo
     - Conjugado
     - Representacion polar
     - Representacion cartesiana
     - Fase
 
 - Vectores Complejos
     - Producto por escalar
     - Inversa 
     - Sumar vectores
     
     
- Matrices Complejas
     - Sumar matrices
     - Inversa
     - Producto escalar
     - Transpuesta
     - Conjugada
     - Adjunta
     - Accion
     - Norma
     - Distancia entre matrices
     - Revisar si es unitaria
     - Revisar si es hermitian
     - Producto tensor
	 
 ## Simulación de lo clásico a lo cuántico
   - Los experimentos de la canicas con coeficiente booleanos
   - Experimentos de las múltiples rendijas clásico probabilístico, con más de dos rendijas.
   - Experimento de las múltiples rendijas cuántico.

## Intalación 
Si quieres saber como funciona el programa, tienes que seguir los siguientes pasos:
1. Descargar eclipse (última versión) o cualquier editor de JAVA.
2. Abra el proyecto en el editor.
3. Corra el programa y verifique que no tiene errores.
4. Ingrese los parámetros deseados que desea ver para visualizar las funcionalidades del sistema.

## Instalación (Proyecto Maven)
Para tener una mejor experiencia con el programa, es recomendable tener instalado maven en el sistema operativo,
de esta forma se puede visualizar de una mejor manera las pruebas y ejecutarlas desde consola.
Para instalar maven seguimos los siguientes pasos:
1. En eclipse vamos al menu que dice help.
2. Ahí le damos a install new software.
3. Nos abrirá una nueva pestaña, allí le damos donde aparece "add".
4. En "Name" escribimos lo siguiente: M2Eclipse
5. En "Location" escribimos la siguiente dirección: http://download.eclipse.org/technology/m2e/releases
6. Le damos Add, señalamos los plugins que aparecieron.
7. Aceptamos los terminos y condiciones, y se instalará automáticamente.
8. Reiniciamos eclipse y ya está instalado maven en eclipse.

## Pruebas
Para poder ejecutar sus pruebas siga los siguientes pasos:
1. Cambie los valores c1, c2, c3 y c4 por los valores deseados.
2. Elija la prueba que desea y cambie el resultado por el esperado.
3. Corra las pruebas y verifique que el resultado esperado es igual al valor dado por el programa.
## Ejemplo de prueba de simulacion de canicas
```
	Matriz pruebaCanicas = new Matriz(matrizCompleja);

	Complejo[] vectorAux = new Complejo[] { new Complejo(10, 0), new Complejo(4, 0), new Complejo(1, 0),
			new Complejo(7, 0), new Complejo(2, 0), new Complejo(2, 0), new Complejo(11, 0), new Complejo(0, 0),
			new Complejo(3, 0), new Complejo(1, 0), new Complejo(0, 0), new Complejo(5, 0), new Complejo(2, 0) };

	Vector vectorPrueba = new Vector(vectorAux);
	double[][] lista = new double[][] { { 0, 0 }, { 0, 0 }, { 1, 0 }, { 7, 0 }, { 2, 0 }, { 21, 0 }, { 5, 0 },
			{ 0, 0 }, { 4, 0 }, { 0, 0 }, { 3, 0 }, { 5, 0 }, { 0, 0 } };
	Vector res = pruebaCanicas.experimentoCanicas(25, pruebaCanicas, vectorPrueba);
	Vector esperado = new Vector(lista);
	assertTrue(res.equals(esperado));

```

## Ejemplos de uso
Habrá el proyecto en el editor de su preferencia:
1. Busque el directorio src\main\java\edu\eci\cnyt\calculadora.
2. Habrá la clase CalculadoraCompleja que es la clase principal.
3. En el constructor cree un nuevo número complejo(parte real, parte imaginaria).
4. Complejo n = new Complejo(3,4);
5. Complejo n2 = new Complejo(3,4);
6. Ejecute las operaciones deseadas
7. Complejo resultado = sumar(n, n2);

## Ejemplos de uso con maven
Para ello nos dirigimos a la carpeta principal del proyecto, dependiendo de lo que queramos hacer.

Si queremos compilar el proyecto y ver que no tiene fallos, utilizamos el comando **mvn package**.

Si queremos ejecutar las pruebas y ver que todo está perfecto, utilizamos el comando **mvn test**.

**NOTA:** El comando **mvn package** compilar y ejecuta las pruebas al mismo tiempo.

## Construido 
[Eclipse](https://www.eclipse.org/) Editor de JAVA donde se puede compilar el proyecto. 

## Autor
Johann Sebastian Páez Campos - Trabajo Programación

## Licencia
Este programa es de uso libre, puede ser usado por cualquier persona.

