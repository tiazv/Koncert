package com.koncert.ris.models;

/*import com.itextpdf.io.font.FontConstants;

import com.itextpdf.kernel.color.Color;*/
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
public class PdfTextFornat {
    public static void main(String args[]) throws Exception
    {
        String file
                = "D:\\FERI\\2. letnik\\3. semester\\RIS\\File.pdf";

        // Creating a PdfDocument object
        PdfDocument pdfDoc
                = new PdfDocument(new PdfWriter(file));

        // Creating a Document object
        Document doc = new Document(pdfDoc);

        // Adding text to the document
        Text text1 = new Text("Hi I'm Elena");

        // Setting color to the text
        /*text1.setFontColor(Color.BLACK);

        // Setting font to the text
        /*text1.setFont(PdfFontFactory.createFont(
            FontConstants.HELVETICA));*/

        // Creating a paragraph 1
        Paragraph para1 = new Paragraph(text1);

        Text text2 = new Text(
                "I'm (ful) smart!");

        // Setting color to the text
        /*text2.setFontColor(Color.BLACK);

        // Setting font to the text
        /*text2.setFont(PdfFontFactory.createFont(
            FontConstants.HELVETICA));*/

        // Creating a paragraph 2
        Paragraph para2 = new Paragraph(text2);

        // Adding paragraphs to the document
        doc.add(para1);
        doc.add(para2);

        // Closing the document
        doc.close();
        System.out.println("Text added successfully..");
    }
}
