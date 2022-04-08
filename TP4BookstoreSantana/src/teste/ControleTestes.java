package teste;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;
/**
 * Classe para testar as validações feitas
 * @author Milena Aires
 *
 */
class ControleTestes {
    Valida valida = new Valida ();
    
    /**
     * Testa a validação de venda
     */
    @Test
    void testaVenda() {
        assertFalse(valida.validaVenda(-3,-2,-1));
    }
    
    /**
     * Testa a validação do nome do cliente
     */
    
    @Test
    void testaNomeCliente() {
        assertFalse(valida.validaCliente("Lu", "12345678901"));
    }

    /**
     * Testa a validação do CPF do cliente
     */
    
    @Test
    void testaCpfCliente() {
        assertFalse(valida.validaCliente("Milena", "321"));
    }

    /**
     * Testa a validação do valor do audiobook
     */
    @Test
    void testaValorAudiobook() {
        assertFalse(valida.validaAudiobook(-3, 2));
    }

    /**
     * Testa a validação dos minutos do audiobook
     */
    @Test
    void testaMinutosAudioAudiobook() {
        assertFalse(valida.validaAudiobook(3, -3));
    }

    /**
     * Testa a validação do valor do ebook
     */
    @Test
    void testaValorEbook() {
        assertFalse(valida.validaEbook(-3));
    }
}