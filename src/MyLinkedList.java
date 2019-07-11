class MyLinkedList {
        class Node{
            int val;
            Node next;
            public Node(int v){
                this.val = v;
            }
        }

        int size;
        Node sentinel;



        /** Initialize your data structure here. */
        public MyLinkedList() {
            size = 0;
            this.sentinel = new Node(-1);
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index >= size || index < 0 ){
                return -1;
            }else{
                Node ptr = this.sentinel;
                int count = 0;
                while (count != index){
                    ptr = ptr.next;
                    count++;
                }
                return ptr.next.val;
            }

        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = this.sentinel.next;
            this.sentinel.next = node;
            this.size += 1;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            int count = 0;
            Node ptr = this.sentinel;
            while(count < size){
                ptr = ptr.next;
                count++;
            }
            ptr.next = new Node(val);
            this.size += 1;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size){
                return;
            }else if (index <= 0){
                addAtHead(val);
                return;
            }else if (index == size){
                addAtTail(val);
                return;
            }else{
                int count = 0;
                Node node = new Node(val);
                Node ptr = this.sentinel;
                while(count < index){
                    ptr = ptr.next;
                    count++;
                }
                node.next = ptr.next;
                ptr.next = node;
                this.size += 1;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node ptr = this.sentinel;
            int count = 0;
            while (count < index){
                ptr = ptr.next;
                count++;
            }
            ptr.next = ptr.next.next;
            this.size -= 1;
        }
}
