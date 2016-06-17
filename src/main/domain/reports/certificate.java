public class Certificate {
    public static void main( String[] args ) {

        CertificateRender render = new Certificate();
        String renderedHtml = render.write( "Valid Name", "Valid Course", 10, "Valid Date", 10 );

        System.out.println( "The following HTML was rendered: " + new java.util.Date().toString() );
        System.out.println( renderedHtml );
        System.out.println( "*** End of HTML ***" );
    }

}