public class StackQueue_QueueUsingArray {
    public static class Queue{
        int start,end;
        int[] que;
        int size,currsize;

        public Queue(int size){
            this.size=size;
            que=new int[size];
            start=end=-1;
            currsize=0;
        }

        void push(int x){
            if(currsize==size){
                System.out.println("OverFlow");
                return;
            }
            if(currsize==0)
                start=end=0;
            else    
                end=(end+1)%size;
            currsize++;
            que[end]=x;
        }

        int pop(){
            if(currsize==0){
                System.out.println("Underflow");
                return -1;
            }

            int val=que[start];
            currsize--;
            if(currsize==0)
                start=end=-1;
            else
                start=(start+1)%size;
            return val;
        }

        int peek(){
            if(currsize==0){
                System.out.println("Underflow");
                return -1;
            }

            return que[start];
        }

        int size(){
            return currsize;
        }
    }

    public static void main(String[] args) {
        Queue que=new Queue(5);
        que.push(1);
        que.push(2);
        que.push(3);
        que.push(4);
        que.push(5);
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        System.out.println(que.pop());
        que.push(7);
        System.out.println(que.pop());
    }
}
