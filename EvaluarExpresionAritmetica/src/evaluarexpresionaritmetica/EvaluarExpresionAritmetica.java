package evaluarexpresionaritmetica;

import java.util.Scanner;

/*
 * @Autor: Ulises Rivera Guillén
 */
public class EvaluarExpresionAritmetica {

    public static void main(String[] args) {
        //Declaramos el objeto Scanner
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Ingrese la expresión aritmetica (Usando espacios para separar elementos: ");
                String expresion = input.nextLine();

                Pila stack = new Pila(100);

                String[] tokens = expresion.split("\\s+");

                for (int i = 0; i < tokens.length; i++) {
                    String token = tokens[i];

                    if (esNumero(token)) {
                        stack.push(Double.parseDouble(token));
                    } else {
                        if (stack.size() < 2) {
                            System.out.println("ERROR: No hay suficientes operandos para el operador " + token);
                            continue;
                        }
                        double operando2 = stack.pop();
                        double operando1 = stack.pop();
                        double resultado = 0;

                        switch (token.charAt(0)) {
                            case '+':
                                resultado = operando1 + operando2;
                                break;

                            case '-':
                                resultado = operando1 - operando2;
                                break;

                            case '*':
                                resultado = operando1 * operando2;
                                break;

                            case '/':
                                if (operando2 == 0) {
                                    System.out.println("ERROR: No se puede dividir entre 0'");
                                    return;
                                }
                                resultado = operando1 / operando2;
                                break;
                            default:
                                System.out.println("Error: Operador no valido" + token);

                        }
                        stack.push(resultado);
                    }
                }

                if (stack.size() == 1) {
                    System.out.println("El resultado de la expresión RPN es: " + stack.pop());
                    break;
                } else {
                    System.out.println("ERROR: Ecuación no valida");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Ingreso valores invalidos");
            }
        }
        input.close();

    }

    private static boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
