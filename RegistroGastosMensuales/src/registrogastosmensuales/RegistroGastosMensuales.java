/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package registrogastosmensuales;
import java.time.LocalDate; //Obtener fechas
import java.time.YearMonth; //Obtener cantidad de dias en el mes
import java.util.Scanner;
import java.util.ArrayList; 
/**
 *
 * @author Sarai Villalta
 */
public class RegistroGastosMensuales {

        public static double gastoTotal = 0,monto;
        public static int contGastos;
        public static ArrayList<String> descripciones = new ArrayList<>();
        public static ArrayList<Double> montos = new ArrayList<>();
        public static String descripcionGasto,opcion,opcion1;
        
        
        public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); //Objeto Scanner para entradas por teclado
     
        //Obtenemos la  fecha actual
        LocalDate fecha = LocalDate.now();
        int dia = fecha.getDayOfMonth(), mes = fecha.getMonthValue(), año = fecha.getYear(); //Obtenemos dia/mes/año
        
        //Obtenemos la cantidad de dias que tiene el mes actual
        YearMonth dias = YearMonth.of(año,mes);
        int diaMes = dias.lengthOfMonth();
        
        do{
            if (diaMes - dia != 0) //La condicion dejará de cumplirse cuando sea ultimo dia de mes, para comenzar un nuevo registro de otro mes
            {
                System.out.println("Registro Mensual de gastos");
                
                do{
                    System.out.println("\n\t" + dia + "/" + mes + "/" + año);
                    System.out.print("Ingrese la descripcion del gasto: ");
                    descripcionGasto = entrada.nextLine().trim();

                    if (descripcionGasto.isEmpty()) {
                        break;
                    }
                    descripciones.add(descripcionGasto); //Agregramos la descripcion al ArrayList

                    do {
                        System.out.print("Ingrese el monto: $");
                        monto = entrada.nextDouble();
                    } while (monto <= 0 );//Verificamos que no sea menor que 0 

                    montos.add(monto); //Agregramos el monto al ArrayList
                    entrada.nextLine(); // Consumir el salto de línea pendiente
                    
                    System.out.println("\n\n\n1.Ingresar nuevos gastos");
                    System.out.println("2. Verifiar gastos");
                    System.out.print("Seleccione su opcion: ");
                    opcion = entrada.nextLine();
                    if (opcion.equals("2")){
                        Limpiar();
                        Impresiones();
                        System.out.println("\n\n\n\n");}
                        }
                while (opcion.equals("1"));
            }else System.out.println("Fin de registro de gastos mensuales");
        
        }while (!(mes == 12 && dia == 31) || opcion.equals("1")); //La condicion dejará de cumplirse mientras no sea ultimo mes y ultimo dia del año
        
        entrada.close(); //Cierre de Scanner
    }
        
        //Métodos
        public static void Impresiones() {
        //Impresion de gastos 
            contGastos = descripciones.size();
            System.out.println("\n\n\n\nGastos Mensuales");
            System.out.println("Este mes tuvo " + contGastos + " gastos, detallados a continuacion:");
            for(int i =0 ; i<contGastos; i++)
            {
                gastoTotal += montos.get(i);
                System.out.println("\nDescipcion del gasto: " + descripciones.get(i));
                System.out.println("Monto: $" +  montos.get(i));
            }
            System.out.println("El total de sus gastos es de: $" + gastoTotal);
        }
        
        public static void Limpiar(){
        gastoTotal = 0;
        contGastos=0;
        }
        
       
}
       
