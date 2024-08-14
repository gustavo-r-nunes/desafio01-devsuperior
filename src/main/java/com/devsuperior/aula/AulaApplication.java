package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.services.FreteService;
import com.devsuperior.aula.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Autowired
	private FreteService freteService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o código do pedido: ");
		int codigo = scanner.nextInt();
		System.out.println("Digite o valor básico: ");
		double basic = scanner.nextDouble();
		System.out.println("Digite a porcentagem do desconto: ");
		double discount = scanner.nextDouble();

		Order order = new Order(codigo, basic, discount);
		double valorFinal = 0;

		valorFinal = orderService.total(order);
		valorFinal = freteService.shipment(order) - valorFinal;

		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$" + valorFinal);


	}
}
