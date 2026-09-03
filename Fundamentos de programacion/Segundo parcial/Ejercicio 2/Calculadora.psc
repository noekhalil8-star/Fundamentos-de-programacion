Algoritmo CalculadoraBasica
    Definir num1, num2 Como Entero
    Definir op Como Caracter
    
    Escribir "Ingrese el primer número entero: "
    Leer num1
    Escribir "Ingrese el segundo número entero: "
    Leer num2
    Escribir "Ingrese la operación (+, -, *, /): "
    Leer op
    
    Segun op Hacer
        "+":
            Escribir "Resultado: ", (num1 + num2)
        "-":
            Escribir "Resultado: ", (num1 - num2)
        "*":
            Escribir "Resultado: ", (num1 * num2)
        "/":
            Si num2 <> 0 Entonces
                Escribir "Resultado: ", (num1 / num2)
            Sino
                Escribir "Error: División por cero no permitida."
            FinSi
        De Otro Modo:
            Escribir "Operador no válido."
    FinSegun
FinAlgoritmo