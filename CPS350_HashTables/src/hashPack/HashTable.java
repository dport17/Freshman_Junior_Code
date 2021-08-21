package hashPack;

public class HashTable {
	int[] HashArray;
	boolean[] occupied;
	static int TABLE_SIZE;
	public HashTable(int size){
		TABLE_SIZE=size;
		HashArray=new int[size];
		occupied=new boolean[size];
	}//end constructor
	
	private int getIndexBySimpleHashing(int key) {
		int hashIndex=key%TABLE_SIZE;
		
		if(occupied[hashIndex]) {
			return getIndexByLinearProbing(key);
		}
		
		occupied[hashIndex]=true;
		return hashIndex;
		
	}//end simple hashing
	
	private int getIndexByLinearProbing(int key) {
		int attempt=1;
		int hashIndex=(key%TABLE_SIZE);
		while (occupied[hashIndex]) {
			if (hashIndex+1==TABLE_SIZE&&occupied[hashIndex+1]) {
				
			}//end if
			hashIndex=key%TABLE_SIZE+attempt;
			attempt++;
			
		}//end while loop
		occupied[hashIndex]=true;
		return hashIndex;
	}//end linear probing
	
	private int getIndexByQuadProbing(int key) {
		
	}//end 
	
	private int getIndexByDoubleHashing(int key) {
		
	}
}//end HashTable
