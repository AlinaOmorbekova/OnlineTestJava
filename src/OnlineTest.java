
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class OnlineTest extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    OnlineTest(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct answers = "+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which of the following is not OOPS concept in Java?");
            jb[0].setText("Inheritance");jb[1].setText("Encapsulation");jb[2].setText("Polymorphism");jb[3].setText("Compilation");
        }
        if(current==1)
        {
            l.setText("Que2: Which of the following is a type of polymorphism in Java?");
            jb[0].setText("Compile time polymorphism");jb[1].setText("Execution time polymorphism");jb[2].setText("Multiple polymorphism");jb[3].setText("Multilevel polymorphism");
        }
        if(current==2)
        {
            l.setText("Que3: When does method overloading is determined?");
            jb[0].setText("At run time");jb[1].setText("At compile time");jb[2].setText("At coding time");jb[3].setText("At execution time");
        }
        if(current==3)
        {
            l.setText("Que4:  Which concept of Java is a way of converting real world objects in terms of class?");
            jb[0].setText("Polymorphism");jb[1].setText("Encapsulation");jb[2].setText("Abstraction");jb[3].setText("Inheritance");
        }
        if(current==4)
        {
            l.setText("Que5: Which concept of Java is achieved by combining methods and attribute into a class??");
            jb[0].setText("Encapsulation");jb[1].setText("Inheritance");jb[2].setText("Polymorphism");jb[3].setText("Abstraction");
        }
        if(current==5)
        {
            l.setText("Que6: Which definition best describes an object?");
            jb[0].setText("Instance of a class");jb[1].setText("Instance of itself");jb[2].setText("Child of a class");jb[3].setText("Overview of a class");
        }
        if(current==6)
        {
            l.setText("Que7: Which of the following is not type of class?");
            jb[0].setText("Abstract Class");jb[1].setText("Final Class");jb[2].setText("Start Class");
            jb[3].setText("String Class");
        }
        if(current==7)
        {
            l.setText("Que8: Which of the following is a method having same name as that of it’s class?");
            jb[0].setText("finalize");
            jb[1].setText("delete");
            jb[2].setText("class");
            jb[3].setText("constructor");
        }
        if(current==8)
        {
            l.setText("Que9: Which of the below is invalid identifier with the main method?");
            jb[0].setText("public");jb[1].setText("static");jb[2].setText("private");jb[3].setText("final");
        }
        if(current==9)
        {
            l.setText("Que10: Which keyword is used by the method to refer to the object that invoked it?");
            jb[0].setText("import");jb[1].setText("this");jb[2].setText("catch");
            jb[3].setText("abstract");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[3].isSelected());
        if(current==1)
            return(jb[0].isSelected());
        if(current==2)
            return(jb[1].isSelected());
        if(current==3)
            return(jb[2].isSelected());
        if(current==4)
            return(jb[0].isSelected());
        if(current==5)
            return(jb[0].isSelected());
        if(current==6)
            return(jb[2].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[2].isSelected());
        if(current==9)
            return(jb[1].isSelected());
        return false;
    }
    public static void main(String s[])
    {
        new OnlineTest("Online Test Of Java");
    }
}

