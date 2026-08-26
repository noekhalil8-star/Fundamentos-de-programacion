Algoritmo CobroEstacionamiento
	Definir horas Como Entero
	Definir totalPagar Como Real
	
	Escribir "Ingrese la cantidad de horas:"
	Leer horas
	
	Si horas <= 0 Entonces
		Escribir "Cantidad de horas no válida."
	Sino
		Si horas > 10 Entonces
			totalPagar <- 380
		Sino
			Si horas <= 2 Entonces
				totalPagar <- horas * 30
			Sino
				Si horas <= 5 Entonces
					totalPagar <- (2 * 30) + ((horas - 2) * 25)
				Sino
					totalPagar <- (2 * 30) + (3 * 25) + ((horas - 5) * 20)
				FinSi
			FinSi
		FinSi
		
		Escribir "El cobro por el estacionamiento es: $", totalPagar
	FinSi
FinAlgoritmo
