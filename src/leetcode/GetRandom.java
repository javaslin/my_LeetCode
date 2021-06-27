package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandom {

    private List<Integer> list;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public GetRandom(ListNode head) {
        random=new Random();
        this.list=new ArrayList<>();
        while (head!=null && head.next!=null){
            list.add(head.val);
            head=head.next;
        }
        if(head!=null && head.next==null){
            list.add(head.val);
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        if(list.size()==0) return 0;
        int res=0;

        int rd=random.nextInt(list.size());

        return list.get(rd);
    }
}


