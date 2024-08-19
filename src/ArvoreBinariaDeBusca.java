public class ArvoreBinariaDeBusca {
    public No raiz;

    ArvoreBinariaDeBusca(Produto produto){
        raiz = new No(produto);
    }

    public void inserir(Produto produto){
        No novo = new No(produto);
        No atual = raiz;
        No proximo = raiz;
        while(proximo != null){
            atual = proximo;
            if(atual.produto.equals(produto)) {
                atual.produto.setQuantidade(produto.getQuantidade() + atual.produto.getQuantidade());
                System.out.println("O produto " + atual.produto.getNome() + " já existia no estoque, a quantidade foi atualizada");
                return;
            }
            proximo = atual.produto.getCodigo() > produto.getCodigo() ? atual.filhoEsquerdo : atual.filhoDireito;
        }
        if(atual.produto.getCodigo() > produto.getCodigo()) {
            atual.filhoEsquerdo = novo;
            novo.pai = atual;
            System.out.println("O produto " + novo.produto.getNome() + " foi adicionado no estoque");
            return;
        }
        atual.filhoDireito = novo;
        novo.pai = atual;
        System.out.println("O produto " + novo.produto.getNome() + " foi adicionado no estoque");
    }

    private No sucessor(No no){
        no = no.filhoDireito;
        if(no == null){
            return no;
        }
        while(no.filhoEsquerdo != null){
            no = no.filhoEsquerdo;
        }
        return no;
    }

    private No predecessor(No no){
        no = no.filhoEsquerdo;
        if(no == null){
            return no;
        }
        while(no.filhoDireito != null){
            no = no.filhoDireito;
        }
        return no;
    }

    private void removerCaso1(No no){
        if(no.pai == null){
            raiz = null;
            return; // testar caso raiz
        }
        if(no.pai.filhoEsquerdo == no){
            no.pai.filhoEsquerdo = null;
            return;
        }
        no.pai.filhoDireito = null;
    }
    private void removerCaso2(No no){
        if(no.pai.filhoEsquerdo == no){
            if(no.filhoEsquerdo != null){
                no.filhoEsquerdo.pai = no.pai;
                no.pai.filhoEsquerdo = no.filhoEsquerdo;
                return;
            }
            no.filhoDireito.pai = no.pai;
            no.pai.filhoDireito = no.filhoDireito;
            return;
        }
        if(no.filhoEsquerdo != null){
            no.filhoEsquerdo.pai = no.pai;
            no.pai.filhoDireito = no.filhoEsquerdo;
            return;
        }
        no.filhoDireito.pai = no.pai;
        no.pai.filhoDireito = no.filhoDireito;
    }
    private void removerCaso3(No no){
        No herdeiro = sucessor(no);
        if(herdeiro == null){
            herdeiro = predecessor(no);
            if(herdeiro == null){
                no = null;
                return;
            }
        }
        if(herdeiro.filhoDireito != null || herdeiro.filhoEsquerdo != null){
            removerCaso2(herdeiro);
        }
        removerCaso1(herdeiro);
        herdeiro.filhoEsquerdo = no.filhoEsquerdo;
        herdeiro.filhoDireito = no.filhoDireito;
        no.filhoEsquerdo.pai = herdeiro;
        no.filhoDireito.pai = herdeiro;
        if(no.pai != null){
            herdeiro.pai = no.pai;
            if(no.pai.filhoEsquerdo == no){
                no.pai.filhoEsquerdo = herdeiro;
                return;
            }
            no.pai.filhoDireito = herdeiro;
            return;
        }
        raiz = herdeiro;
    }

    public void remover(int codigo){
        No atual = raiz;
        String nomeProduto;
        while(atual != null){
            if(atual.produto.equals(codigo)){
                nomeProduto = atual.produto.getNome();
                if(atual.filhoEsquerdo != null && atual.filhoDireito != null){
                    removerCaso3(atual);
                }else if(atual.filhoEsquerdo == null && atual.filhoDireito == null){
                    removerCaso1(atual);
                }else{
                    removerCaso2(atual);
                }
                System.out.println("O produto " + nomeProduto + " foi removido do estoque");
                return;
            }
            atual = atual.produto.getCodigo() > codigo ? atual.filhoEsquerdo : atual.filhoDireito;
        }
        System.out.println("O produto não encontrado no estoque");
    }

    public void buscar(int codigo){
        No atual = raiz;
        while(atual != null){
            if(atual.produto.equals(codigo)) {
                System.out.println("Dados do produto: " + atual.produto.getNome()
                        + " tem a quantidade de " + atual.produto.getQuantidade() + " no estoque");
                return;
            }
            atual = atual.produto.getCodigo() > codigo ? atual.filhoEsquerdo : atual.filhoDireito;
        }
        System.out.println("O produto não encontrado no estoque");
    }

    public void produtoEmOrdem(No no){
        if(no.filhoEsquerdo != null){
            produtoEmOrdem(no.filhoEsquerdo);
        }
        System.out.print(no.produto.getCodigo() + " ");
        if(no.filhoDireito != null){
            produtoEmOrdem(no.filhoDireito);
        }
    }

    public void menorCodigo(){
        No atual = raiz;
        while(atual.filhoEsquerdo != null){
            atual = atual.filhoEsquerdo;
        }
        System.out.println("O menor código é o " + atual.produto.getCodigo()
                + " do produto " + atual.produto.getNome());
    }

    public void maiorCodigo(){
        No atual = raiz;
        while(atual.filhoDireito != null){
            atual = atual.filhoDireito;
        }
        System.out.println("O maior código é o " + atual.produto.getCodigo()
                + " do produto " + atual.produto.getNome());
    }

}
