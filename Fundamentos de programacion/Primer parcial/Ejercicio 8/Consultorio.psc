Algoritmo ConsultorioMedico
	Definir numeroCita Como Entero
	Definir costoCita, montoTotal Como Real
	
	Escribir "Ingrese el número de cita:"
	Leer numeroCita
	
	Si numeroCita <= 0 Entonces
		Escribir "Número de cita no válido."
	Sino
		// Calcular el costo de la cita actual
		Si numeroCita <= 3 Entonces
			costoCita <- 900
		Sino
			Si numeroCita <= 5 Entonces
				costoCita <- 800
			Sino
				Si numeroCita <= 8 Entonces
					costoCita <- 600
				Sino
					costoCita <- 500
				FinSi
			FinSi
		FinSi
		
		// Calcular el monto total acumulado abonado por el tratamiento
		Si numeroCita <= 3 Entonces
			montoTotal <- numeroCita * 900
		Sino
			Si numeroCita <= 5 Entonces
				montoTotal <- (3 * 900) + ((numeroCita - 3) * 800)
			Sino
				Si numeroCita <= 8 Entonces
					montoTotal <- (3 * 900) + (2 * 800) + ((numeroCita - 5) * 600)
				Sino
					montoTotal <- (3 * 900) + (2 * 800) + (3 * 600) + ((numeroCita - 8) * 500)
				FinSi
			FinSi
		FinSi
		
		Escribir "Costo de esta cita (#", numeroCita, "): $", costoCita
		Escribir "Monto total pagado hasta esta cita: $", montoTotal
	FinSi
FinAlgoritmo
