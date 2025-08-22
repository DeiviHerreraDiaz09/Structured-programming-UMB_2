import java.nio.charset.StandardCharsets;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;
import Class.EmployeeA;
import Class.EmployeeC;
import java.io.Writer;

public class App {

    private static final String FILE_ASALARIADOS = "asalariados.txt";
    private static final String FILE_COMISION = "comision.txt";

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido al sistema de cálculo de sueldos de empleados.");

            // Employee A
            System.out.print("Ingrese la cantidad de empleados asalariados: ");
            int employeeACount = scanner.nextInt();
            float[] salariesA = new float[employeeACount];
            procesarAsalariados(scanner, salariesA);

            // Employee C
            System.out.print("Ingrese la cantidad de empleados por comisión: ");
            int employeeCCount = scanner.nextInt();
            float[] salariesC = new float[employeeCCount];
            procesarComision(scanner, salariesC);

            mostrarArchivo(FILE_ASALARIADOS);
            mostrarArchivo(FILE_COMISION);
        }
    }

    private static void procesarAsalariados(Scanner scanner, float[] salariesA) {
        System.out.println("Ingrese el sueldo fijo para los empleados asalariados: ");
        float fixedSalary = scanner.nextFloat();
        Arrays.fill(salariesA, fixedSalary);

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_ASALARIADOS), StandardCharsets.UTF_8))) {
            writer.write("========== NÓMINA EMPLEADOS ASALARIADOS ==========\n\n");
            for (int i = 0; i < salariesA.length; i++) {
                EmployeeA employeeA = new EmployeeA(i, fixedSalary);
                employeeA.billingDetails(writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + FILE_ASALARIADOS + ": " + e.getMessage());
        }
    }

    private static void procesarComision(Scanner scanner, float[] salariesC) {
        System.out.println("Ingrese el sueldo base para los empleados por comisión: ");
        float baseSalary = scanner.nextFloat();
        Arrays.fill(salariesC, baseSalary);

        System.out.println("Ingrese el total de ventas para los empleados por comisión: ");
        float totalSales = scanner.nextFloat();

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_COMISION), StandardCharsets.UTF_8))) {
            writer.write("========== NÓMINA EMPLEADOS POR COMISIÓN ==========\n\n");
            for (int i = 0; i < salariesC.length; i++) {
                EmployeeC employeeC = new EmployeeC(i, baseSalary, totalSales);
                employeeC.billingDetails(writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + FILE_COMISION + ": " + e.getMessage());
        }
    }

    private static void mostrarArchivo(String filename) {
        try {
            Files.lines(Paths.get(filename), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + filename + ": " + e.getMessage());
        }
    }

}
