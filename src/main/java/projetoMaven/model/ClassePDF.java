package projetoMaven.model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ClassePDF {
	
	public ClassePDF() {
		
	}

	public static <T> void geradorDePDF(ArrayList<T> lista, String nomeDoPDF) {
		Document document = new Document(PageSize.A4);

		try {

			OutputStream os = new FileOutputStream(nomeDoPDF); // no do arquivo.
			PdfWriter.getInstance(document, os);

			document.open();
			Paragraph paragraph = new Paragraph("PDF"); // nome que vai aparecer no PDF.
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			for (T elemento : lista) {
				document.add(new Paragraph("\n" + elemento.toString()));
			}
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
