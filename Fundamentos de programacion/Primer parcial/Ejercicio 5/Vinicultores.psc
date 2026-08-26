Algoritmo Vinicultores
	Definir precioInicial, kilos, precioFinal, ganancia Como Real
	Definir tipo Como Cadena
	Definir tamano Como Entero
	
	Escribir "Ingrese el precio inicial por kilo ($):"
	Leer precioInicial
	Escribir "Ingrese la cantidad de kilos:"
	Leer kilos
	Escribir "Ingrese el tipo de uva (A o B):"
	Leer tipo
	Escribir "Ingrese el tamaño de uva (1 o 2):"
	Leer tamano
	
	tipo <- Mayusculas(tipo)
	precioFinal <- precioInicial
	
	Si tipo = "A" Entonces
		Si tamano = 1 Entonces
			precioFinal <- precioInicial + 0.20
		Sino
			Si tamano = 2 Entonces
				precioFinal <- precioInicial + 0.30
			FinSi
		FinSi
	Sino
		Si tipo = "B" Entonces
			Si tamano = 1 Entonces
				precioFinal <- precioInicial - 0.30
			Sino
				Si tamano = 2 Entonces
					precioFinal <- precioInicial - 0.50
				FinSi
			FinSi
		FinSi
	FinSi
	
	ganancia <- kilos * precioFinal
	
	Escribir "El precio final por kilo es: $", precioFinal
	Escribir "La ganancia total del embarque es: $", ganancia
FinAlgoritmo