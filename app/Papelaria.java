package app;

import model.ItemPedido;

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
