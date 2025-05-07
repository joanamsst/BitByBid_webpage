package com.bitbybid.rfpmanager.service.ai;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;

@Service
public class PromptBuilderService {

    public String buildFewShotPromptFromExamples() {
        try {
            // Lê o ficheiro único com bons e maus exemplos
            ClassPathResource resource = new ClassPathResource("rag/examples.pdf");
            try (InputStream is = resource.getInputStream();
                 PDDocument document = PDDocument.load(is)) {

                PDFTextStripper stripper = new PDFTextStripper();
                String content = stripper.getText(document);

                StringBuilder prompt = new StringBuilder("Aqui estão exemplos de RFPs aceites e rejeitados:\n\n");
                prompt.append(content);
                prompt.append("\nAgora analisa o seguinte formulário e gera um RFP bem estruturado com base no estilo dos aceites:\n\n");

                return prompt.toString();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o PDF com os exemplos: " + e.getMessage(), e);
        }
    }
}