package com.bitbybid.rfpmanager.controller.ai;

import com.bitbybid.rfpmanager.service.ai.RagService;
import com.bitbybid.rfpmanager.service.pdfServiceLayer.PdfGeneratorService;
import com.bitbybid.rfpmanager.service.ai.PromptBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ai-analysis")
@CrossOrigin(
        origins = "http://ec2-13-60-169-55.eu-north-1.compute.amazonaws.com",
        allowedHeaders = "*",
        methods = {RequestMethod.POST},
        exposedHeaders = {"Content-Disposition"}
)public class AiAnalysisController {

    @Autowired
    private PromptBuilderService promptBuilderService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;
    @Autowired
    private RagService ragService;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "${OPENAI_API_KEY}"; // substitui antes de fazer deploy

    /**
     * Endpoint original para simples análise de aceitação.
     */
    @PostMapping
    public ResponseEntity<?> analyzeRfpData(@RequestBody Map<String, Object> rfpData) {
        try {
            String prompt = "Analisa este RFP e diz se tem alta ou baixa probabilidade de aceitação:\n\n" + rfpData;

            return sendToOpenAi(prompt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro na chamada à IA: " + e.getMessage());
        }
    }

    @PostMapping("/generate-structured")
    public ResponseEntity<?> generateStructuredRfp(@RequestBody Map<String, Object> rfpData) {
        try {
            // 1. Cria o prompt baseado nos exemplos
            String basePrompt = promptBuilderService.buildFewShotPromptFromExamples();
            String finalPrompt = basePrompt + rfpData;

            // 2. Envia o prompt para o ChatGPT
            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(Map.of("role", "user", "content", finalPrompt)),
                    "temperature", 0.7
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    "https://api.openai.com/v1/chat/completions",
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<>() {}
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                List<?> choices = (List<?>) response.getBody().get("choices");
                if (!choices.isEmpty()) {
                    Map<?, ?> firstChoice = (Map<?, ?>) choices.get(0);
                    Map<?, ?> message = (Map<?, ?>) firstChoice.get("message");
                    String content = (String) message.get("content");

                    // 3. Gerar o PDF com o conteúdo da IA
                    byte[] pdfBytes = pdfGeneratorService.generatePdfFromText(content);

                    // 4. Devolver o ficheiro PDF
                    HttpHeaders pdfHeaders = new HttpHeaders();
                    pdfHeaders.setContentType(MediaType.APPLICATION_PDF);
                    pdfHeaders.setContentDisposition(ContentDisposition.attachment().filename("generated_rfp.pdf").build());

                    return new ResponseEntity<>(pdfBytes, pdfHeaders, HttpStatus.OK);
                }
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível obter resposta da IA.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao gerar RFP estruturado: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar que envia o prompt para o ChatGPT e devolve a resposta.
     */
    private ResponseEntity<?> sendToOpenAi(String prompt) {
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(Map.of("role", "user", "content", prompt)),
                "temperature", 0.7
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                "https://api.openai.com/v1/chat/completions",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<>() {}
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<?> choices = (List<?>) response.getBody().get("choices");
            if (!choices.isEmpty()) {
                Map<?, ?> firstChoice = (Map<?, ?>) choices.get(0);
                Map<?, ?> message = (Map<?, ?>) firstChoice.get("message");
                String content = (String) message.get("content");
                return ResponseEntity.ok(content);
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Não foi possível obter resposta da IA.");
    }
    @PostMapping("/generate-rfp-rag")
    public ResponseEntity<?> generateRfpUsingRag(@RequestBody Map<String, Object> formData) {
        try {
            String query = formData.toString();
            String finalPrompt = ragService.buildPrompt(query);

            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(Map.of("role", "user", "content", finalPrompt)),
                    "temperature", 0.7
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    "https://api.openai.com/v1/chat/completions",
                    HttpMethod.POST,
                    request,
                    new ParameterizedTypeReference<>() {}
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                List<?> choices = (List<?>) response.getBody().get("choices");
                if (!choices.isEmpty()) {
                    Map<?, ?> firstChoice = (Map<?, ?>) choices.get(0);
                    Map<?, ?> message = (Map<?, ?>) firstChoice.get("message");
                    String content = (String) message.get("content");

                    // 🔽 Aqui é onde geras o PDF
                    byte[] pdfBytes = pdfGeneratorService.generatePdfFromText(content);

                    HttpHeaders pdfHeaders = new HttpHeaders();
                    pdfHeaders.setContentType(MediaType.APPLICATION_PDF);
                    pdfHeaders.setContentDisposition(ContentDisposition.attachment().filename("generated_rfp.pdf").build());

                    return new ResponseEntity<>(pdfBytes, pdfHeaders, HttpStatus.OK);
                }
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível obter resposta da IA.");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro na geração do RFP com RAG: " + e.getMessage());
        }
    }
}
