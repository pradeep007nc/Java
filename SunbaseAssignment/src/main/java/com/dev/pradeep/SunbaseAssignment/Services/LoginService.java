package com.dev.pradeep.SunbaseAssignment.Services;
import com.dev.pradeep.SunbaseAssignment.Dto.LoginDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Service
public class LoginService {

    public String getAccessToken(LoginDto loginDto) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");

        // Set the request body using the provided LoginDto
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(loginDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setText(requestBody);
        httpPost.setEntity(entityBuilder.build());

        try {
            // Execute the request
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            // Check for a successful response (status code 200)
            if (response.getStatusLine().getStatusCode() == 200) {
                // Parse the response and extract the access token
                String responseBody = EntityUtils.toString(httpEntity);
                // Assuming the response is in JSON format
                // You might want to use a JSON parsing library for a more robust solution
                String accessToken = responseBody.split("\"access_token\":")[1].split("\"")[1];
                return accessToken;
            } else {
                // Handle non-successful response
                System.err.println("Error: " + response.getStatusLine().getReasonPhrase());
            }

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }

        return null;
    }


}
