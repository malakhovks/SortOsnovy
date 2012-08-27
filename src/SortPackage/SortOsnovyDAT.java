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
public class SortOsnovyDAT {

    /**
     * @param args the command line arguments
     */
    private static final String ENCODING_WIN1251 = "windows-1251";
    private static final String ENCODING_UTF8 = "UTF-8";

    public static void main(String[] args) {


        SortOsnovyDAT SOD = new SortOsnovyDAT();
        SOD.SortMethod(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Boolean.parseBoolean(args[3]));


    }

    public void SortMethod(String SelectedFileForRead, int StartNumberOfLetter, int EndNumberOfLetter, Boolean DontWriteUnnecessaryWords) {
        try {
            BufferedReader BRForMainReadLoop = null;
            String StringForReadWord = null;
            ArrayList<String> ArrayForSortTerms = new ArrayList<String>();
            String S_Buffer = "2312312312313";


            try {
                try {
                    BRForMainReadLoop = new BufferedReader(new InputStreamReader(new FileInputStream(SelectedFileForRead), ENCODING_WIN1251));
                    //BRForMainReadLoop = new BufferedReader(new InputStreamReader(new FileInputStream(SelectedFileForRead)));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while ((StringForReadWord = BRForMainReadLoop.readLine()) != null) {




                    StringForReadWord = StringForReadWord.substring(0, StringForReadWord.indexOf("	"));

                    //System.out.println(StringForReadWord);




//                     if (StartNumberOfLetter > StringForReadWord.length() | EndNumberOfLetter > StringForReadWord.length()) {
//                        System.out.println("Set parameters higher than the word length !!!!!");
//                    } else {
//
//
//
//                        StringForReadWord = StringForReadWord.substring(StartNumberOfLetter, EndNumberOfLetter);
//
//
//
//                        if (!ArrayForSortTerms.contains(StringForReadWord.toLowerCase())) {
//                            ArrayForSortTerms.add(StringForReadWord.toLowerCase());
//                        }
//
//
//
//
//
//
//
//
//                    }

                    if (StartNumberOfLetter > StringForReadWord.length()) {
                        System.out.println("Set parameters higher than the word length !!!!!");
                    } else {

                        if (EndNumberOfLetter > StringForReadWord.length()) {


                            StringForReadWord = StringForReadWord.substring(StartNumberOfLetter, StringForReadWord.length());
                            System.out.println("------->>>>" + StringForReadWord);





//                            if (StringForReadWord.length()>3){
//                               
//                                
//                                
//                            StringForReadWord = StringForReadWord.substring(0, 3);
//                            
//                            System.out.println("------->>>>" + StringForReadWord);
//                            
//                            
//                            
//                            }

                            if (!ArrayForSortTerms.contains(StringForReadWord.toLowerCase())) {
                                ArrayForSortTerms.add(StringForReadWord.toLowerCase());
                            }


                        } else {


                            StringForReadWord = StringForReadWord.substring(StartNumberOfLetter, EndNumberOfLetter);



                            if (!ArrayForSortTerms.contains(StringForReadWord.toLowerCase())) {
                                ArrayForSortTerms.add(StringForReadWord.toLowerCase());
                            }


                        }











                    }



                }
            } catch (IOException ex) {
                Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
            }







            Collections.sort(ArrayForSortTerms);
            for (String str : ArrayForSortTerms) {
                System.out.println(str.toString());

            }


            System.out.println(ArrayForSortTerms.size());


            ArrayForSortTerms.add(String.valueOf(ArrayForSortTerms.size()));







            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("SortFile.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SortOsnovy.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter writer_ = null;


            writer_ = new BufferedWriter(new OutputStreamWriter(fos, ENCODING_WIN1251));
            for (int k = 0; k < ArrayForSortTerms.size(); k++) {
                try {
                    writer_.append(ArrayForSortTerms.get(k).toString());
                } catch (IOException ex) {
                    Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    writer_.append("\n");
                } catch (IOException ex) {
                    Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            try {
                writer_.close();
            } catch (IOException ex) {
                Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SortOsnovyDAT.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
