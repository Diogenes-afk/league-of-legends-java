
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
    		this.times[i].setVitorias(1); //ZERANDO AS VIT�RIAS DOS TIMES CADASTRADOS
    	}
    }
    public void setMvp(Pessoa mvp) {
    	this.mvp = mvp;
    	this.mvp.setMvp();
    }
    public void setCampeao() { //FUN��O QUE BUSCA O CAMPE�O (TIME COM MAIS VIT�RIAS)
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
    private void getCampeao() { //M�todo que checa quem possui mais vit�rias
    	this.campeao = this.times[0]; //Por padr�o o campe�o entra como sendo o primeiro time do vetor
    	for(i=0;i<this.total_times;i++) { //For ser� executado de i at� a quantidade total de times no campeonato
    		if(this.campeao.getVitorias() < this.times[i].getVitorias()) //Se as vit�rias do time na posi��o 'i' for maior que do atual campe�o
    			this.campeao = this.times[i]; //O campe�o recebe o time da posi��o 'i'
    	}
    	this.campeao.getNome();
    }
    public void getInfos() {
    	System.out.println("********************");
    	System.out.println("Nome do campeonato: " + this.nome);
    	System.out.println("Local: " + this.local);
    	System.out.println("Pr�mio: " + this.premiacao);
    	System.out.println("Total de times: " + this.total_times);
    	System.out.print("MVP: "); this.getMVP();
    	System.out.println(" ");
    	System.out.print("Time campe�o: "); System.out.println(this.campeao.getNome());
    	System.out.println("********************");
    }
}
