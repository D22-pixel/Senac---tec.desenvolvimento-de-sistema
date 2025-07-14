programa
{
	
	funcao inicio()
	{ cadeia nome_cliente[6], cliente_com_desc[6], cliente_sem_desc[6]
	  real desconto[6]
	  real valores[6]
	  real valores_finais[6]
	  real desconto_dia = 0.0, desconto_limite = 100.00, total_recebido = 0.0
	  inteiro cliente_com_desconto = 0,cliente_sem_desconto = 0, i

	  escreva("Digite o desconto do dia: ")
	  leia(desconto_dia)

	  para (i = 0; i < 6 ; i++){
	  	escreva("Digite o nome do cliente ", i+1,":")
	 	 leia(nome_cliente[i])
	 	 
	 		escreva("Digite valor gasto por ", nome_cliente[i],":")
	  		 leia(valores[i])
	  		 
        se (valores[i] > desconto_limite) {
        	
                valores_finais[i] = valores[i] - desconto_dia
                
                desconto[i] = desconto_dia

                cliente_com_desc[cliente_com_desconto]= nome_cliente[i]
                
                cliente_com_desconto = cliente_com_desconto + 1
                
            } senao {
            	
            	desconto[i] = 0.0
            	
                valores_finais[i] = valores[i]
                
                cliente_sem_desc[cliente_sem_desconto]= nome_cliente[i]
                
                cliente_sem_desconto = cliente_sem_desconto + 1
            }
            
                 total_recebido = total_recebido + valores_finais[i]
        }
        
      
        escreva("\n==== Relatórios ====\n")
        
        para (i = 0; i < 6; i++) {
            escreva("Cliente: ", nome_cliente[i], " Valor a pagar: R$", valores_finais[i], " Desconto: R$ " , desconto[i], "\n")
        }
        
        escreva( " \n Total recebido pela loja: R$ ", total_recebido )
        escreva(" \n Clientes que receberam desconto: \n", cliente_com_desconto )
         
        para (i = 0; i < cliente_com_desconto; i++) 
          {
            escreva(cliente_com_desc[i], " ")
          }


        escreva("\n Clientes que NÃO receberam desconto: \n", cliente_sem_desconto )
            para (i = 0; i < cliente_sem_desconto; i++) 
         {
           escreva(cliente_sem_desc[i], " ")
         }

    }
}







































































































































































 










	  

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1858; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */