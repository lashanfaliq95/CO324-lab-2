
/* here since we use local string buffers they are not shared between threads so when we
print it they wont be jumbled up */


import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.StringBuffer;
public class GetUrlTask4 extends Thread{
    private URL url;
      static ArrayList<StringBuffer> fullContent=new ArrayList<StringBuffer>();//to add all the local string buffers of each thread
    
    public  GetUrlTask4(URL url){
       this.url=url; 
    }
    @Override
    public void run() {
       try{ URL oracle = url;
     BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
         StringBuffer content=new StringBuffer();

        String inputLine;
        while ((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close();
        fullContent.add(content); }
        catch(FileNotFoundException e){
            System.out.println("Wrong url");
        }
        catch(IOException e){
           System.out.println("IO error");
        }

    }
	public static void main(String [] args)throws IOException{
        try{ArrayList<Thread> list=new ArrayList<Thread>();

        for(int i=0;i<args.length;i++){
        
        Thread thread=new GetUrlTask4(new URL(args[i]));
        thread.start();
        list.add(thread);
       
        }
        for(Thread i:list){//waiting for all threads to finish
            i.join();
        }
        System.out.println(fullContent);}
        catch( InterruptedException e){

        }
        
    
        }
}
