package algorithm.dataStructure.v1;

import lombok.Data;

import java.util.Stack;

/**
 * 题目：实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能更
 * 准备两个栈，一个data栈，一个min栈。数据压data栈，min栈对比min栈顶元素，谁小加谁。这样的话data栈和min栈是同步上升的，元素个数一样多，
 * 且min栈的栈顶，是data栈所有元素中最小的那个。数据弹出data栈，我们同步弹出min栈，保证个数相等，切min栈弹出的就是最小值
 */
public class StackTest {

    @Data
    public static class Stack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public Stack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            // 当前最小栈为空，直接压入
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
                // 当前元素小于最小栈的栈顶，压入当前值
            } else if (newNum <= this.getMin()) {
                this.stackMin.pop();
            }


        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("stack empty");
            }
            return this.stackMin.peek();
        }

        public int pop() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("stack empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        //原来作者的代码
        public static class MyStack2 {
            private Stack<Integer> stackData;
            private Stack<Integer> stackMin;

            public MyStack2() {
                this.stackData = new Stack<Integer>();
                this.stackMin = new Stack<Integer>();
            }

            public void push(int newNum) {
                if (this.stackMin.isEmpty()) {
                    this.stackMin.push(newNum);
                } else if (newNum < this.getmin()) {
                    this.stackMin.push(newNum);
                } else {
                    int newMin = this.stackMin.peek();
                    this.stackMin.push(newMin);
                }
                this.stackData.push(newNum);
            }

            public int pop() {
                if (this.stackData.isEmpty()) {
                    throw new RuntimeException("Your stack is empty.");
                }
                // 弹出操作，同步弹出，保证大小一致，只返回给用户data栈中的内容即可
                this.stackMin.pop();
                return this.stackData.pop();
            }

            public int getmin() {
                if (this.stackMin.isEmpty()) {
                    throw new RuntimeException("Your stack is empty.");
                }
                return this.stackMin.peek();
            }
        }


    }


    /**
     * 用栈实现队列
     */
    private static class TwoStacksImplementQueue {

        public static class TwoStackQueue {
            public Stack<Integer> stackPush;
            public Stack<Integer> stackPop;
            public TwoStackQueue() {
                this.stackPush = new Stack<>();
                this.stackPop = new Stack<>();
            }
            //push stack inject data into pop stack
            private void pushToPop() {
                if (stackPop.empty()) {
                    while (!stackPush.empty()) {
                        stackPop.push(stackPush.pop());
                    }
                }
            }

            public void add(int data) {
                stackPush.push(data);
                pushToPop();
            }

            public int poll() {
                if (stackPop.empty() && stackPush.empty()) {
                    throw new RuntimeException("Queue is empty!");
                }pushToPop();
                return stackPop.pop();
            }
            public int peek() {
                if (stackPop.empty() && stackPush.empty()) {
                    throw new RuntimeException("Queue is empty!");
                }
                pushToPop();
                return stackPop.peek();
            }



        }



    }

    //int mid = l + ((r - l) >> 1);
    //求求数组arr[L...R]中的最大值，怎么用递归方法实现
    public static int getMax(int[] arr) {
        return processingMax(arr, 0, arr.length - 1);
    }

    public static int processingMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftmax = processingMax(arr, l, mid);
        int rightmax = processingMax(arr, mid + 1, r);
        return Math.max(leftmax, rightmax);
    }



    public static void main(String[] args) {
        TwoStacksImplementQueue.TwoStackQueue test = new TwoStacksImplementQueue.TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }




}
