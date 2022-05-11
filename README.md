# ML-Technical-Assessment
## Description

A web API to manage users's accesses to new features via feature switches. 
AI Engineer technical assessment for [MoneyLion](https://www.moneylion.com/).

## Features
### 1. Get 
This endpint receives email and featureName as request parameters and returns the following response in JSON format.
The response is true if the user has access to the featureName and false otherwise.

**Example:**
- Generate request in HTTP client:

    ![image](https://user-images.githubusercontent.com/72979718/167908188-d693c9aa-17fa-4273-b451-5c33d662c920.png)
    
    
- Response:
    
    ![image](https://user-images.githubusercontent.com/72979718/167908386-c4f161d5-72f6-4106-a4ca-2b0738497131.png)
    

### 2. Post

This endpoint receives the request in JSON format and returns an empty response with HTTP Status OK (200) when the database is updated successfully with the feature registerd by new user, otherwise returns HTTP Status Not Modified (304).

**Example:**
- Generate request in HTTP client:
    
    ![image](https://user-images.githubusercontent.com/72979718/167908858-6abc3cbe-182b-42db-8102-e8bc003f1551.png)

- Response:

    ![image](https://user-images.githubusercontent.com/72979718/167909023-6d65a87e-97b9-4d18-a255-a7a052b0e898.png)


### 3. Put
- This endpoint acts as a switch to enable or disable users' accesses to certain features by receiving email, featureName and enable as request parameters. It returns an empty response with HTTP Status OK (200) when the enable parameter is updated successfully for target email and feature, otherwise returns HTTP Status Not Modified (304).

**Example:**
- Generate request in HTTP client:

    ![image](https://user-images.githubusercontent.com/72979718/167909453-b81d836d-e00e-4dea-ad67-23b64fbf0886.png)
    
- Response:
    
    ![image](https://user-images.githubusercontent.com/72979718/167909578-2a2821fd-6a8d-47af-99a5-4bbf1ad247c5.png)





## Technologies
Project is created with:
* Java version: 17
* Spring Boot version: 2.6.7



