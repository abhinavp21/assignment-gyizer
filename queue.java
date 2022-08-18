import java.util.Stack;

public class QueueUsingTwoStacks {
    Stack<Integer> st1, st2;
    void add(int val){
        st1.push(val);
    }
    int poll(){
        int ans=0;
        if(st1.empty())
            ans=-1;
        else{
            while(st1.size()>1){
                int x=st1.pop();
                st2.push(x);
            }
            ans=st1.pop();
            while(!st2.empty()){
                int x=st2.pop();
                st1.push(x);
            }
        }
        return ans;
    }
    int peek(){
        int ans=0;
        if(st1.empty())
            ans= -1;
        else {
            while (st1.size() > 1) {
                int x = st1.pop();
                st2.push(x);
            }
            ans = st1.peek();
            while (!st2.empty()) {
                int x = st2.pop();
                st1.push(x);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        QueueUsingTwoStacks queue=new QueueUsingTwoStacks();
        queue.st1=new Stack();
        queue.st2=new Stack();
        queue.add(10);   // 10
        System.out.println(queue.poll());  // null
        queue.add(20);  // 20
        queue.add(30);  // 20 30
        queue.add(40);  // 20 30 40
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
