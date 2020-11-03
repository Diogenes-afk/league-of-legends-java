
public class Pessoa implements AcoesBasicas { //IMPLEMENTANDO A INTERFACE

	//ATRIBUTOS
	private String nome;
    private String nick;
    private double salario;
    private Times time;
    
    
    //CONSTRUTOR
    public Pessoa (String nome, String nick) {
    	this.nome = nome;
    	this.nick = nick;
    }
    
    //SETTERS
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public void setNick(String nick) {
    	this.nick = nick;
    }
    public void setTime(Times time) {
    	this.time = time;
    }
    public void setSalario(double salario) {
    	this.salario = salario;
    }
    
    //GETTERS
    public void getNick() {
    	System.out.print(this.nick);
    }
    public double getSalario() {
    	return this.salario;
    }
    public String getNome() {
    	return this.nome;
    }
    public void getTime() {
    	System.out.println(this.time.getNome());
    }
    
    //IMPLEMENTANDO AS FUNÇÕES DA INTERFACE
    public void recall() {
		this.getNick();
		System.out.println(" tentou dar recall mas esqueceu que a função dele é fora do jogo.");
	}
    public void emote() {
		this.getNick();
		System.out.println(" ta dando jóia pra todo mundo.");
	}
    public void trashTalk() {
		this.getNick();
		System.out.println(" tá mostrando o dedo do meio pra todo mundo.");
	}
    public void surrender() {
		this.getNick();
		System.out.println(" acha que é melhor o time se render.");
	}
    
    public void getInfos() {
    	System.out.println("Nome: "+ this.nome);
    	System.out.println("Nick: "+ this.nick);
    	System.out.println("Time: "+ this.time.getNome());
    	System.out.println("Salário: "+ this.salario);    	
    }
    
    //MÉTODOS A SEREM USADOS PELAS CLASSES FILHAS
    public void castQ() {}
    public void castW() {}
    public void castE() {}
    public void castR() {}
    public void pickChamp(Campeoes campeao, SummonerSkills a, SummonerSkills b) {} 
    public void getInfosPlus() {}
    public void setMvp() {}
    public void getChamp() {}
    public void getFuncao() {}
    
    
}
