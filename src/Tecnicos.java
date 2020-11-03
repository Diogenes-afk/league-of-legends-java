
public class Tecnicos extends Pessoa { //HERANÇA DA CLASSE 'PESSOA'

	public Tecnicos(String nome, String nick) {
		super(nome, nick);
	}
	
	public void getInfosPlus() {
		System.out.println("-------------------- ");
		this.getInfos();
		System.out.println("-------------------- ");
	}
	
}
