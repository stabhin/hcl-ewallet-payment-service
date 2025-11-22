package paymentService.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import paymentService.beans.CustomerWalletResponse;
import reactor.core.publisher.Mono;

@Service
public class ApiService {

	private final WebClient webClient;

	public ApiService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
	}

	public CustomerWalletResponse callExternalApi(String token) {
		Mono<CustomerWalletResponse> response = webClient.get().uri("/data").header("Authorization", "Bearer " + token)
				.retrieve().bodyToMono(CustomerWalletResponse.class);

		return response.block(); // converts Mono → actual object
	}
}
