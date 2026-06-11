package Atv_01.app.controller;

import Atv_01.app.dao.PessoaDao;
import Atv_01.app.model.Pessoa;

public class PessoaController {
    private PessoaDao dao = new PessoaDao();

    public void cadastrarPessoa(String nome){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        dao.inserir(pessoa);
    }

    public Pessoa consultarPessoa(String nome){
        return dao.buscarPorNome(nome);
    }

    public void atualizarPessoa(int id, String nome) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        dao.atualizar(pessoa);
    }

    public void excluirPessoa(int id) {
        dao.excluir(id);
    }
}
