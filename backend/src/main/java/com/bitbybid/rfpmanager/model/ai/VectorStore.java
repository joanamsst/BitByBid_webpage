package com.bitbybid.rfpmanager.model.ai;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class VectorStore {

    private String documentContent;

    public void init() {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/rag/*.pdf");

            StringBuilder allContent = new StringBuilder();
            for (Resource resource : resources) {
                try (InputStream is = resource.getInputStream();
                     PDDocument document = PDDocument.load(is)) {

                    PDFTextStripper stripper = new PDFTextStripper();
                    allContent.append(stripper.getText(document)).append("\n\n");
                }
            }

            this.documentContent = allContent.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar os PDFs do diretório rag/", e);
        }
    }

    public List<String> search(String query) {
        // Devolve o conteúdo combinado de todos os PDFs
        return List.of(documentContent);
    }
}
