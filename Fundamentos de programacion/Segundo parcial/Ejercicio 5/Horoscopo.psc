Algoritmo Horoscopo
    Definir dia, mes Como Entero
    Escribir "Ingrese día de nacimiento: "
    Leer dia
    Escribir "Ingrese número de mes de nacimiento (1-12): "
    Leer mes
    
    Segun mes Hacer
        1:
            Si dia <= 19 Entonces 
				Escribir "Capricornio" 
				
			Sino Escribir "Acuario"
		FinSi
		2:
			Si dia <= 18 Entonces
				Escribir "Acuario" 
				
			Sino Escribir "Piscis" 
		FinSi
		3:
		    Si dia <= 20 Entonces 
				Escribir "Piscis" 
				
			Sino Escribir "Aries" 
		FinSi
		4:
			Si dia <= 19 Entonces 
				Escribir "Aries" 
			Sino Escribir "Tauro" 
		FinSi
		5:
			Si dia <= 20 Entonces
				Escribir "Tauro"
				
			Sino Escribir "Géminis" 
		FinSi
		6:
		    Si dia <= 20 Entonces
				Escribir "Géminis"
				
			Sino Escribir "Cáncer" 
		FinSi
		7:
			Si dia <= 22 Entonces
				Escribir "Cáncer" 
				
			Sino Escribir "Leo" 
		FinSi
		8:
			Si dia <= 22 Entonces 
				Escribir "Leo" 
				
			Sino Escribir "Virgo" 
		FinSi
		9:
			Si dia <= 22 Entonces 
				Escribir "Virgo" 
				
			Sino Escribir "Libra"
		FinSi
		10:
			Si dia <= 22 Entonces 
				Escribir "Libra" 
				
			SiNo
				Escribir "Escorpio"
		FinSi
		11:
		    Si dia <= 21 Entonces 
				Escribir "Escorpio" 
				
			Sino Escribir "Sagitario"
		FinSi
		12:
			Si dia <= 21 Entonces 
				Escribir "Sagitario" 
				
			Sino Escribir "Capricornio" 
		FinSi
		De Otro Modo:
			Escribir "Mes inválido."
	FinSegun
FinAlgoritmo