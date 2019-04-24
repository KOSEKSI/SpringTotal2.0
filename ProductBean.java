package shopping;
import java.io.*;
public class ProductBean implements Serializable{
     String pName,pCode;
	int pQuantity;
	float pPrice;
public ProductBean(){}
public void setPname(String pName){
	this.pName=pName;
}
public void setPCode(String pCode){
	this.pCode=pCode;
}
public void setPquantity(int pQuantity)
{
	this.pQuantity=pQuantity;
}
public void setPprice(float pPrice) {
	this.pPrice=pPrice;
}
public String getPCode(){
	return pCode;
}
public String getPName(){
	return pName;
}
public int getPQuantity(){
	return pQuantity;
}
public float getPprice(){
	return pPrice;
}
}
