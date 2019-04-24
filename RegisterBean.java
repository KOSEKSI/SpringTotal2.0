package userreg1;
//it is a java bean class
import java.io.*;
public class RegisterBean implements Serializable {
private String Uname,Pword,Fname,Lname,Addr,Emailid;
private long Phone;
public RegisterBean(){}

public void setUName(String Uname)
{
	this.Uname=Uname;
}

public void setPWord(String Pword){
	this.Pword=Pword;
}
public void setFName(String Fname){
	this.Fname=Fname;
}
public void setLName(String Lname){
	this.Lname=Lname;
}
public void setADdr(String Addr){
	this.Addr=Addr;
}
public void setEMailid(String EMailid){
	this.Emailid=EMailid;
}
public void setPHone(long Phone){
	this.Phone=Phone;
}

public String getUName(){
	return Uname;
}
public String getPWord(){
	return Pword;
}
public String getFName(){
	return Fname;
}
public String getLName(){
	return Lname;
}
public String getADdr(){
	return Addr;
}
public String getEMailid(){
	return Emailid;
}
public long getPHone(){
	return Phone;
}
}
