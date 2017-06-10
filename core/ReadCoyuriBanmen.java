package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by takai on 17/06/03.
 */
public class ReadCoyuriBanmen {

    public static ArrayList<String> read_coyuri_input_stream(ArrayList<String> command){
        ArrayList<String> result = new ArrayList<>();

        ProcessBuilder pb = new ProcessBuilder(command);

        try {

            Process process = pb.start();
            try {
                process.waitFor();
            }catch (Exception e){
                System.err.println(e);
            }
            InputStream is = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            try{
                do{
                    String line = br.readLine();
                    if(line == null){
                        break;
                    }
                    result.add(line);
                }while(true);
            }catch (Exception e){
                System.err.println(e);
            }

        }catch (IOException e){
            System.err.println(e);
        }

        return result;

    }

}
