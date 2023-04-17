package calculadora;

import java.util.Scanner;

public class Calculadora {
    private double resultado; // Me almacena resultado de las operaciones
    private boolean continuar; // variable para saber si el usuario quiere continuar o no
    
    /**
     * Contrusctor de la clase. Inicializa el resultado en cero y establece continuar en verdadero.
    */
    public Calculadora() { // constructor de la clase 
        resultado = 0; // inicializamos el resultado en cero
        continuar = true; // inicializamos continuar el booleano en verdadero para inicar el ciclo
    }

    /**
        * Suma. el número dado al resultado actual.
    */
    public void sumar(double numero) {
        resultado += numero; 
    }
    
       /**
        * Resta. el número dado al resultado actual.
       */
    public void restar(double numero) {
        resultado -= numero;
    }
    
        /**
            * Multiplicacion. el número dado al resultado actual.
        */
    public void multiplicar(double numero) {
        resultado *= numero;
    }

        /**
            * Divide. el resultado actual por el número dado.
            * Si el número es cero, muestra un mensaje de error.
        */
    public void dividir(double numero) {
        if (numero == 0) { // no se puede dividir por cero
            System.out.println("No se puede dividir por cero.");
        } else {
            resultado /= numero;
        }
    }
    
        /**
            * Calcula el porcentaje del resultado actual con el número dado.
            * Si el número es cero, muestra un mensaje de error .
        */
    public void porcentaje(double numero) { 
        if (numero == 0) { // no se puede dividir por cero
            System.out.println("No se puede dividir por cero.");
        } else {
            resultado %= numero;
        }
    }

        /**
            * Obtiene el resultado actual.
        */
    public double getResultado() {
        return resultado;
    }

    /**
        * Continuar.
    */
    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }
    
    /**
        * Obtiene el valor de continuar.
    */
    public boolean getContinuar() {
        return continuar;
    }

    /**
        * Método principal que se ejecuta al iniciar el programa.
        * Permite al usuario ingresar números y operaciones a través de la consola.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//capturar las variables del usuario
        Calculadora calculadora = new Calculadora(); // creamos una instancia de la clase Calculadora

        System.out.println("Introduce un número:");
        calculadora.resultado = scanner.nextDouble(); // inicializamos el resultado con el primer número

        while (calculadora.continuar) { // mientras continuar sea verdadero
            System.out.println("Introduce la operación (+, -, *, /, %):");
            String operacion = scanner.next();

            System.out.println("Introduce el siguiente número:");
            double numero = scanner.nextDouble();

            switch (operacion) { // dependiendo de la operación seleccionada, llamamos al método correspondiente
                case "+":
                    calculadora.sumar(numero);
                    break;
                case "-":
                    calculadora.restar(numero);
                    break;
                case "*":
                    calculadora.multiplicar(numero);
                    break;
                case "/":
                    calculadora.dividir(numero);
                    break;
                case "%":
                    calculadora.porcentaje(numero);
                    break;
                default:
                    System.out.println("Operación no válida.");
                    calculadora.continuar = false;
            }

            if (calculadora.continuar) { // si el usuario quiere continuar, mostramos el resultado y preguntamos si desea seguir
                System.out.println("Resultado: " + calculadora.getResultado());
                System.out.println("¿Desea continuar? (s/n)");
                calculadora.setContinuar(scanner.next().equalsIgnoreCase("s"));
            }
        }

    }
}