import java.nio.charset.StandardCharsets;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;
import java.io.Writer;
import java.util.Map;

import Class.EmployeeA;
import Class.EmployeeC;

public class App {

    //Environment variables
    private static final String FILE_ASALARIADOS = (System.getenv("FILE_ASALARIADOS") != null && !System.getenv("FILE_ASALARIADOS").isEmpty() ? System.getenv("FILE_ASALARIADOS") : "Docs/asalariados.txt");
    private static final String FILE_COMISION = (System.getenv("FILE_COMISION") != null && !System.getenv("FILE_COMISION").isEmpty() ? System.getenv("FILE_COMISION") : "Docs/comision.txt");

    public static void main(String[] args) throws Exception {

        Files.createDirectories(Paths.get("Docs"));
        Map<String, Boolean> files = new LinkedHashMap<>();
        files.put(FILE_ASALARIADOS, false);
        files.put(FILE_COMISION, false);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido al sistema de cálculo de sueldos de empleados.");

            // Employee A
            System.out.print("Ingrese la cantidad de empleados asalariados: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.next();
            } else {
                int employeeACount = scanner.nextInt();
                if (employeeACount >= 1) {
                    float[] salariesA = new float[employeeACount];
                    processSalariedEmployees(scanner, salariesA);
                    files.put(FILE_ASALARIADOS, true);
                }
            }

            // Employee C
            System.out.print("Ingrese la cantidad de empleados por comisión: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número entero.");
            } else {
                int employeeCCount = scanner.nextInt();
                if (employeeCCount >= 1) {
                    float[] salariesC = new float[employeeCCount];
                    processCommissionEmployees(scanner, salariesC);
                    files.put(FILE_COMISION, true);
                }
            }

            files.forEach((file, created) -> {
                if (created)
                    showFile(file);
            });
        }
    }

    private static void processSalariedEmployees(Scanner scanner, float[] salariesA) {
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

    private static void processCommissionEmployees(Scanner scanner, float[] salariesC) {
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

    private static void showFile(String filename) {
        try {
            Files.lines(Paths.get(filename), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + filename + ": " + e.getMessage());
        }
    }

}
