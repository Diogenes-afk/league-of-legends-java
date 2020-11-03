
public class Times {
	public static int i = 0; //ATRIBUTO EST�TICO QUE SERVIR� COMO CONTADOR PARA O VETOR 'JOGADORES'

	//ATRIBUTOS
	private String nome;
    private String sigla;
    private String regiao;
    private int nro_titulos;
    private Pessoa jogadores[];
    private Pessoa tecnico;
    private double salarioBase;
    private int vitorias;
    
    //CONSTRUTOR
    public Times (String nome, String sigla, String regiao) {
    	this.nome = nome;
    	this.sigla = sigla;
    	this.regiao = regiao;
    }
    
    //SETTERS
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public void setSigla(String sigla) {
    	this.sigla = sigla;
    }
    public void setTitulos(int tit) {//FUN��O PARA DECLARAR N�MERO FIXO DE T�TULOS AO TIME
    	this.nro_titulos = tit; 
    }
    public void setTitulos() { //SOBRECARGA DE M�TODOS ; FUN��O QUE AUTO INCREMENTA O N�MERO DE T�TULOS EM 1
    	++this.nro_titulos;
    }
    public void setVitorias() {//FUN��O PARA AUTO INCREMENTAR VIT�RIAS EM 1
    	++this.vitorias;
    }
    public void setVitorias(int x) { //SOBRECARGA DE M�TODO ; FUN��O QUE ZERA AS V�TORAS
    	this.vitorias = 0;
    }
    public void setSalario(double salario) {
    	this.salarioBase = salario;
    }
    public void setJogadores(Pessoa jogador[]) {//FUN��O PARA ATRIBUIR JOGADORES
    	for(i=0;i<5;i++) {
	    	this.jogadores = jogador;
	    	this.jogadores[i].setTime(this);//ATRIBUINDO ESTE TIME A CADA JOGADOR CADASTRADO
	    	if(jogador[i].getSalario() < this.salarioBase) { //SE O SAL�RIO DO JOGADOR FOR MENOR QUE O SAL�RIO BASE DA ORGANIZA��O, SEU SAL�RIO � SETADO PARA O BASE DA ORGANIZA��O
	    		this.jogadores[i].setSalario(this.salarioBase);
	    	}
    	}
    }
    public void setTecnico(Pessoa tecnico) {
    	this.tecnico = tecnico;
    	this.tecnico.setTime(this);//ATRIBUINDO ESTE TIME AO T�CNICO CADASTRADO
    	if(tecnico.getSalario() < this.salarioBase) {//SE O SAL�RIO DO T�CNICO FOR MENOR QUE O SAL�RIO BASE DA ORGANIZA��O, SEU SAL�RIO � SETADO PARA O BASE DA ORGANIZA��O
    		this.tecnico.setSalario(this.salarioBase);
    	}
    }
    
    //GETTERS
    public String getNome() {
    	return this.nome;
    }
    public String getSigla() {
    	return this.sigla;
    }
    public int getVitorias() {
    	return this.vitorias;
    }
    public void getTecnico() {
    	System.out.println(this.tecnico.getNome());
    }
    public void getJogadores() {
    	for(i=0;i<5;i++) {
    		this.jogadores[i].getNick();
    	}
    }
    public double getSalario() {
    	return this.salarioBase;
    }
    
    public void getChamps() {
    	for(i=0;i<5;i++) {
    		this.jogadores[i].getChamp();
    	}
    }
    public void getTitulos() {
    	System.out.println(this.nro_titulos);
    }
    
    public void getInfos() {
    	System.out.println("-------------------- ");
    	System.out.println("Time: " + this.nome);
    	System.out.println("Sigla: " + this.sigla);
    	System.out.println("Regi�o: " + this.regiao);
    	System.out.println("Jogadores: ");
    	for(i=0;i<5;i++) {
    		this.jogadores[i].getNick();
    		this.jogadores[i].getFuncao();
    		//System.out.println(" ");
        }
    	System.out.print("T�cnico: "); this.tecnico.getNick(); System.out.println(" ");
    	System.out.println("T�tulos: " + this.nro_titulos);
    	System.out.println("-------------------- ");
    }
}
