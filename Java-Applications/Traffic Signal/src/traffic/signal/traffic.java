package traffic.signal;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class traffic extends Applet implements Runnable
{
Thread t;
Font f,f1;
int i=0,a=0,j=0;
public void init(){

	setBackground(Color.lightGray);

f=new Font("TimesNewRoman",f.ITALIC,28);
f1=new Font("TimesNewRoman",Font.ITALIC+Font.BOLD,28);


}
public void start()
{
t=new Thread(this);
t.start();
}

public void run()
{


for(i=25;i>=0;i--)//countdown
{

try
{
Thread.sleep(1000);
}
catch(Exception e)
{
System.out.println(e);
}
if(i<=25 && i>3)//red
{
	a=1;
	repaint();
}
else
if(i<=3 && i>0)//yelloe
{
	a=2;
	repaint();
}
else
if(i==0)//green
{



	for(j=0;j<25;j++)
{
	a=3;
	try
	{
		Thread.sleep(1000);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	repaint();

}


         if(j==25)//end of green(return to red)
			 {
				 run();
			 }


}

}

repaint();
}



public void paint(Graphics g)
{
setBackground(Color.lightGray);//ROAD

g.setColor(Color.black);//pole top
g.fillArc(100,150,100,100,0,180);
g.drawArc(100,150,100,100,0,180);

g.setColor(Color.black);//POLE UP
g.fillRect(150,150,50,150);
g.drawRect(150,150,50,150);



g.setColor(Color.black);//POLE DOWN
g.fillRect(165,300,20,155);
g.drawRect(165,300,20,155);


g.drawOval(150,150,50,50);//RED

g.drawOval(150,200,50,50);//YELLOW


g.drawOval(150,250,50,50);//GREEN


g.setColor(Color.red);//COUNTDOWN STOP
g.setFont(f);
g.drawString(""+i,50,50);


g.setColor(Color.white);//CROSSING1
g.fillRect(300,5,15,125);
g.drawRect(300,5,15,125);



g.setColor(Color.white);
g.fillRect(300,145,15,135);
g.drawRect(300,145,15,135);


g.setColor(Color.white);
g.fillRect(300,300,15,135);
g.drawRect(300,300,15,135);

g.setColor(Color.white);//CROSSING2
g.fillRect(450,5,15,125);
g.drawRect(450,5,15,125);



g.setColor(Color.white);
g.fillRect(450,145,15,135);
g.drawRect(450,145,15,135);


g.setColor(Color.white);
g.fillRect(450,300,15,135);
g.drawRect(450,300,15,135);


g.setColor(Color.black);//TREE1DOWN
g.fillRect(600,300,15,135);
g.drawRect(600,300,15,135);


g.setColor(Color.green);//TREE1UP
g.fillArc(560,290,100,100,0,180);
g.drawArc(560,290,100,100,0,180);


g.setColor(Color.black);//TREE2DOWN
g.fillRect(460,300,15,135);
g.drawRect(460,300,15,135);


g.setColor(Color.green);//TREE2UP
g.fillArc(420,290,100,100,0,180);
g.drawArc(420,290,100,100,0,180);






if(a==1)//REDSIGNAL
{
	g.setColor(Color.red);
	g.fillOval(150,150,50,50);
	g.drawOval(150,150,50,50);
	g.drawString("STOP",50,150);
}
if(a==2)//YELLOWSIGNAL
{
	g.setColor(Color.yellow);
	g.fillOval(150,200,50,50);
	g.drawOval(150,200,50,50);
	g.drawString("READY",50,200);
}
if(a==3)//GREENSIGNAL
{
	g.setColor(Color.blue);//countdown
	g.setFont(f);
g.drawString(""+j,150,50);


	g.setColor(Color.green);
	g.fillOval(150,250,50,50);
	g.drawOval(150,250,50,50);
	g.drawString("GO",50,250);


}


int x1[]={220,300,300,280};
	int y1[]={250,150,250,150};
	int n1=4;
	int n2=3;
	int x2[]={340,380,380};
	int y2[]={150,100,150};

	int x3[]={460,460,500};
	int y3[]={150,100,150};





g.setColor(Color.black);
	g.fillPolygon(x1,y1,n1);
g.drawPolygon(x1,y1,n1);


	g.setColor(Color.yellow);
	g.fillRect(380,100,80,50);
g.drawRect(380,100,80,50);


g.setColor(Color.yellow);
	g.fillPolygon(x2,y2,n2);
g.drawPolygon(x2,y2,n2);

g.setColor(Color.yellow);
	g.fillPolygon(x3,y3,n2);
g.drawPolygon(x3,y3,n2);

g.setColor(Color.black);
	g.fillOval(440,210,60,60);
g.drawOval(440,210,60,60);

g.setColor(Color.black);
	g.fillOval(340,210,60,60);
g.drawOval(340,210,60,60);

g.setColor(Color.red);
	g.fillRect(300,150,250,100);
g.drawRect(300,150,250,100);


g.setColor(Color.black);
g.setFont(f1);
g.drawString ("Zumbo",380,200);



}
}


