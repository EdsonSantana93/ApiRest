package com.example.demo.entities.enums;

public enum StatusPedido {
	PAGAMENTO_PENDENTE(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int code;

	private StatusPedido(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StatusPedido valueOf(int code) {
		for (StatusPedido value :StatusPedido.values()) {
			if (value.getCode() == code) {
				return value;
			}
		} 
		throw new IllegalArgumentException("O valor passado é invalido!");
	}
}
