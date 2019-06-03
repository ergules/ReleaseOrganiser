/*
Creates a thread, iterates over all Releases and checkif it is time for alert.
If so a messagebox will be displayed on desktop
 */
package com.hypesniper.ReleaseOrganizer.auxilliary;

import com.hypesniper.ReleaseOrganizer.DataOperationsHandler;
import com.hypesniper.ReleaseOrganizer.model.Release;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.SwingWorker;

public class AlertWorker extends SwingWorker<String, Integer> {

    DataOperationsHandler opHandler;

    public AlertWorker(DataOperationsHandler op) {
        this.opHandler = op;
    }

    @Override
    protected String doInBackground() throws Exception {
        ArrayList<Release> releases = opHandler.getAllReleases();

        int mins = opHandler.getAlertBefore(); // gets alert before time, default 15mins

        Date compareBefore = new Date(System.currentTimeMillis() + (mins + 1) * 60 * 1000); //adds before time to current time 
        Date compareAfter = new Date(System.currentTimeMillis() + mins * 60 * 1000);        // to compare
        Date eventDate;
        System.out.print("checking upcoming releases in background  : @");
        System.out.println(compareAfter);

        int i = 0; // stores popup/panel count to prevent overlay

        for (Release rel : releases) {

            eventDate = rel.getDate();
            if (eventDate == null) {
                continue;
            }
   
            if (eventDate.after(compareAfter) && eventDate.before(compareBefore)) {     // if it is time for alert
                DesktopNotification notification = new DesktopNotification(rel, ++i);   // run notification on desktop
                notification.setVisible(true);
                Toolkit.getDefaultToolkit().beep();
            }

        }

        return "complete";
    }

}
