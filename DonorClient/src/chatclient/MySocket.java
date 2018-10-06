package chatclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MySocket {
    private Socket s;
    private BufferedReader br;
    private PrintWriter pr;

    public MySocket(Socket st)throws Exception{
        s = st;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pr = new PrintWriter(s.getOutputStream(),true);
    }

    public void println(String str)throws Exception{
        pr.println(str);
    }
    public String readLine()throws Exception{
        return br.readLine();
    }
    public void close()throws Exception{
        s.close();
    }
}
