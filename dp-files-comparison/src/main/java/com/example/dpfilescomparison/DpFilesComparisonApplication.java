package com.example.dpfilescomparison;


import de.redsix.pdfcompare.PdfComparator;
import java.io.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;

public class DpFilesComparisonApplication {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.home") + "\\Desktop";

        String[] filePaths = new String[]{path+"\\dp1.1.pdf" , path+"\\dp2.1.pdf"};
        new PdfComparator(filePaths[0], filePaths[1]).compare().writeTo("C:\\Users\\mpanorios\\Desktop\\differences1");

        List<String> fileContent = new ArrayList<>();
        PdfReader reader = new PdfReader(filePaths[0]);
        try {

            for (int page=0; page<reader.getNumberOfPages(); page++) {
                for (int index = 0; index < filePaths.length; index++) {
                    reader = new PdfReader(filePaths[index]);
                    String pageContent = PdfTextExtractor.getTextFromPage(reader, page+1 );
                    fileContent.add(index, pageContent);
                }

                Reader br1 = new StringReader(fileContent.get(0));
                Reader br2 = new StringReader(fileContent.get(1));

                String sCurrentLine;
                List<String> list1 = new ArrayList<String>();
                List<String> list2 = new ArrayList<String>();
                br1 = new BufferedReader(br1);
                br2 = new BufferedReader(br2);
                while ((sCurrentLine = ((BufferedReader) br1).readLine()) != null) {
                    list1.add(sCurrentLine);
                }
                while ((sCurrentLine = ((BufferedReader) br2).readLine()) != null) {
                    list2.add(sCurrentLine);
                }

                System.out.println("\n======Differences spotted at page: "+ (page+1) +" ==========");

                List<String> tmpList = new ArrayList<String>(list1);
                tmpList.removeAll(list2);
                System.out.println("Content from "+ FilenameUtils.getName(filePaths[0]) +" which "+ FilenameUtils.getName(filePaths[1]) + " doesn't include.");
                for (int i = 0; i < tmpList.size(); i++) {
                    System.out.println((i+1) + ")" + tmpList.get(i));
                }

                System.out.println("Content from "+ FilenameUtils.getName(filePaths[1]) +" which "+ FilenameUtils.getName(filePaths[0]) + " doesn't include.");

                tmpList = list2;
                tmpList.removeAll(list1);
                for (int i = 0; i < tmpList.size(); i++) {
                    System.out.println((i+1) + ")" + tmpList.get(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
