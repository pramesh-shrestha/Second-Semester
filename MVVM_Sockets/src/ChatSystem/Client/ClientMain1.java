package ChatSystem.Client;

import ChatSystem.transferObjects.Message;


import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientMain1
{
    private ClientSocketHandler clientSocketHandler;
    private int id;
    private ArrayList<Message> allMess = new ArrayList<>();
    private chatController chatController ;



    public void runClient()
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 1235);
             clientSocketHandler =  new ClientSocketHandler(socket, this);


            Thread thread =  new Thread(clientSocketHandler);
            thread.setDaemon(true);
            thread.start();

        }
        catch (IOException  e)
        {
            e.printStackTrace();
        }


    }

    public void sendMessage(Message msg)
    {
        clientSocketHandler.sendMessageToServer(msg);
    }

    public void messageReceived(Message msg)
    {
        System.out.println(msg.getId()+ ": " + msg.getMsg());
        allMess.add(msg);
        chatController.updateMessages();




    }
    public void setId(int id)
    {
        this.id = id;

    }
    public String getList()
    {
        String returnStr = "";
        for (int i = 0; i < allMess.size(); i++)
        {
            Message message = allMess.get(i);
            returnStr+=message+ "\n";
        }

        return returnStr;
    }
    public int getId()
    {
        return id;
    }

    public void setController(chatController ctrl)
    {
        this.chatController = ctrl;
    }
}
