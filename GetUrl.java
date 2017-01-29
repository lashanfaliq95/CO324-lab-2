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
public class GetUrl extends Thread{
    private URL url;
    public  GetUrl(URL url){
       this.url=url; 
    }
    @Override
    public void run(){


    }
	public static void main(String [] args)throws IOException{
      try{  StringBuffer content=new StringBuffer();
        for(int i=0;i<args.length;i++){
        URL oracle = new URL(args[i]);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));


        String inputLine;
        while ((inputLine = in.readLine()) != null){
            content.append(inputLine);
        }
        in.close(); 
        }
        System.out.println(content);}
        catch(FileNotFoundException e){
            System.out.println("Wrong url");
        }
    
        


	}
}
