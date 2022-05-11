package com.example.MoneyLion.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }



    public ClientFeatureResponse featureResponse(String featureName, String email) {
        List<Client> clients =  clientRepository.findClientByFeatureNameAndEmail(featureName,email);
        Client client = clients.get(0);
        if (client.getCanAccess() == true) {
            return (new ClientFeatureResponse(true));
        }
        else {
            return (new ClientFeatureResponse(false));
        }

    }


    public void addNewClient(Client client) {
        Optional<Client> clientByEmail = clientRepository.findClientByEmail(client.getEmail());
        Optional<Client> clientByFeature = clientRepository.findClientByFeature(client.getFeatureName());
        if (clientByEmail.isPresent() && clientByFeature.isPresent()){
            throw new IllegalStateException("This feature is already registered by this email");
        }
        clientRepository.save(client);
    }


}
