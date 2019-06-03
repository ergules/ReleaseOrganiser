/*
 * Stores the info of Releases
 * Everything except link and isearlyLink can be left blank
 * 
 */
package com.hypesniper.ReleaseOrganizer.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Release {

    private Date date;
    private String bot;
    private String shopify;
    private boolean isEarlyLink;
    private String link;
    private String queue;
    private String notes;

    public Release() {
    }

    public Release(Date date, String bot, String shopify, boolean el, String sl, String queue, String notes) {
        this.date = date;
        this.bot = bot;
        this.isEarlyLink = el;
        this.shopify = shopify;
        this.link = sl;
        this.queue = queue;
        this.notes = notes;
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        if (date == null) {
            return "";
        }
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return ft.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBot() {
        return bot;
    }

    public void setBot(String bot) {
        this.bot = bot;
    }

    public String getShopify() {
        return shopify;
    }

    public void setShopify(String shopify) {
        this.shopify = shopify;
    }

    public boolean getisEarlyLink() {
        return isEarlyLink;
    }

    public void setisEarlyLink(boolean earlyLink) {
        this.isEarlyLink = earlyLink;
    }

    public String getLink() {
        return link;
    }

    public String getTrimmedLink() {
        return trimURLPrefix(link);
    }

    public void setLink(String siteLink) {
        this.link = siteLink;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // removes http, https and www. from beginning of a string
    private String trimURLPrefix(String urlStr) {
        String trimmedUrl;
        trimmedUrl = urlStr.replaceFirst("^(http://|https://)", "");
        trimmedUrl = trimmedUrl.replaceFirst("^(www\\.)", "");
        return trimmedUrl;
    }

//        public static void main(String args[]) {
//        
//            Release r = new Release();
//            System.out.println(r.getFormattedDate());
//            r.setDate(new Date());
//            System.out.println(r.getDate());
//            System.out.println(r.getFormattedDate());
//                    
//        }
}
