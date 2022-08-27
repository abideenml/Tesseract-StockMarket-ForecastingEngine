package com.project.projectcrypto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;

public class CSVReader {
    public String open;
    public String high;
    public String low;
    public String current_price;
    public String company_name;


    // pass the filename like "TSLA.csv"
    CSVReader(String filename) {
        File file = new File("C:\\Users\\HPP\\ProjectCrypto\\src\\main\\java\\com\\project\\projectcrypto\\" + filename);
        readFromLast(file, 2);
    }


    // Reads n lines from the end of the file
    public void readFromLast(File file, int lines){
        int readLines = 0;
        StringBuilder sb = new StringBuilder();
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long fileLength = file.length() - 1;
            // Set the pointer at the last of the file
            randomAccessFile.seek(fileLength);
            for(long pointer = fileLength; pointer >= 0; pointer--){
                randomAccessFile.seek(pointer);
                char c;
                // read from the last one char at the time
                c = (char)randomAccessFile.read();
                // break when end of the line
                if(c == '\n'){
                    readLines++;
                    if(readLines == lines)
                        break;
                }
                sb.append(c);
            }
            sb.reverse();
            String nb = new String(sb);
            String[] info = nb.split(",");
            setCompany_name(info[0]);
            setCurrent_price(info[2]);
            setHigh(info[3]);
            setLow(info[4]);
            setOpen(info[5]);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(randomAccessFile != null){
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}