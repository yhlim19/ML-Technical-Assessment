package com.example.MoneyLion.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/moneylion/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClient(){
        return clientService.getClient();
    }

    @GetMapping(path="featureAccessibility")
    public ClientFeatureResponse featureResponse
            (@RequestParam String featureName,
             @RequestParam String email){
        return clientService.featureResponse(featureName,email);
//        return clientService.featureAccessibility();
    }

    @PostMapping(path = "new")
    public void registerNewClient
            (@RequestBody Client client){
        clientService.addNewClient(client);
    }
}
