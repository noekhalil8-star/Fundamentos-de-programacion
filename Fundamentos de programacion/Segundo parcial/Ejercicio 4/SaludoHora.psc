Algoritmo SaludoHora
    Definir hora Como Entero
    Escribir "Ingrese la hora actual (0 a 23): "
    Leer hora
    
    Si hora >= 0 Y hora <= 23 Entonces
        Segun hora Hacer
            6, 7, 8, 9, 10, 11, 12:
                Escribir "Buenos días"
            13, 14, 15, 16, 17, 18, 19, 20:
                Escribir "Buenas tardes"
            De Otro Modo:
                Escribir "Buenas noches"
        FinSegun
    Sino
        Escribir "Hora fuera del rango de 0 a 23."
    FinSi
FinAlgoritmo
