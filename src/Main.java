//Temos o cadastro das skills, campe�es, times, jogadores e campeonatos.
//Al�m disso temos uma simula��o de campeonato, onde cadastramos uma partida, simulamos os picks de campe�es para cada jogador de cada time e setamos os resultados(vencedor da partida, mvp, tempo total).
//Ao fim do cadastro de todas as partidas, a classe campeonatos busca dentre os times cadastrados, qual tem o maior n�mero de vit�rias para atribuir o t�tulo, tamb�m atribuimos o mvp do campeonato.
//Cada atribui��o de t�tulo/mvp � um incremento dentro da classe que possui o atributo. No cadastro dos times em cada novo campeonato suas vit�rias em partidas s�o zeradas para n�o haver conflitos.
//Todos os requisitos do trabalho se encontram comentados em suas respectivas classes/m�todos.
//No main simulamos o cadastro de quatro times, e um campeonato com poucas partidas. Caso deseje brincar com o c�digo, os construtores est�o bem simples de se entender.
//As sa�das em tela s�o respectivamente: Dados das partidas um e dois; Dados do campeonato; Algumas a��es de jogador/t�cnico; Informa��es de um campe�o; Informa��es de skill; Informa��es de um jogador; Informa��es de um time;

public class Main {

	public static void main(String[] args) {
		
		//FEITI�OS DE INVOCADOR
		SummonerSkills flash = new SummonerSkills("Flash", "Teleporta seu campe�o por uma curta dist�ncia", "SR, ARAM");
		SummonerSkills teleporte = new SummonerSkills("Teleporte", "Canaliza por 4 segundos para teleportar o campe�o para uma unidade, torre ou sentinela aliada", "SR");
		SummonerSkills incendiar = new SummonerSkills("Incendiar", "Incendeia um campe�o inimigo causando 70-140 de dano verdadeiro ao longo de 5 segundos", "SR, ARAM");
		SummonerSkills curar = new SummonerSkills("Curar", "Cura 90-345 de HP e concede 30% de velocidade de movimento por 1 segundo a voc� e um aliado pr�ximo", "SR, ARAM");
		SummonerSkills golpear = new SummonerSkills("Golpear", "Causa 390-1000 de dano verdadeiro a monstros e restaura vida com base na vida m�xima do campe�o", "SR");
		SummonerSkills marca = new SummonerSkills("Marca", "Arremesa uma bola de neve em linha reta. Se atingir um campe�o, ele fica marcado, e seu campe�o pode usar a habilidade novamente para se teleportar at� o alvo", "ARAM");
		SummonerSkills exaustao = new SummonerSkills("Exaust�o", "Reduz a velocidade de movimento e o dano causado de um campe�o inimigo em 30% e 40% respectivamente", "SR, ARAM");
		
		//DECLARA��O DE SKILLS E CAMPE�ES
		ChampionSkills katP = new ChampionSkills("Voracidade", "Os Tempos de Recarda de Katarina s�o reduzidos drasticamente sempre que ela participa de um abate.", 0);
		ChampionSkills katQ = new ChampionSkills("L�mina Saltitante", "Katarina arremesa uma adaga no alvo. Ela salta em inimigos pr�ximos antes de ricochetear e cair no ch�o.", 0);
		ChampionSkills katW = new ChampionSkills("Prepara��o", "Katarina recebe Velocidade de Movimento, arremessando uma Adaga no ar diretamente acima de sim mesma.", 0);
		ChampionSkills katE = new ChampionSkills("Shunpo", "Katarina desloca-se em dire��o ao alvo, golpeando-o caso seja inimigo ou golpeando o inimigo mais pr�ximo caso n�o seja.", 0);
		ChampionSkills katR = new ChampionSkills("L�tus da Morte", "Katarina gira em torno de si mesma, disparando adagas muito rapidamente e causando muito Dano M�gico nos 3 Campe�es inimigos mais pr�ximos.", 0);
		Campeoes katarina = new Campeoes("Katarina",  katP, katQ, katW, katE, katR, 602, 0, 58, 0, 28, 32);
		
		ChampionSkills graP = new ChampionSkills("Happy Hour", "Gragas cura a si mesmo periodicamente ap�s utilizar uma habilidade.", 0);
		ChampionSkills graQ = new ChampionSkills("Jogar o Barril", "Gragas rola seu barril at� um local, que pode ser ativado novamente para explodir ou explodir� sozinho ap�s 4 segundos. Inimigos atingidos pela explos�o t�m sua Velocidade de Movimento reduzida.", 60);
		ChampionSkills graW = new ChampionSkills("F�ria da Bebedeira", "Gragas entorna a bebida de seu barril garganta abaixo, canalizando por 1 segundo. Ao terminar, ele fica torpecidamente poderoso, causando mais dano em seu pr�ximo ataque b�sico e reduzindo o dano recebido.", 30);
		ChampionSkills graE = new ChampionSkills("Barrigada", "Gragas avan�a em dire��o a um local e colide com a primeira unidade inimiga que encontrar, causando dano a todas as unidades inimigas pr�ximas e atordoando-as.", 50);
		ChampionSkills graR = new ChampionSkills("Barril Explosivo", "Gragas arremessa seu barril em um local, causando dano e afastando os inimigos pegos no raio da explos�o.", 100);
		Campeoes gragas = new Campeoes("Gragas", graP, graQ, graW, graE, graR, 600, 400, 64, 0, 38, 32);
		
		ChampionSkills shaP = new ChampionSkills("Apunhalar", "Os ataques b�sicos de Shaco e Veneno de Dois Gumes causam dano adicional ao atingirem o inimigo por tr�s.", 0);
		ChampionSkills shaQ = new ChampionSkills("Enganar", "Shaco fica Invis�vel e se teleporta para o local-alvo. Seu primeiro ataque enquanto est� Invis�vel � fortalecido, causando dano adicional e cr�tico ao atingir o inimigo por tr�s.", 50);
		ChampionSkills shaW = new ChampionSkills("Caixinha-Surpresa", "Shaco cria uma Caixinha-Surpresa escondida. Quando ativada, ela causar� temor e atacar� inimigos pr�ximos", 30);
		ChampionSkills shaE = new ChampionSkills("Veneno de Dois Gumes", "As facas de Shaco envenenam alvos passivamente ao contato, reduzindo sua Velocidade de Movimento. Ele pode arremess�-las para causar dano e envenenar o alvo. A faca arremessada causa dano adicional se a Vida do alvo estiver abaixo de 30%.", 60);
		ChampionSkills shaR = new ChampionSkills("Alucina��es", "Shaco cria uma ilus�o de si mesmo pr�xima a ele, que pode atacar inimigos pr�ximos (causa dano reduzido a torres). Ao morrer, ela explode, fazendo surgir tr�s Caixinhas-Surpresa e causando dano a todos os inimigos pr�ximos.", 100);
		Campeoes shaco = new Campeoes("Shaco", shaP, shaQ, shaW, shaE, shaR, 587, 297, 63, 0, 30, 32);
		
		ChampionSkills dravenP = new ChampionSkills("League of Draven", "Draven ganha Adora��o de seus f�s quando apanha uma Revolu��o do Machado ou abate uma tropa, monstro ou torre. Abater Campe�es inimigos concede ouro adicional a Draven, com base em quanta Adora��o ele tem.", 0);
		ChampionSkills dravenQ = new ChampionSkills("Revolu��o do Machado", "O pr�ximo ataque de Draven causar� Dano F�sico adicional. O machado ricochetear� do alvo em dire��o ao ar. Se Draven o apanhar, ele automaticamente ir� preparar outra Revolu��o do Machado. Draven pode ter duas Revolu��es do Machado simultaneamente em a��o.", 50);
		ChampionSkills dravenW = new ChampionSkills("Adrenalina", "Draven ganha um aumento de Velocidade de Movimento e de Ataque. O aumento na Velocidade de Movimento decai rapidamente ao longo da dura��o. Apanhar uma Revolu��o do Machado far� com que o Tempo de Recarga de Adrenalina seja zerado.", 30);
		ChampionSkills dravenE = new ChampionSkills("Sai da Frente", "Draven arremessa seus machados, causando Dano F�sico aos alvos atingidos e empurrando-os para o lado. Os alvos atingidos sofrem redu��o de velocidade.", 40);
		ChampionSkills dravenR = new ChampionSkills("Reta da Morte", "Draven arremessa dois machados gigantes para causar Dano F�sico a cada unidade atingida. Reta da Morte lentamente muda de dire��o e retorna a Draven ap�s atingir um Campe�o inimigo. Draven tamb�m pode ativar essa habilidade enquanto seus machados estiverem em percurso para fazer com que voltem antecipadamente. Causa menos dano para cada unidade atingida e zera quando os machados mudam de dire��o.", 100);
		Campeoes draven = new Campeoes("Draven",  dravenP, dravenQ, dravenW, dravenE, dravenR, 605, 360, 60, 0, 29, 30);

		ChampionSkills hecarimP = new ChampionSkills("Caminho da Guerra", "Hecarim recebe Dano de Ataque equivalente a um percentual de sua Velocidade de Movimento adicional.", 0);
		ChampionSkills hecarimQ = new ChampionSkills("Enfurecido", "Hecarim golpeia inimigos pr�ximos, causando Dano F�sico. Caso ele cause dano a ao menos um inimigo, os usos subsequentes da habilidade causam mais dano e t�m menor Tempo de Recarga.", 50);
		ChampionSkills hecarimW = new ChampionSkills("Esp�rito do Pavor", "Hecarim causa Dano M�gico a inimigos pr�ximos por um curto per�odo de tempo. Hecarim recebe Vida igual a um percentual de qualquer dano que esses inimigos receberem.", 65);
		ChampionSkills hecarimE = new ChampionSkills("Ataque Devastador", "Hecarim recebe Velocidade de Movimento crescente e ignora colis�o com unidades por um curto per�odo de tempo. Seu pr�ximo ataque empurra o alvo para tr�s e causa Dano F�sico adicional com base na dist�ncia percorrida desde a ativa��o da habilidade.", 55);
		ChampionSkills hecarimR = new ChampionSkills("Massacre das Sombras", "Hecarim invoca cavaleiros espectrais e avan�a, causando Dano M�gico em linha reta. Hecarim desfere uma onda de choque ao terminar o ataque, fazendo com que inimigos pr�ximos se afastem aterrorizados.", 100);
		Campeoes hecarim = new Campeoes("Hecarim",  hecarimP, hecarimQ, hecarimW, hecarimE, hecarimR, 580, 277, 66, 0, 40, 32);

		ChampionSkills leesinP = new ChampionSkills("Agita��o", "Ap�s Lee Sin usar uma habilidade, seus pr�ximos 2 ataques b�sicos recebem Velocidade de Ataque e recuperam Energia.", 0);
		ChampionSkills leesinQ = new ChampionSkills("Onda S�nica / Ataque Ressonante", "Onda S�nica: Lee Sin projeta uma onda sonora para localizar seus inimigos, causando Dano F�sico ao primeiro que encontrar. Se Onda S�nica atingir um inimigo, Lee Sin pode conjurar Ataque Ressonante nos pr�ximos 3 segundos. Ataque Ressonante: Lee Sin avan�a no inimigo atingido por Onda S�nica, causando Dano F�sico baseado na Vida perdida do alvo.", 30);
		ChampionSkills leesinW = new ChampionSkills("Proteger / Vontade de Ferro", "Proteger: Lee Sin avan�a at� um alvo aliado, protegendo a si mesmo do dano. Se o aliado for um Campe�o, ele tamb�m � protegido. Ap�s usar Proteger, Lee Sin pode conjurar Vontade de Ferro dentre os pr�ximos 3 segundos. Vontade de Ferro: O treinamento intenso de Lee Sin permite que ele fique mais resistente em combate. Por 4 segundos, ele recebe Roubo de Vida e Vampirismo M�gico.", 40);
		ChampionSkills leesinE = new ChampionSkills("Tempestade / Multilar", "Tempestade: Lee Sin golpeia o ch�o, enviando uma onda de choque que causa Dano M�gico e revela unidades inimigas atingidas. Se Tempestade atingir um inimigo, Lee Sin pode conjurar Mutilar nos pr�ximos 3 segundos. Mutilar: Lee Sin mutila inimigos pr�ximos revelados por Tempestade, reduzindo a Velocidade de Movimento deles por 4 segundos. A Velocidade de Movimento � recuperada gradualmente ao longo da dura��o.", 50);
		ChampionSkills leesinR = new ChampionSkills("F�ria do Drag�o", "Lee Sin executa um poderoso chute girat�rio, arremessando seu alvo para tr�s e causando Dano F�sico ao alvo e a qualquer inimigo com quem ele colidir. Esses inimigos s�o lan�ados ao ar durante um curto per�odo. Essa t�cnica foi ensinada a ele por Jesse Perring, mas Lee Sin n�o chuta os jogadores para fora do mapa.", 100);
		Campeoes leesin = new Campeoes("Lee sin",  leesinP, leesinQ, leesinW, leesinE, leesinR, 660, 200, 70, 0, 33, 32);

		ChampionSkills masteryiP = new ChampionSkills("Ataque Duplo", "A cada alguns ataques b�sicos consecutivos, Master Yi ataca duas vezes.", 0);
		ChampionSkills masteryiQ = new ChampionSkills("Ataque Alpha", "Master Yi se teleporta pelo campo de batalha t�o r�pido que n�o pode ser visto, causando Dano F�sico a v�rias unidades pelo caminho enquanto fica inalvej�vel. O Ataque Alpha pode causar Acerto Cr�tico e Dano F�sico adicional contra monstros. Ataques b�sicos reduzem o Tempo de Recarga de Ataque Alpha.", 50);
		ChampionSkills masteryiW = new ChampionSkills("Meditar", "Master Yi rejuvenesce seu corpo com a for�a da mente, restaurando Vida e recebendo dano reduzido por um curto per�odo. Al�m disso, ele recebe ac�mulos de Ataque Duplo e pausa a dura��o restante de Estilo Wuju e de Highlander para cada segundo de canaliza��o.", 40);
		ChampionSkills masteryiE = new ChampionSkills("Estilo Wuju", "Concede Dano Verdadeiro adicional em ataques b�sicos.", 35);
		ChampionSkills masteryiR = new ChampionSkills("Highlander", "Master Yi se movimenta com extrema agilidade, aumentando temporariamente sua Velocidade de Ataque e de Movimento, e tornando-se imune a todos os efeitos de redu��o de velocidade. Abates ou assist�ncias de Campe�es estendem a dura��o de Highlander enquanto a habilidade estiver ativa. Reduz passivamente o Tempo de Recarga das outras habilidades a cada abate ou assist�ncia.", 100);
		Campeoes masteryi = new Campeoes("Master Yi",  masteryiP, masteryiQ, masteryiW, masteryiE, masteryiR, 598, 250, 69, 0, 36, 32);

		ChampionSkills sylasP = new ChampionSkills("Explos�o de Petricita", "Ap�s conjurar uma habilidade, Sylas armazena uma carga de Explos�o de Petricita. Seus ataques b�sicos gastam uma carga e agitam as correntes energizadas ao redor dele, causando Dano M�gico adicional a inimigos atingidos. Enquanto Sylas tiver uma carga de Explos�o de Petricita, ele recebe Velocidade de Ataque.", 0);
		ChampionSkills sylasQ = new ChampionSkills("Correntes-Chicotes", "Sylas chicoteia com suas correntes, que se intersectam no local-alvo, causando dano e reduzindo a velocidade dos inimigos. Ap�s um intervalo, h� uma explos�o de energia m�gica no ponto da intersec��o, causando dano.", 45);
		ChampionSkills sylasW = new ChampionSkills("Regicida", "Sylas avan�a em um inimigo com uma for�a m�gica, causando dano com base em execu��o e curando a si mesmo contra Campe�es inimigos.", 35);
		ChampionSkills sylasE = new ChampionSkills("Evas�o / Abdu��o", "Sylas avan�a por uma curta dist�ncia, podendo reconjurar a habilidade para arremessar suas correntes e se arrastar na dire��o do inimigo atingido.", 50);
		ChampionSkills sylasR = new ChampionSkills("Usurpar", "Sylas rouba a habilidade ultimate do inimigo e pode conjur�-la sem custo.", 100);
		Campeoes sylas = new Campeoes("Sylas",  sylasP, sylasQ, sylasW, sylasE, sylasR, 525, 280, 64, 55, 31, 34);
		
		ChampionSkills ahriP = new ChampionSkills("Furto de Ess�ncia", "Quando Ahri atinge 9 inimigos com suas habilidades, sua pr�xima habilidade tamb�m a cura por cada inimigo atingido.", 0);
		ChampionSkills ahriQ = new ChampionSkills("Orbe da Ilus�o", "Ahri lan�a e puxa de volta seu orbe, causando Dano M�gico na ida e Dano Verdadeiro na volta.", 60);
		ChampionSkills ahriW = new ChampionSkills("Fogo de Raposa", "Ahri recebe um breve impulso de Velocidade de Movimento e lan�a tr�s Fogos de Raposa que perseguem e atacam inimigos pr�ximos.", 40);
		ChampionSkills ahriE = new ChampionSkills("Encanto", "Ahri manda um beijo que causa dano e encanta um inimigo, interrompendo imediatamente qualquer habilidade de movimento em progresso e fazendo com que ele ande inofensivamente em sua dire��o. O alvo temporariamente sofre dano aumentado de Ahri.", 80);
		ChampionSkills ahriR = new ChampionSkills("�mpeto Espiritual", "Ahri avan�a e atira raios de ess�ncia, causando dano a inimigos pr�ximos. �mpeto Espiritual pode ser conjurado at� tr�s vezes antes de entrar em Tempo de Recarga.", 100);
		Campeoes ahri = new Campeoes("Ahri",  ahriP, ahriQ, ahriW, ahriE, ahriR, 526, 418, 53, 0, 20, 30);

		ChampionSkills akaliP = new ChampionSkills("Marca do Assassino", "Causar dano com habilidades em Campe�es cria um c�rculo de energia em volta deles. Sair desse c�rculo fortalece o pr�ximo ataque b�sico de Akali com alcance e dano adicionais.", 0);
		ChampionSkills akaliQ = new ChampionSkills("Golpe dos Cinco Pontos", "Akali atira cinco kunais, causando redu��o de velocidade e dano com base em seu Dano de Ataque adicional e Poder de Habilidade.", 120);
		ChampionSkills akaliW = new ChampionSkills("Prote��o do Crep�sculo", "Akali solta uma prote��o de fuma�a e recebe Velocidade de Movimento por um curto per�odo. Enquanto estiver dentro da prote��o, Akali se torna invis�vel e n�o pode ser selecionada como alvo de habilidades e ataques inimigos. Atacar ou usar habilidades far� com que ela seja revelada brevemente.", 0);
		ChampionSkills akaliE = new ChampionSkills("Investida Shuriken", "Salta para tr�s e atira uma shuriken para a frente, causando Dano M�gico. O primeiro inimigo ou nuvem de fuma�a que forem atingidos s�o marcados. Conjure novamente para avan�ar ao alvo marcado, causando dano adicional.", 60);
		ChampionSkills akaliR = new ChampionSkills("Execu��o Perfeita", "Akali salta em uma dire��o, causando dano aos inimigos que atingir. Conjurar novamente: Akali avan�a em uma dire��o, executando todos os inimigos que atingir.", 0);
		Campeoes akali = new Campeoes("Akali", akaliP, akaliQ, akaliW, akaliE, akaliR, 575, 200, 62, 0, 23, 37);

		ChampionSkills eveP = new ChampionSkills("Sombra Demon�aca", "Quando est� fora de combate, Evelynn entra em Sombra Demon�aca. A Sombra Demon�aca cura Evelynn quando ela est� com pouca Vida e concede Camuflagem ap�s o n�vel 6.", 0);
		ChampionSkills eveQ = new ChampionSkills("Espinho de �dio", "Evelynn ataca com seu Chicote, causando dano ao primeiro inimigo atingido. Depois, Evelynn dispara uma linha de espinhos at� 3 vezes contra inimigos pr�ximos.", 40);
		ChampionSkills eveW = new ChampionSkills("Fascina��o", "Evelynn amaldi�oa seu alvo, fazendo com que o pr�ximo ataque ou habilidade dela o encante e reduza sua Resist�ncia M�gica depois um intervalo.", 60);
		ChampionSkills eveE = new ChampionSkills("Chicotada", "Evelynn a�oita seu alvo com seu Chicote, causando dano. Depois, ela ganha Velocidade de Movimento por um breve per�odo.", 50);
		ChampionSkills eveR = new ChampionSkills("�ltima Car�cia", "Evelynn fica inalvej�vel por um breve per�odo e dizima a �rea � sua frente antes de se mover uma longa dist�ncia para tr�s.", 100);
		Campeoes evelynn = new Campeoes("Evelynn", eveP, eveQ, eveW, eveE, eveR, 572, 315, 61, 0, 37, 32);

		ChampionSkills ShenP = new ChampionSkills ("Barreira de Ki", "Ap�s conjurar uma habilidade, Shen recebe um escudo. Afetar outros escudos reduz o Tempo de Recarga desse efeito.", 0);
		ChampionSkills ShenQ = new ChampionSkills ("Ataque Crep�sculo", "Shen chama sua espada espiritual para atacar com ela, causando dano com base na Vida m�xima do alvo. Os ataques s�o fortalecidos drasticamente caso ela colida com um Campe�o inimigo. Todos os Campe�es com quem ela colide t�m a velocidade reduzida enquanto fogem de Shen.", 100);
		ChampionSkills ShenW = new ChampionSkills ("Ref�gio Espiritual", "Ataques que atingiriam Shen ou seus aliados pr�ximos � sua espada espiritual s�o bloqueados.", 40);
		ChampionSkills ShenE = new ChampionSkills ("Corrida das Sombras", "Shen avan�a em uma dire��o, provocando inimigos em seu trajeto.", 70);
		ChampionSkills ShenR = new ChampionSkills ("Manter a Uni�o", "Shen protege o Campe�o-alvo aliado do dano recebido e, em seguida, teleporta-se para seu local.", 0);
		Campeoes shen = new Campeoes ("Shen", ShenP, ShenQ, ShenW, ShenE, ShenR, 540, 400, 60, 0, 34, 34);

		ChampionSkills SingedP = new ChampionSkills ("Corrente de Ar Nociva", "Ao passar por Campe�es pr�ximos, Singed ganha Velocidade de Movimento.", 0);
		ChampionSkills SingedQ = new ChampionSkills ("Rastro de Veneno", "Deixa um rastro de veneno atr�s de Singed, causando dano aos inimigos que passam por este caminho.", 10);
		ChampionSkills SingedW = new ChampionSkills ("Mega Aesivo", "Joga um frasco de Mega Adesivo no ch�o, reduzindo a velocidade e prendendo os inimigos que pisam nele.", 50);
		ChampionSkills SingedE = new ChampionSkills ("Lan�ar", "Causa dano ao inimigo alvo e o arremessa pelo ar para tr�s de Singed. Se o alvo que Singed arremessar aterrissar em seu Mega Adesivo, ele ficar� enraizado.", 60);
		ChampionSkills SingedR = new ChampionSkills ("Po��o da Insanidade", "Singed bebe uma potente mistura de produtos qu�micos, que d� a ele um aumento nos atributos de combate.", 100);
		Campeoes singed = new Campeoes ("Singed", SingedP, SingedQ, SingedW, SingedE, SingedR, 580, 330, 63, 0, 34, 32);

		ChampionSkills SionP = new ChampionSkills ("In Gloria Mori", "Ap�s ser abatido, Sion ser� reanimado temporariamente, mas sua Vida decair� rapidamente. Seus ataques ficar�o muito r�pidos, curando e causando dano adicional com base na Vida m�xima do alvo.", 0);
		ChampionSkills SionQ = new ChampionSkills ("Golpe Demolidor", "Sion carrega um poderoso golpe em uma �rea � sua frente que causar� dano a inimigos quando lan�ado. Caso carregue por tempo suficiente, tamb�m arremessar� ao ar e atordoar� os inimigos atingidos.", 60);
		ChampionSkills SionW = new ChampionSkills ("Fornalha da Alma", "Sion se protege e pode reativar ap�s 3 segundos para causar Dano M�gico a inimigos pr�ximos. Quando Sion abate inimigos, ele recebe Vida m�xima passivamente.", 50);
		ChampionSkills SionE = new ChampionSkills ("Urro do Assassino", "Sion dispara uma onda de choque de curto alcance que causa dano e reduz a velocidade e Armadura do primeiro inimigo atingido. Se ela atingir uma tropa ou monstro, o mesmo ser� arremessado para tr�s, causando dano e reduzindo a velocidade e Armadura de todos os inimigos que atravessar.", 55);
		ChampionSkills SionR = new ChampionSkills ("Investida Incontrol�vel", "Sion avan�a em linha reta, acelerando ao longo do tempo. Ele pode guiar levemente sua investida com o cursor do mouse na posi��o. Ao colidir com um inimigo, ele causa dano e o arremessa ao ar com base na dist�ncia percorrida.", 100);
		Campeoes sion = new Campeoes ("Sion", SionP, SionQ, SionW, SionE, SionR, 545, 330, 68, 0, 32, 32);

		ChampionSkills SivirP = new ChampionSkills ("P�s Ligeiros", "Sivir ganha um pequeno impulso de Velocidade de Movimento quando ela ataca um campe�o inimigo.", 0);
		ChampionSkills SivirQ = new ChampionSkills ("L�mina Bumerangue", "Sivir arremessa sua l�mina como um bumerangue, causando dano tanto na ida quanto na volta.", 80);
		ChampionSkills SivirW = new ChampionSkills ("Ricochete", "Os pr�ximos ataques de Sivir ricochetear�o em outros alvos al�m do primeiro, causando dano reduzido a alvos secund�rios.", 50);
		ChampionSkills SivirE = new ChampionSkills ("Escudo de Feiti�o", "Cria uma barreira m�gica que bloqueia a habilidade de um �nico inimigo lan�ada em Sivir. Ela recupera a Mana gasta se o feiti�o for bloqueado.", 0);
		ChampionSkills SivirR = new ChampionSkills ("Na Ca�ada", "Sivir conduz seus aliados at� a batalha, concedendo a eles aumento de Velocidade de Movimento por um per�odo de tempo. Al�m disso, a habilidade concede Velocidade de Ataque adicional passivamente a Sivir enquanto Ricochete estiver ativo.", 100);
		Campeoes sivir = new Campeoes ("Sivir", SivirP, SivirQ, SivirW, SivirE, SivirR, 562, 284, 63, 0, 26, 30);

		ChampionSkills ShyvanaP = new ChampionSkills ("F�ria da Meio-Drag�o", "Shyvana causa dano adicional a drag�es, al�m de receber Armadura e Resist�ncia M�gica. Conforme Shyvana e seus aliados abatem mais drag�es, ela recebe mais Armadura e Resist�ncia M�gica.", 0);
		ChampionSkills ShyvanaQ = new ChampionSkills ("Mordida Dupla", "Shyvana golpeia duas vezes no seu pr�ximo ataque. Ataques b�sicos reduzem o Tempo de Recarga de Mordida Dupla em 0,5 segundo. Forma de Drag�o: Mordida Dupla fere todas as unidades � frente de Shyvana.", 0);
		ChampionSkills ShyvanaW = new ChampionSkills ("Combust�o", "Shyvana rodeia-se com fogo, causando Dano M�gico por segundo a inimigos pr�ximos e movimentando-se mais r�pido por 3 segundos; parte deste dano � aplicada novamente quando os ataques b�sicos de Shyvana acertam um inimigo com o efeito de Combust�o ativo. A Velocidade de Movimento � reduzida ao longo da dura��o da habilidade. Ataques b�sicos prolongam a dura��o de Combust�o. Forma de Drag�o: Combust�o cresce em tamanho.", 0);
		ChampionSkills ShyvanaE = new ChampionSkills ("H�lito Flamejante", "Shyvana desfere uma bola de fogo que causa dano a todos os inimigos que atingir e deixa os alvos em brasa, marcando-os por 5 segundos. Os ataques b�sicos de Shyvana em alvos marcados causam um percentual de sua Vida m�xima como dano ao contato. Forma de Drag�o: H�lito Flamejante explode ao impacto ou no local alvo, causando dano adicional e abrasando a terra por um curto per�odo de tempo.", 0);
		ChampionSkills ShyvanaR = new ChampionSkills ("Descida do Drag�o", "Shyvana se transforma em drag�o e voa em dire��o ao local alvo. Inimigos em seu caminho recebem dano e s�o lan�ados na dire��o de seu local alvo. Shyvana passivamente recebe F�ria por segundo e recebe 2 de F�ria em ataques b�sicos.", 0);
		Campeoes shyvana = new Campeoes ("Shyvana", ShyvanaP, ShyvanaQ, ShyvanaW, ShyvanaE, ShyvanaR, 595, 350, 66, 0, 38, 32);

		ChampionSkills kaisaP = new ChampionSkills("Segunda Pele", "Os ataques b�sicos de Kai'Sa acumulam Plasma, causando Dano M�gico adicional crescente. Efeitos imobilizadores de aliados ajudam a acumular Plasma. Al�m disso, as aquisi��es de itens de Kai'Sa aprimoram suas habilidades b�sicas, deixando-as mais poderosas.", 0);
		ChampionSkills kaisaQ = new ChampionSkills("Chuva Icathiana", "Kai'Sa dispara uma chuva de proj�teis que correm atr�s de alvos pr�ximos. Arma Viva: Chuva Icathiana � aprimorada e lan�a mais m�sseis.", 40);
		ChampionSkills kaisaW = new ChampionSkills("Exploradora do Vazio", "Kai'Sa lan�a um proj�til de longo alcance, marcando inimigos com sua passiva. Arma Viva: Exploradora do Vazio � aprimorada e aplica mais marcas passivas e tem o Tempo de Recarga reduzido ao acertar um Campe�o.", 80);
		ChampionSkills kaisaE = new ChampionSkills("Sobrecarga", "Kai'Sa aumenta brevemente sua Velocidade de Movimento, depois aumenta sua Velocidade de Ataque. Arma Viva: Sobrecarga � aprimorada e concede Invisibilidade por um breve per�odo.", 80);
		ChampionSkills kaisaR = new ChampionSkills("Instinto Assasino", "Kai'Sa avan�a para perto de um Campe�o inimigo.", 100);
		Campeoes kaisa = new Campeoes("Kai'Sa", kaisaP, kaisaQ, kaisaW, kaisaE, kaisaR, 600, 344, 59, 0, 28, 30);

		ChampionSkills jinxP = new ChampionSkills("Anime-se!", "Jinx recebe um aumento dr�stico de Velocidade de Movimento e de Velocidade de Ataque sempre que ajuda a destruir uma estrutura ou a abater um Campe�o inimigo ou monstro �pico da selva.", 0);
		ChampionSkills jinxQ = new ChampionSkills("Trocando!", "Jinx modifica seus ataques b�sicos ao trocar entre Pow-Pow, sua metralhadora, e Fishbones, seu lan�a-m�sseis. Ataques com Pow-Pow concedem Velocidade de Ataque, enquanto ataques com Fishbones causam dano em �rea de a��o, recebem aumento de Alcance e drenam Mana.", 20);
		ChampionSkills jinxW = new ChampionSkills("Zap!", "Jinx usa Zapper, sua pistola de choques, para disparar um proj�til que causa dano ao primeiro inimigo atingido, reduzindo sua velocidade e revelando-o.", 60);
		ChampionSkills jinxE = new ChampionSkills("Mordidinha Flamejante!", "Jinx arremessa uma fileira de granadas-armadilha que explodem ap�s 5 segundos, deixando os inimigos em chamas. As Mordidinhas Flamejantes morder�o campe�es inimigos que caminharem sobre elas, enraizando-os no local.", 70);
		ChampionSkills jinxR = new ChampionSkills("Super Mega M�ssil da Morte!", "Jinx dispara um super-m�ssil no mapa, que acumula dano ao longo de seu trajeto. O m�ssil explodir� ao colidir com um campe�o inimigo, causando dano a ele e a inimigos ao seu redor, com base em sua Vida removida.", 100);
		Campeoes jinx = new Campeoes("Jinx", jinxP, jinxQ, jinxW, jinxE, jinxR, 610, 245, 57, 0, 28, 30);

		ChampionSkills luxP = new ChampionSkills("Ilumina��o", "As habilidades de dano de Lux carregam o alvo com energia por 6s. O pr�ximo ataque de Lux incendeia a energia, causando Dano M�gico adicional (com base no n�vel de Lux) ao alvo.", 0);
		ChampionSkills luxQ = new ChampionSkills("Liga��o da Luz", "Lux atira uma esfera de luz que se prende e causa dano em at� duas unidades inimigas.", 60);
		ChampionSkills luxW = new ChampionSkills("Barreira Prism�tica", "Lux lan�a sua varinha e uma luz envolve todos os aliados atingidos, protegendo-os contra dano inimigo.", 50);
		ChampionSkills luxE = new ChampionSkills("Singularidade Lucente", "Dispara uma luz irregular em uma �rea, reduzindo a velocidade de inimigos pr�ximos. Lux pode deton�-la para causar dano aos inimigos na �rea de a��o.", 80);
		ChampionSkills luxR = new ChampionSkills("Centelha Final", "Ap�s acumular energia, Lux dispara um feixe de luz que causa dano a todos os inimigos na �rea. Al�m disso, ativa a habilidade passiva de Lux e reinicia a dura��o do efeito de Ilumina��o.", 100);
		Campeoes lux = new Campeoes("Lux", luxP, luxQ, luxW, luxE, luxR, 490, 480, 53, 0, 18, 30);

		ChampionSkills YasuoP = new ChampionSkills("Estilo do errante", "A Chance de Acerto Cr�tico de Yasuo � dobrada. Al�m disso, Yasuo forma um escudo sempre que estiver em movimento. O escudo � ativado quando ele recebe dano de um campe�o ou monstro.", 0);
		ChampionSkills YasuoQ = new ChampionSkills("Tempestade de a�o", "Golpeia � frente, causando dano a todos os inimigos em linha reta. Ao contato, concede um ac�mulo de tempestade crescente por alguns segundos. Com 2 ac�mulos, tempestade de a�o desfere um tornado que arremessa os inimigos ao ar", 0);
		ChampionSkills YasuoW = new ChampionSkills("Parede de vento", "Cria uma parede movedi�a que bloqueia todos os proj�teis inimigos por 4 segundos", 0);
		ChampionSkills YasuoE = new ChampionSkills("Espada �gil", "Avan�a e atrevessa o inimigo alvo, causando dano m�gico. Cada conjura��o aumenta o dano base de seu pr�ximo avan�o, at� um limite m�ximo. N�o pode ser conjurado novamente no mesmo inimigo por alguns segundos. Se tempestade de a�o for conjurada durante o avan�o, o ataque ser� circular", 0);
		ChampionSkills YasuoR = new ChampionSkills("�ltimo suspiro", "Teletransporta-se para um Campe�o inimigo arremessado ao ar, causando Dano F�sico e mantendo no ar todos os inimigos da �rea que foram arremessados ao ar. Concede o m�ximo de Fluxo, mas zera todos os ac�mulos de Tempestade Crescente Por um per�odo moderado a seguir, os Acertos Cr�ticos de Yasuo recebem Penetra��o de Armadura adicional significativa.", 0);
		Campeoes yasuo = new Campeoes("Yasuo", YasuoP, YasuoQ, YasuoW, YasuoE, YasuoR, 490, 0, 60, 0, 30, 32);

		ChampionSkills JhinP = new ChampionSkills("Sussurro", "O canh�o de Jhin, Sussurro, � um instrumento preciso criado para causar muito dano. Ele dispara com frequ�ncia fixa e carrega apenas quatro proj�teis. Jhin encanta o proj�til final com magia das trevas para causar acerto cr�tico e dano adicional de execu��o. Sempre que a Sussurro causa acerto cr�tico, ela inspira Jhin com Velocidade de Movimento", 0);
		ChampionSkills JhinQ = new ChampionSkills("Granada dan�ante", "Jhin lan�a um cartucho m�gico em um inimigo. Ele pode atingir at� quatro alvos e acumula dano a cada vez que causa um abate", 30);
		ChampionSkills JhinW = new ChampionSkills("Florescer mortal", "Jhin brande sua bengala, fazendo um disparo �nico com incr�vel alcance. Ele atravessa tropas e monstros, mas para no primeiro Campe�o atingido. Se o alvo foi recentemente atingido por aliados de Jhin, por Armadilhas de L�tus ou recebeu dano de Jhin, ele ser� enraizado.", 50);
		ChampionSkills JhinE = new ChampionSkills("Audi�ncia cativa", "Jhin posiciona uma armadilha de l�tus invis�vel que floresce ao ser pisada. Ela reduz a velocidade de inimigos pr�ximos antes de causar dano com uma explos�o de p�talas serrilhadas. Beleza em Morte - Quando Jhin abate um Campe�o inimigo, uma armadilha de l�tus florescer� pr�ximo a seu cad�ver.", 20);
		ChampionSkills JhinR = new ChampionSkills("Aclama��o", "Jhin canaliza, transformando a Sussurro em um mega-canh�o de ombro. Ela � capaz de fazer 4 super disparos com extremo alcance que atravessam tropas e monstros, mas que param no primeiro campe�o atingido. A Sussurro mutila os inimigos atingidos, o que reduz sua velocidade e aumenta o dano de execu��o. O 4� disparo � feito com perfei��o, de poder �pico e garante um acerto cr�tico", 100);
		Campeoes jhin = new Campeoes("Jhin", JhinP, JhinQ, JhinW, JhinE, JhinR, 585, 300, 59, 0, 24, 30);

		ChampionSkills ZoeP = new ChampionSkills("Brililim!", "O pr�ximo ataque b�sico ap�s Zoe conjurar uma habilidade causa Dano M�gico adicional.", 0);
		ChampionSkills ZoeQ = new ChampionSkills("Estrela desviada!", "Zoe dispara um proj�til que pode ser redirecionado durante o percurso. Causa mais dano quanto maior for a dist�ncia percorrida em linha reta.", 50);
		ChampionSkills ZoeW = new ChampionSkills("Roubo arcano", "Zoe pode apanhar os vest�gios das conjura��es de Feiti�o de Invocador ou de itens ativos do inimigo para que ela mesma os conjure. Sempre que ela conjura um Feiti�o de Invocador, ela ganha 3 proj�teis que s�o disparados contra o alvo mais pr�ximo.", 20);
		ChampionSkills ZoeE = new ChampionSkills("Bolha do soninho", "Faz com que o alvo fique sonolento e depois adorme�a. A primeira fonte de dano que interromper o sono � dobrada, at� determinado limite.", 60);
		ChampionSkills ZoeR = new ChampionSkills("Salto Dimensional", "Teleporta-se para uma posi��o pr�xima por 1s, depois se teleporta de volta.", 10);
		Campeoes zoe = new Campeoes("Zoe", ZoeP, ZoeQ, ZoeW, ZoeE, ZoeR, 560, 425, 58, 0, 20, 30);

		ChampionSkills AzirP = new ChampionSkills("Legado de Shurima", "Azir pode invocar o Disco Solar das ru�nas de uma torre aliada ou inimiga.", 0);
		ChampionSkills AzirQ = new ChampionSkills("Areias da conquista", "Azir comanda todos os Soldados de Areia na dire��o do local-alvo. Eles causam Dano M�gico aos inimigos que atravessam e aplicam redu��o de velocidade por 1 segundo.", 40);
		ChampionSkills AzirW = new ChampionSkills("Surja!", "Azir invoca um Soldado de Areia para atacar alvos pr�ximos por ele, substituindo seu ataque b�sico contra alvos dentro do alcance do soldado. Seu ataque causa Dano M�gico a inimigos em linha reta. Surja! tamb�m concede Velocidade de Ataque passiva a Azir e seus Soldados de Areia.", 30);
		ChampionSkills AzirE = new ChampionSkills("Areias oscilantes", "Azir se protege com um escudo por um momento e avan�a na dire��o de um de seus Soldados de Areia, causando dano aos inimigos atingidos. Se Azir acertar um Campe�o inimigo, ele prepara instantaneamente um novo Soldado de Areia para mobiliza��o e cessa seu avan�o.", 60);
		ChampionSkills AzirR = new ChampionSkills("Decreto do imperador", "Azir invoca uma parede de soldados que marcha em frente, causando dano e empurrando para tr�s os inimigos.", 100);
		Campeoes azir = new Campeoes("Azir", AzirP, AzirQ, AzirW, AzirE, AzirR, 552, 480, 52, 0, 19, 30);

		ChampionSkills amumuP = new ChampionSkills("Toque Amaldi�oado", "Os ataques b�sicos de Amumu Amaldi�oam seus inimigos, fazendo com que recebam Dano Verdadeiro adicional de qualquer Dano M�gico causado a eles.", 0);
		ChampionSkills amumuQ = new ChampionSkills("Lan�ar Bandagens", "Amumu lan�a uma bandagem pegajosa em seu alvo e se lan�a em sua dire��o, causando dano e atordoamento.", 40);
		ChampionSkills amumuW = new ChampionSkills("Desespero", "Tomados pela ang�stia, inimigos pr�ximos perdem um percentual de sua Vida m�xima a cada segundo e suas Maldi��es s�o restauradas.", 90);
		ChampionSkills amumuE = new ChampionSkills("Chilique", "Reduz permanentemente o Dano F�sico que Amumu receberia. Ele pode liberar sua f�ria, causando dano a inimigos pr�ximos. Sempre que Amumu � atingido, o Tempo de Recarga de Chilique � reduzido em 0,5 segundo.", 20);
		ChampionSkills amumuR = new ChampionSkills("A Maldi��o da M�mia Triste", "Amumu amarra unidades inimigas ao seu redor com ataduras, aplicando sua Maldi��o, causando dano e deixando-as incapazes de atacar ou se mover.", 100);
		Campeoes amumu = new Campeoes("Amumu", amumuP, amumuQ, amumuW, amumuE, amumuR, 613, 287, 53, 0, 33, 32);

		ChampionSkills annieP = new ChampionSkills("Piromania", "Ap�s conjurar 4 habilidades, a pr�xima habilidade de ataque de Annie atordoar� o alvo.", 0);
		ChampionSkills annieQ = new ChampionSkills("Desintegrar", "Annie arremessa uma bola de fogo infundida em Mana, causando dano e recuperando o custo de Mana caso o alvo seja destru�do.", 20);
		ChampionSkills annieW = new ChampionSkills("Incinerar", "Annie conjura um ardente cone de fogo, causando dano em todos os inimigos na �rea.", 90);
		ChampionSkills annieE = new ChampionSkills("Escudo Fundido", "Concede a Annie maior percentual de redu��o de dano, um impulso de Velocidade de Movimento e causa dano a inimigos que a atacarem com ataques b�sicos.", 40);
		ChampionSkills annieR = new ChampionSkills("Invocar: Tibbers", "Annie d� vida ao urso Tibbers, causando dano a unidades na �rea. Tibbers pode atacar e tamb�m queimar inimigos que ficarem pr�ximos a ele.", 100);
		Campeoes annie = new Campeoes("Annie", annieP, annieQ, annieW, annieE, annieR, 524, 418, 50, 0, 19,30);

		ChampionSkills fizzP = new ChampionSkills("Lutador Ligeiro", "Fizz pode se mover atrav�s de unidades e sofre uma quantidade fixa de dano reduzido de todas as origens.", 0);
		ChampionSkills fizzQ = new ChampionSkills("Ataque do Ouri�o", "Fizz avan�a em dire��o ao alvo, causando Dano M�gico e aplicando efeitos de contato.", 90);
		ChampionSkills fizzW = new ChampionSkills("Tridente da Pedra do Mar", "Os ataques de Fizz fazem seus inimigos sangrarem, causando Dano M�gico por v�rios segundos. Fizz pode fortalecer seu pr�ximo ataque para causar dano adicional e fortalecer os seguintes por um curto per�odo.", 20);
		ChampionSkills fizzE = new ChampionSkills("Brincalh�o / Trapaceiro", "Fizz faz acrobacias no ar, aterrissando graciosamente sobre seu tridente e ficando inalvej�vel. Desta posi��o, ele pode tanto golpear o ch�o quanto pular novamente antes de cair de vez.", 40);
		ChampionSkills fizzR = new ChampionSkills("Lan�ar Isca", "Fizz arremessa um peixe em determinada dire��o, que se prende a qualquer Campe�o que tocar, reduzindo a velocidade do alvo. Ap�s um curto intervalo, um tubar�o emerge do ch�o, lan�ando o alvo ao ar e empurrando outros inimigos para tr�s. Todos os inimigos atingidos recebem Dano M�gico e t�m sua velocidade reduzida.", 100);
		Campeoes fizz = new Campeoes("Fizz", fizzP, fizzQ, fizzW, fizzE, fizzR, 570, 317, 58, 0, 22, 32);

		ChampionSkills luluP = new ChampionSkills("Pix, o Silfo Companheiro", "Pix faz disparos de energia m�gica sempre que o Campe�o que estiver seguindo atacar outra unidade inimiga. Os disparos seguem o inimigo, mas podem ser interceptados por outras unidades.", 0);
		ChampionSkills luluQ = new ChampionSkills("Lan�a-Purpurina", "Pix e Lulu disparam, cada uma, um proj�til de energia m�gica que reduz drasticamente a velocidade dos inimigos atingidos. Cada inimigo somente pode ser atingido por um proj�til.", 50);
		ChampionSkills luluW = new ChampionSkills("Caprichos", "Se conjurada sobre um aliado, ela lhe concede Velocidade de Movimento por um curto per�odo de tempo. Se lan�ado sobre um inimigo, ele � transformado em um ador�vel bichinho que n�o pode atacar nem lan�ar feiti�os", 70);
		ChampionSkills luluE = new ChampionSkills("Socorro, Pix!", "Se conjurada em um aliado, ordena para que Pix pule nele e o proteja. Ela em seguida o segue e ajuda com seus ataques. Se conjurada em um inimigo, ordena para que Pix pule nele e o atinja. Ela o segue e lhe concede vis�o do inimigo.", 80);
		ChampionSkills luluR = new ChampionSkills("Crescimento Virente", "Lulu aumenta o tamanho de um aliado, arremessando ao ar inimigos pr�ximos e concedendo ao aliado uma grande quantidade de Vida adicional. Pelos pr�ximos segundos, tal aliado recebe uma aura que reduz a velocidade de inimigos pr�ximos.", 100);
		Campeoes lulu = new Campeoes("Lulu", luluP, luluQ, luluW, luluE, luluR, 252, 250, 47, 0, 29,30);
		
		//CADASTRO JOGADORES E T�CNICOS (POLIMORFISMO / POLIFORMISMO (N�O SEI MAIS QUAL O CERTO, OBRIGADO DIEGO))
		Pessoa bwipo = new Jogadores ("Gabri�l Rau", "Bwipo", 2, "Top");
		Pessoa selfmade  = new Jogadores ("Oskar Boderek", "Selfmade",4 , "Jungle");
		Pessoa nemesis = new Jogadores ("Tim Lipov�ek", "Nemesis", 4, "Mid");
		Pessoa rekkles = new Jogadores ("Martin Larsson", "Rekkles", 19, "Adc");
		Pessoa hylissang = new Jogadores ("Zdravets Iliev Galabov", "Hylissang", 3, "Sup");
		Pessoa aagie = new Tecnicos ("Carlos Carpio Cuencia", "Aagie");
		Pessoa impact = new Jogadores ("Jung Eon-yeong", "Impact", 10, "Top");
		Pessoa broxah = new Jogadores ("Mads Brock-Pedersen", "Broxah", 6, "Jungle");
		Pessoa jensen = new Jogadores ("Nicolaj Jensen", "Jensen", 7, "Mid");
		Pessoa tactical = new Jogadores ("Edward Ra", "Tactical", 3, "Adc");
		Pessoa corejj = new Jogadores ("Jo Yong-in", "CoreJJ", 9, "Sup");
		Pessoa cain = new Tecnicos ("Jang Nu-ri", "Cain");
		Pessoa nuguri = new Jogadores ("Jang Ha-gwon", "Nuguri", 5, "Top");
		Pessoa canyon = new Jogadores ("Kim Geon-bu", "Canyon", 3, "Jungle");
		Pessoa showmaker = new Jogadores ("Heo Su", "ShowMaker", 4, "Mid");
		Pessoa nuclear = new Jogadores ("Sin Jeong-hyeon", "Nuclear", 7, "Adc");
		Pessoa beryl = new Jogadores ("Cho Geon-hee", "BeryL", 2, "Sup");
		Pessoa daero = new Tecnicos ("Yang Dae-in", "Daeny");
		Pessoa robo = new Jogadores ("Leonardo Souza", "Robo", 2, "Top");
		Pessoa cariok = new Jogadores ("Marcos Oliveira", "Cariok", 1, "Jungle");
		Pessoa tinowns = new Jogadores ("Thiago Sartori", "TinOwns", 7, "Mid");
		Pessoa brtt = new Jogadores ("Felipe Gon�alves", "brTT", 5, "Adc");
		Pessoa esa = new Jogadores ("Andr� Eidi Yanagimachi Pavezi", "esA", 1, "Sup");
		Pessoa xero = new Tecnicos ("Sin Hyeok", "Xero");
		
		//CADASTRO DOS TIMES
		Pessoa vetor_jogadores[] = {robo, cariok, tinowns, brtt, esa};
		Times pain = new Times ("Pain Gaming", "PNG", "Brazil");
		pain.setSalario(10000);
		pain.setTitulos(10);
		pain.setJogadores(vetor_jogadores);
		pain.setTecnico(xero);
		
		Pessoa vetor_jogadores2[] = {bwipo, selfmade, nemesis, rekkles, hylissang};
		Times fnc = new Times ("Fnactic Gaming", "FNC", "Europe");
		fnc.setSalario(25000);
		fnc.setTitulos(21);
		fnc.setJogadores(vetor_jogadores2);
		fnc.setTecnico(aagie);
		
		Pessoa vetor_jogadores3[] = {nuguri, canyon, showmaker, nuclear, beryl};
		Times damwon = new Times ("Damwon Gaming", "DWG", "Korea");
		damwon.setSalario(20000);
		damwon.setTitulos(10);
		damwon.setJogadores(vetor_jogadores3);
		damwon.setTecnico(daero);
		
		Pessoa vetor_jogadores4[] = {impact, broxah, jensen, tactical, corejj};
		Times liquid = new Times ("Team Liquid", "TL", "North America");
		liquid.setSalario(21000);
		liquid.setTitulos(13);
		liquid.setJogadores(vetor_jogadores4);
		liquid.setTecnico(cain);
		
		//CADASTRO DE UM CAMPEONATO
		Campeonatos worlds = new Campeonatos ("League of Legends World Championship 2020", "Shangai - China", 30000000, 4);
		Times vetor_times[] = {fnc, pain, damwon, liquid};
		worlds.setTimes(vetor_times);

		
		//CADASTRANDO PARTIDA 1
		Partidas p1 = new Partidas (pain, fnc, worlds);
		//CADASTRANDO PICK DE CAMPE�ES TIME 1
		robo.pickChamp(katarina, flash, incendiar);
		cariok.pickChamp(amumu, golpear, flash);
		tinowns.pickChamp(fizz, flash, incendiar);
		brtt.pickChamp(jhin, curar, flash);
		esa.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPE�ES TIME 2
		bwipo.pickChamp(yasuo, flash, teleporte);
		selfmade.pickChamp(shyvana, flash, golpear);
		nemesis.pickChamp(azir, exaustao, flash);
		rekkles.pickChamp(sivir, flash, curar);
		hylissang.pickChamp(lux, golpear, teleporte);
		//SETANDO OS RESULTADOS DE MVP, VENCEDOR E DADOS DE PARTIDA
		p1.setTempo("33:33");
		p1.setMvp(tinowns);
		p1.setVencedor(fnc);
		p1.dadosPartida();
		
		Partidas p2 = new Partidas (liquid, fnc, worlds);
		//CADASTRANDO PICK DE CAMPE�ES TIME 1
		impact.pickChamp(hecarim, flash, incendiar);
		broxah.pickChamp(amumu, golpear, flash);
		jensen.pickChamp(ahri, flash, incendiar);
		tactical.pickChamp(jhin, curar, flash);
		corejj.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPE�ES TIME 2
		bwipo.pickChamp(yasuo, flash, teleporte);
		selfmade.pickChamp(shyvana, flash, golpear);
		nemesis.pickChamp(azir, exaustao, flash);
		rekkles.pickChamp(sivir, flash, curar);
		hylissang.pickChamp(lux, golpear, teleporte);
		//SETANDO OS RESULTADOS DE MVP, VENCEDOR E DADOS DE PARTIDA
		p2.setTempo("44;51");
		p2.setMvp(rekkles);
		p2.setVencedor(fnc);
		p2.dadosPartida();
		
		Partidas p3 = new Partidas (pain, liquid, worlds);
		//CADASTRANDO PICK DE CAMPE�ES TIME 1
		robo.pickChamp(katarina, flash, incendiar);
		cariok.pickChamp(amumu, golpear, flash);
		tinowns.pickChamp(fizz, flash, incendiar);
		brtt.pickChamp(jhin, curar, flash);
		esa.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPE�ES TIME 2
		impact.pickChamp(hecarim, flash, incendiar);
		broxah.pickChamp(yasuo, golpear, flash);
		jensen.pickChamp(ahri, flash, incendiar);
		tactical.pickChamp(sivir, curar, flash);
		corejj.pickChamp(katarina, exaustao, flash);
		//SETANDO OS RESULTADOS DE MVP, VENCEDOR E DADOS DE PARTIDA
		p3.setTempo("20;02");
		p3.setMvp(brtt);
		p3.setVencedor(pain);
		//p3.dadosPartida();
		
		//SETANDO CAMPE�O E MVP DO CAMPEONATO SEGUIDO DAS INFORMA��ES
		worlds.setCampeao();
		worlds.setMvp(rekkles);
		worlds.getInfos();

		//EXEMPLO DE COMO AS A��ES DOS JOGADORES S�O EXIBIDAS EM TELA, COM O NOME DO JOGADOR E DO CAMPE�O QUE ELE EST� REALIZANDO A A��O
		System.out.println(" ");
		tinowns.recall();
		tinowns.emote(); //MESMA FUN��O DO T�CNICO MAS DEVIDO AO POLIMORFISMO DE INCLUS�O, AS A��ES S�O DIFERENTES.
		tinowns.castQ();
		
		//EXEMPLO DE COMO AS A��ES DOS T�CNICOS S�O EXIBIDAS EM TELA
		System.out.println(" ");
		xero.emote(); //MESMA FUN��O DO JOGADOR MAS DEVIDO AO POLIMORFISMO DE INCLUS�O, AS A��ES S�O DIFERENTES
		xero.recall();
		
		//EXEMPLO DE COMO AS INFORMA��ES DO CAMPE�O S�O EXIBIDAS EM TELA
		System.out.println(" ");
		katarina.getInfos();
		//DETALHES DE UMA SKILL ESPEC�FICA
		katQ.getInfosPlus();
		
		//INFORMA��ES DO JOGADOR, CONTENDO O CAMPE�O ATUAL E OS FEITI��S DE INVOCADOR SELECIONADOS NO MOMENTO
		tinowns.getInfosPlus();
		System.out.println(" ");
		//INFORMA��ES DE UM TIME
		fnc.getInfos();
		//INFORMA��ES DE UM JOGADOR
		rekkles.getInfosPlus();
		
		
		
		





	}

}
