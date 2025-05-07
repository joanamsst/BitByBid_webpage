package com.bitbybid.rfpmanager.service.pdfServiceLayer;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfGeneratorService {

    public byte[] generatePdfFromText(String content) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph(content));
            document.close();
            return out.toByteArray();
        } catch (DocumentException e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
