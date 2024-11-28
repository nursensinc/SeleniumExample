package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureReport {

    public static void generateAllureReport() {
        String allureResultsPath = "allure-results";

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm").format(new Date());
        String allureReportPath = "reports/" + timestamp;

        try {
            File reportDir = new File(allureReportPath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            String[] command = {
                    "cmd.exe", "/c",
                    "allure generate " + allureResultsPath + " -o " + allureReportPath + " --clean"
            };

            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Allure report has been successfully generated in: " + allureReportPath);
            } else {
                System.err.println("Failed to generate Allure report. Exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error while generating Allure report: " + e.getMessage());
        }

    }
}
