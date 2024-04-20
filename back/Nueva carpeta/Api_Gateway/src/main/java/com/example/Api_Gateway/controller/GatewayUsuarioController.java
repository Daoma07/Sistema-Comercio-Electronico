package com.example.Api_Gateway.controller;

import com.example.Api_Gateway.rabbit_client.RabbitMQClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.dto.CredencialDto;
import com.mycompany.utilities.dto.UsuarioDto;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class GatewayUsuarioController {

    private RabbitMQClient rabbitMQClient;

    @Autowired
    private ObjectMapper objectMapper;

    public GatewayUsuarioController(RabbitMQClient rabbitMQClient) {
        this.rabbitMQClient = rabbitMQClient;
    }

    @PostMapping("/register")
    public ResponseFormat servicio1Request(@RequestBody CredencialDto credencial) throws JsonProcessingException {
        String jsonCredencial = objectMapper.writeValueAsString(credencial);
        RequestFormat requestFormat = new RequestFormat(jsonCredencial, "add-credencial");
        return rabbitMQClient.sendMessage(requestFormat);
    }
}
