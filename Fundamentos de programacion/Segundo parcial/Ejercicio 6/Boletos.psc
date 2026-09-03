Algoritmo BoletosCine
    Definir personas, dia, parejas, individuales Como Entero
    Definir membresia Como Caracter
    Definir total Como Real
    
    Escribir "Ingrese el número de personas: "
    Leer personas
    Escribir "Seleccione día (1:Lunes, 2:Martes, 3:Miércoles, 4:Jueves, 5:Viernes, 6:Sábado, 7:Domingo): "
    Leer dia
    Escribir "¿Tiene membresía? (S/N): "
    Leer membresia
    
    total <- 0
    
    Segun dia Hacer
        3: // Miércoles (promoción)
            total <- personas * 30
        4: // Jueves (parejas)
            parejas <- trunc(personas / 2)
            individuales <- personas % 2
            total <- (parejas * 75) + (individuales * 50)
        De Otro Modo: // Precio base
            total <- personas * 50
    FinSegun
    
    Si Mayusculas(membresia) = "S" Entonces
        total <- total * 0.90
    FinSi
    
    Escribir "El total a pagar es: $", total
FinAlgoritmo