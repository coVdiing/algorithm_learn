package com.vi.algorithm.linear;

/**
 * 使用环形链表解决约瑟夫环问题
 */
public class JosephuProblem {
    public static void main(String[] args) {
        CircleLinkList cll = new CircleLinkList();
        cll.buildCircle(10);
//        cll.showCircle();
        cll.game(1,3,10);
    }
}

//  环形链表
class CircleLinkList {
    private Child first = null;

    public CircleLinkList() {
    }

    //  内部类成员，表示约瑟夫问题中的每个孩子
    private class Child {
        int no;
        Child next;

        public Child(int data) {
            this.no = data;
        }
    }

    //  构建一个环形链表
    public void buildCircle(int num) {
        if (num < 1) {
            System.out.println("构建的数量不合理!失败");
            return;
        }
        if (num == 1) {
            first = new Child(1);
            //  如果链表中只有一个元素，头节点下个指向自己
            first.next = first;
        } else {
            first = new Child(1);
            Child current = first;
            for (int i = 2; i <= num; i++) {
                Child newChild = new Child(i);
                current.next = newChild;
                current = current.next;
                if (i == num)
                    //  形成环
                    current.next = first;
            }
        }
    }

    //  遍历链表
    public void showCircle() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Child current = first;
        do {
            System.out.println("孩子" + current.no);
            current = current.next;
        } while (current != first);
    }

    /**
     * 小孩出圈的方法实现
     * @param startNo 从哪个位置开始报数
     * @param step  每次几个人报数
     * @param total 参加游戏的总人数
     */
    public void game(int startNo, int step, int total) {
        //  判断输入的参数是否合法
        if (startNo < 1 || startNo > total || step < 1) {
            System.out.println("输入的参数有误");
            return;
        }
        //  定义1个辅助指针，指向头节点的前一个位置
        Child pre = first;
        while (pre.next != first) {
            pre = pre.next;
        }
        //  定义一个当前指针，指向头结点
        Child current = first;
        //  将两个指针调整到游戏开始的位置
        for (int i = 1; i < startNo; i++) {
            current = current.next;
            pre = pre.next;
        }
        //  开始报数,游戏结束的条件是圈中只剩下一个孩子，届时两个指针会指向相同位置
        while (current != pre) {
            //  报数step-1次而不是step次，因为要把自己算进来
            for (int i = 1; i < step; i++) {
                current = current.next;
                pre = pre.next;
            }
            //  current指向的孩子出局，将current的后一个孩子和pre指向的孩子链接起来
            System.out.println("孩子=>"+current.no+"出局");
            Child temp = current;
            current = current.next;
            pre.next = current;
            //  将出局的孩子节点置空，让gc处理
            temp.next = null;
            temp = null;
        }
        System.out.println("最后留在圈中的孩子是==>"+current.no);
    }
}
