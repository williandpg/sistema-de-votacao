package com.betrybe.sistemadevotacao;

/**
 * Req 02 - Implemente a classe PessoaCandidata.
 */
public class PessoaCandidata extends Pessoa {

  int numero;
  int votos;

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  /**
   * Construtor da classe.
   *
   * @param nome    nomeParam
   * @param numero  numeroParam
   */
  public PessoaCandidata(String nome, int numero) {
    this.setNome(nome);
    this.numero = numero;
    this.votos = 0;
  }
}
