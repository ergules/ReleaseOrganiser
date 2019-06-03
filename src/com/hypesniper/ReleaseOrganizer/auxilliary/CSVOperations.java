/*
A static class to handle save releases as CSV files and load back.
 */
package com.hypesniper.ReleaseOrganizer.auxilliary;

import com.hypesniper.ReleaseOrganizer.model.Release;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CSVOperations {

    //saves given array of releases to given file
    public static boolean save(ArrayList<Release> ary, File outputFile) {

        try {
            FileWriter writer = new FileWriter(outputFile);

            writer.write("Date, Bot, Shopify, EarlyLink, SiteLink, Queue, Notes");
            for (Release r : ary) {
                writer.write("\r\n");
                writer.write("\"");
                writer.write(r.getFormattedDate());
                writer.write("\",\"");
                writer.write(r.getBot());
                writer.write("\",\"");
                writer.write(r.getShopify());
                writer.write("\",\"");
                writer.write(r.getisEarlyLink() ? "true" : "false");
                writer.write("\",\"");
                writer.write(r.getLink());
                writer.write("\",\"");
                writer.write(r.getQueue());
                writer.write("\",\"");
                writer.write(r.getNotes());
                writer.write("\"");
            }
            writer.close();
            System.out.println("written to file : " + outputFile.getPath());
        } catch (IOException ex) {
            System.out.println("Exception in CSVOp.save()");
            return false;
        }
        return true;

    }

    // loads releases to given arrays from given files
    // returns count of expired releases
    public static int load(ArrayList<Release> releases, ArrayList<Release> past, File csvFile, File pastFile) {
        releases.clear();
        past.clear();
        BufferedReader br = null;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        int expired = 0;
        String line = "";
        try {

            br = new BufferedReader(new FileReader(pastFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) { // first load past file
                past.add(crtRelease(line));
            }
            br.close();

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) { // first load past file
                Release release = crtRelease(line);
                if (checkExpire(release)) {
                    past.add(release);
                    expired++;
                } else {
                    releases.add(release);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return expired;
    }

    // creates a new release from a line of string(a line of CSV file)
    private static Release crtRelease(String line) {
        String[] values = line.split(","); // use comma as separator
        Release release = new Release();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            release.setDate(ft.parse(values[0].replaceAll("^\"|\"$", "")));
        } catch (Exception e) {
            release.setDate(null);
        }
        release.setBot(values[1].replaceAll("^\"|\"$", ""));
        release.setShopify(values[2].replaceAll("^\"|\"$", ""));
        release.setisEarlyLink(Boolean.parseBoolean(values[3].replaceAll("^\"|\"$", "")));
        release.setLink(values[4].replaceAll("^\"|\"$", ""));
        release.setQueue(values[5].replaceAll("^\"|\"$", ""));
        release.setNotes(values[6].replaceAll("^\"|\"$", ""));

        return release;
    }

    //detects if a given release is due to yesterday or older
    private static boolean checkExpire(Release rel) { // return true if expired
        Date today = new Date();
        today.setHours(23);
        today.setMinutes(59);
        today.setSeconds(0);
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, -1);
        Date yesterday = c.getTime();
        if (rel.getDate() == null) {
            return false;
        } else {
            return rel.getDate().before(yesterday);
        }
    }

}
