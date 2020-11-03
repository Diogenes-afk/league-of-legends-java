
public class Campeoes{
	
	//ATRIBUTOS
	private String nome;
	private ChampionSkills skill_passiva; //ASSOCIANDO CLASSE 'CHAMPIONSKLLS' A CLASSE 'CAMPEOES'
	private ChampionSkills skillQ; 
	private ChampionSkills skillW;
	private ChampionSkills skillE;
	private ChampionSkills skillR;
	private int HpBase;
	private int MpBase;
	private int AdBase;
	private int ApBase;
	private int ArmorBase;
	private int MrBase;
	
	//CONSTRUTOR
	public Campeoes(String nome, ChampionSkills skill_passiva, ChampionSkills skillQ, ChampionSkills skillW, ChampionSkills skillE, ChampionSkills skillR, int hp, int mp, int ad, int ap, int ar, int mr) {
		this.nome = nome;
		this.skill_passiva = skill_passiva;
		this.skillQ = skillQ;
		this.skillE = skillE;
		this.skillW = skillW;
		this.skillR = skillR;
		this.HpBase = hp;
		this.MpBase = mp;
		this.AdBase = ad;
		this.ApBase = ap;
		this.ArmorBase = ar;
		this.MrBase = mr;
	}
	
	//SETTERS
	public void setNome(String nome) { //ENCAPSULAMENTO
		this.nome = nome;
	}
	public void setPassiva(ChampionSkills passiva) {
		this.skill_passiva = passiva;
	}
	public void setQ(ChampionSkills Q) {
		this.skillQ = Q;
	}
	public void setW(ChampionSkills W) {
		this.skillW = W;
	}
	public void setE(ChampionSkills E) {
		this.skillE = E;
	}
	public void setR(ChampionSkills R) {
		this.skillR = R;
	}
	public void setStatus(int hp, int mp, int ad, int ap, int ar, int mr) {
		this.HpBase = hp; 
		this.MpBase = mp;
		this.AdBase = ad;
		this.ApBase = ap;
		this.ArmorBase = ar;
		this.MrBase = mr;
	}
	
	//GETTERS
	public void getNome() {
		System.out.print(this.nome);
	}	
	public void getInfos() {
		System.out.println("Nome: " + this.nome);
		System.out.print("Passiva: ");this.skill_passiva.getNome();System.out.println(" ");
		System.out.print("Q: ");this.skillQ.getNome();System.out.println(" ");
		System.out.print("W: ");this.skillW.getNome();System.out.println(" ");
		System.out.print("E: ");this.skillE.getNome();System.out.println(" ");
		System.out.print("R: ");this.skillR.getNome();System.out.println(" ");
		System.out.println("HP base: " + this.HpBase);
		System.out.println("MP base: " + this.MpBase);
		System.out.println("AD base: " + this.AdBase);
		System.out.println("AP base: " + this.ApBase);
		System.out.println("AR base: " + this.ArmorBase);
		System.out.println("MR base: " + this.MrBase);
	}
	
	//MÉTODOS QUE CHAMAM MÉTODOS DA CLASSE 'CHAMPION SKILLS'
	public void castQ() {
		System.out.print("(" + this.nome + ") usou ");
		skillQ.cast();
	}
	public void castW() {
		System.out.print("(" + this.nome + ") usou ");
		skillW.cast();
	}
	public void castE() {
		System.out.print("(" + this.nome + ") usou ");
		skillE.cast();
	}
	public void castR() {
		System.out.print("(" + this.nome + ") usou ");
		skillR.cast();
	}
	
}
