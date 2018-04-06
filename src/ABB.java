/**
 *
 * @author vitoria.csilva15
 */
public class ABB {
    
    // Falando que o Nó Árvore é um nó raiz
    NoArvore raiz;
    
    //Criando a árvore binária de busca, indicando que a raiz começa com null
    public ABB(){
        raiz=null;
    }
    
    //Inserindo nó a partir do nó raiz
    public void inserirNo(int d, String nom){
        
        // Criando um nó novo do tipo Arvore
        NoArvore novo= new NoArvore(d,nom);
        
        // Se a raiz for igual á null, irá implementar um novo nó. 
        if(raiz==null){
            raiz=novo;
            
        } else{
            NoArvore auxiliar=raiz;
            NoArvore pai;
            
            while(true){
                pai=auxiliar;
                if(d<auxiliar.dado){
                    auxiliar=auxiliar.FilhoEsquerdo;
                    
                    if(auxiliar==null){
                        pai.FilhoEsquerdo=novo;
                        return;
                    }
                } else {
                    auxiliar=auxiliar.FilhoDireito;
                    if(auxiliar==null){
                        pai.FilhoDireito=novo;
                        return;
                    }
                }
            }
        }
        
    }
}
