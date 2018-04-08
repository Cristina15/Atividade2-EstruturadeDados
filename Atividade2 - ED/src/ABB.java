/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vitoria Cristina
 */
public class ABB {
    // Falando que o Nó Árvore é um nó raiz

    NoArvore raiz;

    //Criando a árvore binária de busca, indicando que a raiz começa com null
    public ABB() {
        raiz = null;
    }

    //Inserindo nó a partir do nó raiz
    public void inserirNo(int d, String nom) {

        // Criando um nó novo do tipo Arvore
        NoArvore novo = new NoArvore(d, nom);

        // Se a raiz for igual á null, irá implementar um novo nó. 
        if (raiz == null) {
            raiz = novo;

            // se não, o No irá se tornar um auxiliar, que é basicamente o nó pai    
        } else {
            NoArvore auxiliar = raiz;
            NoArvore pai;

            // enquanto o pai for auxiliar
            while (true) {
                pai = auxiliar;
                // se o dado for menor que o "pai"
                if (d < auxiliar.dado) {
                    // irá receber o dado "filho" da esquerda
                    auxiliar = auxiliar.FilhoEsquerdo;
                    //está vendo se o auxiliar está vazio para implementar um 
                    //novo
                    if (auxiliar == null) {
                        pai.FilhoEsquerdo = novo;
                        // sai do metodo
                        return;
                    }
                    // Se o número for maior que o auxiliar
                    // irá para o filho direito
                } else {
                    auxiliar = auxiliar.FilhoDireito;
                    //esta vendo se o auxiliar é igual a vazio, para alocar o 
                    // o filho novo
                    if (auxiliar == null) {
                        pai.FilhoDireito = novo;

                        // sai do metodo
                        return;
                    }
                }
            }
        }

    }

    public NoArvore buscarNo(int d) {

        NoArvore aux = raiz;
        // enquanto a raiz não for igual o dado
        while (aux.dado != d) {
            // vai executar se o dado é menor que a raiz
            //se for vai executar no lado esquerdo
            if (d < aux.dado) {
                aux = aux.FilhoEsquerdo;
            } // se não irá procurar no lado direito
            else {
                aux = aux.FilhoDireito;
            }
            // mas se a auxiliar for igual a vazio
            //ira retornar vazio
            if (aux == null) {
                return null;
            }
        }
        //retornará o resultado
        return aux;
    }

    public boolean remover(int d) {
        
        //Criando um objeto auxiliar que vai receber raiz
        // E um objeto do tipo arvore pai que vai receber raiz
        //eu não entendi muito o método, de qual vai apagar qual
        //Me confundi muito nesse metodo
        NoArvore aux = raiz;
        NoArvore pai = raiz;
        boolean Fesquerdo = true;

        while (aux.dado != d) {

            pai = aux;

            if (d < aux.dado) {

                Fesquerdo = true;
                aux = aux.FilhoEsquerdo;

            } else {
                Fesquerdo = true;
                aux = aux.FilhoDireito;
            }
            if (aux == null) {
                return false;
            }
        } // fim do while

        if (aux.FilhoEsquerdo == null && aux.FilhoDireito == null) {
            if (aux == raiz) {
                raiz = null;
            } else if (Fesquerdo) {
                pai.FilhoEsquerdo = null;
            } else {
                pai.FilhoDireito = null;
            }
        } else if (aux.FilhoDireito == null) {
            if (aux == raiz) {
                raiz = aux.FilhoEsquerdo;
            } else if (Fesquerdo) {
                pai.FilhoEsquerdo = aux.FilhoEsquerdo;
            } else {
                pai.FilhoDireito = aux.FilhoEsquerdo;
            }
        } else if (aux == raiz) {
            raiz = aux.FilhoDireito;
        } else if (Fesquerdo) {
            pai.FilhoEsquerdo = aux.FilhoDireito;

        } else {
            pai.FilhoDireito = aux.FilhoEsquerdo;
             
        }
        else {
             NoArvore rePlantar = ObterNorePlantar(aux);
                if(aux==raiz){
                    raiz = rePlantar;
    } else if (Fesquerdo){
        pai.FilhoEsquerdo=rePlantar;
        
    } else {
        pai.FilhoDireito=rePlantar;
    }
                rePlantar.FilhoEsquerdo=aux.FilhoEsquerdo;

    }
        return true;
    }

    // essa função faz que o Nó que for apagado irá ser replantado
    //conforme o sucessor mais próximo
    public NoArvore ObterNorePlantar(NoArvore NoRe) {
        NoArvore rePlantarPai = NoRe;
        NoArvore rePlantar = NoRe;
        NoArvore aux = NoRe.FilhoDireito;

        while (aux != null) {
            rePlantarPai = rePlantar;
            rePlantar = aux;
            aux = aux.FilhoEsquerdo;

        }
        if (rePlantar != NoRe.FilhoDireito) {
            rePlantarPai.FilhoEsquerdo = rePlantar.FilhoDireito;
            rePlantar.FilhoDireito = NoRe.FilhoDireito;

        }
        System.out.println("O nó remplantando é: " + rePlantar );
    return rePlantar;
}
}