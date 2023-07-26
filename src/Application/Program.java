package Application;

import entities.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static javax.print.attribute.Size2DSyntax.MM;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira os dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Cliente cliente = new Cliente(nome, email, birthDate);

        System.out.println("Insira os dados do pedido:");
        System.out.print("Status: ");
        OrdemStatus status = OrdemStatus.valueOf(sc.next());

        Ordem ordem = new Ordem(new Date(), status, cliente);

        System.out.print("Serão quantos itens no pedido? ");
        int N = sc.nextInt();
        for (int i=1; i<=N; i++) {
            System.out.println("Entre #" + i + " item :");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preço do produto: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            Produto product = new Produto(productName, productPrice);

            OrdemItem it = new OrdemItem(quantity, productPrice, product);

            Ordem.addItem(it);
        }

        System.out.println();
        System.out.println(ordem);




        sc.close();
    }
}
