
public abstract class Skills { //CLASSE ABSTRATA
	
	private String nome;
	private String descricao;
	
	public Skills (String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public void getNome() {
		System.out.print(this.nome);
	}
	public void getInfos() {
		System.out.println("Nome da skill: " + this.nome);
		System.out.println("Descrição: " + this.descricao);
	}
	public abstract void cast(); //MÉTODO ABSTRATO

}
