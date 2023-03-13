package ko.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*자료 구조 , 자료를 꺼내가면 꺼낸 자료는 삭제됨 
 * Stack ==> 후입선출(LIFO:Last In First Out)
 * Queue ==> 선입선출(FIFO:First In First Out)
*/
public class StackQueueTest {
	public static void main(String[] args) {
	/*
	 * stack의 명령
	 * 1.자료 입력 : push(입력값)
	 * 2.자료 출력 : pop()  ==> 자료를 꺼내온 후 꺼낸 자료를 Stack에서 삭제한다.
	 *               peek() ==> 삭제 없이 자료를 꺼내온다. (확인용,필요로 하는 자료가 있는지 확인 할 때 사용)
	 *               
     */		
		Stack<String> stack = new Stack<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("성춘향");
		stack.push("변학도");
		System.out.println("현재 Stack ==> "+stack);
		System.out.println("꺼낸 Stack ==> "+stack.pop());
		System.out.println("꺼낸 Stack ==> "+stack.pop());
		System.out.println("현재 Stack ==> "+stack);
		System.out.println("확인 Stack ==> "+stack.peek());
		System.out.println("입력 Stack ==> "+stack.push("강감찬"));		
		System.out.println("현재 Stack ==> "+stack);
		System.out.println("꺼낸 Stack ==> "+stack.pop());
		System.out.println("현재 Stack ==> "+stack);
		
		System.out.println("--------------------------------------------");
		/*
	     * Queue의 명령
		 * .자료 입력 : offer(입력값)
	     * 2.자료 출력 : poll() ==> 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
                         peek() ==> 삭제 없이 자료를 꺼내온다.
           Queue는 LinkedList 를 이용해서 사용 할 수 있다.                         
		*/               
		Queue<String> queue = new LinkedList<>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("성춘향");
		queue.offer("변학도");
		
		System.out.println("현재 Queue ==>"+queue);
		System.out.println("꺼낸 Queue ==>"+queue.poll());
		System.out.println("현재 Queue ==>"+queue);
		System.out.println("확인 Queue ==>"+queue.peek());
		queue.offer("강감찬");
		System.out.println("현재 Queue ==>"+queue);
		System.out.println("꺼낸 Queue ==>"+queue.poll());
		System.out.println("현재 Queue ==>"+queue);
		
		
		
		
	}
}
