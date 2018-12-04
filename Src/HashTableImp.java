
class HashTableImp implements HashTable {
  	private int buckets;
    
    private HashTableLinked[] table;

    public HashTableImp(int buckets) {
		this.buckets = buckets;
        table = new HashTableLinked[buckets];
        for( int i =0;i<buckets;i++){
            table[i]=null;
        }
    }



    public void insert (String key){

        int hashValue= generateHashValue(key);
        
        int value = 1;
        boolean found = false;
        for (HashTableLinked entry = table[hashValue]; entry != null; entry = entry.next) {
            if (entry.getKey().equals(key)) {
                entry.setValue(entry.getValue() + 1);  // trying to add 1 for existing key
                found = true;
                break;
            }
        }
        if (!found) {
            HashTableLinked added = new HashTableLinked(key, value);
            added.next = table[hashValue];
            table[hashValue] = added;
        }
    }

    public int generateHashValue(String key){
    	
            int hashValue = 7;
            for (int i = 0; i < key.length(); i++) {
                hashValue = (hashValue*31 + key.charAt(i))%buckets;
           	 }
            return hashValue;
    	
	}

    public void printHashTable(){

        for (int i = 0; i < buckets; i++){
           	//If(separateFuctions = true)
            System.out.print("\nBucket "+ (i + 1) +"  :    ");
            HashTableLinked entry  = table[i];
            int count=0;
            while (entry != null){
            	count++;
            	
                //System.out.print(entry.getKey()+"  "+entry.getValue() +" \n\t\t");
                entry = entry.next;
            }
            //sIf(separateFuctions = true)
        		System.out.println(count);
        }
    }




    public int search(String key ) {
        int hashValue = generateHashValue( key);
        if (table[hashValue] == null)
            return 0;
        else {
            HashTableLinked entry = table[hashValue];
            while (entry != null ){
                if(entry.getKey().equals(key)){
                	return entry.getValue();
                    // System.out.println(entry.getKey()+"  "+entry.getValue());
                    // System.out.print(hashValue+" "+entry.getKey()+"  "+entry.getValue() +" \n");

                }
                entry = entry.next;
            }
            if (entry == null)
                return 0;

        }
        return hashValue;
    }

  

}
