Algoritmo PresupuestoTarta
    Definir sabor, tipoChoco, respSnack, respNombre Como Caracter
    Definir numSnacks Como Entero
    Definir total Como Real
    
    total <- 0
    Escribir "Elija el sabor de la tarta (manzana, fresa, chocolate): "
    Leer sabor
    sabor <- Minusculas(sabor)
    
    Segun sabor Hacer
        "manzana":
            total <- 200
        "fresa":
            total <- 250
        "chocolate":
            Escribir "¿Chocolate negro o blanco?: "
            Leer tipoChoco
            tipoChoco <- Minusculas(tipoChoco)
            Si tipoChoco = "negro" Entonces
                total <- 280
            Sino
                total <- 300
            FinSi
        De Otro Modo:
            Escribir "Sabor no reconocido."
    FinSegun
    
    Si total > 0 Entonces
        Escribir "¿Desea añadir snacks? (S/N): "
        Leer respSnack
        Si Mayusculas(respSnack) = "S" Entonces
            Escribir "¿Cuántos snacks desea añadir?: "
            Leer numSnacks
            total <- total + (numSnacks * 25)
        FinSi
        
        Escribir "¿Desea personalizar con un nombre? (S/N): "
        Leer respNombre
        Si Mayusculas(respNombre) = "S" Entonces
            total <- total + 30
        FinSi
        
        Escribir "El precio total de la tarta es: $", total
    FinSi
FinAlgoritmo