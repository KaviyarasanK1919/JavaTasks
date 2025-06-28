package sample.AIproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sample.AIproject.model.ChatRequest;
import sample.AIproject.model.ChatResponse;
import sample.AIproject.service.ChatService;



@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.getAIResponse(request.getMessage());
    }
}
