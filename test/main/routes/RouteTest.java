package main.routes;

import main.Main;
import main.persistence.inmemory.InMemoryFactory;

import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

public abstract class RouteTest {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final String PORT = System.getenv("PORT");
    
    @Test
    public abstract void responseCodeForNoRequestBody() throws Exception;

    @BeforeClass
    public static void setUpClass() throws Exception{
    	InMemoryFactory.reset();
    	Main.setFactory(InMemoryFactory.getInstance());
    	Main.main();
    	Spark.awaitInitialization();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Spark.stop();
    }

    protected void assertRouteResponse(String method, String path, String expectedResponse) throws Exception {
        HttpURLConnection connection = makeConnection(path);
        writeRequestHeader(method, connection);
        assertResponse(expectedResponse, connection);
    }

    protected void assertRouteResponse(String method, String path, String requestBody, String expectedResponse) throws Exception {
        byte[] bodyBytes = requestBody.getBytes(UTF_8);
        HttpURLConnection connection = makeConnection(path);
        writeRequestHeader(method, connection, bodyBytes);
        writeRequestBody(connection, bodyBytes);
        assertResponse(expectedResponse, connection);
    }
    
    protected void assertRouteResponse(String method, String path, int expectedResponseCode) throws Exception {
        HttpURLConnection connection = makeConnection(path);
        writeRequestHeader(method, connection);
        assertResponseCode(expectedResponseCode, connection);
    }

    private HttpURLConnection makeConnection(String path) throws IOException {
    	String validPort = PORT != null? PORT: "8080";
        return (HttpURLConnection) new URL("http://localhost:" + validPort + path).openConnection();
    }

    private void writeRequestHeader(String method, HttpURLConnection connection) throws ProtocolException {
        connection.setRequestMethod(method);
        connection.setUseCaches(false);
        connection.setDoOutput(true);
    }

    private void writeRequestHeader(String method, HttpURLConnection connection, byte[] bodyBytes) throws ProtocolException {
        writeRequestHeader(method, connection);
        connection.setRequestProperty("Content-Length", String.valueOf(bodyBytes.length));
    }

    private void writeRequestBody(HttpURLConnection connection, byte[] bodyBytes) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(bodyBytes);
        outputStream.close();
    }
    
    private void assertResponseCode(int expectedResponse, HttpURLConnection connection) throws IOException {
    	assertEquals(expectedResponse , connection.getResponseCode());
    }

    private void assertResponse(String expectedResponse, HttpURLConnection connection) throws IOException {
        assertEquals(expectedResponse + "\r", getResponse(connection));
    }

	private String getResponse(HttpURLConnection connection) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = inputReader.readLine()) != null) {
            responseBuilder.append(line);
            responseBuilder.append('\r');
        }
        inputReader.close();
        return responseBuilder.toString();
    }
}
