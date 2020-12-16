package com.example.demo.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Categoria;
import com.example.demo.entities.ItemPedido;
import com.example.demo.entities.Pedido;
import com.example.demo.entities.Produto;
import com.example.demo.entities.Usuario;
import com.example.demo.entities.enums.StatusPedido;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ItemPedidoRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Estroncio Silva", "estroncio@gmail.com", "11-99999-9998", "12345");
		Usuario u2 = new Usuario(null, "Dionesia Pereira", "dionesia@gmail.com", "11-99999-9999", "12345");
		Usuario u3 = new Usuario(null, "Mariazinha Lopes", "mariazinha@gmail.com", "11-99999-9997", "55687");

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		Pedido p1 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"), StatusPedido.ENTREGUE, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2020-10-05T15:48:33Z"), StatusPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2020-12-12T18:15:14Z"), StatusPedido.PAGAMENTO_PENDENTE, u1);

		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Categoria c1 = new Categoria(null, "Computadores");
		Categoria c2 = new Categoria(null, "Celulares");
		Categoria c3 = new Categoria(null, "Eletrodomestico");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Produto pr1 = new Produto(null, "Notebook HYX300", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit."
				+ " Cras accumsan gravida metus, vel rhoncus diam luctus et. "
				+ "Aliquam quis varius libero. Nunc dolor elit, interdum sit amet posuere vulputate, "
				+ "laoreet in nisi. Sed et sodales magna.", new BigDecimal(3499.99),
				"fringilla consequat faucibus");
		
		Produto pr2 = new Produto(null, "Celular KK20", 
				"Sed quis finibus ipsum, at imperdiet felis. Vivamus semper magna eget ex rhoncus,"
				+ " eget suscipit felis sodales. Vivamus vehicula tincidunt porttitor.",
						new BigDecimal(899.00),
						"quis dolor eu sem suscipit");
		
		Produto pr3 = new Produto(null, "TV MDK-12", 
				"Integer dictum ligula sit amet eros bibendum, id efficitur purus rhoncus. "
				+ "Pellentesque in condimentum nunc, a condimentum nisl. ",
						new BigDecimal(1237.50),
						"tincidunt congue nunc");
		
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3));
		
		pr1.getCategoria().add(c1);
		pr2.getCategoria().add(c1);
		pr2.getCategoria().add(c2);
		pr3.getCategoria().add(c3);
		
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3));
		
		
		ItemPedido ip1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
		ItemPedido ip4 = new ItemPedido(p3, pr2, 3, pr2.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
	}

}
