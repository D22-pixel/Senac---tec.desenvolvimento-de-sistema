programa
{
	
	funcao inicio()
	{ cadeia nome_cliente[6]
	  real desconto[6]
	  real valores[6]
	  real valores_finais[6]
	  real desconto_dia = 0.0, desconto_limite = 100.00, total_recebido = 0.0
	  inteiro cliente_com_desconto = 0, i

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
                
                cliente_com_desconto = cliente_com_desconto + 1
                
            } senao {
            	desconto[i] = 0.0
                valores_finais[i] = valores[i]
            }
            
                 total_recebido = total_recebido + valores_finais[i]
        }
        
      
        escreva("\n==== Relatórios ====\n")
        
        para (i = 0; i < 6; i++) {
            escreva("Cliente: ", nome_cliente[i], " Valor a pagar: R$", valores_finais[i], " Desconto: R$ " , desconto[i], "\n")
        }
        
        escreva("\nTotal recebido pela loja: R$", total_recebido)
        escreva("\n Clientes que receberam desconto: ", cliente_com_desconto)
    }
}

	  

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1175; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */