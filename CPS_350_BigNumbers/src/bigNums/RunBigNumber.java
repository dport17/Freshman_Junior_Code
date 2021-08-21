package bigNums;

/*Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong*/

import java.util.regex.Pattern;

public class RunBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//the addition tests
		BigNumber x = new BigNumber("36583291");
		BigNumber y= new BigNumber("0");
		BigNumber result=BigNumber.add(x, y);
		result.display_bigEnd();
		
		result=BigNumber.add(y, x);
		result.display_bigEnd();
		
		result=BigNumber.add(x, new BigNumber("846489"));
		result.display_bigEnd();
		
		result=BigNumber.add(new BigNumber("846489"), x);
		
		//subtraction tests
		result=BigNumber.sub(x, y);
		result.display_bigEnd();
		result=BigNumber.sub(y, x);
		result.display_bigEnd();
		
		BigNumber z= new BigNumber("36583290");
		result=BigNumber.sub(x, z);
		result.display_bigEnd();
		result=BigNumber.sub(z,x);
		result.display_bigEnd();
		
		//the multiplication tests
		result=BigNumber.multi(x, new BigNumber("846489"));
		result.display_bigEnd();
		result=BigNumber.multi(new BigNumber("846489"), x);
		result.display_bigEnd();
		
		result=BigNumber.multi(x, new BigNumber("-1"));
		result.display_bigEnd();
		
		result=BigNumber.multi(new BigNumber("-1"), x);
		result.display_bigEnd();
		
		result=BigNumber.multi(x, new BigNumber("0"));
		result.display_bigEnd();
		
		result=BigNumber.multi(new BigNumber("0"),x);
		result.display_bigEnd();
		
		result=x.divideBy(new BigNumber("-1"));
		result.display_bigEnd();
		
		result=new BigNumber("-1").divideBy(x);
		result.display_bigEnd();
		
		result=new BigNumber("1").divideBy(x);
		result.display_bigEnd();
		
		result=x.divideBy(new BigNumber("1"));
		result.display_bigEnd();
		
		result=x.divideBy(new BigNumber("846489"));
		result.display_bigEnd();
		
		result=z.divideBy(x);
		result.display_bigEnd();
		
		//multi tests
		
		
	}//end main

}//end RunBigNumber