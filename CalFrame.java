import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class CalFrame extends JFrame implements ActionListener{
  static String buttonLabel[]={"1","2","3","+","4","5","6","-","7","8","9","*","0",".","=","/","^","Del","Ans","AC"};
  static JPanel numpanel=new JPanel();
  static JPanel panel=new JPanel();
  static JPanel mainpanel= new JPanel();
  static JButton button[]= new JButton[20];
  static JLabel label=new JLabel("0");
  static String num[]={"",""};
  static int count=0;
  static int operation = 0 ;
  static boolean hasDot=false;
  static String ans;
  static boolean error=false;
  CalFrame(){
    this.setTitle("Calculator");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300,350);
    numpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    mainpanel.setLayout(new BorderLayout());
    numpanel.setSize(50,200);
    mainpanel.setSize(240,200);
    panel.setSize(200,200);
    panel.setLayout(new GridLayout(5,4,0,0));
    for(int i=0;i<20;i++){
      button[i]=new JButton(buttonLabel[i]);
      button[i].setSize(40,40);
      button[i].addActionListener(this);
      panel.add(button[i]);
    }
    numpanel.add(label);
    mainpanel.add(numpanel,BorderLayout.NORTH);
    mainpanel.add(panel,BorderLayout.CENTER);
    this.add(mainpanel);
    label.setFont(new Font("Times New Roman",Font.BOLD,20));
    numpanel.setPreferredSize(new Dimension(50,50));
    mainpanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.setAlignmentX(Component.BOTTOM_ALIGNMENT);
    numpanel.setAlignmentX(Component.TOP_ALIGNMENT);
    label.setHorizontalAlignment(JLabel.RIGHT);
    label.setVerticalAlignment(JLabel.CENTER);
    numpanel.setBackground(new Color(200,200,200));
    this.setVisible(true);
  }
    @Override
    public void actionPerformed(ActionEvent e){  
    
//1    
    if (e.getSource()==button[0]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="1";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"1";
label.setText(num[count]);
      }
    }
    
//2
    if (e.getSource()==button[1]){
      if(num[count].isEmpty()||num[count].equals("0")) {
              num[count]="2";
         label.setText(num[count]);
            } else{
              num[count]=num[count]+"2";
     label.setText(num[count]);
            }
    }
    
//3
    if (e.getSource()==button[2]){
      if(num[count].isEmpty()||num[count].equals("0")) {
              num[count]="3";
label.setText(num[count]);
            } else{
              num[count]=num[count]+"3";
label.setText(num[count]);
            }
    }
    
//+
    if (e.getSource()==button[3]){
      if (count==0 && num[count].length()!=0){
        operation=1;
        count++;
        hasDot=false;
      }
if (count==1 && num[count].length()!=0){
              doOperation();
              num[0]=ans;
              operation=1;
              count++;
              hasDot=false;
            }
    }
    
//4
    if (e.getSource()==button[4]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="4";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"4";
label.setText(num[count]);
      }    }
      
//5
    if (e.getSource()==button[5]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="5";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"5";
label.setText(num[count]);
      }    }
      
//6
    if (e.getSource()==button[6]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="6";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"6";
label.setText(num[count]);
      }    }
      
//-
    if (e.getSource()==button[7]){
      if (count==0){
        operation=2;
        count++;
        hasDot=false;
      }    
if (count==1 && num[count].length()!=0){
              doOperation();
              num[0]=ans;
              operation=2;
              count++;
              hasDot=false;
            }
    }
      
//7
    if (e.getSource()==button[8]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="7";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"7";
label.setText(num[count]);
      }    }
      
//8      
    if (e.getSource()==button[9]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="8";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"8";
label.setText(num[count]);
      }    }

//9      
    if (e.getSource()==button[10]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="9";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"9";
label.setText(num[count]);
      }    }
      
//×
    if (e.getSource()==button[11]){
      if (count==0 && num[count].length()!=0){
        operation=3;
        count++;
        hasDot=false;
      }    
if (count==1 && num[count].length()!=0){
              doOperation();
              num[0]=ans;
              operation=3;
              count++;
              hasDot=false;
            }
    }
      
//0
    if (e.getSource()==button[12]){
      if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="0";
label.setText(num[count]);
      } else{
        num[count]=num[count]+"0";
label.setText(num[count]);
      }    }
      
//.
    if (e.getSource()==button[13]){
      if (hasDot==false){
        if(num[count].isEmpty()||num[count].equals("0")) {
        num[count]="0.";
        } else{
          num[count]=num[count]+".";
        }
        hasDot=true;
      }
      label.setText(num[count]);
    }
    
//=
    if (e.getSource()==button[14]){
      if (!(num[1].isEmpty())){
        doOperation();
      }
    }
    
//÷
    if (e.getSource()==button[15]){
      if (count==0 && num[count].length()!=0){
        operation=4;
        count++;
        hasDot=false;
      }
if (count==1 && num[count].length()!=0){
              doOperation();
              num[0]=ans;
              operation=4;
              count++;
              hasDot=false;
            }
    }
    
//^
    if (e.getSource()==button[16]){
      if (count==0 && num[count].length()!=0){
        operation=5;
        count++;
        hasDot=false;
      }if (count==1 && num[count].length()!=0){
        doOperation();
        num[0]=ans;
        operation=5;
        count++;
        hasDot=false;
      }
    }
    //del    
	if (e.getSource()==button[17]){
		if (num[count].length()>0){
			num[count]=num[count].substring(0,num[count].length()-1);
			label.setText(num[count]);
		}
	}

//ans    
	if (e.getSource()==button[18]){
		num[count]=ans;
		label.setText(num[count]);
	}

//AC    
	if (e.getSource()==button[19]){
		operation=0;
		Arrays.fill(num,"");
		hasDot=false;
		count=0;
		label.setText("");
		}
	}
	public void doOperation(){
		switch (operation){
			case 1:
			ans=Double.toString(Double.parseDouble(num[0])+Double.parseDouble(num[1]));
			break;
			case 2:
			ans=(Double.toString(Double.parseDouble(num[0])-Double.parseDouble(num[1])));
			break;
			case 3:
			ans=Double.toString(Double.parseDouble(num[0])*Double.parseDouble(num[1]));
			break;
			case 4:
			if(num[1].equals("0")){
			error=true;
			ans="";
			break;
			}
			ans=Double.toString(Double.parseDouble(num[0])/Double.parseDouble(num[1]));
			break;
			case 5:
			ans=Double.toString(Math.pow(Double.parseDouble(num[0]),Double.parseDouble(num[1])));
			}
		if (error!=true){
			label.setText(ans);
		}
                error=false;
		operation=0;
		Arrays.fill(num,"");
		hasDot=false;
		count--;
		}
}