package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcionMenu;
        do {
        Scanner leerDato= new Scanner(System.in); // nuevo scanner
         // esta será la opcion del menú
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("Taller de vacaciones de java");
            System.out.println("1. Interes simple");
            System.out.println("2. Conversor de moneda");
            System.out.println("3. Calculo del IMC");
            System.out.println("4. Registro de temperatura");
            System.out.println("5. Contador de dias");
            System.out.println("6. Calculadora de gastos de viaje");
            System.out.println("7. Conversion de temperatura");
            System.out.println("8. Salir");
            System.out.print("ingrese la opcion deseada: ");
            // que diferencia hay si uso int variable = Integer.valueOf(scanner.nextLine());
            opcionMenu=leerDato.nextInt();
            switch (opcionMenu){
                case 1:
                    System.out.println("Programa de interes simple");
                    System.out.print("ingrese el capital inicial: ");
                    double capitalInicial=leerDato.nextDouble();
                    System.out.print("ingrese la tasa de interes: ");
                    double tasaInteresAnual=leerDato.nextDouble();
                    System.out.print("ingrese la cantidad de años: ");
                    int numeroAnos=leerDato.nextInt();
                    tasaInteresAnual/=100.0;
                    System.out.println("El interes simple es de: "+capitalInicial*tasaInteresAnual*numeroAnos);
                    break;
                case 2:
                    int opcionCase2;
                    System.out.println("conversor de moneda:");
                    System.out.println("Ingrese 1 para convertir de COP a USD");
                    System.out.println("Ingrese 2 para convertir de USD a COP");
                    opcionCase2=leerDato.nextInt();
                    if (opcionCase2==1){
                        System.out.print("ingrese el monto en COP a convertir: ");
                        double montoCop=leerDato.nextDouble();
                        System.out.println("la cantidad en dolares es de: "+ convertirCopUsd(montoCop));
                        break;

                    } else if (opcionCase2==2) {
                        System.out.print("ingrese el monto en USD a convertir: ");
                        double montoUsd=leerDato.nextDouble();
                        System.out.println("la cantidad en pesos es de: "+ convertirUsdCop(montoUsd));
                        break;
                    }else{
                        System.out.println("ingrese una opcion valida");
                    }

                    break;
                case 3:
                    System.out.print("ingrese su peso en kg");
                    double pesoUsuario=leerDato.nextDouble();
                    System.out.print("ingrese su altura en metros");
                    double alturaUsuario=leerDato.nextDouble();
                    double imc= pesoUsuario/(Math.pow(alturaUsuario,2));
                    if(imc <18.5){
                        System.out.println("su IMC es: "+imc+" usuario con delgadez");
                    } else if (imc>18.5 && imc<24.9) {
                        System.out.println("su IMC es: "+imc+" usuario saludable");
                    } else if (imc>25.0 && imc<29.9) {
                        System.out.println("su IMC es: "+imc+" usuario con sobrepeso");
                    } else if (imc>30.0) {
                        System.out.println("su IMC es: "+imc+" usuario con obesidad");
                    }
                    break;
                case 4:
                    double sumaTemperaturas=0;
                    int contador =0;
                    int contadorPrint=1;
                    while (true){
                        System.out.println("ingrese la temperatura #"+contadorPrint+" o ingrese -1" +
                                "para finalizar y calcular el promedio");
                        double temperatura= leerDato.nextDouble();
                        if (temperatura==-1){
                            break;
                        }
                        sumaTemperaturas+=temperatura;
                        contador++;
                        contadorPrint++;
                    }
                    double promedioTemp=sumaTemperaturas/contador;
                    System.out.println("El promedio de las "+ (contadorPrint-1)+ " temperaturas es:"+
                            promedioTemp);
                    break;
                case 5:
                    System.out.println("ingrese la primera fecha en el formato: dd-mm-aaaa");
                    String fechaPrimera=leerDato.next();
                    leerDato.nextLine();
                    System.out.println("ingrese la segunda fecha en el formato: dd-mm-aaaa");
                    String fechaSegunda=leerDato.next(); // preguntar al profe sobre este error
                    System.out.println("la diferencia de dias entre las dos fechas es " +
                            "de: "+(Math.abs(diferenciaDias(fechaPrimera,fechaSegunda)))+" dias");

                    break;
                case 6:
                    System.out.println("-----------------");
                    System.out.println("Ingrese el numero de kilometros a recorrer");
                    double distanciaKilometros=leerDato.nextDouble();
                    System.out.println("Ingrese el costo por kilometro");
                    double costoKilometro= leerDato.nextDouble();
                    System.out.println("Ingrese el valor de otros gastos adicionales");
                    double costosAdicionales=leerDato.nextDouble();
                    System.out.println("El costo total es de: $"+calculoViaje(distanciaKilometros,
                            costoKilometro,costosAdicionales));
                    break;
                case 7:
                    System.out.println("Ingrese la cantidad en Celcius a convertir");
                    double gradosCelcius=leerDato.nextDouble();
                    double gradosFar=(9.0/5.0)*gradosCelcius+32;
                    System.out.println("la temperatura en fahrenheir es de: "+ gradosFar);
                    break;
                case 8:
                    System.out.println("Vuelva pronto");
                    break;

                default:
                    System.out.println("opcion no valida");

            }



        }while(opcionMenu!=8);
    }
    /**
     * Descripción: función que convierte pesos colombianos a dolares
     * @param cantidadCop Cantidad de pesos colombianos
     * @return devuelve la cantidad en USD
     * */
    public static double convertirCopUsd(double cantidadCop) {
        return cantidadCop / 3919.87;
    }
    public static double convertirUsdCop(double cantidadUsd){
        return cantidadUsd*3919.87;
        }
     public static long diferenciaDias(String fecha1, String fecha2){
         String[] partesfecha1=fecha1.split("-");
         String[] partesfecha2=fecha2.split("-");
         int dia1= Integer.parseInt(partesfecha1[0]);
         int dia2= Integer.parseInt(partesfecha2[0]);
         int mes1= Integer.parseInt(partesfecha1[1]);
         int mes2= Integer.parseInt(partesfecha2[1]);
         int ano1= Integer.parseInt(partesfecha1[2]);
         int ano2= Integer.parseInt(partesfecha2[2]);
         LocalDate fechaInicio=LocalDate.of(ano1,mes1,dia1);
         LocalDate fechaFin=LocalDate.of(ano2,mes2,dia2);
         long diferenciaDias= ChronoUnit.DAYS.between(fechaInicio,fechaFin);
         return diferenciaDias;
     }
    public static double calculoViaje(double distancia,double costoDitancia,double costoAdicional){
        double totalViaje= (distancia*costoDitancia)+costoAdicional;
        return totalViaje;
    }


}