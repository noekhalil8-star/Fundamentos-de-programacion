Algoritmo AhorroMes
	Definir mes Como Entero
	Definir deposito, Total Como Real
	Total <- 0
	Para mes<-1 Hasta 12 Con Paso 1 Hacer
		Escribir 'Ingrese la cantidad depositada en el mes ', mes, ':'
		Leer deposito
		Total <- Total+deposito
		Escribir 'El ahorro acumulado al final del mes ', mes, ' es: $', Total
		Escribir ''
	FinPara
	Escribir 'El ahorro total al final del año es: $', Total
FinAlgoritmo
