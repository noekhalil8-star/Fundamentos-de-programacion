Algoritmo telefonia
	Definir dia, turno Como Cadena
	Definir minutos, tarifa, costo Como Real
	Escribir '¿cual es la duracion de la llamada?'
	Leer minutos
	Si minutos<=5 Entonces
		tarifa <- (minutos*1)
	SiNo
		Si minutos<=8 Entonces
			tarifa <- 5+(minutos-5)*0.8
		SiNo
			Si minutos<=10 Entonces
				tarifa <- 7.4+(minutos-8)*0.7
			SiNo
				tarifa <- 8.8+((minutos-10)*0.5)
			FinSi
		FinSi
	FinSi
	Escribir '¿En que dia realizo la llamada?'
	Escribir 'Escriba h para dia habil y d para domingo'
	Leer dia
	Si dia='h' Entonces
		Escribir '¿En que horario se realizo la llamada?'
		Escribir 'Escriba m para matutino y v para vespertino'
		Leer turno
		Si turno='m' Entonces
			costo <- tarifa+(tarifa*.15)
		SiNo
			Si turno='v' Entonces
				costo <- tarifa+(tarifa*.10)
			SiNo
				Escribir 'opcion erronea'
			FinSi
		FinSi
	SiNo
		Si dia='d' Entonces
			costo <- tarifa+(tarifa*.03)
		SiNo
			Escribir 'opcion erronea'
		FinSi
	FinSi
	Escribir 'el costo total es de:', costo
FinAlgoritmo
