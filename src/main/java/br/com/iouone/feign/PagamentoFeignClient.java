package br.com.iouone.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pagamentoClient", url ="${urls.apis.pagamento}")
public interface PagamentoFeignClient {

    @GetMapping("api/v1/assinaturas/status")
    Boolean statusAssinatura(@RequestParam("customerId") String customerId);
}
