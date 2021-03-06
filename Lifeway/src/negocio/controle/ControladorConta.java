package negocio.controle;

import java.util.List;
import excecoes.ContaJaGeradaException;
import excecoes.ElementoJaExisteException;
import excecoes.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Conta;

public class ControladorConta {

    private static ControladorConta instance;

    private IRepositorioGenerico<Conta> repositorioContas;

    ControladorConta() {
        this.repositorioContas = new RepositorioGenerico<>("contas.dat");
    }

    public static ControladorConta getInstance() {
        if (instance == null) {
            instance = new ControladorConta();
        }
        return instance;
    }

    public void criarNovaConta(Conta conta) throws ElementoJaExisteException, ContaJaGeradaException {
        repositorioContas.inserir(conta);
    }

    public void excluirConta(Conta conta) throws ElementoNaoExisteException {
        repositorioContas.remover(conta);
    }

    public List<Conta> listarContas() {
        return repositorioContas.listar();
    }

    public void salvar() {
        this.repositorioContas.salvar();
    }

}
