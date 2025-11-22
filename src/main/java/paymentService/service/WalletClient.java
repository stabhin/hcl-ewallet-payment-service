package paymentService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public Double getWalletBalance(Long customerId) {
        String url = "http://localhost:8082/wallet/balance/" + customerId;
        return restTemplate.getForObject(url, Double.class);
    }

    public void updateWalletBalance(Long customerId, Double newBalance) {
        String url = "http://localhost:8082/wallet/update/" + customerId;
        restTemplate.put(url, newBalance);
    }
}