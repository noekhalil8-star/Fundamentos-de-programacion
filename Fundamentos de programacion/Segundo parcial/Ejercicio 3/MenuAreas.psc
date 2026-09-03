Algoritmo MenuAreas
    Definir opcion Como Entero
    Definir lado, base, altura, radio, area Como Real
    
    Escribir "--- MENÚ DE ÁREAS ---"
    Escribir "1. Cuadrado"
    Escribir "2. Rectángulo"
    Escribir "3. Triángulo"
    Escribir "4. Círculo"
    Escribir "Elija una opción: "
    Leer opcion
    
    Segun opcion Hacer
        1:
            Escribir "Ingrese el lado del cuadrado: "
            Leer lado
            area <- lado * lado
            Escribir "Área del cuadrado: ", area
        2:
            Escribir "Ingrese la base: "
            Leer base
            Escribir "Ingrese la altura: "
            Leer altura
            area <- base * altura
            Escribir "Área del rectángulo: ", area
        3:
            Escribir "Ingrese la base: "
            Leer base
            Escribir "Ingrese la altura: "
            Leer altura
            area <- (base * altura) / 2
            Escribir "Área del triángulo: ", area
        4:
            Escribir "Ingrese el radio: "
            Leer radio
            area <- PI * (radio ^ 2)
            Escribir "Área del círculo: ", area
        De Otro Modo:
            Escribir "Opción inválida."
    FinSegun
FinAlgoritmo