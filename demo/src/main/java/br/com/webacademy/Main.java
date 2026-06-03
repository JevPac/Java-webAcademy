package br.com.webacademy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do {
            exibirMenu();
            opcao = Integer.parseInt( sc.nextLine());
            switch (opcao) {
                case 0 -> salvarProduto();
                case 1 -> buscarproduto();
                case 2 -> buscarprodutoporID();
                case 3 -> atualizarProduto();
                case 4 -> excluirproduto();
                case 5 -> System.exit(0);
            default -> System.out.print("Opção invalida!");

            } 
            sc.close();
        } while (opcao !=0 ); {
        }
    }

    private static void exibirMenu() {
        System.out.println("\n## MENU de operações##");
        System.out.println("0. Salvar novo produto");
        System.out.println("1. buscar todos produto");
        System.out.println("2. buscar produto por id");
        System.out.println("3. atualizar produto");
        System.out.println("4. excluir produto");
        System.out.println("5. Sair do sistema");
        System.out.print("Escoha uma opção");

    }

    private static void salvarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n###Criar Novo Produto###");
        System.out.println("Nome:");
        String nome = sc.next();
        System.out.println("Quantidade: ");
        int Quantidade = Integer.parseInt(sc.nextline());
        System.out.println("Valor:");
        double valor = Double.parseDouble(sc.nextline());
        Produto produto = new Produto(nome, Quantidade, valor);
        produtoDAO produtoDAO = new ProdutoDAO();
        try {
            produtoDAO.salvar(produto);
            System.out.println("Produto criado com sucesso!");
        } catch(exeption e) {
            System.err.print(e.getMessage());
        }
        sc.close();
    }
    private static void buscarprodutoporID: {
    Scanner sc = new Scanner(System.in)
    System.out.println("\n###Buscar produto por ID###");
    System.out.println("\nDigite o ID do produto: ");
    long id = Long.parseLong(sc.nextLine());
    ProdutoDAO produtoDAO = new produtoDAO();
    }
}