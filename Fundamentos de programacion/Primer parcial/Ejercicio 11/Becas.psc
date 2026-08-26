Algoritmo BecasEstudiantiles
	Definir edad Como Entero
	Definir promedio Como Real
	
	Escribir "Ingrese la edad del estudiante:"
	Leer edad
	Escribir "Ingrese el promedio del estudiante:"
	Leer promedio
	
	Si edad > 18 Entonces
		Si promedio >= 9.0 Entonces
			Escribir "Beca asignada: $10,000.00"
		Sino
			Si promedio >= 7.5 Entonces
				Escribir "Beca asignada: $8,000.00"
			Sino
				Si promedio >= 6.0 Entonces
					Escribir "Beca asignada: $5,000.00"
				Sino
					Escribir "Se enviará carta de invitación para estudiar más."
				FinSi
			FinSi
		FinSi
	Sino
		// Edad <= 18 años
		Si promedio >= 9.0 Entonces
			Escribir "Beca asignada: $8,000.00"
		Sino
			Si promedio >= 8.0 Entonces
				Escribir "Beca asignada: $6,000.00"
			Sino
				Si promedio >= 6.0 Entonces
					Escribir "Beca asignada: $4,000.00"
				Sino
					Escribir "Se enviará carta de invitación para estudiar más."
				FinSi
			FinSi
		FinSi
	FinSi
FinAlgoritmo
