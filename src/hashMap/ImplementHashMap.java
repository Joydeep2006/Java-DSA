import java.util.*;
public class ImplementHashMap {
    static class HashMap<K,V>{ // generics
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total no. of nodes
        private int N; // size of the bucket array
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                buckets[i] = new LinkedList<>();
            }
        }

        // returns the index of the bucket
        private int hashFunction(K key){
            int hc = key.hashCode();
            hc = Math.abs(hc) % buckets.length;
            return hc;
        }

        // to search for the key in the bucket idx
        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        // to rehash the HashMap for better T.C
        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            // initialize the buckets with empty linkedList
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            // copying all the nodes from the oldBucket to new bucket
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get();
                    this.put(node.key,node.value);
                }
            }
        }

        // to put a key-value pair in the hashMap
        public void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di!=-1){ // key exists update the value of the key
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{ // the key does not exist
                buckets[bi].add(new Node(key,value));
                n++;
            }
            // parameter to check reHash is required
            double lamdha = (double)n/N;
            if(lamdha>2.0){
                reHash();
            }
        }

        // to check if a key exists in hashMap
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            if(searchInLL(key, bi) == -1){
                return false;
            }else{
                return true;
            }
        }
        // to return the value to the corresponing key
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di==-1){
                return null;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // to remove a key-value pair
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1){
                Node node = buckets[bi].remove(di);
                return node.value;
            }
            else{
                return null;
            }
        }
        // to return an arrayList of all the keys of the HashMap
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            // go to every bucket idx
            for(int i=0;i<buckets.length;i++){
                // now in each bucket idx go to every node
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    keys.add(buckets[i].get(j).key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        hm.put("Joydeep",104);
        hm.put("Suman",48);
        hm.put("Sudip",47);
        System.out.println(hm.containsKey("Suman"));
        System.out.println(hm.get("Joydeep"));
        System.out.println(hm.keySet());

    }
}
