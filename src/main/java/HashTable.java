import java.util.LinkedList;

public class HashTable {
    // 데이터를 저장할 리스트
    LinkedList<Node>[] data;

    // 테이블 생성 시 크기 지정
    public HashTable(int size) {
        this.data = new LinkedList[size];
    }

    /**
     * @param key
     * @return ASCII 코드로 변환된 HashCode 반환
     */
    int getHashCode(String key){
        int hashcode = 0;
        // ASCII 코드로 변환
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }

    /**
     * @param hashcode
     * @return 배열의 Index값 할당
     */
    int convertToIndex(int hashcode){
        return hashcode % data.length;
    }

    /**
     *
     * @param list
     * @param key
     * @return index로 배열의 방을 찾은 이후 방에 여러개의 Node를 가지고 있을 경우 list에서 key로 해당 노드 찾는 함수
     */
    Node searchKey(LinkedList<Node> list, String key){
        if(list==null) return null;
        for(Node node : list){
            if(node.getKey().equals(key)){
                return node;
            }
        }
        return null;
    }


    void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index]; // index에 해당하는 리스트 가져오기
        if (list == null) { // 해당 리스트가 null이라면
            list = new LinkedList<Node>();  // 새로운 list를 만든다.
            data[index] = list; // 해당 index에 list를 넣어준다.
        }
        Node node = searchKey(list,key); // list에서 node 찾기
        if (node == null) { // 만약 해당 node가 없다면 새로 생성해 넣어준다.
            list.addLast(new Node(key,value));
        }else{ // 기존의 value에 덮어 씌우기
            node.setValue(value);
        }
    }

    String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);
        if(node == null){
            return "Not Found";
        }
        return node.getValue();
    }

}
