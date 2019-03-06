import java.util.EmptyStackException;
import java.util.Stack;

public class Peg {
	
	private Stack<Disc> discs;
	private int x;
	private char letter;
	
	public Peg(int x, char letter) {
		discs = new Stack<>();
		this.x = x;
		this.letter = letter;
	}
	
	public String toString() {
		return ""+letter;
	}
	
	public void moveTopDiscTo(Peg to) {
		boolean t1 = true;
		boolean t2 = true;
		Disc top1 = null, top2 = null;
		try {
			top1 = pop();
		} 
		catch(EmptyStackException e) {
			t1 = false;
			top2 = to.pop();
			push(top2);
		}
		try {
			if(t1) top2 = to.pop();
		}
		catch(EmptyStackException e) {
			t2 = false;
			top1 = pop();
			to.push(top1);
		}
		if(t1&&t2) {
			if(top1.getWidth()>top2.getWidth()) {
				push(top1);
				push(top2);
			}
			else {
				to.push(top2);
				to.push(top1);
			}
		}
	}
	
	public Stack<Disc> getDiscs(){return discs;}
	
	public void push(Disc dAdd) {
		discs.push(dAdd);
	}
	public Disc pop() {
		return discs.pop();
	}
}
