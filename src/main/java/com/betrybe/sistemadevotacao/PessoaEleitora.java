package com.betrybe.sistemadevotacao;

/**
 * Req 03 - Implemente a classe PessoaEleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public PessoaEleitora(String nome, String cpf) {
    this.setNome(nome);
    this.cpf = cpf;
  }

}
