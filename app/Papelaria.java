package app;

import model.ItemPedido;

/*
 * RESPOSTAS DO EXERCICIO
 *
 * a) Qual bloco esta repetido?
 *    O bloco que calcula o bruto, o desconto (if / else if / else), o
 *    liquido e imprime a linha com printf. Ele aparecia 4 vezes, uma
 *    para cada item, mudando so o numero da variavel.
 *
 * b) Quais variaveis estao numeradas?
 *    descricao1..4, valor1..4, qtd1..4, kit1..4, bruto1..4,
 *    abatimento1..4 e liquido1..4.
 *
 * c) Quais numeros magicos existem e o que significam?
 *    0.15  -> 15% de desconto para kit   (DESCONTO_KIT)
 *    0.08  -> 8% de desconto por quantidade (DESCONTO_QUANTIDADE)
 *    10    -> quantidade minima para ganhar o desconto de 8%
 *    150.0 -> valor minimo dos itens para ter frete gratis
 *    12.90 -> valor do frete quando nao e gratis
 */
public class Papelaria {

    private static final double VALOR_MINIMO_FRETE_GRATIS = 150.0;
    private static final double VALOR_FRETE = 12.90;
    private static final double SEM_FRETE = 0.0;

    public static void main(String[] args) {
        System.out.println("=== PAPELARIA PONTO FINAL ===\n");

        ItemPedido[] itens = {
            new ItemPedido("Caderno 10 materias", 24.90, 1, false),
            new ItemPedido("Lapis grafite", 1.50, 12, false),
            new ItemPedido("Kit escolar basico", 84.00, 1, true),
            new ItemPedido("Caneta azul", 2.80, 10, false)
        };

        double soma = 0;
        for (ItemPedido item : itens) {
            item.exibirLinha();
            soma = soma + item.calcularValorLiquido();
        }

        double frete = calcularFrete(soma);

        System.out.printf("%nItens:  R$ %.2f%n", soma);
        System.out.printf("Frete:  R$ %.2f%n", frete);
        System.out.printf("Total do pedido: R$ %.2f%n", soma + frete);
    }

    public static double calcularFrete(double valorItens) {
        if (valorItens >= VALOR_MINIMO_FRETE_GRATIS) {
            return SEM_FRETE;
        } else {
            return VALOR_FRETE;
        }
    }
}
