package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerDato= new Scanner(System.in); // nuevo scanner
        int opcionMenu; // esta será la opcion del menú
        while (true){
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("------------------------------");
            System.out.println("Taller de vacaciones de java");
            System.out.println("1. Interes simple");
            System.out.println("2. Conversor de moneda");
            System.out.println("3. Calculo del IMC");
            System.out.println("4. Registro de temperatura");
            System.out.println("5. Salir");
            System.out.print("ingrese la opcion deseada: ");
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
                        System.out.println("la cantidad en dolares es de: "+ montoCop/3900.0);
                        break;

                    } else if (opcionCase2==2) {
                        System.out.print("ingrese el monto en USD a convertir: ");
                        double montoUsd=leerDato.nextDouble();
                        System.out.println("la cantidad en pesos es de: "+ montoUsd*3900.0);
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
                    System.out.println("Promedio de temperaturas");
                    System.out.println("ingrese la temperatura 1/5: ");
                    double temp1=leerDato.nextDouble();
                    System.out.println("ingrese la temperatura 2/5: ");
                    double temp2=leerDato.nextDouble();
                    System.out.println("ingrese la temperatura 3/5: ");
                    double temp3=leerDato.nextDouble();
                    System.out.println("ingrese la temperatura 4/5: ");
                    double temp4=leerDato.nextDouble();
                    System.out.println("ingrese la temperatura 5/5: ");
                    double temp5=leerDato.nextDouble();
                    double promedioTemp=(temp1+temp2+temp3+temp4+temp5)/5;
                    System.out.println("El promedio de las temperaturas ingresadas es" +
                            "de: "+promedioTemp);
                    break;
                case 5:
                    System.exit(0);

                default:
                    System.out.println("opcion no valida");

            }



        }
    }
}