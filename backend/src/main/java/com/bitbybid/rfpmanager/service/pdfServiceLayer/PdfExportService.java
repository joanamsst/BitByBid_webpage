package com.bitbybid.rfpmanager.service.pdfServiceLayer;

import com.bitbybid.rfpmanager.model.RfpForm;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfExportService {

    public ByteArrayInputStream exportToPdf(List<RfpForm> responses) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font sectionTitleFont = new Font(Font.HELVETICA, 14, Font.BOLDITALIC);
            Font contentFont = new Font(Font.HELVETICA, 12);

            document.add(new Paragraph("RFP Response Package", titleFont));
            document.add(Chunk.NEWLINE);

            for (RfpForm form : responses) {
                document.add(new Paragraph("Project Name: " + form.getProjectName(), titleFont));
                document.add(new Paragraph("Company Name: " + form.getCompanyName(), contentFont));
                document.add(new Paragraph("RFP Date: " + form.getRfpDate(), contentFont));
                document.add(new Paragraph("End Date: " + form.getEndDate(), contentFont));
                document.add(new Paragraph("Goal: " + form.getProjectGoal(), contentFont));
                document.add(new Paragraph("Technical Description: " + form.getTechnicalDescription(), contentFont));
                document.add(new Paragraph("Integration Plan: " + form.getIntegrationPlan(), contentFont));
                document.add(new Paragraph("Data Security: " + form.getDataSecurity(), contentFont));
                document.add(new Paragraph("Total Price: $" + form.getTotalPrice(), contentFont));
                document.add(new Paragraph("Support and Warranty: " + form.getSupportAndWarranty(), contentFont));
                document.add(Chunk.NEWLINE);

                if (form.getCronogram() != null && !form.getCronogram().isEmpty()) {
                    document.add(new Paragraph("Project Phases:", sectionTitleFont));
                    for (var phase : form.getCronogram()) {
                        document.add(new Paragraph(" - Phase: " + phase.getPhaseName(), contentFont));
                        document.add(new Paragraph("   Start: " + phase.getStartDate(), contentFont));
                        document.add(new Paragraph("   End: " + phase.getEndDate(), contentFont));
                        document.add(new Paragraph("   Deliverables: " + phase.getDeliverables(), contentFont));
                    }
                    document.add(Chunk.NEWLINE);
                }

                if (form.getCompanyCertifications() != null && !form.getCompanyCertifications().isEmpty()) {
                    document.add(new Paragraph("Company Certifications:", sectionTitleFont));
                    for (var cert : form.getCompanyCertifications()) {
                        document.add(new Paragraph(" - " + cert.getCertificationName(), contentFont));
                    }
                    document.add(Chunk.NEWLINE);
                }

                if (form.getTechnicalTeam() != null && !form.getTechnicalTeam().isEmpty()) {
                    document.add(new Paragraph("Technical Team:", sectionTitleFont));
                    for (var member : form.getTechnicalTeam()) {
                        document.add(new Paragraph(" - Name: " + member.getMemberName(), contentFont));
                        document.add(new Paragraph("   Role: " + member.getRole(), contentFont));
                        document.add(new Paragraph("   Specialization: " + member.getSpecialization(), contentFont));
                    }
                    document.add(Chunk.NEWLINE);
                }

                document.add(new LineSeparator());
                document.add(Chunk.NEWLINE);
            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}