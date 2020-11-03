
public class Times {
	public static int i = 0; //ATRIBUTO ESTÁTICO QUE SERVIRÁ COMO CONTADOR PARA O VETOR 'JOGADORES'

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
    public void setTitulos(int tit) {//FUNÇÃO PARA DECLARAR NÚMERO FIXO DE TÍTULOS AO TIME
    	this.nro_titulos = tit; 
    }
    public void setTitulos() { //SOBRECARGA DE MÉTODOS ; FUNÇÃO QUE AUTO INCREMENTA O NÚMERO DE TÍTULOS EM 1
    	++this.nro_titulos;
    }
    public void setVitorias() {//FUNÇÃO PARA AUTO INCREMENTAR VITÓRIAS EM 1
    	++this.vitorias;
    }
    public void setVitorias(int x) { //SOBRECARGA DE MÉTODO ; FUNÇÃO QUE ZERA AS VÍTORAS
    	this.vitorias = 0;
    }
    public void setSalario(double salario) {
    	this.salarioBase = salario;
    }
    public void setJogadores(Pessoa jogador[]) {//FUNÇÃO PARA ATRIBUIR JOGADORES
    	for(i=0;i<5;i++) {
	    	this.jogadores = jogador;
	    	this.jogadores[i].setTime(this);//ATRIBUINDO ESTE TIME A CADA JOGADOR CADASTRADO
	    	if(jogador[i].getSalario() < this.salarioBase) { //SE O SALÁRIO DO JOGADOR FOR MENOR QUE O SALÁRIO BASE DA ORGANIZAÇÃO, SEU SALÁRIO É SETADO PARA O BASE DA ORGANIZAÇÃO
	    		this.jogadores[i].setSalario(this.salarioBase);
	    	}
    	}
    }
    public void setTecnico(Pessoa tecnico) {
    	this.tecnico = tecnico;
    	this.tecnico.setTime(this);//ATRIBUINDO ESTE TIME AO TÉCNICO CADASTRADO
    	if(tecnico.getSalario() < this.salarioBase) {//SE O SALÁRIO DO TÉCNICO FOR MENOR QUE O SALÁRIO BASE DA ORGANIZAÇÃO, SEU SALÁRIO É SETADO PARA O BASE DA ORGANIZAÇÃO
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
    	System.out.println("Região: " + this.regiao);
    	System.out.println("Jogadores: ");
    	for(i=0;i<5;i++) {
    		this.jogadores[i].getNick();
    		this.jogadores[i].getFuncao();
    		//System.out.println(" ");
        }
    	System.out.print("Técnico: "); this.tecnico.getNick(); System.out.println(" ");
    	System.out.println("Títulos: " + this.nro_titulos);
    	System.out.println("-------------------- ");
    }
}
