package excecoes;

public class IDInvalidoException extends Exception {
    public IDInvalidoException(String id) {
        super("CPF ou CNPJ inválido.");
    }

    public IDInvalidoException(Exception e) {
    }
}
