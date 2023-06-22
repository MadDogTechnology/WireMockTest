package com.resolute;

public class Main {
    public static void main(String[] args) {
        GitHubClient recorderReplayer = new GitHubClient();
        recorderReplayer.startServer();

        // Record the API request
        // recorderReplayer.recordApiRequest();

        // Replay the recorded request
        System.out.println("\n");
        System.out.println("--------------------------------------------------");
        recorderReplayer.replayApiRequest();
        System.out.println("--------------------------------------------------");
        System.out.println("\n");

        recorderReplayer.stopServer();
    }
}
