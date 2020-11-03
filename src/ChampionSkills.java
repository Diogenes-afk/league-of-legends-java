
public class ChampionSkills extends Skills { //HERANÇA DA CLASSE ABSTRATA 'SKILLS'

	//ATRIBUTOS
	private int custo;
	
	//CONSTRUTOR
	public ChampionSkills(String nome, String desc, int custo) {
		super(nome, desc);
		this.custo = custo;
	}
	public void cast() { //MÉTODO ABSTRATO VINDO DE SKILLS
		this.getNome();
	}
	public void getInfosPlus() {
		this.getInfos();
		System.out.println("Custo: " + this.custo);
	}
}
