package empreg;
import java.io.*;
public class EretriveBean implements Serializable {
	private String eid1,ename1,egen1,elang1,edob1,eaddr1;
	public EretriveBean() {}
	public void setEid(String eid1){
		this.eid1=eid1;
	}
	public void setEname(String ename1){
		this.ename1=ename1;
	}
	public void setEgen(String egen1){
		this.egen1=egen1;
	}
	public void setElang(String elang1){
		this.elang1=elang1;
	}
	public void setEdob(String edob1){
		this.edob1=edob1;
	}
	public void setEaddr(String eaddr){
		this.eaddr1=eaddr1;
	}
	public String getEid(){
		return eid1;
	}
	public String getEname(){
		return ename1;
	}
	public String getEgen(){
		return egen1;
	}
	public String getElang(){
		return elang1;
	}
	public String getEdob(){
		return edob1;
	}
	public String getAddr(){
		return eaddr1;
	}

}
