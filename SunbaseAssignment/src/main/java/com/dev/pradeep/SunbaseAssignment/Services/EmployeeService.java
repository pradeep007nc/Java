package com.dev.pradeep.SunbaseAssignment.Services;

import com.dev.pradeep.SunbaseAssignment.Dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.support.ManagedList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    public EmployeeService(CacheService cacheService){
        this.cacheService = cacheService;
        this.employees = new HashMap<>();
        //demo employee to check
    }

    private final CacheService cacheService;

    Map<String, Employee> employees;
    public void addEmployee(Employee employee) {
        String endpoint = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=create";

        String authorizationToken = cacheService.getToken().trim();
        System.out.println(cacheService.getToken());

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(endpoint);

        // Set the request headers
        httpPost.addHeader("Authorization", "Bearer " + authorizationToken);
        httpPost.addHeader("Content-Type", "application/json");


        // Convert the Employee object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Set the request body
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setText(requestBody);
        httpPost.setEntity(entityBuilder.build());

        try {
            // Execute the request
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            // Check the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                System.out.println("Successfully created");
            } else if (statusCode == 400) {
                System.out.println("First Name or Last Name is missing");
            } else {
                System.out.println("Unexpected response code: " + statusCode);
            }

            // Print the response body for debugging purposes
            System.out.println(EntityUtils.toString(httpEntity)+"working");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void fetchAllEmployees() {
            String endpoint = "https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";

            String authorizationToken = cacheService.getToken().trim();

            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(endpoint);

            // Set the request headers
            httpGet.addHeader("Authorization", "Bearer " + authorizationToken);

            try {
                // Execute the request
                HttpResponse response = httpClient.execute(httpGet);
                HttpEntity httpEntity = response.getEntity();

                // Check the response status code
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    System.out.println("Successfully fetched employees");

                    // Parse the JSON response into a List<Employee>
                    ObjectMapper objectMapper = new ObjectMapper();
                    List<Employee> employeeList = objectMapper.readValue(httpEntity.getContent(), new TypeReference<List<Employee>>() {});

                    // Populate the employees map with email as key
                    employeeList.forEach(employee -> employees.put(employee.getUuid(), employee));
                } else {
                    System.out.println("Unexpected response code: " + statusCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    public Employee getEmployeeById(String uuid){
        return employees.get(uuid);
    }

    public List<Employee> getEmployees(){
        return employees.values().stream().toList();
    }

}
