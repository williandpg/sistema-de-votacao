package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Req 04, 05 e 06 - Implementar a classe GerenciamentoVotacao com atributos,
 * os métodos de cadastro da classe GerenciamentoVotacao
 * e os métodos de votação da classe GerenciamentoVotacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (Objects.equals(pessoaCandidata.getNumero(), numero)) {
        System.out.println("Número da pessoa candidata já utilizado!");
      }
    }
    pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (Objects.equals(pessoaEleitora.getCpf(), cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    }
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (Objects.equals(pessoaCandidata.getNumero(), numeroPessoaCandidata)) {
        pessoaCandidata.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      String nome = pessoaCandidata.getNome();
      int votos = pessoaCandidata.getVotos();
      int votosTotal = cpfsComputados.size();
      int votosPercentual = Math.round(((float) votos / votosTotal) * 100);
      System.out.printf("Nome: %s - %d votos ( %s )%n", nome, votos, votosPercentual);
      System.out.printf("Total de votos: %s%n", votosTotal);
    }
  }
}