programa
{
	
	funcao inicio()
	{
		 cadeia nomecliente, vegetariano, dieta, prato , pagamento

		 escreva("Digite nome de cliente: ")
		 leia(nomecliente)

		 escreva("O cliente é vegetariano? ")
		 leia(vegetariano)
		 
		 escreva("O cliente está de dieta? ")
		 leia(dieta)

     	se (dieta == "sim" e vegetariano == "sim")
     		 { prato = "Salada" } 
 
     	senao se (dieta == "sim" e vegetariano == "nao") 
     		  { prato = "Frango Grelhado" }
     	

     	senao se (dieta == "nao" e vegetariano == "sim") 
     		   { prato = "Macarrão"}

     	senao 
     	   {  prato = "Feijoada" }
	
     	

     	escreva("\n", nomecliente , " sua sugestão de prato é: ", prato, "\n ")

     	escreva("Você deseja pagar com dinheiro ou cartão? ")
     	leia(pagamento)

     	se(pagamento == "dinheiro")
     	{
     		escreva ("O cliente possui 15% de desconto. \n")
     	
     	}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 548; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */