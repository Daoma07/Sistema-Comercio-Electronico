package com.example.User_Service.rabbit_client;

import com.example.User_Service.entity.Credencial;
import com.example.User_Service.service.impl.CredencialServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.dto.CredencialDto;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQClient {

    @Autowired
    private CredencialServiceImpl credencialServiceImpl;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public ResponseFormat consume(@Payload RequestFormat request) throws Exception {
        ResponseFormat responseFormat = new ResponseFormat();

        try {
            CredencialDto credencial = objectMapper.readValue(request.getContent(), CredencialDto.class);
            credencial = credencialServiceImpl.createCredencial(credencial);
            responseFormat.setContent(objectMapper.writeValueAsString(credencial));
            responseFormat.setResponseStatus(HttpStatus.OK.value());
        } catch (Exception ex) {
            responseFormat.setResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseFormat.setContent(ex.getMessage());
        }
        return responseFormat;

    }

}
