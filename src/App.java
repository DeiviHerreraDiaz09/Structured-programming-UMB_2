import java.nio.charset.StandardCharsets;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import Class.EmployeeA;
import java.util.Arrays;
import java.io.Writer;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int EmployeeA = 0;
        int EmployeeC = 0;

        System.out.println("Bienvenido al sistema de cálculo de sueldos de empleados.");

        // Employees A
        System.out.print("Ingrese la cantidad de empleados asalariados: ");
        EmployeeA = scanner.nextInt();
        float[] salariesA = new float[EmployeeA];

        System.out.println("Ingrese el sueldo fijo para los empleados asalariados: ");
        float fixedSalary = scanner.nextFloat();
        Arrays.fill(salariesA, fixedSalary);

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("asalariados.txt"), StandardCharsets.UTF_8))) {
            writer.write("========== NÓMINA EMPLEADOS ASALARIADOS ==========\n\n");
            for (int i = 0; i < salariesA.length; i++) {
                EmployeeA employeeA = new EmployeeA(i, fixedSalary);
                employeeA.calculateTotalSalary();
                employeeA.billingDetails(writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo asalariados.txt: " + e.getMessage());
        }

        // Employees C
        System.out.println("Ingrese la cantidad de empleados por comisión: ");
        EmployeeC = scanner.nextInt();
        float[] salariesC = new float[EmployeeC];

        System.out.println("Ingrese el sueldo base para los empleados por comisión: ");
        float baseSalary = scanner.nextFloat();
        Arrays.fill(salariesC, baseSalary);

        System.out.println("Ingrese el total de ventas para los empleados por comisión: ");
        float totalSales = scanner.nextFloat();

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("comision.txt"), StandardCharsets.UTF_8))) {

            writer.write("========== NÓMINA EMPLEADOS POR COMISIÓN ==========\n\n");
            for (int i = 0; i < salariesC.length; i++) {
                float commission = totalSales * 0.2f;
                salariesC[i] = baseSalary + commission;

                writer.write("Empleado #" + (i + 1) + "\n");
                writer.write("----------------------------------------\n");
                writer.write(String.format("Sueldo Base:          $%,.2f%n", baseSalary));
                writer.write(String.format("Ventas Totales:       $%,.2f%n", totalSales));
                writer.write(String.format("Comisión (20%%):       $%,.2f%n", commission));
                writer.write("----------------------------------------\n");
                writer.write(String.format("Sueldo Neto:        $%,.2f%n", salariesC[i]));
                writer.write("========================================\n\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo comision.txt: " + e.getMessage());
        }

        Files.lines(Paths.get("asalariados.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
        Files.lines(Paths.get("comision.txt"), StandardCharsets.UTF_8).forEach(System.out::println);

        scanner.close();
    }
}
