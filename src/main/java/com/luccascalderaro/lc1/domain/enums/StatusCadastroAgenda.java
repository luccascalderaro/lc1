package com.luccascalderaro.lc1.domain.enums;

public enum StatusCadastroAgenda {
	
	
		
		ATIVO(1,"ATIVO"),
		INATIVO(2,"INATIVO");
		
		private Integer id;
		
		private String descricao;
		

		private StatusCadastroAgenda(Integer id, String descricao) {
			this.id = id;
			this.descricao = descricao;
		}


		public Integer getId() {
			return id;
		}


		public String getDescricao() {
			return descricao;
		}
		
		


}
