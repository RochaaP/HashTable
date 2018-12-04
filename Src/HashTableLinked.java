
public class HashTableLinked {

        private String key;
        int value;
        HashTableLinked next;



        public HashTableLinked(String key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
;
        }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
            return key;
        }
        public int getValue(){
            return value;
        }
}
