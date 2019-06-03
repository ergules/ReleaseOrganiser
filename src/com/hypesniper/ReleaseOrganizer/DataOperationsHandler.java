/*
 * Saves and loads Releases to/from CSV
 * Organizes sort operations in ArrayLists
 */
package com.hypesniper.ReleaseOrganizer;

import com.hypesniper.ReleaseOrganizer.auxilliary.CSVOperations;
import com.hypesniper.ReleaseOrganizer.model.Release;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public final class DataOperationsHandler {

    private ArrayList<Release> allReleases;
    private ArrayList<Release> pastReleases;
    private static final String CSV_FILE = "./Files/Releases.csv";
    private static final String PAST_FILE = "./Files/History.csv";
    private static final String SETTINGS_FILE = "./Files/Settings.txt";

    public DataOperationsHandler() {
        allReleases = new ArrayList<>();
        pastReleases = new ArrayList<>();
        getSettingsFile(); // to create directories if they don't exist
    }

    public ArrayList<Release> getPastReleases() {
        return pastReleases;
    }

    public ArrayList<Release> getAllReleases() {
        return allReleases;
    }

    // load to ArrayLists from CSV
    public int load() {
        int expired = CSVOperations.load(allReleases, pastReleases, getCSVFile(), getPastFile());
        CSVOperations.save(allReleases, getCSVFile());
        CSVOperations.save(pastReleases, getPastFile());

        return expired;
    }

    public int load(File file) {
        int expired = CSVOperations.load(allReleases, pastReleases, file, getPastFile());
        CSVOperations.save(allReleases, getCSVFile());
        CSVOperations.save(pastReleases, getPastFile());

        return expired;
    }

    // save content of all releases arrayList in a CSV file
    public void save() {
        CSVOperations.save(allReleases, getCSVFile());
    }

    public boolean save(File file) {
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("exception in dataophand.save(file)");
        }
        return CSVOperations.save(allReleases, file);
    }

    // save content of past releases array to CSV file
    public void saveHistory() {
        CSVOperations.save(pastReleases, getPastFile());
    }

    public File getCSVFile() {
        File csv = new File(CSV_FILE);
        try {
            csv.createNewFile();
        } catch (Exception e) {
        }
        return csv;
    }

    public File getPastFile() {
        File past = new File(PAST_FILE);
        try {
            past.createNewFile();
        } catch (Exception e) {
        }
        return past;
    }

    public File getSettingsFile() {
        File settingsFile = new File(SETTINGS_FILE);
        try {
            File folder = new File("./Files");
            if (!folder.exists()) {
                folder.mkdir();
            }
            settingsFile.createNewFile();
        } catch (Exception e) {
            System.out.println("error in  DataOperationsHandler.getSettingsFile method ");
        }
        return settingsFile;
    }

    // dumps csv file under Files/dump directory
    // method is called from import and delete all methods in edit tab
    public void dump() {

        SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd HH.mm");
        String today = ft.format(new Date());
        File csv = getCSVFile();
        File dest = new File("./Files/dump/" + today + "/");
        dest.mkdirs();
        if (csv.renameTo(new File(dest + "/Releases.csv"))) {
            System.out.println("dump success");
        } else {
            System.out.println("dump unseccessfull"); //below method would replace existing dump
//            File finaltry = new File(dest + "/Releases.csv");
//            try {
//                finaltry.createNewFile();
//            } catch (IOException ex) {
//                System.out.println("can't create dump file");
//            }
//            save(finaltry);
        }

    }

    // Reads Files/settings file and returns value of alertBefore
    public int getAlertBefore() {
        int alertBefore = 15;
        try {
            File folder = new File("./Files");
            if (!folder.exists()) {
                folder.mkdir();
            }
            File settingsFile = getSettingsFile();

            BufferedReader br = new BufferedReader(new FileReader(settingsFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split("=")[0].toLowerCase().contains("alertbefore")) {
                    alertBefore = Integer.parseInt(line.split("=")[1]);
                    break;
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("exception in DataOperationsHandler.getAlertBefore");
        }

        return alertBefore;
    }

    public void setAlertBefore(int mins) {
        if (mins < 3) {
            mins = 3;
        }
        changeSetting("alertbefore", Integer.toString(mins));
    }

    // could be done in an easier way
    // but id there were more to save for settings
    // this method is safe
    private void changeSetting(String key, String val) {
        File settingsFile = getSettingsFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
            String line; //System.getProperty("line.separator")
            StringBuffer buffer = new StringBuffer();
            boolean match = false;
            while ((line = reader.readLine()) != null) {
                if (line.split("=")[0].toLowerCase().contains(key.toLowerCase())) {
                    buffer.append(key + "=" + val);
                    match = true;
                } else {
                    buffer.append(line);
                }
                buffer.append(System.getProperty("line.separator"));
            }
            if (!match) {
                buffer.append(key + "=" + val);
            }
            reader.close();

            FileOutputStream fileOut = new FileOutputStream(settingsFile);
            fileOut.write(buffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("excepition in DataOperationsHandler.changeLine");
        }
    }
}
