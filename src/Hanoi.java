import java.awt.Canvas;

public class Hanoi extends Canvas{
	
	public static void main(String[] args) {
		new Hanoi();
	}
	
	public Hanoi() {
		super();
		Peg[] pegs = {new Peg(150, 'S'), new Peg(450, 'A'), new Peg(750, 'D')};
		pegs[0].push(new Disc(pegs[0]));
		pegs[0].push(new Disc(pegs[0]));
		pegs[0].push(new Disc(pegs[0]));
		print(pegs);
		hanoi(pegs.length, pegs[0], pegs[2], pegs[1]);
	}
	
	public void hanoi(int size, Peg from, Peg to, Peg aux) {
		Peg[][] moves = getHanoiMoves(size, from, to, aux);
		for(int i =0; i<moves.length; i++) {
			for(int j=0; j<moves[i].length; j++) {
				System.out.print(moves[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i<moves.length; i++) {
			moves[i][0].moveTopDiscTo(moves[i][1]);
		}
	}
	
	private Peg[][] getHanoiMoves(int size, Peg from, Peg to, Peg aux){
		if(size%2==0) {
			Peg temp = to;
			to = aux;
			aux = temp;
		}
		int num = (int)(Math.pow(2, size)-1);
		Peg[][] moves_ = new Peg[num][];
		for(int i=1; i<=num; i++) {
			moves_[i-1] = new Peg[2];
			if(i%3==1){moves_[i-1][0]= from; moves_[i-1][1] = to;}
			else if(i%3==2){moves_[i-1][0]= from; moves_[i-1][1] = aux;}
			else if(i%3==0){moves_[i-1][0]= aux; moves_[i-1][1] = to;}
			}
		return moves_;
	}
	
	public static void print(Peg[] pegs) {
		int i = 1;
		for(Peg peg : pegs) {
			System.out.println("Peg " + i++);
			for(Disc disc : peg.getDiscs()) {
				System.out.println(disc.toString());
			}
		}
	}
}
