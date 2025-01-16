package br.com.iouone.listener;

import br.com.iouone.config.RabbitConfig;
import br.com.iouone.dto.CustomerIdMessageRequest;
import br.com.iouone.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerIdListener {

    @Autowired
    private PessoaService pessoaService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerIdListener.class);

    @RabbitListener(queues = RabbitConfig.RECEIVING_CUSTOMER_QUEUE)
    public void handleCustomerIdMessage(CustomerIdMessageRequest message) {
        logger.info("Recebida mensagem com PessoaId: {} e CustomerId: {}", message.getPessoaId(), message.getCustomerId());

        try {
            pessoaService.updateCustomerId(message.getPessoaId(), message.getCustomerId());
            logger.info("CustomerId atualizado com sucesso para PessoaId: {}", message.getPessoaId());
        } catch (Exception e) {
            logger.error("Erro ao atualizar o CustomerId para PessoaId: {}", message.getPessoaId(), e);
        }
    }
}
