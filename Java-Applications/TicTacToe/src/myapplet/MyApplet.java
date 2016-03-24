package myapplet;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;

public class MyApplet extends JApplet implements MouseListener {

    Rectangle r[]; //Sizes
    int arr[]; //Statuses
    
    final int EMPTY = 0 ;
    final int EX = 1;
    final int OH = 2;
    
public void init() { 

    resize(210,220); //Window Size
    r = new Rectangle[9];
    r[0] = new Rectangle(0,0,70,70); // (x,y,wd,ht);
    r[1] = new Rectangle(70,0,70,70);
    r[2] = new Rectangle(140,0,70,70);
    r[3] = new Rectangle(0,70,70,70);
    r[4] = new Rectangle(70,70,70,70);
    r[5] = new Rectangle(140,70,70,70);
    r[6] = new Rectangle(0,140,70,70);
    r[7] = new Rectangle(70,140,70,70);
    r[8] = new Rectangle(140,140,70,70);
    
    arr = new int[9];
    for(int i = 0; i<=8;i++)
        arr[i] = EMPTY;
     
        addMouseListener(this); //this - Listener for current applet.
}

public void paint (Graphics g){
    
    Graphics2D g2d = (Graphics2D)g;
    g2d.setStroke(new BasicStroke(2));
    g.setColor(Color.yellow);
    
    g.drawLine(0, 70, 210, 70);
    g.drawLine(0, 140, 210, 140);
    g.drawLine(70, 0, 70, 210);
    g.drawLine(140, 0, 140, 210);
    
    for(int i = 0; i <= 8; i++ )
    {
        if(arr[i]== EX)
            drawex(g,i);
        
        if(arr[i]== OH)
            drawoh(g,i);
    }
}

void drawex(Graphics g, int i){

    Graphics2D g2d = (Graphics2D)g;
    g2d.setStroke(new BasicStroke(2));
    g.setColor(Color.red);
    
    int x1,y1,x2,y2;
    
    x1 = r[i].x + 10;
    y1 = r[i].y + 10;
    x2 = x1 + r[i].width - 20;
    y2 = y1 + r[i].height - 20;
    
    g.drawLine(x1, y1, x2, y2);
    g.drawLine(x2, y1, x1, y2);
}

void drawoh(Graphics g, int i){

    Graphics2D g2d = (Graphics2D)g;
    g2d.setStroke(new BasicStroke(2));
    g.setColor(Color.blue);
    
    int x1,y1,wd,ht;
    
    x1 = r[i].x + 10;
    y1 = r[i].y + 10;
    wd = r[i].width - 20;
    ht = r[i].height - 20;

    g.fillOval(x1, y1, wd, ht);
    g.setColor(Color.darkGray);
    g.drawOval(x1, y1, wd, ht);
    
}

@Override
    public void mouseClicked(MouseEvent e) 
    {
         showStatus("");
         
         for(int i = 0; i<=8; i++)
         {
             Point pt = e.getPoint();
             
             if(r[i].contains(pt)&&(arr[i]==OH||arr[i]==EX))
             {
                 showStatus("Cheating! Click only in Empty Boxes");
                 return;
             }
             else
             {
                 if(r[i].contains(pt)&&arr[i]==EMPTY)
                 {
                     arr[i] = OH;
                     repaint(); //Generate paint event and return
                 
                     if(diduserwin())
                     {
                         showStatus("O Won The Game !!");
                         break;
                     }
                     else
                     {
                         if(isgamedrawn())
                         {
                             showStatus("Game is Drawn !!");
                         }
                         else
                         {
                             complay();
                             repaint();
                             if(didcomwin())
                             {
                                 showStatus("Computer Won The Game");
                                 break;
                             }
                         }
                          
                     }
                 }    
             }
         }
    } // MouseClicked Ends.
    
    void complay()
    {
        //attempt to win 
        if (arr[0]==EMPTY && arr[1]==EX && arr[2]==EX ||
            arr[0]==EMPTY && arr[4]==EX && arr[8]==EX ||
            arr[0]==EMPTY && arr[3]==EX && arr[6]==EX )
        {
            arr[0] = EX;
            return;
        }
        if (arr[1]==EMPTY && arr[0]==EX && arr[2]==EX ||
            arr[1]==EMPTY && arr[4]==EX && arr[7]==EX )
        {
            arr[1] = EX;
            return;
        }
        if (arr[2]==EMPTY && arr[0]==EX && arr[1]==EX ||
            arr[2]==EMPTY && arr[4]==EX && arr[6]==EX ||
            arr[2]==EMPTY && arr[5]==EX && arr[8]==EX )
        {
            arr[2] = EX;
            return;
        }
        if (arr[3]==EMPTY && arr[0]==EX && arr[6]==EX ||
            arr[3]==EMPTY && arr[4]==EX && arr[5]==EX )
        {
            arr[3] = EX;
            return;
        }
        if (arr[4]==EMPTY && arr[0]==EX && arr[8]==EX ||
            arr[4]==EMPTY && arr[2]==EX && arr[6]==EX ||
            arr[4]==EMPTY && arr[1]==EX && arr[7]==EX ||
            arr[4]==EMPTY && arr[3]==EX && arr[5]==EX)
        {
            arr[4] = EX;
            return;
        }
        if (arr[5]==EMPTY && arr[3]==EX && arr[4]==EX ||
            arr[5]==EMPTY && arr[2]==EX && arr[8]==EX )
        {
            arr[5] = EX;
            return;
        }
        if (arr[6]==EMPTY && arr[0]==EX && arr[3]==EX ||
            arr[6]==EMPTY && arr[4]==EX && arr[2]==EX ||
            arr[6]==EMPTY && arr[7]==EX && arr[8]==EX )
        {
            arr[6] = EX;
            return;
        }
        if (arr[7]==EMPTY && arr[1]==EX && arr[4]==EX ||
            arr[7]==EMPTY && arr[6]==EX && arr[8]==EX )
        {
            arr[7] = EX;
            return;
        }
        if (arr[8]==EMPTY && arr[2]==EX && arr[5]==EX ||
            arr[8]==EMPTY && arr[4]==EX && arr[0]==EX ||
            arr[8]==EMPTY && arr[6]==EX && arr[7]==EX )
        {
            arr[8] = EX;
            return;
        }
        //attempt to draw
        if (arr[0]==EMPTY && arr[1]==OH && arr[2]==OH ||
            arr[0]==EMPTY && arr[4]==OH && arr[8]==OH ||
            arr[0]==EMPTY && arr[3]==OH && arr[6]==OH )
        {
            arr[0] = EX;
            return;
        }
        if (arr[1]==EMPTY && arr[0]==OH && arr[2]==OH ||
            arr[1]==EMPTY && arr[4]==OH && arr[7]==OH )
        {
            arr[1] = EX;
            return;
        }
        if (arr[2]==EMPTY && arr[0]==OH && arr[1]==OH ||
            arr[2]==EMPTY && arr[4]==OH && arr[6]==OH ||
            arr[2]==EMPTY && arr[5]==OH && arr[8]==OH )
        {
            arr[2] = EX;
            return;
        }
        if (arr[3]==EMPTY && arr[0]==OH && arr[6]==OH ||
            arr[3]==EMPTY && arr[4]==OH && arr[5]==OH )
        {
            arr[3] = EX;
            return;
        }
        if (arr[4]==EMPTY && arr[0]==OH && arr[8]==OH ||
            arr[4]==EMPTY && arr[2]==OH && arr[6]==OH ||
            arr[4]==EMPTY && arr[1]==OH && arr[7]==OH ||
            arr[4]==EMPTY && arr[3]==OH && arr[5]==OH)
        {
            arr[4] = EX;
            return;
        }
        if (arr[5]==EMPTY && arr[3]==OH && arr[4]==OH ||
            arr[5]==EMPTY && arr[2]==OH && arr[8]==OH )
        {
            arr[5] = EX;
            return;
        }
        if (arr[6]==EMPTY && arr[0]==OH && arr[3]==OH ||
            arr[6]==EMPTY && arr[4]==OH && arr[2]==OH ||
            arr[6]==EMPTY && arr[7]==OH && arr[8]==OH )
        {
            arr[6] = EX;
            return;
        }
        if (arr[7]==EMPTY && arr[1]==OH && arr[4]==OH ||
            arr[7]==EMPTY && arr[6]==OH && arr[8]==OH )
        {
            arr[7] = EX;
            return;
        }
        if (arr[8]==EMPTY && arr[2]==OH && arr[5]==OH ||
            arr[8]==EMPTY && arr[4]==OH && arr[0]==OH ||
            arr[8]==EMPTY && arr[6]==OH && arr[7]==OH )
        {
            arr[8] = EX;
            return;
        }
        
        //Occupy center or first available corner
        if(arr[4]==EMPTY)
        {
            arr[4]= EX;
            return;
        }
        if(arr[0]==EMPTY)
        {
            arr[0]= EX;
            return;
        }
        if(arr[2]==EMPTY)
        {
            arr[2]= EX;
            return;
        }
        if(arr[6]==EMPTY)
        {
            arr[6]= EX;
            return;
        }
        
        if(arr[8]==EMPTY)
        {
            arr[8]= EX;
            return;
        }
        
        //Occupy empty slot
        for(int i=0; i<=8; i++)
        {
            if(arr[i]==EMPTY)
            {
                arr[i] = EX;
                break;
            }
        }    
    }
    
    boolean diduserwin()
    {
        int winner;
        winner = findwinner();
        
       if(winner == OH )
           return true;
       else
           return false;
    }
    
    boolean didcomwin()
    {
        int winner;
        winner = findwinner();
        
       if(winner == EX )
           return true;
       else
           return false;
    }
    
    boolean isgamedrawn()
    {
       for(int i = 0; i<=8; i++)
       {
           if(arr[i] == EMPTY)
               return false;
       }
           return true;
    }
    
    int findwinner()
    {
        int pattern[][] = {
                             {0,1,2},{3,4,5},{6,7,8},{0,3,6},
                             {1,4,7},{2,5,8},{0,4,8},{2,4,6}
                             
                          };
        for(int i = 0 ; i<=7 ; i++)
        {
            if(arr[pattern[i][0]]==OH && arr[pattern[i][1]]==OH && arr[pattern[i][2]]==OH)
                return OH;
            if(arr[pattern[i][0]]==EX && arr[pattern[i][1]]==EX && arr[pattern[i][2]]==EX)
                return EX;
            
        }
        return 0;
    }
    
            

 
    public void mousePressed(MouseEvent e) {
        
    }

 
    public void mouseReleased(MouseEvent e) {
        
    }

 
    public void mouseEntered(MouseEvent e) {
     
    }

 
    public void mouseExited(MouseEvent e) {
     
    }


}
