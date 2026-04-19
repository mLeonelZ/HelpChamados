package br.com.helpchamados.exceptions;

public class NegocioException extends RuntimeException {
    public NegocioException(String message) {
        super(message);
    }
}
