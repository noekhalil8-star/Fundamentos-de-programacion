Algoritmo Ventas
	Definir N, i Como Entero
	Definir venta Como Real
	Definir respuesta Como Cadena
	Definir Mayor1000, Entre500y1000, Menor500 Como Entero
	Definir CantEntre500y1000, CantMayor1000, CantMenor500, Total Como Entero
	CantMayor1000 <- 0
	CantEntre500y1000 <- 0
	CantMenor500 <- 0
	Mayor1000 <- 0
	Entre500y1000 <- 0
	Menor500 <- 0
	Total <- 0
	Escribir 'desea registrar una venta? (S/N):'
	Leer respuesta
	Mientras Mayusculas(respuesta)='S' Hacer
		Escribir 'Ingrese el monto de la venta:'
		Leer venta
		Total <- Total+venta
		Si venta>1000 Entonces
			CantMayor1000 <- CantMayor1000+1
			Mayor1000 <- Mayor1000+venta
		SiNo
			Si venta>500 Y venta<=1000 Entonces
				CantEntre500y1000 <- CantEntre500y1000+1
				Entre500y1000 <- Entre500y1000+venta
			SiNo
				Si Venta <= 500 Entonces
					Menor500 <- Menor500+venta
					CantMenor500 <- CantMenor500+1
				FinSi
			FinSi
		FinSi
		Escribir 'Desea registrar otra venta? (S/N):'
		Leer respuesta
	FinMientras
	Escribir '1.- Ventas mayores a $1000:'
	Escribir '  - Cantidad: ', CantMayor1000
	Escribir '2.- Ventas de entre $500 y $1000:'
	Escribir '  - Cantidad: ', CantEntre500y1000
	Escribir '3.- Ventas menores a $500:'
	Escribir '  - Cantidad: ', CantMenor500
	Escribir '  - Monto acumulado: $', Total
FinAlgoritmo
