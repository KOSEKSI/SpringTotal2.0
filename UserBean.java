package shopping;

import java.io.Serializable;

public class UserBean implements Serializable {
private String uname,pass,fname,sname,addr;
private long phone;
private String mail;

public UserBean()
{
	//constructor

}

public void setUname(String uname){
	this.uname=uname;
}
public void setPass(String pass){
	this.pass=pass;
}
public void setFname(String fname){
	this.fname=fname;
}
public void setSname(String sname){
	this.sname=sname;
}
public void setAddr(String addr){
	this.addr=addr;
}
public void setPhone(long phone){
	this.phone=phone;
}
public void setMail(String mail){
	this.mail=mail;
}

public String getUname(){
	return uname;
}

public String getPass(){
	return pass;
}

public String getFname(){
	return fname;
}
public String getSname(){
	return sname;
}

public String getAddr(){
	return addr;
}
public long getPhone(){
	return phone;
}

public String getMail(){
	return mail;
}
}
