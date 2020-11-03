
public class Partidas {
	
	//ATRIBUTOS
	private Times time1;
	private Times time2;
	private String tempoTotal;
	private Times vencedor;
	private Pessoa mvp;
	private Campeonatos champ;
	
	//CONSTRUTOR
	public Partidas (Times time1, Times time2, Campeonatos champ) {
		this.time1 = time1;
		this.time2 = time2;
		this.champ = champ;
	}
	
	//SETTERS
	public void setMvp(Pessoa mvp) {
		this.mvp = mvp;
		this.mvp.setMvp();
	}
	public void setVencedor(Times time) {
		this.vencedor = time;
		this.vencedor.setVitorias();
	}
	public void setTempo(String tempo) {
		this.tempoTotal = tempo;
	}
	
	//GETTERS
	public void getTimes() {
    	System.out.println(this.time1 + " x " + this.time2);
    }
    public void getMVP() {
    	System.out.print("MVP: ");
    	this.mvp.getNick();
    }
    public void getTempoTotal() {
    	System.out.println("Tempo de partida: " + this.tempoTotal);
    }
    public void getVencedor() {
    	System.out.print("Vencedor: ");
    	this.vencedor.getNome();
    }
    public void getCampeonato() {
    	System.out.println("Campeonato");
    	this.champ.getNome();
    }
    
    public void dadosPartida() {
    	System.out.println("-------------");
    	System.out.print(this.time1.getSigla());
    	System.out.print(" x ");
    	System.out.println(this.time2.getSigla());
    	System.out.print("Vencedor: ");
    	System.out.println(this.vencedor.getNome());;
    	System.out.print("MVP: ");
    	this.mvp.getNick();
    	System.out.println(" ");
    	System.out.println("Tempo de partida: "+this.tempoTotal);
    	System.out.println(" ");
    	System.out.println("Composição " + this.time1.getNome());
    	this.time1.getChamps();
    	System.out.println(" ");
    	System.out.println("Composição " + this.time2.getNome());
    	this.time2.getChamps();
    	System.out.println("-------------");
    } 	
    
}
