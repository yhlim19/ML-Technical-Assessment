package com.example.MoneyLion.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
        if (clients.isEmpty()){
            throw new IllegalStateException(
                    "Feature " + featureName + " is not registered by the client with email " + email);
        }else{
            Client clientTarget = clients.get(0);
            if (clientTarget.getCanAccess()) {
                return (new ClientFeatureResponse(true));
            }
            else {
                return (new ClientFeatureResponse(false));
            }
        }
    }


    public void addNewClient(Client client) {
        Optional<Client> clientBonding = clientRepository.findClientBonding(client.getFeatureName(),client.getEmail());

        if (clientBonding.isPresent()) {
            throw new HttpStatusCodeException(HttpStatus.NOT_MODIFIED) {
                @Override
                public HttpStatus getStatusCode() {
                    return super.getStatusCode();
                }
            };
        }
        clientRepository.save(client);
    }


    @Transactional
    public void updateClient(String featureName, String email, Boolean enable) {
        List<Client> clients =  clientRepository.findClientByFeatureNameAndEmail(featureName,email);
        if (clients.isEmpty()){
            throw new IllegalStateException(
                    "Feature " + featureName + " is not registered by the client with email " + email);
        }else{
            Client client = clients.get(0);
            if (!Objects.equals(client.getEnable(),enable)) {
                client.setEnable(enable);
            }else{
                throw new HttpStatusCodeException(HttpStatus.NOT_MODIFIED) {
                    @Override
                    public HttpStatus getStatusCode() {
                        return super.getStatusCode();
                    }
                };

            }
        }
    }
}
