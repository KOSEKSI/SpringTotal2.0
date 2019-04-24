package empreg;
import java.io.*;
public class EregBean implements Serializable {
	private String eid,ename,egen,elang,edob,eaddr;
	public EregBean(){}
	public void setEid(String eid){
		this.eid=eid;
	}
	public void setEname(String ename){
		this.ename=ename;
	}
	public void setEgen(String egen){
		this.egen=egen;
	}
	public void setElang(String elang){
		this.elang=elang;
	}
	public void setEdob(String edob){
		this.edob=edob;
	}
	public void setEaddr(String eaddr){
		this.eaddr=eaddr;
	}
	public String getEid(){
		return eid;
	}
	public String getEname(){
		return ename;
	}
	public String getEgen(){
		return egen;
	}
	public String getElang(){
		return elang;
	}
	public String getEdob(){
		return edob;
	}
	public String getAddr(){
		return eaddr;
	}
}

