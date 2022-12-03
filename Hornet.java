import java.awt.*;
import java.awt.image.*;
import java.util.*;
public class Hornet extends Bee{
	private int id;
	private boolean dead=false;
	private boolean look=false;
	public Hornet(int id,int x, int y, double angle,boolean isAlive,Image img){
		super(id,x,y,angle,isAlive,img);
		this.id = id;
	}
	
	/**此方法是需要重写的核心代码，蜜蜂采蜜的主要个性在此类体现*/
	public void search()
	{
		String strVision = BeeFarming.search(id);
		String[] strs = strVision.split("~");
	
		
		for(int i=0;i<strs.length;i++)
		{
			//如果碰到*为首的字符串，代表遇到了边，这里是随机顺时针旋转90度以内的角度
			if(strs[i].indexOf('*')==0)
			{	
			        double debian;
					String strTmp = strs[i];
					char bian=strTmp.charAt(1);
					if(bian=='N')
						debian=270;
					else if(bian=='E')
						debian=0;
					else if(bian=='S')
						debian=90;
					else 
						debian=180;
					double lim;
					boolean fuhao=true;
					if(this.angle >= debian){
						lim=90-(this.angle-debian);
						fuhao=true;
					}
					else{
						lim=90-(debian-this.angle);
						fuhao=false;
					}
					if(lim<0)
						lim=90;
					// System.out.println(id+":lim"+lim);
					Random ra = new Random();
					double degree=ra.nextInt(140);
					while(degree<lim)
						degree=ra.nextInt(140);
					if(fuhao)
						angle += degree;
					else
						angle -= degree; 
					//System.out.println(id+":degree"+degree);
					/* Random ra = new Random();
					double degree=ra.nextInt(360); */
					ratoteImage(angle); 
								
			}
			//如果碰到-为首的字符串，代表遇到了花，这里是向其中一朵花飞（即使同时看到多个花）
			if(strs[i].indexOf('-')==0)
			{
				String strTmp = strs[i];
				int end = strTmp.indexOf(',');
				strTmp = strTmp.substring(end+1);
				end = strTmp.indexOf(')');
				String s = strTmp.substring(0,end);
				if(!s.equals("ON")){
					double a = new Double(s).doubleValue();
				
					if(!look)
					{
						ratoteImage(a);
					}
				}
				//System.out.println("Hornet sees a flower !");
			} 
			else if(strs[i].indexOf('+')==0)
			{
			   look=true;
			   String[] strs1Temp= strs[i].split(","); 
			   String st=strs1Temp[1];
			   double r_angle = new Double(st).doubleValue();//看到蜜蜂就询问BeeFarming 自己与蜜蜂的夹角
			   ratoteImage(r_angle);
		    }
			else  {
			Random ra = new Random();
			angle -= ra.nextInt(15);
			ratoteImage(angle);
			if(look)
			{
			boolean zhuan=false;
			Random ra1 = new Random();
			zhuan = ra1.nextBoolean();
			if(zhuan)
				angle+=90;
			else
				angle-=90;
				ratoteImage(angle);
				look=false;
			}
			}
			
			
			
				//System.out.println(strs[i]);						
			
//下面是一个黄蜂抓到蜜蜂后并得知该消息的具体展示，可以随意修改
			if(dead==true){
					System.out.println("杀死");
				/**当判定完黄蜂抓到了蜜蜂后，请务必将boolean dead设为false，不然会影响黄蜂下一轮的判断*/
					dead = false;
					}
		}
		setXYs(0);
	}
	/**如果黄蜂抓到了蜜蜂，则boolean dead==true，黄蜂可以根据dead的值判断蜜蜂知否被杀死。
	本方法可以修改，在BeeFarming的killBee方法中当蜜蜂被黄蜂消灭后将被调用*/
	public boolean isCatched(){
	    dead = true;
	    return dead;
	}
	  
}