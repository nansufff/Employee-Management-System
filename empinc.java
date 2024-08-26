import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class EmployeeSal extends JFrame implements ActionListener
{
JButton inc;
JTextField id,vf,csal,amt,newsal;
JLabel heading,empid,verf,current,amount,neww;
EmployeeSal()
{
super("Nandhana Suffin_Roll No.4");
inc=new JButton("Increment");
heading=new JLabel("Increment Salary");
empid=new JLabel("Employee Id*  :");
verf=new JLabel("Validation");
current=new JLabel("Previous Salary:");
amount=new JLabel("Amount incremented*  :");
neww=new JLabel("Updated Salary:");
id=new JTextField(10);
vf=new JTextField(30);
csal=new JTextField(10);
amt=new JTextField(10);
newsal=new JTextField(10);
add(heading);
add(inc);
add(id);
add(vf);
add(csal);
add(amt);
add(newsal);
add(empid);
add(verf);
add(current);
add(amount);
add(neww);
setLayout(null);
heading.setBounds(125,20,200,50);
empid.setBounds(20,70,150,20);
amount.setBounds(20,100,200,20);
verf.setBounds(20,130,150,20);
current.setBounds(20,160,200,20);
neww.setBounds(20,190,150,20);
id.setBounds(200,70,100,20);
amt.setBounds(200,100,100,20);
vf.setBounds(200,130,100,20);
csal.setBounds(200,160,100,20);
newsal.setBounds(200,190,100,20);
inc.setBounds(330,110,200,40);
setSize(700,400);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
inc.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
Object source=ae.getSource();
try
{double currentsalary=0,incamt,newsalary;
int emp_id=0,row,flag=0;
Class.forName("com.mysql.cj.jdbc.Driver");
Connection
con=DriverManager.getConnection("jdbc:mysql://localhost3306/empl
oyeedata","root","password");
Statement stm=con.createStatement();
emp_id=Integer.parseInt(id.getText());
incamt=Double.parseDouble(amt.getText());
if(source==inc)
{
String qry="select * from employee where empid="+emp_id+" ;";
ResultSet rs=stm.executeQuery(qry);
while(rs.next())
{
f
lag=1;
emp_id=Integer.parseInt(rs.getString(1));
vf.setText("ID VERIFIED");
currentsalary=Double.parseDouble(rs.getString(3));
csal.setText(rs.getString(3));
}
if (flag==1)
{
newsalary=currentsalary+incamt;
String qry1="update employee set salary= "+newsalary+" where empid=
"+emp_id+" ;";
row=stm.executeUpdate(qry1);
if(row==1)
{
newsal.setText(Double.toString(newsalary));
}
}
else if(flag==0)
{
vf.setText("INVALID ID");
newsal.setText("");
csal.setText("");
amt.setText("");
}
rs.close();
stm.close();
con.close();
}
}
catch(ClassNotFoundException e)
{System.out.println(e);
}
catch(SQLException e)
{
System.out.println(e);
}
}
public static void main(String args[])
{
EmployeeSal obj=new EmployeeSal();
}
}
