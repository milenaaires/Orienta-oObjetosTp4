package teste;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;
/**
 * Classe para testar as valida��es feitas
 * @author Milena Aires
 *
 */
class ControleTestes {
    Valida valida = new Valida ();
    
    /**
     * Testa a valida��o de venda
     */
    @Test
    void testaVenda() {
        assertFalse(valida.validaVenda(-3,-2,-1));
    }
    
    /**
     * Testa a valida��o do nome do cliente
     */
    
    @Test
    void testaNomeCliente() {
        assertFalse(valida.validaCliente("Lu", "12345678901"));
    }

    /**
     * Testa a valida��o do CPF do cliente
     */
    
    @Test
    void testaCpfCliente() {
        assertFalse(valida.validaCliente("Milena", "321"));
    }

    /**
     * Testa a valida��o do valor do audiobook
     */
    @Test
    void testaValorAudiobook() {
        assertFalse(valida.validaAudiobook(-3, 2));
    }

    /**
     * Testa a valida��o dos minutos do audiobook
     */
    @Test
    void testaMinutosAudioAudiobook() {
        assertFalse(valida.validaAudiobook(3, -3));
    }

    /**
     * Testa a valida��o do valor do ebook
     */
    @Test
    void testaValorEbook() {
        assertFalse(valida.validaEbook(-3));
    }
}