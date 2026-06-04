package br.com.webacademy;

import java.util.Scanner;
import java.util.List;

import br.com.webacademy.produto;
import br.com.webacademy.produtoDAO;
import br.com.webacademy.conexao;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do {
            exibirMenu();
            opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 0 -> salvarProduto();
                case 1 -> buscarprodutos();
                case 2 -> buscarprodutoPorID();
                case 3 -> atualizarProduto();
                case 4 -> excluirProduto();
                case 5 -> System.exit(0);
                default -> System.out.print("Opção invalida!");

            }
            sc.close();
        } while (opcao != 0);
        {
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

    // salvar produto

    private static void salvarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n###Criar Novo Produto###");
        System.out.print("Nome:");
        String nome = sc.nextLine();
        System.out.print("Quantidade: ");
        int Quantidade = Integer.parseInt(sc.nextLine());
        System.out.print("Valor:");
        double valor = Double.parseDouble(sc.nextLine());
        produto produto = new produto (nome, Quantidade, valor);
        produtoDAO produtoDAO = new produtoDAO();
        try {
            produtoDAO.salvar(produto);
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        sc.close();
    }

    private static void buscarprodutos() {
        System.out.println("\n### buscar todos ###");
        produtoDAO produtoDAO = new produtoDAO();
        try {
            List<produto> produtos = produtoDAO.buscarTodos();
            if (produtos !=null) {
                System.out.println("lista de produto: ");
                for (produto produto : produtos ){
                    System.out.println("nome: " + produto.nome());
                }   
            }else {
                System.out.println("produto nao encontrado");
                }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    // busca por ID do produto

    private static void buscarprodutoPorID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n###Buscar produto por ID###");
    System.out.println("\nDigite o ID do produto: ");
    long id = Long.parseLong(sc.nextLine());
    produtoDAO produtoDAO = new produtoDAO();
    try {
        produto produto = produtoDAO.buscarPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado: ");
            System.out.println(produto.nome());
        } else {
            System.out.println("Pro não encontrado");
        }
    } catch(Exception e){
        System.err.println(e.getMessage());
    }
    sc.close();
    }

    // Atulizar produto no codigo

    private static void atualizarProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n### Atualzar Produto ###");
        System.out.println("Digite o ID do produto que deseja atulizar");
        Long id = Long.parseLong(sc.nextLine());
        produtoDAO produtoDAO = new produtoDAO();
    try {
        produto produtoExistente = produtoDAO.buscarPorId(id);
        if (produtoExistente != null) {
        System.out.println("Novo nome (atual: "+ produtoExistente.quantidade() +"):");
        String nome = sc.nextLine();
        System.out.println("Nova quantidade (atual: "+ produtoExistente.quantidade()  );
        int quantidade = Integer.parseInt(sc.nextLine());
        System.out.println("Novo valor (atual: " + produtoExistente.valor()+ "): ");
        Double valor = Double.parseDouble(sc.nextLine());
        produto produtoAtualizado = new produto(id, nome, quantidade, valor); 
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

    // excluir produto

    private static void excluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n### Exclir Produto ###");
        System.out.println("Digit o ID do produto que deseja exlcuir: ");
        Long id = Long.parseLong(sc.nextLine());
       produtoDAO produtoDAO = new produtoDAO();
        try {
            produto produtoExistente = produtoDAO.buscarPorId(id);
            if (produtoExistente != null) {
                produtoDAO.excluir(produtoExistente.id());
                System.out.println("Produto excluido com sucesso!");

            } else {
                System.out.println("Produto não encontrada");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        sc.close();
    }

}