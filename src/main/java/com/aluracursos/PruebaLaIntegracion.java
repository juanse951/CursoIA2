package com.aluracursos;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;


public class PruebaLaIntegracion {
    public static void main(String[] args) {
        var user = "Genera 5 productos";
        var system = "Eres un generador de productos de un E-comerce de " +
                "electronicos y debes responder solo el nombre del producto " +
                "por ejemplo: Aspiradora , Televisíon";

        var service = new OpenAiService("your_token");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Somebody once told me the world is gonna roll me")
                .model("babbage-002"")
                        .echo(true)
                        .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
