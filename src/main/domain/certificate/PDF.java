package main.domain.certificate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	private String course;
	private String courseDate;
	private String name;
	private String duration;
	private String score;
	private String certificateDate;
	private String uuid;
	private String fileName;
	private String location;
	
	public PDF(Certificate certificate, String location){
		this.course = certificate.course.toString();
		this.courseDate = certificate.getCourseDate().toString();
		this.name = certificate.getName().toString();
		this.duration = certificate.getDuration().toString();
		this.score = certificate.getScore().toString();
		this.certificateDate = certificate.getCertificateDate().toString();
		this.uuid = UUID.randomUUID().toString().replaceAll("-","");
		this.fileName = course + "_" + name + "_" + uuid +"_"+ ".pdf";
		this.location = location;
	}

	public String create() {
		String fullPath = location.concat("/".concat(fileName));
		try {
			File f = new File(fullPath);
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			document.open();
	        document.add(new Paragraph("Certificamos que " + name +" participou da seguinte atividade:"));
	        document.add(new Paragraph(course));
	        document.add(new Paragraph("Com duração de: "+duration+"minutos, na data: "+courseDate+", obtendo a nota: "+score+"."));
	        document.add(new Paragraph("Porto Alegre, "+certificateDate));
	        document.close();
	        writer.close();
			
		} catch ( IOException | DocumentException ignored) {
			return "";
		}
		return fullPath;
	}

}
