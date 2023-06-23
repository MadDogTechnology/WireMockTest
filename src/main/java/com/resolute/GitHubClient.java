package com.resolute;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.IOException;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitHubClient {

    private static final String API_ENDPOINT = "/repos/oaydas23/test";
    private static final int WIREMOCK_PORT = 1234;
    private WireMockServer wireMockServer;
        
    public GitHubClient() {
        WireMockConfiguration configuration = WireMockConfiguration.options()
                .port(WIREMOCK_PORT);

        wireMockServer = new WireMockServer(configuration);
        
    }

    public void startServer() {
        wireMockServer.start();
        WireMock.configureFor("localhost", WIREMOCK_PORT);
    }

    public void stopServer() {
        wireMockServer.stop();
    }

    public void recordApiRequest() {
        // Start recording
        WireMock.startRecording("http://api.github.com");

        // Make the actual API request
        // Replace {owner} and {repo} with actual values
        // For example: /repos/openai/gpt-3.5
        // Make sure to configure any required headers, query parameters, etc.
        // You can use a library like Apache HttpClient or OkHttp to make the request

        // Make a GET request to the GitHub API endpoint
        // Replace {owner} and {repo} with actual values
        stubFor(get(urlMatching(API_ENDPOINT))
                .willReturn(aResponse().proxiedFrom("https://api.github.com")));

        // Stop recording and save the recorded mappings
        WireMock.stopRecording();
        wireMockServer.saveMappings();
    }

    public void replayApiRequest() {
        // Load the recorded mappings
        // wireMockServer.loadMappings();

        // Replay the recorded request
        // Make the same request that was recorded
        // Replace {owner} and {repo} with actual values
        // You can use a library like Apache HttpClient or OkHttp to make the request
        // Capture the response and process it as needed

        // Make a GET request to the WireMock server
        // Replace {owner} and {repo} with actual values
        // For example: /repos/openai/gpt-3.5
        String apiEndpoint = "/repos/oaydas23/test";
        String baseUrl = "http://localhost:" + WIREMOCK_PORT;
        // Use your preferred HTTP client library to make the request
        // Here, we're using Apache HttpClient as an example
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        // System.out.println("\n");
        // System.out.println("Line 78:");
        // System.out.println(client);
        // System.out.println("\n");
        
        Request request = new Request.Builder()
                .url(baseUrl + apiEndpoint)
                .build();

        try (Response response = client.newCall(request).execute()) {
            // Process the response as needed
            System.out.println("Replayed response status code: " + response.body().string());
            // Handle the response body, headers, etc.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
