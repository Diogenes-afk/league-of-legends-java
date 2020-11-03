
public class SummonerSkills extends Skills { //HERANÇA DA CLASSE ABSTRATA 'SKILLS'
	
	//ATRIBUTOS
	private String disp;
	
	//CONSTRUTOR
	public SummonerSkills(String nome, String desc, String disp) {
		super(nome, desc);
		this.disp = disp;
	}
	
	public void cast() {
		this.getNome();
	}
	public void getInfosPlus() {
		this.getInfos();
	System.out.println("Disponível no(s) mapa(s): " + this.disp);
	}
}
