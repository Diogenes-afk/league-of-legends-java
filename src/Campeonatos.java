
public class Campeonatos {
	public static int i = 0; //MEMBRO CONSTANTE QUE SERVE COMO CONTADOR PARA O CADASTRO DE TIMES
	
	//ATRIBUTOS
	private String nome;
	private double premiacao;
	private String local;
	private Pessoa mvp;
	private Times times[];
	private Times campeao;
	private int total_times;

	//CONSTRUTOR
	public Campeonatos (String nome, String local, double premiacao, int total_times) {
		this.nome = nome;
		this.local = local;
		this.premiacao = premiacao;
		this.total_times = total_times;
	}
	
	//SETTERS
	public void setTimes(Times time[]) {
    	for(i=0;i<this.total_times;i++) {
    		this.times = time;
    		this.times[i].setVitorias(1); //ZERANDO AS VITÓRIAS DOS TIMES CADASTRADOS
    	}
    }
    public void setMvp(Pessoa mvp) {
    	this.mvp = mvp;
    	this.mvp.setMvp();
    }
    public void setCampeao() { //FUNÇÃO QUE BUSCA O CAMPEÃO (TIME COM MAIS VITÓRIAS)
    	this.getCampeao();
    	this.campeao.setTitulos();
    }
    
    //GETTERS
    public void getNome() {
    	System.out.println(this.nome);
    }
    public void getLocal() {
    	System.out.println(this.local);
    }
    public void getPremio() {
    	System.out.println(this.premiacao);
    }
    public void getTotalTimes() {
    	System.out.println(this.total_times);
    }
    public void getMVP() {
    	this.mvp.getNick();
    }
    private void getCampeao() { //Método que checa quem possui mais vitórias
    	this.campeao = this.times[0]; //Por padrão o campeão entra como sendo o primeiro time do vetor
    	for(i=0;i<this.total_times;i++) { //For será executado de i até a quantidade total de times no campeonato
    		if(this.campeao.getVitorias() < this.times[i].getVitorias()) //Se as vitórias do time na posição 'i' for maior que do atual campeão
    			this.campeao = this.times[i]; //O campeão recebe o time da posição 'i'
    	}
    	this.campeao.getNome();
    }
    public void getInfos() {
    	System.out.println("********************");
    	System.out.println("Nome do campeonato: " + this.nome);
    	System.out.println("Local: " + this.local);
    	System.out.println("Prêmio: " + this.premiacao);
    	System.out.println("Total de times: " + this.total_times);
    	System.out.print("MVP: "); this.getMVP();
    	System.out.println(" ");
    	System.out.print("Time campeão: "); System.out.println(this.campeao.getNome());
    	System.out.println("********************");
    }
}
