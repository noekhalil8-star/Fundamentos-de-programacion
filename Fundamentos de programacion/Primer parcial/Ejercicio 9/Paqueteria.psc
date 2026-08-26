Algoritmo Paqueteria
	Definir pesoKg, pesoGramos, costoGramo, totalPagar Como Real
	Definir zona Como Entero
	
	Escribir "Ingrese el peso del paquete en kg:"
	Leer pesoKg
	
	Si pesoKg > 5 o pesoKg <= 0 Entonces
		Escribir "Entrega rechazada: El paquete excede el límite de 5 kg o es un peso inválido."
	Sino
		Escribir "Seleccione la zona de destino:"
		Escribir "1. América del Norte"
		Escribir "2. América Central"
		Escribir "3. América del Sur"
		Escribir "4. Europa"
		Escribir "5. Asia"
		Leer zona
		
		pesoGramos <- pesoKg * 1000
		costoGramo <- 0
		
		Segun zona Hacer
			1: costoGramo <- 11
			2: costoGramo <- 10
			3: costoGramo <- 12
			4: costoGramo <- 25
			5: costoGramo <- 30
			De Otro Modo:
				Escribir "Zona no válida."
		FinSegun
		
		Si costoGramo > 0 Entonces
			totalPagar <- pesoGramos * costoGramo
			Escribir "Cobro total por entrega: $", totalPagar
		FinSi
	FinSi
FinAlgoritmo
