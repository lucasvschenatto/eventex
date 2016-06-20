package main.domain.reports;

import main.domain.Entity;
import main.domain.Text;

public class Certificate extends Entity {
	protected Text name;
	protected Text course;
	protected int hours;
	protected Text date;
	protected int score;

	public Certificate(String id, String name, String course, int hours, String date, int score){
		this(id, Text.EMPTY, Text.EMPTY, 0, Text.EMPTY, 0);
	}

	public Certificate(String id, Text name, Text course, int hours, Text date, int score){
		super(id);
		this.name = name;
		this.course = course;
		this.hours = hours;
		this.date = date;
		this.score = score;
	}

	public Certificate copy(){
		return new Certificate(id, name, course, hours, date, score);
	}

	public String getHtmlCertificate(Text name, Text course, int hours, Text date, int score){
		StringBuilder html = new StringBuilder();
        html.append( "<!doctype html>\n" );
        
        html.append( "<head>\n" );
        html.append( "<meta charset='utf-8'>\n" );
        html.append( "<title>Certificado de Conclusão</title>\n" );
        html.append( "</head>\n\n" );
        
        html.append( "<body>\n" );
        html.append( "<h1>Certificado</h1>" );
        html.append( "<p>Certificamos para os devidos fins que</p>" );
        html.append( "<h2>"+name+"</h2>" );
        html.append( "<p>Conclui com êxito o curso</p>" );
        html.append( "<h2>"+course+"</h2>" );
        html.append( "<p>Com carga horária de "+hours+" horas realizado em "+date+", O formando atingiu a obteve a pontuação de "+score+"</p>" );
        html.append( "<p>&lt;Assinatura.jpg&gt;</p>" );
        
        html.append( "</body>\n\n" );
        html.append( "</html>" );

        return html.toString();
	}

	public String getHtmlCertificate(){
		StringBuilder html = new StringBuilder();
        html.append( "<!doctype html>\n" );
        
        html.append( "<head>\n" );
        html.append( "<meta charset='utf-8'>\n" );
        html.append( "<title>Certificado de Conclusão</title>\n" );
        html.append( "</head>\n\n" );
        
        html.append( "<body>\n" );
        html.append( "<h1>Certificado</h1>" );
        html.append( "<p>Certificamos para os devidos fins que</p>" );
        html.append( "<h2>"+this.name+"</h2>" );
        html.append( "<p>Conclui com êxito o curso</p>" );
        html.append( "<h2>"+this.course+"</h2>" );
        html.append( "<p>Com carga horária de "+this.hours+" horas realizado em "+this.date+", O formando atingiu a obteve a pontuação de "+this.score+"</p>" );
        html.append( "<p>&lt;Assinatura.jpg&gt;</p>" );
        
        html.append( "</body>\n\n" );
        html.append( "</html>" );

        return html.toString();
	}

    public Text getName() {
    	return name;
    }

	public void setName(Text name) {
		this.name = name;
	}

	public Text getCourse() {
    	return course;
    }

	public void setCourse(Text course) {
		this.course = course;
	}

	public Text getDate() {
    	return date;
    }

	public void setDate(Text date) {
		this.date = date;
	}

	public int getHours() {
    	return hours;
    }

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getScore() {
    	return score;
    }

	public void setScore(int score) {
		this.score = score;
	}

    public static void main( String[] args ) {
    	// testing
        Certificate c = new Certificate("Valid ID", "Valid Name", "Valid Course", 60, "Valid Date", 10);
        String html = c.getHtmlCertificate();

        System.out.println( "The following HTML was rendered: " + new java.util.Date().toString() );
        System.out.println( html );
        System.out.println( "*** End of HTML ***" );
    }

}