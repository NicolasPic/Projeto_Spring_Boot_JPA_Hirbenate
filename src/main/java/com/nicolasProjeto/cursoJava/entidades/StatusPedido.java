package com.nicolasProjeto.cursoJava.entidades;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public static StatusPedido valorDo(int codigo) {
		for (StatusPedido valor : StatusPedido.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Codigo invalido");
	}
}
