import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.FontFamilyAction;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.awt.*;
import java.awt.event.*;
class foodBill
{
		static JTextField jt1;
		static JTextField jt2;
		static JTextField jt3;
		static JComboBox jb1;
		static JLabel jl1;
		static JLabel jl2;
		static JLabel jl3;
		static JLabel jl4;
		static JFrame jf;
		static JButton jb2;
		static JButton jb3;
		static JTextArea ja;
		public static void main(String args[])
		{
			jf=new JFrame("McDonald's");
			jf.setSize(680,900);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setLayout(new FlowLayout());
			jl1=new JLabel("ORDER NO:");
			jl2=new JLabel("SELECT ITEM");
			jl3=new JLabel("QUANTITY");
			jl4=new JLabel("TOTAL");
			jt1=new JTextField(10);
			jt2=new JTextField(10);
			jt3=new JTextField(10);
			jb1=new JComboBox();
			jb2=new JButton("GENERATE BILL");
			jb3=new JButton("CLEAR");
			ja=new JTextArea(40,60);//40	60
			ja.setBounds(50,50,100,100);
			jb1.addItem("McChicken Burger");
			jb1.addItem("McSaver Chicken Nuggets");
			jb1.addItem("Paneer Pizza");
			jb1.addItem("Veg Momos(5pcs)");
			jb1.addItem("French Fries(M)");
			jb1.addItem("Chicken Popcorn(R)");
			jf.add(jl1);//orderno
			jf.add(jt1);//text field of orderno
			jf.add(jl3);//quantity
			jf.add(jt2);//textfield of quantity
			jf.add(jl2);//select item
			jf.add(jb1);//combobox of item selection
			jf.add(jl4);//total
			jf.add(jt3);//textfield of total
			jf.add(jb2);//generate bill button
			jf.add(jb3);//clear button
			jf.add(ja);//text area
			jf.setVisible(true);
			listen l=new listen();
			lis ls=new lis();
			jb1.addActionListener(l);
			jb2.addActionListener(ls);
			jb3.addActionListener(ls);
		}
		void menu(char sym)
		{	
		
			try
			{
				int qty=Integer.parseInt(jt2.getText());
				int total=0;
				String ans;
				switch(sym)
				{
					case 'F':	
						total=total+(95*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
					case 'B':
						total=total+(120*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
					case 'N':
						total=total+(94*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
					case 'f':
						total=total+(269*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
					case 'R':
						total=total+(199*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
					case 'V':
						total=total+(168*qty);
						ans=String.valueOf(total);
						jt3.setText(ans);
						break;
				}
			}
			catch(Exception n)
			{
				JOptionPane.showMessageDialog(jf,n);  
			}
		}
		void bill(char c)
		{
			try
			{
				int n1=Integer.parseInt(jt1.getText());
				int n2=Integer.parseInt(jt2.getText());
				int n3=Integer.parseInt(jt3.getText());
				switch(c)
				{	
					case 'G':
						DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDateTime now=LocalDateTime.now();
						DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalDateTime now1=LocalDateTime.now();
						ja.append("Date:"+dtf.format(now)+"\t\t\t\t\t"+"                 Time:"+dtf1.format(now1));
						ja.append("\n\t\t**********HELLO!"+" "+"WELCOME TO McDonald's**********");
						ja.append("\n\n\n\nYOUR ORDER NUMBER:"+n1);	
						ja.append("\nYOU ORDERED:"+jb1.getSelectedItem());
						ja.append("\nQUNATITY:"+n2);	
						ja.append("\nAMOUNT TO BE PAID:"+n3);
						ja.append("\n\n\n\n\n\t\t\t"+"THANK YOU,VISIT  AGAIN");						
						break;
					case 'C':
						jt1.setText("");
						jt2.setText("");
						jt3.setText("");
						ja.setText("");
						break;
						
				}
			}
			catch(Exception o)
			{
				JOptionPane.showMessageDialog(jf,o);  
			}
			
		}	
}
class listen extends foodBill implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if(jb1.getSelectedItem().equals("French Fries(M)"))
		{
			foodBill obj=new foodBill();
			obj.menu('F');
		}
		else if(jb1.getSelectedItem().equals("McChicken Burger"))
		{
			foodBill obj=new foodBill();
			obj.menu('B');
		}
		else if(jb1.getSelectedItem().equals("McSaver Chicken Nuggets"))
		{
			foodBill obj=new foodBill();
			obj.menu('N');
		}
		else if(jb1.getSelectedItem().equals("Paneer Pizza"))
		{
			foodBill obj=new foodBill();
			obj.menu('f');
		}
		else if(jb1.getSelectedItem().equals("Veg Momos(5pcs)"))
		{
			foodBill obj=new foodBill();
			obj.menu('R');
		}
		else
		{
			foodBill obj=new foodBill();
			obj.menu('V');
		}
	}
}
class lis implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("GENERATE BILL"))
		{
			foodBill obj=new foodBill();
			obj.bill('G');
		}
		else
		{
			foodBill obj=new foodBill();
			obj.bill('C');
		}
	}
}