import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        int amountTaxPayers;
        double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        amountTaxPayers = sc.nextInt();

        for (int i = 1; i <= amountTaxPayers; i++) {
            System.out.printf("\nDigite os dados do º%d contribuinte: \n", i);
            System.out.print("Informe a renda anual com salário: ");
            salaryIncome = sc.nextDouble();
            System.out.print("Informe a renda anual com prestação de serviços: ");
            servicesIncome = sc.nextDouble();
            System.out.print("Informe a renda anual com ganho de capital: ");
            capitalIncome = sc.nextDouble();
            System.out.print("Informe os gastos médicos: ");
            healthSpending = sc.nextDouble();
            System.out.print("Informe os gastos educacionais: ");
            educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            taxPayers.add(taxPayer);
        }

        int counter = 1;
        for (TaxPayer taxPayer : taxPayers) {

            System.out.printf("\nResumo do º%d contribuinte: \n", counter);
            System.out.printf("Imposto bruto total: %.2f\n", taxPayer.grossTax());
            System.out.printf("Abatimento: %.2f\n", taxPayer.taxRebate());
            System.out.printf("Imposto devido: %.2f\n", taxPayer.netTax());
            counter++;
        }

        sc.close();


    }
}
