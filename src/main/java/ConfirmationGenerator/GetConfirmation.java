package ConfirmationGenerator;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class GetConfirmation {
    private final String myNameCampany = "SerwTel";
    private final String myNipCampany = "1234567890";
    private final String myStreetCampany = "Złota 59";
    private final String myPostCodeCampany = "00-819 Warszawa";
    private final String myNumberPhone = "+48 500 500 500";
    private String idOrder;
    private String dateOrder;
    private String modelPhone;
    private String problem;
    private String nameCustomer;
    private String nipCustomer;
    private String streetCustomer;
    private String postCodeCustomer;
    private String cityCustomer;
    private String numberPhoneCustomer;

    public GetConfirmation() {
        generateData();
    }

    public void execute() throws DocumentException, IOException {
        String file = "Invoice/potwierdzenie" + idOrder + ".pdf";
        new GetConfirmation().createPdf(file);
        File myFile = new File(file);
        Desktop.getDesktop().open(myFile);
    }

    private void createPdf(String filename)
            throws DocumentException, IOException {
        Document document = new Document();
        BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 8);
        PdfWriter.getInstance(document, new FileOutputStream(filename));

        document.open();

        Paragraph date = new Paragraph();
        date.setAlignment(Element.ALIGN_RIGHT);
        date.add("Warszawa, " + dateOrder);
        document.add(date);

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add("Potwierdzenie przyjecia do serwisu");
        document.add(title);
        Paragraph nrOrder = new Paragraph();
        nrOrder.setAlignment(Element.ALIGN_CENTER);
        nrOrder.add("Numer zlecenia: " + idOrder);
        document.add(nrOrder);

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        document.add(dataCustomerHeader());

        document.add(new Phrase("\n"));

        document.add(new Paragraph("Model telefonu"));
        document.add(new Phrase(modelPhone, font));

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        document.add(new Paragraph("Opis usterki"));
        document.add(new Phrase(problem, font));

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        document.add(signatures());

        document.close();
    }

    private PdfPTable dataCustomerHeader() throws DocumentException, IOException {
        BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 9);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        PdfPCell myDataCampany = new PdfPCell(new Phrase("Dane serwisu:" + "\n \n" + myNameCampany + "\n" + "NIP: " + myNipCampany + "\n" + myStreetCampany + "\n" + myPostCodeCampany + "\n" + myNumberPhone + "\n", font));
        PdfPCell customerData = new PdfPCell(new Phrase("Dane klienta: " + "\n \n" + nameCustomer + "\n" + "NIP: " + nipCustomer + "\n" + streetCustomer + "\n" + postCodeCustomer + " " + cityCustomer + "\n" + numberPhoneCustomer, font));

        myDataCampany.setBorder(Rectangle.NO_BORDER);
        customerData.setBorder(Rectangle.NO_BORDER);
        table.addCell(myDataCampany);
        table.addCell(customerData);

        return table;
    }

    private PdfPTable signatures() throws DocumentException, IOException {
        BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font font = new Font(baseFont, 9);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);

        PdfPCell signatureCustomer = new PdfPCell(new Phrase(".............................................. \n Podpis klienta", font));
        PdfPCell signatureService = new PdfPCell(new Phrase(".............................................. \n Podpis serwisu", font));

        signatureCustomer.setBorder(Rectangle.NO_BORDER);
        signatureService.setBorder(Rectangle.NO_BORDER);
        table.addCell(signatureCustomer);
        table.addCell(signatureService);

        return table;
    }

    private void generateData() {
        GeneratorHelper generatorHelper = new GeneratorHelper();
        generatorHelper.execute();

        Object[] result = generatorHelper.resultList.get(0);
        idOrder = String.valueOf(result[0]);
        dateOrder = String.valueOf(result[1]);
        modelPhone = String.valueOf(result[2]);
        problem = String.valueOf(result[3]);
        nameCustomer = String.valueOf(result[4]);
        nipCustomer = String.valueOf(result[5]);
        streetCustomer = String.valueOf(result[6]);
        postCodeCustomer = String.valueOf(result[7]);
        cityCustomer = String.valueOf(result[8]);
        numberPhoneCustomer = String.valueOf(result[9]);
    }
}

