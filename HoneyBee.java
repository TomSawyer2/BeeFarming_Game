import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class HoneyBee extends Bee{
	private int id;
//	public static int idFound=10;
//	public static boolean[] beFound={false,false,false,false};
//	public static boolean[] flags={false,false,false,false};
	public HoneyBee(int id,int x, int y, double angle,boolean isAlive,Image img){
		super(id,x,y,angle,isAlive,img);
		this.id = id;
	}
	
	/**此方法是需要重写的核心代码，蜜蜂采蜜的主要个性在此类体现*/
	public void search(){
		String strVision = BeeFarming.search(id);
//		System.out.println(id);
//		System.out.println(idFound);
		String[] strs = strVision.split("~");
		for(int i=0;i<strs.length;i++){
			//如果碰到*为首的字符串，代表遇到了边，这里是随机顺时针旋转90度以内的角度
			if(strs[i].indexOf('*')==0)
			{	
				
				Random ra = new Random();
				if(id%2==0){
					angle += ra.nextInt(90);
				}else{
					angle -= ra.nextInt(90);
				}
				//angle += ra.nextInt(90);
				ratoteImage(angle);
				//ratoteImage(angle+100);
					
				
			}
			//如果碰到-为首的字符串，代表遇到了花，这里是向其中一朵花飞（即使同时看到多个花）
			if(strs[i].indexOf('-')==0)
			{
//				if(beFound[id]==true){
//					if(flags[id]==false){
//						ratoteImage(angle+100);
//						flags[id]=true;
//					}else{
//						ratoteImage(angle+180);
//						flags[id]=false;
//					}
					
//				}else{
					String strTmp = strs[i];
					int start = strTmp.indexOf('(');
					int end = strTmp.indexOf(',');
					String s = strTmp.substring(start+1,end);
					int honey = new Integer(s).intValue();
					strTmp = strTmp.substring(end+1);
					end = strTmp.indexOf(')');
					s = strTmp.substring(0,end);
					if(!s.equals("ON")){
						double a = new Double(s).doubleValue();
						angle = a;
						ratoteImage(angle);
					}
//				}
			}else if(strs[i].indexOf('+')==0){
				String s=strs[i];
				int start=s.indexOf('(');
				int end=s.indexOf(')');
				s=s.substring(start+1, end);
				//System.out.println(s);
				String[] ss=s.split(",");
				int idOfHoneyBee=Integer.parseInt(ss[0]);
				double angleOfDelta=Double.parseDouble(ss[1]);
				double angleOfHoneyBee=Double.parseDouble(ss[2]);
				if(idOfHoneyBee==9){
					if(Math.abs(angleOfHoneyBee-angleOfDelta)>=170&&Math.abs(angleOfHoneyBee-angleOfDelta)<=190){
						angle=angleOfHoneyBee;
					}else{
						angle =180+angleOfHoneyBee;
					}
					/*
					//第一象限
					if(angleOfDelta>=0&&angleOfDelta<=90&&angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=270+angleOfDelta){
						
						//if(angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=270+angleOfDelta){
						for(int idd=0;idd<beFound.length;idd++){
							beFound[idd]=false;
						}	
						beFound[id]=true;
						//}
					//第二象限	
					}else if(angleOfDelta>=90&&angleOfDelta<=180&&angleOfHoneyBee>=0&&(angleOfHoneyBee<=angleOfDelta-90||angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=360)){
//						if(angleOfHoneyBee>=0&&angleOfHoneyBee<=angleOfDelta-90||angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=360){
						for(int idd=0;idd<beFound.length;idd++){
							beFound[idd]=false;
						}
						beFound[id]=true;
							
//						}
						//第三象限
					}else if(angleOfDelta>=180&&angleOfDelta<=270&&(angleOfHoneyBee>=0&&angleOfHoneyBee<=angleOfDelta-90||angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=360)){
//						if(angleOfHoneyBee>=0&&angleOfHoneyBee<=angleOfDelta-90||angleOfHoneyBee>=angleOfDelta+90&&angleOfHoneyBee<=360){
						for(int idd=0;idd<beFound.length;idd++){
							beFound[idd]=false;
						}
						beFound[id]=true;
							
//						}
					}//第四象限
					else if(angleOfDelta>=270&&angleOfDelta<=360&&angleOfHoneyBee>=angleOfDelta-270&&angleOfHoneyBee<=angleOfDelta-90){
//						if(angleOfHoneyBee>=angleOfDelta-270&&angleOfHoneyBee<=angleOfDelta-90){
						for(int idd=0;idd<beFound.length;idd++){
							beFound[idd]=false;
						}
						beFound[id]=true;
//						}
					}else{
						for(int idd=0;idd<beFound.length;idd++){
							beFound[idd]=false;
						}
						
					}
					*/
					ratoteImage(angle);
				}else{
					Random ra = new Random();
					Random rb =new Random();
					if(rb.nextInt(2)==1)
						angle -=(45+(ra.nextInt(90)));
						
					else
						angle += (45+(ra.nextInt(90)));
					ratoteImage(angle);
					//System.out.println(strs[i]);
				}
			}
		}
		setXYs(0);
	}
}