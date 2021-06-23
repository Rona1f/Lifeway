package negocio.controle;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ElementoJaExisteException;
import excecoes.EmpresaJaCadastradaException;
import negocio.beans.Empresa;

public class ControladorEmpresa {

    private static ControladorEmpresa instance;
    
    private IRepositorioGenerico<Empresa> repositorioEmpresa;

    
    ControladorEmpresa() {
        this.repositorioEmpresa = new RepositorioGenerico<>();
    }

    public static ControladorEmpresa getInstance() {
        if(instance == null){
            instance = new ControladorEmpresa();
        }
        return instance;
    }

    public void criarNovaEmpresa(Empresa empresa) throws ElementoJaExisteException {
        repositorioEmpresa.inserir(empresa);
    }

    public void excluirEmpresa(Empresa empresa) throws ElementoJaExisteException {
        repositorioEmpresa.remover(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return repositorioEmpresa.listar();
    }


    /**
     * Método para cadastrar empresa.
     * @param empresa
     * @throws NoSuchAlgorithmException
     * @throws EmpresaJaCadastradaException
     */
    public void cadastrarEmpresa(Empresa empresa) throws NoSuchAlgorithmException, EmpresaJaCadastradaException {
        if (empresa == null) return; // >>> Tratar erros para GUI

        //id, nome, serviço

        //adicionar empresa ao repositorioEmpresa
        try {
            this.repositorioEmpresa.inserir(empresa);
        } catch(ElementoJaExisteException e) {
            throw new EmpresaJaCadastradaException(e);
        }
    }
}