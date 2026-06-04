package br.com.webacademy;

public record produto(Long id, String nome,
            Integer quantidade, Double valor){

    produto(String nome, Integer quantidade, Double valor){
        this (null, nome, quantidade, valor);
    }
}