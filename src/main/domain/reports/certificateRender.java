public class CertificateRender {

    public String write( String name, String course, int hours, String date, int score ) {
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

}