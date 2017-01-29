/*
1.http:   //www.ce.pdn.ac.lk  /index.php   ?
scheme    host name          path         query string
2.URl points to whats know as a resourse.
3.http response
response code{}
headers{contenty type,content length}
response body{}
*/


import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.StringBuffer;
public class GetUrlTask2 extends Thread{
    private URL url;
    static StringBuffer content=new StringBuffer();
    public  GetUrlTask2(URL url){
       this.url=url; 
    }
    @Override
    public void run() {
       try{ URL oracle = url;
     BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));


        String inputLine;
        while ((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close(); }
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
        
        Thread thread=new GetUrlTask2(new URL(args[i]));
        thread.start();
        list.add(thread);
       
        }
        for(Thread i:list){//waiting for all threads to finish
            i.join();
        }
        System.out.println(content);}
        catch( InterruptedException e){

        }
        
    
        


	}
}
