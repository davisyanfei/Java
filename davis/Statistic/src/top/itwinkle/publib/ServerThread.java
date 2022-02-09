package top.itwinkle.publib;

        import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;

/**
 *
 * server端线程处理类
 */
public class ServerThread extends Thread {

    //和本线程相关的Socket
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public String stringLength (String len) {
        return "length: " + len.length() + "\n";
    }

    public String numWords (String numbers) {
        String input = numbers.trim().replaceAll(" +", " ");
        int space =  0 ;
        int word = 0 ;
        for (int i = 0 ; i < input.length() ; i++) {
            char spaces = input.charAt(i);
            if(spaces == ' ') {
                space ++;
            }
        }
        word = space + 1;
        return "number of words: " + word + "\n";
    }

    public String punctuation (String punct) {
        int numOfPunct = 0 ;
        for (int i = 0 ; i < punct.length() ; i++) {
            char numPunct = punct.charAt(i);
            int numAsci = numPunct;
            /*空格 32 英文标点符号 33-47  58-64  91-96 123-126  数字： 48-57 字符65-90 97-122
                这里写成 >=33 是为了程序的可读性，想想是否需要换成 >32 为什么？ */
            if (((numAsci>=33) && (numAsci<=47))
                    || ((numAsci>=58) && (numAsci<=64))
                    || ((numAsci>=91) && (numAsci<=96))
                    || ((numAsci>=123) && (numAsci<=126))){
                numOfPunct ++;
            }
        }
        return "number of punctuations: " + numOfPunct + "\n";
    }

    public String notSpace (String noSpace) {
        int numChar = 0 ;
        for (int i = 0; i < noSpace.length() ; i++) {
            char characters = noSpace.charAt(i);
            if (characters != ' ') {
                numChar ++;
            }
        }
        return "number of characters: " + numChar + "\n";
    }

    public String freqOfDig (String digits) {
        int[] storeDigits = new int[10];
        for (int i = 0 ; i < digits.length() ; i++) {
            char onlyDigits = digits.charAt(i);
            if (onlyDigits >= '0' && onlyDigits <= '9') {
                storeDigits[onlyDigits - '0'] ++;
            }
        }
        String output = "";
        for (int i = 0; i < 10 ; i++) {
            if (storeDigits[i] !=0)
            output += i + "-" + storeDigits[i] + ", ";
        }
        return output + "\n";
    }

    private String freqOfLet (String letters) {
        String lowerCase = letters.toLowerCase();
        int[] storeLetters = new int[26];
        for (int i = 0 ; i < lowerCase.length() ; i++) {
            char onlyLetters = lowerCase.charAt(i);
            if (onlyLetters >= 'a' && onlyLetters <= 'z') {
                storeLetters[onlyLetters - 'a'] ++;
            }
        }
        String output = "";
        for (int i = 0; i < 26 ; i++) {
            if (storeLetters[i] !=0)
            output += (char)('a'+i) + "-" + storeLetters[i] + ",";
        }
        return output + "\n";
    }


    public  void  run() {
        BufferedReader reader=null;
        PrintWriter writer=null;
        try{
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            while (true) {
                String message = reader.readLine();
                String statistics = stringLength(message) + numWords(message) + punctuation(message)
                        + notSpace(message) + freqOfDig(message) + freqOfLet(message);

                writer.write(statistics);
                writer.println();
                writer.flush();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭资源
            try {
                if (reader != null)
                    reader.close();
                if (writer != null)
                    writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
      }




}