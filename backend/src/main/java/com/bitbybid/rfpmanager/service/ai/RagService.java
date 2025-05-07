package com.bitbybid.rfpmanager.service.ai;

import com.bitbybid.rfpmanager.model.ai.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class RagService {

    private final VectorStore vectorStore;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ai.rag_prompt_template}")
    private Resource promptTemplate;

    public RagService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
        this.vectorStore.init();
    }

    public String buildPrompt(String query) {
        try {
            List<String> documents = vectorStore.search(query);

            String context = String.join("\n---\n", documents);

            Reader reader = new InputStreamReader(promptTemplate.getInputStream(), StandardCharsets.UTF_8);
            String template = FileCopyUtils.copyToString(reader);

            return template
                    .replace("${context}", context)
                    .replace("${query}", query);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar prompt com RAG", e);
        }
    }
}
