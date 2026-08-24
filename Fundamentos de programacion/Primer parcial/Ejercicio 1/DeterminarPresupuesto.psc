Algoritmo DeterminarPresupuesto
	Definir personas Como Entero
	Definir costo, total Como Real
	Escribir 'Ingrese la cantidad de personas para el evento:'
	Leer personas
	Si personas>=300 Entonces
		costo <- 75.00
	SiNo
		Si personas>=200 Entonces
			costo <- 85.00
		SiNo
			costo <- 95.00
		FinSi
	FinSi
	total <- personas*costo
	Escribir 'El costo por platillo es de: $', costo
	Escribir 'El presupuesto total para el evento es: $', total
FinAlgoritmo
