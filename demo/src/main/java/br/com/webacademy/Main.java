package br.com.webacademy;

public class Main {
    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(console.readLine);
            switch (opcao) {
                case 0 -> salvarProduto();
                case 1 -> buscarproduto();
                case 2 -> buscarprodutoporID();
                case 3 -> atualizarProduto();
                case 4 -> excluirproduto();
                case 5 -> System.exit(0);
            default -> System.out.print("Opção invalida!");

            } 
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
}