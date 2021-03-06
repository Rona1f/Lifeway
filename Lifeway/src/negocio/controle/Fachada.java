package negocio.controle;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

import excecoes.IDInvalidoException;
import excecoes.ContaJaGeradaException;
import excecoes.ElementoJaExisteException;
import excecoes.ElementoNaoExisteException;
import excecoes.EmpresaJaCadastradaException;
import excecoes.PropriedadeJaCadastradaException;
import negocio.beans.Conta;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Propriedade;
import negocio.beans.RegistroDeOcorrencia;
import negocio.beans.Taxa;
import negocio.beans.Usuario;

public class Fachada {

    private static Fachada instance;

    private static ControladorUsuario controladorUsuario;
    private static ControladorRO controladorRO;
    private static ControladorPropriedade controladorPropriedade;
    private static ControladorEmpresa controladorEmpresa;
    private static ControladorTaxa controladorTaxa;
    private static ControladorConta controladorConta;

    private Fachada() {
        controladorEmpresa = ControladorEmpresa.getInstance();
        controladorUsuario = ControladorUsuario.getInstance();
        controladorRO = ControladorRO.getInstance();
        controladorPropriedade = ControladorPropriedade.getInstance();
        controladorTaxa = ControladorTaxa.getInstance();
        controladorConta = ControladorConta.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public void criarNovoUsuario(Usuario usuario) throws ElementoJaExisteException {
        controladorUsuario.criarNovoUsuario(usuario);
    }

    public void excluirPerfil(Usuario usuario) throws ElementoJaExisteException {
        controladorUsuario.excluirPerfil(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return controladorUsuario.listarUsuarios();
    }

    public void login(Usuario usuario) {
        controladorUsuario.login(usuario);
    }

    public Usuario getUsuarioLogado() {
        return controladorUsuario.getUsuarioLogado();
    }

    public void criarNovaOcorrencia(String assunto, String mensagem, Empresa empresa, Usuario cliente, LocalDate data,
            Endereco endereco) {
        controladorRO.criarNovaOcorrencia(assunto, mensagem, empresa, cliente, data, endereco);
    }

    public void resolverOcorrencia(RegistroDeOcorrencia ocorrencia) {
        controladorRO.resolverOcorrencia(ocorrencia);
    }

    public void criarNovaOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        controladorRO.criarNovaOcorrencia(registroDeOcorrencia);
    }

    public void excluirOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        controladorRO.excluirOcorrencia(registroDeOcorrencia);
    }

    public List<RegistroDeOcorrencia> listarROcorrencias() {
        return controladorRO.listarROcorrencias();
    }

    public void excluirPropriedade(Propriedade propriedade) throws ElementoJaExisteException {
        controladorPropriedade.excluirPropriedade(propriedade);
        ;
    }

    public List<Propriedade> listarPropriedade() {
        return controladorPropriedade.listarPropriedade();
    }

    public void cadastrarPropriedade(Propriedade propriedade)
            throws NoSuchAlgorithmException, ElementoJaExisteException, PropriedadeJaCadastradaException {
        controladorPropriedade.cadastrarPropriedade(propriedade);
    }

    public void cadastrarPropriedadeComercial(Propriedade propriedade) throws NoSuchAlgorithmException,
            ElementoJaExisteException, PropriedadeJaCadastradaException, IDInvalidoException {
        controladorPropriedade.cadastrarPropriedadeComercial(propriedade);
    }

    public void criarNovaEmpresa(Empresa empresa) throws ElementoJaExisteException, EmpresaJaCadastradaException {
        controladorEmpresa.criarNovaEmpresa(empresa);
    }

    public void excluirEmpresa(Empresa empresa) throws ElementoNaoExisteException {
        controladorEmpresa.excluirEmpresa(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return controladorEmpresa.listarEmpresas();
    }

    public void criarTaxa(Taxa taxa) throws ElementoJaExisteException {
        controladorTaxa.criarTaxa(taxa);
    }

    public void removerTaxa(Taxa taxa) {
        controladorTaxa.removerTaxa(taxa);
    }

    public List<Taxa> listarTaxas() {
        return controladorTaxa.listarTaxas();
    }

    public void criarNovaConta(Conta conta) throws ContaJaGeradaException, ElementoJaExisteException {
        controladorConta.criarNovaConta(conta);
    }

    public void excluirConta(Conta conta) throws ElementoNaoExisteException {
        controladorConta.excluirConta(conta);
    }

    public List<Conta> listarContas() {
        return controladorConta.listarContas();
    }

    public void salvar() {
        controladorTaxa.salvar();
        controladorConta.salvar();
    }

    public void checarInadimplentes() {
        controladorPropriedade.checarInadimplentes();
    }

}
