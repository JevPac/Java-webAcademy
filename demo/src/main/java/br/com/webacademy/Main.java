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
        int Quantidade = Integer.parseInt(sc.nextLine());
        System.out.println("Valor:");
        double valor = Double.parseDouble(sc.nextLine());
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
    try {
        Produto produto = produtoDAO.buscarprodutoporID(id);
        if (produto != null) {
            System.out.println("Produto encontrado: ");
            System.out.println(produto.nome());
        } else {
            System.out.println("Pro não encontrado");
        } 
    } catch(Exepction e ){
        System.err.println(e.getMessage());
    }
    sc.close();
    }
    private static void atualizarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n### Atualzar Produto ###");
        System.out.println("Digite o ID do produto que deseja atulizar");
        Long id = Long.parseLong(sc.nextLine());
        ProdutoDAO produtoDAO = new ProdutoDAO();
    try {
        Produto produtoExistente = produtoDAO.buscarPorId(id);
        if (ProdutoExistente != null) {
        System.out.println("Novo nome (atual: "+ produtoExistente.Quantidade() +"):");
        String nome = sc.nextLine();
        System.out.println("Nova quantidade (atual: "+ produtoExistente.quantidade()   "): ");
        int quantidade = Integer.parseInt(sc.nextLine());
        System.out.println("Novo valor (atual: " + produtoEXistente.valor()+ "): ");
        Double valor = Double.parseDouble(sc.nextLine());
        Produto produtoAtualizado = new Produto(id, nome, quantidade, valor); 
        try {
            produtoDAO.atualizar(produtoAtualizado);
            System.out.println("produto atualizado com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        } 
            else {
                System.out.println("Produto não encontrado");
                }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    sc.close();  
    
}