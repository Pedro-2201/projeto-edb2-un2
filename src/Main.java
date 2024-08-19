import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1012, "Pasta Suspensa", 50);
        Produto p2 = new Produto(1005, "Marcador de Texto", 30);
        Produto p3 = new Produto(1018, "Toner para Impressora", 5);
        Produto p4 = new Produto(1003, "Borracha", 75);
        Produto p5 = new Produto(1007, "Régua 30cm", 60);
        Produto p6 = new Produto(1020, "Lápis de Cor", 70);
        Produto p7 = new Produto(1011, "Clips de Papel", 200);
        Produto p8 = new Produto(1014, "Apontador", 120);
        Produto p9 = new Produto(1019, "Agenda", 35);
        Produto p10 = new Produto(1009, "Perfurador de Papel", 10);
        Produto p11 = new Produto(1001, "Caneta Esferográfica", 50);
        Produto p12 = new Produto(1016, "Corretivo Líquido", 45);
        Produto p13 = new Produto(1004, "Caderno 100 folhas", 40);
        Produto p14 = new Produto(1006, "Tesoura", 25);
        Produto p15 = new Produto(1017, "Fita Adesiva", 90);
        Produto p16 = new Produto(1008, "Grampeador", 15);
        Produto p17 = new Produto(1002, "Lápis HB", 100);
        Produto p18 = new Produto(1015, "Calculadora", 20);
        Produto p19 = new Produto(1013, "Post-it", 80);
        Produto p20 = new Produto(1010, "Papel Sulfite A4", 500);

        ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca(p1);
        estoque.inserir(p2);
        estoque.inserir(p3);
        estoque.inserir(p4);
        estoque.inserir(p5);
        estoque.inserir(p6);
        estoque.inserir(p7);
        estoque.inserir(p8);
        estoque.inserir(p9);
        estoque.inserir(p10);
        estoque.inserir(p11);
        estoque.inserir(p12);
        estoque.inserir(p13);
        estoque.inserir(p14);
        estoque.inserir(p15);
        estoque.inserir(p16);
        estoque.inserir(p17);
        estoque.inserir(p18);
        estoque.inserir(p19);
        estoque.inserir(p20);
        System.out.println();

        System.out.print("Produtos em ordem pelo codigo: ");
        estoque.produtoEmOrdem(estoque.raiz);
        System.out.println();

        estoque.maiorCodigo();
        estoque.menorCodigo();
        System.out.println();

        estoque.inserir(p11);
        System.out.println();

        estoque.buscar(1011);
        estoque.buscar(1001);
        System.out.println();

        estoque.remover(1011);
        estoque.remover(p1.codigo);
        System.out.println();

        estoque.buscar(p1.codigo);
        estoque.buscar(1011);

    }
}