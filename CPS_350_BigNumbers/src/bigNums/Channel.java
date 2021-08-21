package bigNums;
import java.util.*;

/*Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong*/

public class Channel 
{ 
	//this is where we'll test e options from
	BigNumber[] eOptions= {new BigNumber("11"), new BigNumber("17"), new BigNumber("257"), new BigNumber("65537")};
	BigNumber[] p_or_q_options= {new BigNumber("48112959837082048697"), new BigNumber("54673257461630679457"), new BigNumber("29497513910652490397"), new BigNumber("40206835204840513073"), 
			new BigNumber("12764787846358441471")};
	
	//the two prime numbers from which the keys will be fashioned
	BigNumber p=p_or_q_options[0];
	BigNumber q=p_or_q_options[1]; 
	//for n in both keys
	BigNumber n = BigNumber.multi(p,q);
	//for the value of n
	//for the public key
	BigNumber e=new BigNumber("0");
	//for the private key
	BigNumber d=new BigNumber("0");
	
	public Channel() {
		
		BigNumber phi=(BigNumber.multi(BigNumber.sub(p,new BigNumber("1")), BigNumber.sub(q, new BigNumber("1"))));
		phi.display_bigEnd();
		System.out.println(" has been calculated as phi.");
		
		//continuing work on this. Now that we have p, q, and n, we need to find a d and an e to
		//craft the keys from. This is kind of complicated, because to some extent, both depend on n, p and q.
		//If phi, which is the same as ((p-1)*(q-1)), is a certain number, and there is no modular inverse d of 
		//e mod phi such that e*d mod phi=1. In that case, we need a new e. 
		//however, IF the greatest common divisor of e and phi is 1, which means the 2 are coprime, 
		//then there must exist a modular inverse of e mod phi, which is our d value. This means that 
		//we'll need to test e values until one of them is coprime with phi.
		//YAY. Apparently the array at the beginning of this class will allow us to do that.
		//For this, I need a gcd method. It's called greatestCommonDivisor.
		BigNumber ONE=new BigNumber("1");
		for (int i=0;i<eOptions.length;i++) {
			e=eOptions[i];
			System.out.println("e is currently: ");
			e.display_bigEnd();
			BigNumber result1=greatestCommonDivisor(BigNumber.sub(this.p, ONE), e);
			BigNumber result2=greatestCommonDivisor(BigNumber.sub(this.q, ONE), e);
			if(result1==ONE&&result2==ONE) {
				break;
			}
		}//end for
		
		e.display_bigEnd();
		System.out.println(" has been selected as e.");
		
		//Okay, so since the value of d*e has to be larger than phi in order for (d*e)%phi to be 1, or anything
		//other than the number itself, and we already know e, I if I can find the first value of d that makes
		//d*e larger than phi, that's the first possibility value of d that might make (d*e)% phi=1.
		//SO
		//What if that doesn't work? Well, we can just continuously increment d by 1, and thus increase e*d 
		//by an addition of e repeatedly until we get a value for d that works, OR
		//realize that there won't be another opportunity for (d*e)%phi to be 1 until we have a value of (d*e) that
		//is greater than 2*phi.
		
		//The PROBLEM is, where's the stopping case? 
		//Obviously if we find a number that works, that's great. But what if we don't, because it doesn't exist,
		//and we just loop and loop and loop? For this, I'm making the assumption that because e and phi are coprime,
		//there will be a d that works.
		
		d=phi.divideBy(e);
		d=BigNumber.add(d, ONE);
		BigNumber k=new BigNumber("2");
		while(BigNumber.modulus((BigNumber.multi(d, e)), phi)!=ONE) {
			System.out.println("Looking for d...");
			BigNumber nextPossible=BigNumber.multi(phi, k);
			d=nextPossible.divideBy(e);
			d=BigNumber.add(d, ONE);
			k=BigNumber.add(k, ONE);
		}// end while
		d.display_bigEnd();
		System.out.println(" has been selected as d.");
				
	}//end Channel constructor
	
	//What all this is doing:
	//Now, I don't get the math here, but it's what we had in the assignment. 
		//Apparently, if I have 7 numbers:
		//m, c, d, e, p, q, and n
	
		//where n=p*q, and p and q are both prime numbers
		//and (d*e)%((p-1)*(q-1))=1
		//then, no matter what d and e become, as long as they satisfy the above equation
		//I can take any number m, and raise it to the power of e. Then take the result of it, and find result%n.
	
		//Now, let's call "result%m", "c".
	
		//Apparently, if I take c, and raise it to the "d" power instead of the "e", and then use the result
		//(call it newResult)
		//I will find that "newResult%n" will give me the exact same number as m.
	
	//Okay, so we get the super long unicode value, m, as a BigNumber and pop it in here. This will raise that number to the power of
	//e, which is part of the public key, and assign the result of that to c.
	public BigNumber encrypt(BigNumber m) {
		m.simplify();
		BigNumber c;
		System.out.println("Still here...");
		e.display_bigEnd();
		m.display_bigEnd();
		c=(m.toThePowerOf(e));
		System.out.println("The number to be modded by n is ");
		c.display_bigEnd();
		//Okay, now we need to find the remainder of c/n. n is, of course, part of both the public and private keys.
		//Once we find that remainder, we need to assign c to it.
		c=BigNumber.modulus(c,n);
		//Now that c has been calculated by using m and the values in the public key, it represents an encrypted version of m!
		return c;
	
	}//end encrypt
	
	//Okay, so now the receiver of the message just gets c, which is just some BigNumber that, if it were turned into a string,
	//wouldn't become the right unicode value to output the original string! We need to decrypt it.
	
	public BigNumber decrypt(BigNumber c){
		BigNumber m;
		System.out.println("The value of d to use for decryption is: ");
		d.display_bigEnd();
		System.out.println("The value of n to be used for decryption is");
		n.display_bigEnd();
		//raise c to the d power and assign it to m.
		m=(c.toThePowerOf(d));
		System.out.println("After raising to the power of d, the value of m to be modded by n is ");
		m.display_bigEnd();
		//now find the remainder of m/n.
		m=BigNumber.modulus(m, n);
		//This SHOULD give back the unicode value, as a BigNumber, of the original message which we were meant to encrypt. From here, in the main
		//class, we can call a "backToString" method which exists in the BigNumber class, and somehow turn it back
		//into an actual string of characters. Idk about that part yet.
		
		while (m.size()%3!=0) {
			m.tail.next=new Digit(0);
			m.tail.next.previous=m.tail;
			m.tail=m.tail.next;
		}
		
		System.out.println("The result of decryption is: ");
		m.display_bigEnd();
		return m;
		
	}//end decrypt
	
	private BigNumber greatestCommonDivisor(BigNumber a, BigNumber b) {
		System.out.println("Working...");
		BigNumber ZERO=new BigNumber("0");
		if(a==ZERO) {
			return b;
		}
		if(b==ZERO) {
			return a;
		}
		
		else {return greatestCommonDivisor(b, BigNumber.modulus(a, b));}
	}
}	//	End Channel class