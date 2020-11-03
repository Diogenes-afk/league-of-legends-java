
public class Jogadores extends Pessoa{ //HERAN�A DA CLASSE 'PESSOA'
	
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
  
    //M�TODO DE ESCOLHER UM CAMPE�O + FEITI�OS DE INVOCADOR
    public void pickChamp(Campeoes champion, SummonerSkills d, SummonerSkills f) {
    	this.champion = champion;
    	this.spellD = d;
    	this.spellF = f;
    }
    public void setMvp() {
    	++this.mvps;
    }
    
    //POLIMORFISMO DE INCLUS�O
    public void recall() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") est� voltando para a base.");
    }
    public void emote() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") est� usando um emote.");
    }
    public void trashTalk() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") ta xingando todo mundo que del�cia.");
    }
    public void surrender() {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.println(") abriu uma vota��o para se render.");
    }
    
    //SOBRECARGA DO M�TODO SURRENDER
    public void surrender(boolean x) {
    	this.getNick();
    	System.out.print("(");
    	champion.getNome();
    	System.out.print(") tentou se render mas est� cedo demais.");
    }
    
    //M�TODOS DE CAST DE SKILL QUE EXIBEM O NICK E NOME DO CAMPE�O
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
    	System.out.println("Fun��o: "+ this.funcao);
    	System.out.println("MVP's: "+ this.mvps);
    	System.out.print("Campe�o: ");this.champion.getNome();
    	System.out.println();
    	System.out.print("Spells: ");spellD.cast();System.out.print(", ");spellF.cast();
    	System.out.println(". ");
    	System.out.println("-------------------- ");
    }
    
}
