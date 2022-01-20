import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.*;
//for the get request
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Roku extends JFrame{
	private String ip = "192.168.86.41";// just the roku ip
	//define buttons
	private JFrame mainFrame;
	private JButton power;
	private JButton fwd;
	private JButton rev;
	private JButton replay;
	private JButton home;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JButton select;
	private JButton play;
	private JButton back;

	public Roku(){
		//assingen buttons
		mainFrame = new JFrame("Roku");//title
		power = new JButton("Power");//-----------
		power.setIcon(new ImageIcon("Power.png"));
		power.setText("power");
		fwd = new JButton("fwd");//
		fwd.setIcon(new ImageIcon("Fwd.png"));
		fwd.setText("fwd");
		rev = new JButton("rev");//
		rev.setIcon(new ImageIcon("Rev.png"));
		rev.setText("rev");
		replay = new JButton("Replay");//
		replay.setIcon(new ImageIcon("Replay.png"));
		replay.setText("replay");
		home = new JButton("Home");//
		home.setIcon(new ImageIcon("Home.png"));
		home.setText("home");
		up = new JButton("up");//
		up.setIcon(new ImageIcon("Up.png"));
		up.setText("up");
		down = new JButton("down");//
		down.setIcon(new ImageIcon("Down.png"));
		down.setText("down");
		left = new JButton("Left");//
		left.setIcon(new ImageIcon("Left.png"));
		left.setText("left");
		right = new JButton("Right");
		right.setIcon(new ImageIcon("Right.png"));
		right.setText("right");
		select = new JButton("Select");//
		select.setIcon(new ImageIcon("Select.png"));
		select.setText("select");
		play = new JButton("Play");//
		play.setIcon(new ImageIcon("Play.png"));
		play.setText("play");
		back = new JButton("Back");
		back.setIcon(new ImageIcon("Back.png"));
		back.setText("back");
		//make the gui
		Container c = mainFrame.getContentPane();
		c.setLayout(new GridLayout(4,3));
		c.add(power);//[0][0]);--------------
		c.add(up);//[0][1]);-----------
		c.add(replay);//--------
		c.add(left);//[1][0]);--------
		c.add(select);//[1][1]);-------
		c.add(right);//[1][2]);-------
		c.add(back);//---------
		c.add(down);//[2][1]);--------
		c.add(home);//[2][2]);---------
		c.add(rev);//[3][0]);---------
		c.add(play);//[3][1]);--------
		c.add(fwd);//[3][2]);
		
		mainFrame.setSize(300,500);

		//make the x aat the top close window
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});

		AllButtonHandler bhandler = new AllButtonHandler();
		power.addActionListener(bhandler);
		up.addActionListener(bhandler);
		replay.addActionListener(bhandler);
		left.addActionListener(bhandler);
		select.addActionListener(bhandler);
		right.addActionListener(bhandler);
		back.addActionListener(bhandler);
		down.addActionListener(bhandler);
		home.addActionListener(bhandler);
		rev.addActionListener(bhandler);
		play.addActionListener(bhandler);
		fwd.addActionListener(bhandler);


		mainFrame.setVisible(true);

	}

	//this sends a get request
	public static void sendGET(String GET_URL) throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		con.setRequestMethod("GET");
		//con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("User-Agent", "RoByte/2.1.8.2 CFNetwork/1220.1 Darwin/20.3.0");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		
		System.out.println(GET_URL);
		con.disconnect();
		

	}


	class AllButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == power){
				try{
					sendGET("http://"+ip+":8060/keypress/Power");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == up){
				try{
					sendGET("http://"+ip+":8060/keypress/Up");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == replay){
				try{
					sendGET("http://"+ip+":8060/keypress/InstantReplay");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == left){
				try{
					sendGET("http://"+ip+":8060/keypress/Left");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == select){
				try{
					sendGET("http://"+ip+":8060/keypress/Select");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == right){
				try{
					sendGET("http://"+ip+":8060/keypress/Right");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == back){
				try{
					sendGET("http://"+ip+":8060/keypress/Back");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == down){
				try{
					sendGET("http://"+ip+":8060/keypress/Down");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == home){
				try{
					sendGET("http://"+ip+":8060/keypress/Home");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == rev){
				try{
					sendGET("http://"+ip+":8060/keypress/Rev");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == play){
				try{
					sendGET("http://"+ip+":8060/keypress/Play");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			} else if(e.getSource() == fwd){
				try{
					sendGET("http://"+ip+":8060/keypress/Fwd");
				}
				catch(Exception ex){
					System.out.println(ex);
				}
			}

		}
	}

	public static void main(String[] args){
		Roku app;
		app = new Roku();
	}

}