package ConfirmationGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


public class GetConfirmation {

    private final String RESULT = "Invoice/potwierdzenie.pdf";
    private final String myNameCampany = "SerwTel";
    private final String myNipCampany = "1234567890";
    private final String myStreetCampany = "Złota 59";
    private final String myPostCodeCampany = "00-819 Warszawa";
    private final String myNumberPhone = "+48 500 500 500";

    public void execute() throws DocumentException, IOException {
        new GetConfirmation().createPdf(RESULT);
    }
    private void createPdf(String filename)
            throws DocumentException, IOException {
        Document document = new Document();
        BaseFont bf1 = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font french = new Font(bf1, 8);
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        Paragraph date = new Paragraph();
        date.setAlignment(Element.ALIGN_RIGHT);
        date.add("Warszawa, 22.02.2018");
        document.add(date);

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add("Potwierdzenie przyjecia do serwisu");
        document.add(title);
        Paragraph nrOrder = new Paragraph();
        nrOrder.setAlignment(Element.ALIGN_CENTER);
        nrOrder.add("Numer zlecenia: 111");
        document.add(nrOrder);

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        document.add(dataCustomerHeader());

        document.add(new Phrase("\n"));

        document.add(new Paragraph("Model telefonu"));
        document.add(new Phrase("Samsung Galaxy J5 2017",french));

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));

        document.add(new Paragraph("Opis usterki"));
        document.add(new Phrase("Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis" +
                "lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras" +
                "egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est" +
                "molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl" +
                "Phasellus in felis. Nulla tempor augue ac ipsum. Phasellus vitae" +
                "lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo." +
                "luctus felis purus ac tellus. Suspendisse sed dolor. Fusce mi" +
                "consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales" +
                "urna. Vivamus molestie dapibus ligula. Aliquam erat volutpat. Nulla dignissim." +
                "dapibus id, blandit at, nisi. Cum sociis natoque penatibus et" +
                "mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio.",french));

        document.add(new Phrase("\n"));
        document.add(new Phrase("\n"));
        document.add(signatures());
        document.close();
    }

    private PdfPTable dataCustomerHeader() throws DocumentException, IOException {
        BaseFont bf1 = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font french = new Font(bf1, 9);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        PdfPCell myDataCampany = new PdfPCell(new Phrase("Dane serwisu:" + "\n \n" + myNameCampany + "\n"+"NIP: " + myNipCampany + "\n" + myStreetCampany + "\n" + myPostCodeCampany + "\n" + myNumberPhone + "\n", french));
        PdfPCell customerData = new PdfPCell(new Phrase("Dane klienta: " + "\n \n" + "Marcin Goławski" + "\n" + "Zarzecz Lukowski 27" + "\n" + "21-400 Lukow" + "\n" + "505333022", french));

        myDataCampany.setBorder(Rectangle.NO_BORDER);
        customerData.setBorder(Rectangle.NO_BORDER);
        table.addCell(myDataCampany);
        table.addCell(customerData);

        return table;
    }
    private PdfPTable signatures() throws DocumentException, IOException {
        BaseFont bf1 = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.CP1250, BaseFont.EMBEDDED);
        Font french = new Font(bf1, 9);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        PdfPCell signatureCustomer = new PdfPCell(new Phrase(".............................................. \n Podpis klienta", french));
        PdfPCell signatureService = new PdfPCell(new Phrase(".............................................. \n Podpis serwisu", french));

        signatureCustomer.setBorder(Rectangle.NO_BORDER);
        signatureService.setBorder(Rectangle.NO_BORDER);
        table.addCell(signatureCustomer);
        table.addCell(signatureService);

        return table;
    }
}

