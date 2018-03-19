package panelcustomerslist.addcustomer.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;

public class FindsDataCampany {

    public static String nameFound;
    public static String streetFound;
    public static String postCodeFound;
    public static String cityFound;
    public static String urlToSearch;
    AddCustomerFrameController addCustomerFrameController = new AddCustomerFrameController();
    String nipToFind = addCustomerFrameController.addNipCustomer;


    public FindsDataCampany() {
        takeData();
    }

    private void takeData() {


        try {
            Document doc = Jsoup.connect("http://www.krs-online.com.pl/?p=25&lookn=" + nipToFind + "&sprawdz=Sprawd%BC").userAgent("mozilla/17.0").get();
            Elements name2 = doc.select("#main > div:nth-child(7) > span");
            if (name2.text().equals("Podany NIP jest niepoprawny!!!")) {
                JOptionPane.showMessageDialog(null, name2.text());
            } else {
                Elements name1 = doc.select("#main > div:nth-child(7) > p > a");
                for (Element el : name1) {
                    urlToSearch = el.absUrl("href");
                }

                doc = Jsoup.connect(urlToSearch).userAgent("mozilla/17.0").get();
                Elements name = doc.select("#main > div:nth-child(4) > table:nth-child(1) > tbody > tr:nth-child(1) > th > b");
                for (Element el : name) {
                    nameFound = el.text();
                }


                for (int i = 1; i <= 15; i++) {
                    Elements searchNameTable = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(" + i + ") > th");
                    for (Element e : searchNameTable) {
                        String nameTableWithWeb = e.text();
                        switch (nameTableWithWeb) {
                            case "Miejscowość:":
                                Elements city = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(" + i + ") > td");
                                for (Element e1 : city) {
                                    cityFound = e1.text();
                                }
                                break;
                            case "Ulica:":
                                Elements street = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(" + i + ") > td");
                                for (Element e2 : street) {
                                    streetFound = e2.text();
                                }
                                break;
                            case "Kod pocztowy:":
                                Elements postCode = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(" + i + ") > td");
                                for (Element e3 : postCode) {
                                    postCodeFound = e3.text();
                                }
                                break;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, name2.text());
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Przepisz token z obrazka ze strony http://www.krs-online.com.pl");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Problem z pobraniem danych programu");
        }

    }
}