import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;   //IPaddress of the server
	private Socket connection; //Socket==Connection
	
	//constructor
	public Client(String host){
		super("Client Instant Messenger");
		serverIP = host; //To restrict the access of this prog app only to the client comp and not the worldwide server
		userText = new JTextField();
		userText.setEditable(false); //To prevent entering message when not connected
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}
		);
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow),BorderLayout.CENTER);
		setSize(450,270);
		setVisible(true);
	}
	
	//connect to server
	public void startRunning(){
		try{
			connectToServer(); 
			setUpStreams();
			whileChatting();
		}catch(EOFException eof){
			showMessage("\n Client terminated connection");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			closeCrap();
		}
	}
	
	//connect to a server
	private void connectToServer() throws IOException{
		showMessage("Attempting connection\n");
		connection = new Socket(InetAddress.getByName(serverIP),6789); //port - where the server instant messnger applicn is (6789)
		showMessage("\nConnected to: "+ connection.getInetAddress().getHostName());
	}

	//get stream to send and receive messages
	private void setUpStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());			output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n\n Streams are now setup! \n");
	}

	//while chatting with server
	private void whileChatting() throws IOException{
		ableToType(true);
		do{
			//have a conversation
			try{
				message = (String)input.readObject();
				showMessage("\n"+ message);
			}catch(ClassNotFoundException cnfe){
				showMessage("\n IDK wth that user sent");
			}
		}while(!message.equals("SERVER - END")); //type END to end the conversation
	}
	
	//close streams and sockets after u r done chatting
	private void closeCrap(){
		sendMessage("\n Closing connections... \n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//send messages to server
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT - "+ message);
			output.flush();
			showMessage("\nCLIENT -" + message);
		}catch(IOException ioe){
			chatWindow.append("\n ERROR: Cant send " + message);
		}
	}

	//change/update chatWindow 
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				}
		);
	}

	//let a user type stuff into their text box
	private void ableToType(boolean tof){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					userText.setEditable(tof);
				}
			}
		);
	}
}
