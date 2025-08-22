# Gestión de Empleados: Asalariados y por Comisión

Este programa permite gestionar dos tipos de empleados en una empresa: **empleados asalariados** y **empleados por comisión**. El objetivo es calcular el valor a pagar a cada empleado, almacenar la información en archivos de texto y mostrar los resultados discriminados.

## Funcionalidades

1. **Ingreso de empleados**  
	El usuario puede ingresar la cantidad de empleados que desee para cada tipo (asalariado y por comisión).

2. **Empleados asalariados**  
	- Se solicita el sueldo fijo de cada empleado y se guarda en un arreglo.
	- Se adicionan subsidios de alimentación y transporte.
	- Se realizan descuentos de ley: parafiscales, salud y pensión (según porcentajes actualizados, ver [bibliografía](https://www.gerencie.com/porcentaje-de-salud-y-pension-de-empleado-y-empleador.html)).
	- El cálculo discriminado del sueldo se almacena en un archivo de texto específico para asalariados.

3. **Empleados por comisión**  
	- Se solicita el sueldo básico y el valor de ventas realizadas en el mes para cada empleado.
	- Se suma una comisión del 20% sobre el valor de las ventas.
	- El cálculo discriminado del sueldo se almacena en un archivo de texto específico para empleados por comisión.

4. **Visualización de resultados**  
	- El programa lee la información de los archivos generados y muestra en pantalla el sueldo total y el detalle de cada empleado.

## Ejecución

1. El usuario ingresa la cantidad de empleados por cada tipo.
2. Ingresa los datos requeridos por pantalla.
3. El programa realiza los cálculos y guarda los resultados discriminados en archivos de texto.
4. Finalmente, lee los archivos y muestra la información en pantalla.

## Bibliografía

- [Porcentaje de salud y pensión de empleado y empleador](https://www.gerencie.com/porcentaje-de-salud-y-pension-de-empleado-y-empleador.html)
