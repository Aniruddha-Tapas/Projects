import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection; //Socket==Connection
	
	//constructor
	public Server(){
		
		super("Server Instant Messenger");
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
	
	// Set up and run the server
	
	public void startRunning(){
		try{
			server = new ServerSocket(6789,100); //port - where the server instant messnger applicn is (6789)
												 //backlog - no of users accesing the applicn (100)
			while(true){
				try{
					//connect and have conversation
					waitForConnection();
					setupStreams();
					whileChatting();
					
				}catch(EOFException eof){
					showMessage("\n Server ended the connection");
				}finally{
					closeCrap(); //close all connections
				}
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	//wait for connection, then display connection information
	
	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect...");
		connection = server.accept(); //connection to be made and accepting it
		showMessage("Now connected to "+connection.getInetAddress().getHostName()); //get details (ipaddress) of client(2nd user)
	}
	
	//get stream to send and receive messages
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n\n Streams are now setup! \n");
	}
	
	//during chat conversation
	
	private void whileChatting() throws IOException{
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		do{
			//have a conversation
			try{
				message = (String)input.readObject();
				showMessage("\n"+ message);
			}catch(ClassNotFoundException cnfe){
				showMessage("\n IDK wth that user sent");
			}
		}while(!message.equals("CLIENT - END")); //type END to end the conversation
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
	
	//send a message to client
	
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER - "+ message);
			output.flush();
			showMessage("\nSERVER -" + message);
		}catch(IOException ioe){
			chatWindow.append("\n ERROR: Cant send " + message);
		}
	}
	
	//updates chatWindow 
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
