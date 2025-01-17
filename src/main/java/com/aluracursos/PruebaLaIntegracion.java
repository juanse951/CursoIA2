package com.aluracursos;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.Arrays;


public class PruebaLaIntegracion {
    public static void main(String[] args) {

        String apiKey = System.getenv("OPENAI_APIKEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("Error: La variable de entorno 'OPENAI_APIKEY' no está configurada.");
            return;
        }

        var user = "Genera 5 productos";
        var system = "Eres un generador de productos de un E-comerce de " +
                "electronicos y debes responder solo el nombre del producto " +
                "por ejemplo: Aspiradora , Televisíon";

        var service = new OpenAiService(apiKey);
        var request = ChatCompletionRequest.builder()
                .model("gpt-4o-mini")
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.USER.value(), user),
                        new ChatMessage(ChatMessageRole.SYSTEM.value(), system)
                ))
                        .build();
        service.createChatCompletion(request).getChoices().forEach(System.out::println);
    }
}
