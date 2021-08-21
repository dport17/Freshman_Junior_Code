package bigNums;
import java.util.*;
public class CryptoSystemMain {
	/*Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String[] testStrings= {"SOS", "Hello, World!"};
		for(String element : testStrings) {
			String message=element;
			String unicodeVal="";
			for(int i=0;i<message.length();i++) {
				
				int unicode=message.codePointAt(i);
				if((unicode/100)==0) unicodeVal=unicodeVal+"0";
	
				unicodeVal=unicodeVal+unicode;
			}//end for
			
			System.out.println(unicodeVal);
			
			//eventually we'll have the user select this.
			Channel secureChannel=new Channel();
			
			//Convert the unicodeVal, which is a string of the unicode values of the message's characters, into a BigNumber, so we can operate on it.
			BigNumber m=new BigNumber(unicodeVal);
			//just to make sure it converted correctly...
			System.out.println("The unicode value of your message is: ");
			m.display_bigEnd();
			System.out.println();
			
			//This is where we encrypt the unicodeVal. 
			BigNumber c=secureChannel.encrypt(m);
			System.out.println("The result of encryption is: ");
			c.display_bigEnd();
			System.out.println();
			
			
			m=secureChannel.decrypt(c);
			String messageUnicode=m.backToString();
			String actualMessage="";
			for(int startIndex=0;startIndex<=m.size()-3; startIndex+=3) {
				String toBeCast=messageUnicode.substring(startIndex, startIndex+3);
				int unicode=Integer.parseInt(toBeCast);
				actualMessage=actualMessage+(char)unicode;
			}
			System.out.println(actualMessage);
		}//end while loop
	}//end main

}//end CryptoSystemMain
