package com.rnko.webportal.ui.utils;


import java.io.*;

public class JiraServer {

    File jiraDirectory;
    String scriptManagementServer;
    File logFile;

    public JiraServer(String jiraDirectory, String scriptManagementServer) {
        this.jiraDirectory = new File(jiraDirectory);
        this.scriptManagementServer = scriptManagementServer;
        this.logFile = new File(jiraDirectory + "\\log.txt");
    }

    public void StartServer() throws IOException {
        FileWriter writer = new FileWriter(logFile.getPath(), false);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(jiraDirectory);
        processBuilder.command(scriptManagementServer, "start");
        Process process;
        process = processBuilder.start();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line + "\r\n");
        }
        writer.flush();
    }

    public void StopServer() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(scriptManagementServer, "stop");
        processBuilder.start();
    }

    public String CheckStatusServer() throws IOException  {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(scriptManagementServer, "check");
        Process process;
        process = processBuilder.start();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine();
    }
}
