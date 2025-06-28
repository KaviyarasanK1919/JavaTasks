package sample.AIproject.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sample.AIproject.model.ChatResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    @Value("${deepseek.api.url}")
    private String apiUrl;

    @Value("${deepseek.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ChatResponse getAIResponse(String userMessage) {
        // Create request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "deepseek-chat"); // Model name (adjust based on DeepSeek documentation)
        requestBody.put("messages", Collections.singletonList(
                Map.of("role", "user", "content", userMessage)
        ));

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey); // Add API Key to request

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Call DeepSeek AI API
        ResponseEntity<Map> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);

        // Extract AI response
        Map responseBody = responseEntity.getBody();
        if (responseBody != null && responseBody.containsKey("choices")) {
            String aiResponse = ((Map<String, Object>) ((java.util.List) responseBody.get("choices")).get(0)).get("message").toString();
            return new ChatResponse(aiResponse);
        }
        return new ChatResponse("Error: Unable to process response");
    }
}
