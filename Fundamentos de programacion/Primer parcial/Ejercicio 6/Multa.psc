Algoritmo MultaVelocidad
	Definir velocidad, resultado, limite1, limite2 Como Entero
	Definir esCumpleanos Como Logico
	Definir respuestaCumple Como Cadena
	
	Escribir "Ingrese la velocidad:"
	Leer velocidad
	Escribir "¿Es tu cumpleaños? (si/no):"
	Leer respuestaCumple
	
	Si Mayusculas(respuestaCumple) = "SI" Entonces
		esCumpleanos <- Verdadero
	Sino
		esCumpleanos <- Falso
	FinSi
	
	Si esCumpleanos Entonces
		limite1 <- 65
		limite2 <- 85
	Sino
		limite1 <- 60
		limite2 <- 80
	FinSi
	
	Si velocidad <= limite1 Entonces
		resultado <- 0
	Sino
		Si velocidad <= limite2 Entonces
			resultado <- 1
		Sino
			resultado <- 2
		FinSi
	FinSi
	
	Escribir "Resultado de la multa: ", resultado
FinAlgoritmo