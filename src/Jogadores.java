
public class Jogadores extends Pessoa{ //HERANÇA DA CLASSE 'PESSOA'
	
	//ATRIBUTOS
    private int mvps;
    private String funcao;
    private Campeoes champion;
    private SummonerSkills spellD;
    private SummonerSkills spellF;
    
    //CONSTRUTOR
    public Jogadores(String nome, String nick, int mvps, String funcao) {
    	super(nome, nick);
    	this.mvps = mvps;
    	this.funcao = funcao;
    }
  
    //MÉTODO DE ESCOLHER UM CAMPEÃO + FEITIÇOS DE INVOCADOR
    public void pickChamp(Campeoes champion, SummonerSkills d, SummonerSkills f) {
    	this.champion = champion;
    	this.spellD = d;
    	this.spellF = f;
    }
    public void setMvp() {
    	++this.mvps;
    }
    
    //POLIMORFISMO DE INCLUSÃO
    public void recall() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") está voltando para a base.");
    }
    public void emote() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") está usando um emote.");
    }
    public void trashTalk() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") ta xingando todo mundo que delícia.");
    }
    public void surrender() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") abriu uma votação para se render.");
    }
    
    //SOBRECARGA DO MÉTODO SURRENDER
    public void surrender(boolean x) {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.print(") tentou se render mas está cedo demais.");
    }
    
    //MÉTODOS DE CAST DE SKILL QUE EXIBEM O NICK E NOME DO CAMPEÃO
    public void castQ() {
    	this.getNick();
    	champion.castQ();
    	System.out.println(" ");
    }
    public void castW() {
    	this.getNick();
    	champion.castW();
    	System.out.println(" ");
    }
    public void castE() {
    	this.getNick();
    	champion.castE();
    	System.out.println(" ");
    }
    public void castR() {
    	this.getNick();
    	champion.castR();
    	System.out.println(" ");
    }
    
    //GETTERS
    public void getChamp() {
    	this.getNick();
    	System.out.print("(");
    	this.champion.getNome();
    	System.out.println(")");
    }
    public void getFuncao() {
    	System.out.println("(" + this.funcao + ")");
    }
    
    public void getInfosPlus() {
    	System.out.println("-------------------- ");
    	this.getInfos();
    	System.out.println("Função: "+ this.funcao);
    	System.out.println("MVP's: "+ this.mvps);
    	System.out.print("Campeão: ");this.champion.getNome();
    	System.out.println();
    	System.out.print("Spells: ");spellD.cast();System.out.print(", ");spellF.cast();
    	System.out.println(". ");
    	System.out.println("-------------------- ");
    }
    
}
