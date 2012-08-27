/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SortPackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kirilmalahov
 */


public class SortOsnovy {

    /**
     * @param args the command line arguments
     */
    private static final String ENCODING_WIN1251 = "windows-1251";
    private static final String ENCODING_UTF8 = "UTF-8";

    public static void main(String[] args) {



        SortOsnovy SO = new SortOsnovy();

        //SO.SortMethod(1, "test.txt", true);

        SO.SortMethod(Integer.parseInt(args[0]), args[1], Boolean.parseBoolean(args[2]));
    }

    public void SortMethod(int StartNumberOfLetter, String SelectedFileForRead, Boolean DontWriteUnnecessaryWords) {
        try {
            
            String S_Buffer = null;
            String S_Buffer_1 = null;
            BufferedReader BRForMainReadLoop = null;
            String StringForReadWord = null;
            ArrayList<String> ArrayForSortTerms = new ArrayList<String>();

            try {

                //BRForMainReadLoop = new BufferedReader(new InputStreamReader(new FileInputStream(SelectedFileForRead), ENCODING_WIN1251));
                BRForMainReadLoop = new BufferedReader(new InputStreamReader(new FileInputStream(SelectedFileForRead), ENCODING_UTF8));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
            }


    
            try {
                while ((StringForReadWord = BRForMainReadLoop.readLine()) != null) {

                    S_Buffer = StringForReadWord.substring(0, StartNumberOfLetter);
                    StringForReadWord = StringForReadWord.substring(StartNumberOfLetter, StringForReadWord.length());
                    ArrayForSortTerms.add(StringForReadWord + " "+ S_Buffer);
                }
            } catch (IOException ex) {
                Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
            }

            Collections.sort(ArrayForSortTerms);
            for (String str : ArrayForSortTerms) {
                System.out.println(str.toString());

            }

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("SortFile.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter writer_ = null;

            writer_ = new BufferedWriter(new OutputStreamWriter(fos, ENCODING_UTF8));
            for (int k = 0; k < ArrayForSortTerms.size(); k++) {
                try {
                    System.out.println(ArrayForSortTerms.get(k).toString());

                    writer_.append(ArrayForSortTerms.get(k).toString());
                    writer_.append("\n");
                } catch (IOException ex) {
                    Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            writer_.close();
            fos.close();






            BufferedReader BRForSecondReadLoop;
            String StringForReadSecondWord;
            String BufferString = "12131313132";
            String BufferString2 = "12131313132";

            ArrayList<String> ArrayForSortTermsSecond = new ArrayList<String>();

            BRForSecondReadLoop = new BufferedReader(new InputStreamReader(new FileInputStream("SortFile.txt"), ENCODING_UTF8));

            while ((StringForReadSecondWord = BRForSecondReadLoop.readLine()) != null) {



                if (StringForReadSecondWord.regionMatches(false, 0, BufferString, 0, 1)) {

                    BufferString = BufferString.substring(0, 2);
                    BufferString2 = StringForReadSecondWord.substring(0, 2);

                    if (BufferString.startsWith(BufferString2)) {
                        ArrayForSortTermsSecond.add(StringForReadSecondWord);
                    } else {

                        ArrayForSortTermsSecond.add(" ");
                        ArrayForSortTermsSecond.add(StringForReadSecondWord);
                    }


                } else {

                    ArrayForSortTermsSecond.add(" ");
                    ArrayForSortTermsSecond.add(StringForReadSecondWord);
                }

                BufferString = StringForReadSecondWord;
            }

            for (String str1 : ArrayForSortTermsSecond) {
                System.out.println(str1.toString());

            }



            FileOutputStream fos1 = null;
            try {
                fos1 = new FileOutputStream("SortFileWithSpaces.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter writer_1 = null;

            writer_1 = new BufferedWriter(new OutputStreamWriter(fos1, ENCODING_UTF8));
            for (int k = 0; k < ArrayForSortTermsSecond.size(); k++) {
                try {
                    System.out.println(ArrayForSortTermsSecond.get(k).toString());
                    
                    S_Buffer_1 = ArrayForSortTermsSecond.get(k).toString();
                    S_Buffer_1 = S_Buffer_1.substring(S_Buffer_1.lastIndexOf(" "), S_Buffer_1.length());
                    writer_1.append(S_Buffer_1+ArrayForSortTermsSecond.get(k).toString().substring(0, ArrayForSortTermsSecond.get(k).toString().lastIndexOf(" ")));
                    
                    //writer_1.append(ArrayForSortTermsSecond.get(k).toString());
                    writer_1.append("\n");
                } catch (IOException ex) {
                    Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            writer_1.close();
            fos1.close();





        } catch (IOException ex) {
            Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
        }





    }
}