//Temos o cadastro das skills, campeões, times, jogadores e campeonatos.
//Além disso temos uma simulação de campeonato, onde cadastramos uma partida, simulamos os picks de campeões para cada jogador de cada time e setamos os resultados(vencedor da partida, mvp, tempo total).
//Ao fim do cadastro de todas as partidas, a classe campeonatos busca dentre os times cadastrados, qual tem o maior número de vitórias para atribuir o título, também atribuimos o mvp do campeonato.
//Cada atribuição de título/mvp é um incremento dentro da classe que possui o atributo. No cadastro dos times em cada novo campeonato suas vitórias em partidas são zeradas para não haver conflitos.
//Todos os requisitos do trabalho se encontram comentados em suas respectivas classes/métodos.
//No main simulamos o cadastro de quatro times, e um campeonato com poucas partidas. Caso deseje brincar com o código, os construtores estão bem simples de se entender.
//As saídas em tela são respectivamente: Dados das partidas um e dois; Dados do campeonato; Algumas ações de jogador/técnico; Informações de um campeão; Informações de skill; Informações de um jogador; Informações de um time;

public class Main {

	public static void main(String[] args) {
		
		//FEITIÇOS DE INVOCADOR
		SummonerSkills flash = new SummonerSkills("Flash", "Teleporta seu campeão por uma curta distância", "SR, ARAM");
		SummonerSkills teleporte = new SummonerSkills("Teleporte", "Canaliza por 4 segundos para teleportar o campeão para uma unidade, torre ou sentinela aliada", "SR");
		SummonerSkills incendiar = new SummonerSkills("Incendiar", "Incendeia um campeão inimigo causando 70-140 de dano verdadeiro ao longo de 5 segundos", "SR, ARAM");
		SummonerSkills curar = new SummonerSkills("Curar", "Cura 90-345 de HP e concede 30% de velocidade de movimento por 1 segundo a você e um aliado próximo", "SR, ARAM");
		SummonerSkills golpear = new SummonerSkills("Golpear", "Causa 390-1000 de dano verdadeiro a monstros e restaura vida com base na vida máxima do campeão", "SR");
		SummonerSkills marca = new SummonerSkills("Marca", "Arremesa uma bola de neve em linha reta. Se atingir um campeão, ele fica marcado, e seu campeão pode usar a habilidade novamente para se teleportar até o alvo", "ARAM");
		SummonerSkills exaustao = new SummonerSkills("Exaustão", "Reduz a velocidade de movimento e o dano causado de um campeão inimigo em 30% e 40% respectivamente", "SR, ARAM");
		
		//DECLARAÇÃO DE SKILLS E CAMPEÕES
		ChampionSkills katP = new ChampionSkills("Voracidade", "Os Tempos de Recarda de Katarina são reduzidos drasticamente sempre que ela participa de um abate.", 0);
		ChampionSkills katQ = new ChampionSkills("Lâmina Saltitante", "Katarina arremesa uma adaga no alvo. Ela salta em inimigos próximos antes de ricochetear e cair no chão.", 0);
		ChampionSkills katW = new ChampionSkills("Preparação", "Katarina recebe Velocidade de Movimento, arremessando uma Adaga no ar diretamente acima de sim mesma.", 0);
		ChampionSkills katE = new ChampionSkills("Shunpo", "Katarina desloca-se em direção ao alvo, golpeando-o caso seja inimigo ou golpeando o inimigo mais próximo caso não seja.", 0);
		ChampionSkills katR = new ChampionSkills("Lótus da Morte", "Katarina gira em torno de si mesma, disparando adagas muito rapidamente e causando muito Dano Mágico nos 3 Campeões inimigos mais próximos.", 0);
		Campeoes katarina = new Campeoes("Katarina",  katP, katQ, katW, katE, katR, 602, 0, 58, 0, 28, 32);
		
		ChampionSkills graP = new ChampionSkills("Happy Hour", "Gragas cura a si mesmo periodicamente após utilizar uma habilidade.", 0);
		ChampionSkills graQ = new ChampionSkills("Jogar o Barril", "Gragas rola seu barril até um local, que pode ser ativado novamente para explodir ou explodirá sozinho após 4 segundos. Inimigos atingidos pela explosão têm sua Velocidade de Movimento reduzida.", 60);
		ChampionSkills graW = new ChampionSkills("Fúria da Bebedeira", "Gragas entorna a bebida de seu barril garganta abaixo, canalizando por 1 segundo. Ao terminar, ele fica torpecidamente poderoso, causando mais dano em seu próximo ataque básico e reduzindo o dano recebido.", 30);
		ChampionSkills graE = new ChampionSkills("Barrigada", "Gragas avança em direção a um local e colide com a primeira unidade inimiga que encontrar, causando dano a todas as unidades inimigas próximas e atordoando-as.", 50);
		ChampionSkills graR = new ChampionSkills("Barril Explosivo", "Gragas arremessa seu barril em um local, causando dano e afastando os inimigos pegos no raio da explosão.", 100);
		Campeoes gragas = new Campeoes("Gragas", graP, graQ, graW, graE, graR, 600, 400, 64, 0, 38, 32);
		
		ChampionSkills shaP = new ChampionSkills("Apunhalar", "Os ataques básicos de Shaco e Veneno de Dois Gumes causam dano adicional ao atingirem o inimigo por trás.", 0);
		ChampionSkills shaQ = new ChampionSkills("Enganar", "Shaco fica Invisível e se teleporta para o local-alvo. Seu primeiro ataque enquanto está Invisível é fortalecido, causando dano adicional e crítico ao atingir o inimigo por trás.", 50);
		ChampionSkills shaW = new ChampionSkills("Caixinha-Surpresa", "Shaco cria uma Caixinha-Surpresa escondida. Quando ativada, ela causará temor e atacará inimigos próximos", 30);
		ChampionSkills shaE = new ChampionSkills("Veneno de Dois Gumes", "As facas de Shaco envenenam alvos passivamente ao contato, reduzindo sua Velocidade de Movimento. Ele pode arremessá-las para causar dano e envenenar o alvo. A faca arremessada causa dano adicional se a Vida do alvo estiver abaixo de 30%.", 60);
		ChampionSkills shaR = new ChampionSkills("Alucinações", "Shaco cria uma ilusão de si mesmo próxima a ele, que pode atacar inimigos próximos (causa dano reduzido a torres). Ao morrer, ela explode, fazendo surgir três Caixinhas-Surpresa e causando dano a todos os inimigos próximos.", 100);
		Campeoes shaco = new Campeoes("Shaco", shaP, shaQ, shaW, shaE, shaR, 587, 297, 63, 0, 30, 32);
		
		ChampionSkills dravenP = new ChampionSkills("League of Draven", "Draven ganha Adoração de seus fãs quando apanha uma Revolução do Machado ou abate uma tropa, monstro ou torre. Abater Campeões inimigos concede ouro adicional a Draven, com base em quanta Adoração ele tem.", 0);
		ChampionSkills dravenQ = new ChampionSkills("Revolução do Machado", "O próximo ataque de Draven causará Dano Físico adicional. O machado ricocheteará do alvo em direção ao ar. Se Draven o apanhar, ele automaticamente irá preparar outra Revolução do Machado. Draven pode ter duas Revoluções do Machado simultaneamente em ação.", 50);
		ChampionSkills dravenW = new ChampionSkills("Adrenalina", "Draven ganha um aumento de Velocidade de Movimento e de Ataque. O aumento na Velocidade de Movimento decai rapidamente ao longo da duração. Apanhar uma Revolução do Machado fará com que o Tempo de Recarga de Adrenalina seja zerado.", 30);
		ChampionSkills dravenE = new ChampionSkills("Sai da Frente", "Draven arremessa seus machados, causando Dano Físico aos alvos atingidos e empurrando-os para o lado. Os alvos atingidos sofrem redução de velocidade.", 40);
		ChampionSkills dravenR = new ChampionSkills("Reta da Morte", "Draven arremessa dois machados gigantes para causar Dano Físico a cada unidade atingida. Reta da Morte lentamente muda de direção e retorna a Draven após atingir um Campeão inimigo. Draven também pode ativar essa habilidade enquanto seus machados estiverem em percurso para fazer com que voltem antecipadamente. Causa menos dano para cada unidade atingida e zera quando os machados mudam de direção.", 100);
		Campeoes draven = new Campeoes("Draven",  dravenP, dravenQ, dravenW, dravenE, dravenR, 605, 360, 60, 0, 29, 30);

		ChampionSkills hecarimP = new ChampionSkills("Caminho da Guerra", "Hecarim recebe Dano de Ataque equivalente a um percentual de sua Velocidade de Movimento adicional.", 0);
		ChampionSkills hecarimQ = new ChampionSkills("Enfurecido", "Hecarim golpeia inimigos próximos, causando Dano Físico. Caso ele cause dano a ao menos um inimigo, os usos subsequentes da habilidade causam mais dano e têm menor Tempo de Recarga.", 50);
		ChampionSkills hecarimW = new ChampionSkills("Espírito do Pavor", "Hecarim causa Dano Mágico a inimigos próximos por um curto período de tempo. Hecarim recebe Vida igual a um percentual de qualquer dano que esses inimigos receberem.", 65);
		ChampionSkills hecarimE = new ChampionSkills("Ataque Devastador", "Hecarim recebe Velocidade de Movimento crescente e ignora colisão com unidades por um curto período de tempo. Seu próximo ataque empurra o alvo para trás e causa Dano Físico adicional com base na distância percorrida desde a ativação da habilidade.", 55);
		ChampionSkills hecarimR = new ChampionSkills("Massacre das Sombras", "Hecarim invoca cavaleiros espectrais e avança, causando Dano Mágico em linha reta. Hecarim desfere uma onda de choque ao terminar o ataque, fazendo com que inimigos próximos se afastem aterrorizados.", 100);
		Campeoes hecarim = new Campeoes("Hecarim",  hecarimP, hecarimQ, hecarimW, hecarimE, hecarimR, 580, 277, 66, 0, 40, 32);

		ChampionSkills leesinP = new ChampionSkills("Agitação", "Após Lee Sin usar uma habilidade, seus próximos 2 ataques básicos recebem Velocidade de Ataque e recuperam Energia.", 0);
		ChampionSkills leesinQ = new ChampionSkills("Onda Sônica / Ataque Ressonante", "Onda Sônica: Lee Sin projeta uma onda sonora para localizar seus inimigos, causando Dano Físico ao primeiro que encontrar. Se Onda Sônica atingir um inimigo, Lee Sin pode conjurar Ataque Ressonante nos próximos 3 segundos. Ataque Ressonante: Lee Sin avança no inimigo atingido por Onda Sônica, causando Dano Físico baseado na Vida perdida do alvo.", 30);
		ChampionSkills leesinW = new ChampionSkills("Proteger / Vontade de Ferro", "Proteger: Lee Sin avança até um alvo aliado, protegendo a si mesmo do dano. Se o aliado for um Campeão, ele também é protegido. Após usar Proteger, Lee Sin pode conjurar Vontade de Ferro dentre os próximos 3 segundos. Vontade de Ferro: O treinamento intenso de Lee Sin permite que ele fique mais resistente em combate. Por 4 segundos, ele recebe Roubo de Vida e Vampirismo Mágico.", 40);
		ChampionSkills leesinE = new ChampionSkills("Tempestade / Multilar", "Tempestade: Lee Sin golpeia o chão, enviando uma onda de choque que causa Dano Mágico e revela unidades inimigas atingidas. Se Tempestade atingir um inimigo, Lee Sin pode conjurar Mutilar nos próximos 3 segundos. Mutilar: Lee Sin mutila inimigos próximos revelados por Tempestade, reduzindo a Velocidade de Movimento deles por 4 segundos. A Velocidade de Movimento é recuperada gradualmente ao longo da duração.", 50);
		ChampionSkills leesinR = new ChampionSkills("Fúria do Dragão", "Lee Sin executa um poderoso chute giratório, arremessando seu alvo para trás e causando Dano Físico ao alvo e a qualquer inimigo com quem ele colidir. Esses inimigos são lançados ao ar durante um curto período. Essa técnica foi ensinada a ele por Jesse Perring, mas Lee Sin não chuta os jogadores para fora do mapa.", 100);
		Campeoes leesin = new Campeoes("Lee sin",  leesinP, leesinQ, leesinW, leesinE, leesinR, 660, 200, 70, 0, 33, 32);

		ChampionSkills masteryiP = new ChampionSkills("Ataque Duplo", "A cada alguns ataques básicos consecutivos, Master Yi ataca duas vezes.", 0);
		ChampionSkills masteryiQ = new ChampionSkills("Ataque Alpha", "Master Yi se teleporta pelo campo de batalha tão rápido que não pode ser visto, causando Dano Físico a várias unidades pelo caminho enquanto fica inalvejável. O Ataque Alpha pode causar Acerto Crítico e Dano Físico adicional contra monstros. Ataques básicos reduzem o Tempo de Recarga de Ataque Alpha.", 50);
		ChampionSkills masteryiW = new ChampionSkills("Meditar", "Master Yi rejuvenesce seu corpo com a força da mente, restaurando Vida e recebendo dano reduzido por um curto período. Além disso, ele recebe acúmulos de Ataque Duplo e pausa a duração restante de Estilo Wuju e de Highlander para cada segundo de canalização.", 40);
		ChampionSkills masteryiE = new ChampionSkills("Estilo Wuju", "Concede Dano Verdadeiro adicional em ataques básicos.", 35);
		ChampionSkills masteryiR = new ChampionSkills("Highlander", "Master Yi se movimenta com extrema agilidade, aumentando temporariamente sua Velocidade de Ataque e de Movimento, e tornando-se imune a todos os efeitos de redução de velocidade. Abates ou assistências de Campeões estendem a duração de Highlander enquanto a habilidade estiver ativa. Reduz passivamente o Tempo de Recarga das outras habilidades a cada abate ou assistência.", 100);
		Campeoes masteryi = new Campeoes("Master Yi",  masteryiP, masteryiQ, masteryiW, masteryiE, masteryiR, 598, 250, 69, 0, 36, 32);

		ChampionSkills sylasP = new ChampionSkills("Explosão de Petricita", "Após conjurar uma habilidade, Sylas armazena uma carga de Explosão de Petricita. Seus ataques básicos gastam uma carga e agitam as correntes energizadas ao redor dele, causando Dano Mágico adicional a inimigos atingidos. Enquanto Sylas tiver uma carga de Explosão de Petricita, ele recebe Velocidade de Ataque.", 0);
		ChampionSkills sylasQ = new ChampionSkills("Correntes-Chicotes", "Sylas chicoteia com suas correntes, que se intersectam no local-alvo, causando dano e reduzindo a velocidade dos inimigos. Após um intervalo, há uma explosão de energia mágica no ponto da intersecção, causando dano.", 45);
		ChampionSkills sylasW = new ChampionSkills("Regicida", "Sylas avança em um inimigo com uma força mágica, causando dano com base em execução e curando a si mesmo contra Campeões inimigos.", 35);
		ChampionSkills sylasE = new ChampionSkills("Evasão / Abdução", "Sylas avança por uma curta distância, podendo reconjurar a habilidade para arremessar suas correntes e se arrastar na direção do inimigo atingido.", 50);
		ChampionSkills sylasR = new ChampionSkills("Usurpar", "Sylas rouba a habilidade ultimate do inimigo e pode conjurá-la sem custo.", 100);
		Campeoes sylas = new Campeoes("Sylas",  sylasP, sylasQ, sylasW, sylasE, sylasR, 525, 280, 64, 55, 31, 34);
		
		ChampionSkills ahriP = new ChampionSkills("Furto de Essência", "Quando Ahri atinge 9 inimigos com suas habilidades, sua próxima habilidade também a cura por cada inimigo atingido.", 0);
		ChampionSkills ahriQ = new ChampionSkills("Orbe da Ilusão", "Ahri lança e puxa de volta seu orbe, causando Dano Mágico na ida e Dano Verdadeiro na volta.", 60);
		ChampionSkills ahriW = new ChampionSkills("Fogo de Raposa", "Ahri recebe um breve impulso de Velocidade de Movimento e lança três Fogos de Raposa que perseguem e atacam inimigos próximos.", 40);
		ChampionSkills ahriE = new ChampionSkills("Encanto", "Ahri manda um beijo que causa dano e encanta um inimigo, interrompendo imediatamente qualquer habilidade de movimento em progresso e fazendo com que ele ande inofensivamente em sua direção. O alvo temporariamente sofre dano aumentado de Ahri.", 80);
		ChampionSkills ahriR = new ChampionSkills("Ímpeto Espiritual", "Ahri avança e atira raios de essência, causando dano a inimigos próximos. Ímpeto Espiritual pode ser conjurado até três vezes antes de entrar em Tempo de Recarga.", 100);
		Campeoes ahri = new Campeoes("Ahri",  ahriP, ahriQ, ahriW, ahriE, ahriR, 526, 418, 53, 0, 20, 30);

		ChampionSkills akaliP = new ChampionSkills("Marca do Assassino", "Causar dano com habilidades em Campeões cria um círculo de energia em volta deles. Sair desse círculo fortalece o próximo ataque básico de Akali com alcance e dano adicionais.", 0);
		ChampionSkills akaliQ = new ChampionSkills("Golpe dos Cinco Pontos", "Akali atira cinco kunais, causando redução de velocidade e dano com base em seu Dano de Ataque adicional e Poder de Habilidade.", 120);
		ChampionSkills akaliW = new ChampionSkills("Proteção do Crepúsculo", "Akali solta uma proteção de fumaça e recebe Velocidade de Movimento por um curto período. Enquanto estiver dentro da proteção, Akali se torna invisível e não pode ser selecionada como alvo de habilidades e ataques inimigos. Atacar ou usar habilidades fará com que ela seja revelada brevemente.", 0);
		ChampionSkills akaliE = new ChampionSkills("Investida Shuriken", "Salta para trás e atira uma shuriken para a frente, causando Dano Mágico. O primeiro inimigo ou nuvem de fumaça que forem atingidos são marcados. Conjure novamente para avançar ao alvo marcado, causando dano adicional.", 60);
		ChampionSkills akaliR = new ChampionSkills("Execução Perfeita", "Akali salta em uma direção, causando dano aos inimigos que atingir. Conjurar novamente: Akali avança em uma direção, executando todos os inimigos que atingir.", 0);
		Campeoes akali = new Campeoes("Akali", akaliP, akaliQ, akaliW, akaliE, akaliR, 575, 200, 62, 0, 23, 37);

		ChampionSkills eveP = new ChampionSkills("Sombra Demoníaca", "Quando está fora de combate, Evelynn entra em Sombra Demoníaca. A Sombra Demoníaca cura Evelynn quando ela está com pouca Vida e concede Camuflagem após o nível 6.", 0);
		ChampionSkills eveQ = new ChampionSkills("Espinho de Ódio", "Evelynn ataca com seu Chicote, causando dano ao primeiro inimigo atingido. Depois, Evelynn dispara uma linha de espinhos até 3 vezes contra inimigos próximos.", 40);
		ChampionSkills eveW = new ChampionSkills("Fascinação", "Evelynn amaldiçoa seu alvo, fazendo com que o próximo ataque ou habilidade dela o encante e reduza sua Resistência Mágica depois um intervalo.", 60);
		ChampionSkills eveE = new ChampionSkills("Chicotada", "Evelynn açoita seu alvo com seu Chicote, causando dano. Depois, ela ganha Velocidade de Movimento por um breve período.", 50);
		ChampionSkills eveR = new ChampionSkills("Última Carícia", "Evelynn fica inalvejável por um breve período e dizima a área à sua frente antes de se mover uma longa distância para trás.", 100);
		Campeoes evelynn = new Campeoes("Evelynn", eveP, eveQ, eveW, eveE, eveR, 572, 315, 61, 0, 37, 32);

		ChampionSkills ShenP = new ChampionSkills ("Barreira de Ki", "Após conjurar uma habilidade, Shen recebe um escudo. Afetar outros escudos reduz o Tempo de Recarga desse efeito.", 0);
		ChampionSkills ShenQ = new ChampionSkills ("Ataque Crepúsculo", "Shen chama sua espada espiritual para atacar com ela, causando dano com base na Vida máxima do alvo. Os ataques são fortalecidos drasticamente caso ela colida com um Campeão inimigo. Todos os Campeões com quem ela colide têm a velocidade reduzida enquanto fogem de Shen.", 100);
		ChampionSkills ShenW = new ChampionSkills ("Refúgio Espiritual", "Ataques que atingiriam Shen ou seus aliados próximos à sua espada espiritual são bloqueados.", 40);
		ChampionSkills ShenE = new ChampionSkills ("Corrida das Sombras", "Shen avança em uma direção, provocando inimigos em seu trajeto.", 70);
		ChampionSkills ShenR = new ChampionSkills ("Manter a União", "Shen protege o Campeão-alvo aliado do dano recebido e, em seguida, teleporta-se para seu local.", 0);
		Campeoes shen = new Campeoes ("Shen", ShenP, ShenQ, ShenW, ShenE, ShenR, 540, 400, 60, 0, 34, 34);

		ChampionSkills SingedP = new ChampionSkills ("Corrente de Ar Nociva", "Ao passar por Campeões próximos, Singed ganha Velocidade de Movimento.", 0);
		ChampionSkills SingedQ = new ChampionSkills ("Rastro de Veneno", "Deixa um rastro de veneno atrás de Singed, causando dano aos inimigos que passam por este caminho.", 10);
		ChampionSkills SingedW = new ChampionSkills ("Mega Aesivo", "Joga um frasco de Mega Adesivo no chão, reduzindo a velocidade e prendendo os inimigos que pisam nele.", 50);
		ChampionSkills SingedE = new ChampionSkills ("Lançar", "Causa dano ao inimigo alvo e o arremessa pelo ar para trás de Singed. Se o alvo que Singed arremessar aterrissar em seu Mega Adesivo, ele ficará enraizado.", 60);
		ChampionSkills SingedR = new ChampionSkills ("Poção da Insanidade", "Singed bebe uma potente mistura de produtos químicos, que dá a ele um aumento nos atributos de combate.", 100);
		Campeoes singed = new Campeoes ("Singed", SingedP, SingedQ, SingedW, SingedE, SingedR, 580, 330, 63, 0, 34, 32);

		ChampionSkills SionP = new ChampionSkills ("In Gloria Mori", "Após ser abatido, Sion será reanimado temporariamente, mas sua Vida decairá rapidamente. Seus ataques ficarão muito rápidos, curando e causando dano adicional com base na Vida máxima do alvo.", 0);
		ChampionSkills SionQ = new ChampionSkills ("Golpe Demolidor", "Sion carrega um poderoso golpe em uma área à sua frente que causará dano a inimigos quando lançado. Caso carregue por tempo suficiente, também arremessará ao ar e atordoará os inimigos atingidos.", 60);
		ChampionSkills SionW = new ChampionSkills ("Fornalha da Alma", "Sion se protege e pode reativar após 3 segundos para causar Dano Mágico a inimigos próximos. Quando Sion abate inimigos, ele recebe Vida máxima passivamente.", 50);
		ChampionSkills SionE = new ChampionSkills ("Urro do Assassino", "Sion dispara uma onda de choque de curto alcance que causa dano e reduz a velocidade e Armadura do primeiro inimigo atingido. Se ela atingir uma tropa ou monstro, o mesmo será arremessado para trás, causando dano e reduzindo a velocidade e Armadura de todos os inimigos que atravessar.", 55);
		ChampionSkills SionR = new ChampionSkills ("Investida Incontrolável", "Sion avança em linha reta, acelerando ao longo do tempo. Ele pode guiar levemente sua investida com o cursor do mouse na posição. Ao colidir com um inimigo, ele causa dano e o arremessa ao ar com base na distância percorrida.", 100);
		Campeoes sion = new Campeoes ("Sion", SionP, SionQ, SionW, SionE, SionR, 545, 330, 68, 0, 32, 32);

		ChampionSkills SivirP = new ChampionSkills ("Pés Ligeiros", "Sivir ganha um pequeno impulso de Velocidade de Movimento quando ela ataca um campeão inimigo.", 0);
		ChampionSkills SivirQ = new ChampionSkills ("Lâmina Bumerangue", "Sivir arremessa sua lâmina como um bumerangue, causando dano tanto na ida quanto na volta.", 80);
		ChampionSkills SivirW = new ChampionSkills ("Ricochete", "Os próximos ataques de Sivir ricochetearão em outros alvos além do primeiro, causando dano reduzido a alvos secundários.", 50);
		ChampionSkills SivirE = new ChampionSkills ("Escudo de Feitiço", "Cria uma barreira mágica que bloqueia a habilidade de um único inimigo lançada em Sivir. Ela recupera a Mana gasta se o feitiço for bloqueado.", 0);
		ChampionSkills SivirR = new ChampionSkills ("Na Caçada", "Sivir conduz seus aliados até a batalha, concedendo a eles aumento de Velocidade de Movimento por um período de tempo. Além disso, a habilidade concede Velocidade de Ataque adicional passivamente a Sivir enquanto Ricochete estiver ativo.", 100);
		Campeoes sivir = new Campeoes ("Sivir", SivirP, SivirQ, SivirW, SivirE, SivirR, 562, 284, 63, 0, 26, 30);

		ChampionSkills ShyvanaP = new ChampionSkills ("Fúria da Meio-Dragão", "Shyvana causa dano adicional a dragões, além de receber Armadura e Resistência Mágica. Conforme Shyvana e seus aliados abatem mais dragões, ela recebe mais Armadura e Resistência Mágica.", 0);
		ChampionSkills ShyvanaQ = new ChampionSkills ("Mordida Dupla", "Shyvana golpeia duas vezes no seu próximo ataque. Ataques básicos reduzem o Tempo de Recarga de Mordida Dupla em 0,5 segundo. Forma de Dragão: Mordida Dupla fere todas as unidades à frente de Shyvana.", 0);
		ChampionSkills ShyvanaW = new ChampionSkills ("Combustão", "Shyvana rodeia-se com fogo, causando Dano Mágico por segundo a inimigos próximos e movimentando-se mais rápido por 3 segundos; parte deste dano é aplicada novamente quando os ataques básicos de Shyvana acertam um inimigo com o efeito de Combustão ativo. A Velocidade de Movimento é reduzida ao longo da duração da habilidade. Ataques básicos prolongam a duração de Combustão. Forma de Dragão: Combustão cresce em tamanho.", 0);
		ChampionSkills ShyvanaE = new ChampionSkills ("Hálito Flamejante", "Shyvana desfere uma bola de fogo que causa dano a todos os inimigos que atingir e deixa os alvos em brasa, marcando-os por 5 segundos. Os ataques básicos de Shyvana em alvos marcados causam um percentual de sua Vida máxima como dano ao contato. Forma de Dragão: Hálito Flamejante explode ao impacto ou no local alvo, causando dano adicional e abrasando a terra por um curto período de tempo.", 0);
		ChampionSkills ShyvanaR = new ChampionSkills ("Descida do Dragão", "Shyvana se transforma em dragão e voa em direção ao local alvo. Inimigos em seu caminho recebem dano e são lançados na direção de seu local alvo. Shyvana passivamente recebe Fúria por segundo e recebe 2 de Fúria em ataques básicos.", 0);
		Campeoes shyvana = new Campeoes ("Shyvana", ShyvanaP, ShyvanaQ, ShyvanaW, ShyvanaE, ShyvanaR, 595, 350, 66, 0, 38, 32);

		ChampionSkills kaisaP = new ChampionSkills("Segunda Pele", "Os ataques básicos de Kai'Sa acumulam Plasma, causando Dano Mágico adicional crescente. Efeitos imobilizadores de aliados ajudam a acumular Plasma. Além disso, as aquisições de itens de Kai'Sa aprimoram suas habilidades básicas, deixando-as mais poderosas.", 0);
		ChampionSkills kaisaQ = new ChampionSkills("Chuva Icathiana", "Kai'Sa dispara uma chuva de projéteis que correm atrás de alvos próximos. Arma Viva: Chuva Icathiana é aprimorada e lança mais mísseis.", 40);
		ChampionSkills kaisaW = new ChampionSkills("Exploradora do Vazio", "Kai'Sa lança um projétil de longo alcance, marcando inimigos com sua passiva. Arma Viva: Exploradora do Vazio é aprimorada e aplica mais marcas passivas e tem o Tempo de Recarga reduzido ao acertar um Campeão.", 80);
		ChampionSkills kaisaE = new ChampionSkills("Sobrecarga", "Kai'Sa aumenta brevemente sua Velocidade de Movimento, depois aumenta sua Velocidade de Ataque. Arma Viva: Sobrecarga é aprimorada e concede Invisibilidade por um breve período.", 80);
		ChampionSkills kaisaR = new ChampionSkills("Instinto Assasino", "Kai'Sa avança para perto de um Campeão inimigo.", 100);
		Campeoes kaisa = new Campeoes("Kai'Sa", kaisaP, kaisaQ, kaisaW, kaisaE, kaisaR, 600, 344, 59, 0, 28, 30);

		ChampionSkills jinxP = new ChampionSkills("Anime-se!", "Jinx recebe um aumento drástico de Velocidade de Movimento e de Velocidade de Ataque sempre que ajuda a destruir uma estrutura ou a abater um Campeão inimigo ou monstro épico da selva.", 0);
		ChampionSkills jinxQ = new ChampionSkills("Trocando!", "Jinx modifica seus ataques básicos ao trocar entre Pow-Pow, sua metralhadora, e Fishbones, seu lança-mísseis. Ataques com Pow-Pow concedem Velocidade de Ataque, enquanto ataques com Fishbones causam dano em área de ação, recebem aumento de Alcance e drenam Mana.", 20);
		ChampionSkills jinxW = new ChampionSkills("Zap!", "Jinx usa Zapper, sua pistola de choques, para disparar um projétil que causa dano ao primeiro inimigo atingido, reduzindo sua velocidade e revelando-o.", 60);
		ChampionSkills jinxE = new ChampionSkills("Mordidinha Flamejante!", "Jinx arremessa uma fileira de granadas-armadilha que explodem após 5 segundos, deixando os inimigos em chamas. As Mordidinhas Flamejantes morderão campeões inimigos que caminharem sobre elas, enraizando-os no local.", 70);
		ChampionSkills jinxR = new ChampionSkills("Super Mega Míssil da Morte!", "Jinx dispara um super-míssil no mapa, que acumula dano ao longo de seu trajeto. O míssil explodirá ao colidir com um campeão inimigo, causando dano a ele e a inimigos ao seu redor, com base em sua Vida removida.", 100);
		Campeoes jinx = new Campeoes("Jinx", jinxP, jinxQ, jinxW, jinxE, jinxR, 610, 245, 57, 0, 28, 30);

		ChampionSkills luxP = new ChampionSkills("Iluminação", "As habilidades de dano de Lux carregam o alvo com energia por 6s. O próximo ataque de Lux incendeia a energia, causando Dano Mágico adicional (com base no nível de Lux) ao alvo.", 0);
		ChampionSkills luxQ = new ChampionSkills("Ligação da Luz", "Lux atira uma esfera de luz que se prende e causa dano em até duas unidades inimigas.", 60);
		ChampionSkills luxW = new ChampionSkills("Barreira Prismática", "Lux lança sua varinha e uma luz envolve todos os aliados atingidos, protegendo-os contra dano inimigo.", 50);
		ChampionSkills luxE = new ChampionSkills("Singularidade Lucente", "Dispara uma luz irregular em uma área, reduzindo a velocidade de inimigos próximos. Lux pode detoná-la para causar dano aos inimigos na área de ação.", 80);
		ChampionSkills luxR = new ChampionSkills("Centelha Final", "Após acumular energia, Lux dispara um feixe de luz que causa dano a todos os inimigos na área. Além disso, ativa a habilidade passiva de Lux e reinicia a duração do efeito de Iluminação.", 100);
		Campeoes lux = new Campeoes("Lux", luxP, luxQ, luxW, luxE, luxR, 490, 480, 53, 0, 18, 30);

		ChampionSkills YasuoP = new ChampionSkills("Estilo do errante", "A Chance de Acerto Crítico de Yasuo é dobrada. Além disso, Yasuo forma um escudo sempre que estiver em movimento. O escudo é ativado quando ele recebe dano de um campeão ou monstro.", 0);
		ChampionSkills YasuoQ = new ChampionSkills("Tempestade de aço", "Golpeia à frente, causando dano a todos os inimigos em linha reta. Ao contato, concede um acúmulo de tempestade crescente por alguns segundos. Com 2 acúmulos, tempestade de aço desfere um tornado que arremessa os inimigos ao ar", 0);
		ChampionSkills YasuoW = new ChampionSkills("Parede de vento", "Cria uma parede movediça que bloqueia todos os projéteis inimigos por 4 segundos", 0);
		ChampionSkills YasuoE = new ChampionSkills("Espada ágil", "Avança e atrevessa o inimigo alvo, causando dano mágico. Cada conjuração aumenta o dano base de seu próximo avanço, até um limite máximo. Não pode ser conjurado novamente no mesmo inimigo por alguns segundos. Se tempestade de aço for conjurada durante o avanço, o ataque será circular", 0);
		ChampionSkills YasuoR = new ChampionSkills("Último suspiro", "Teletransporta-se para um Campeão inimigo arremessado ao ar, causando Dano Físico e mantendo no ar todos os inimigos da área que foram arremessados ao ar. Concede o máximo de Fluxo, mas zera todos os acúmulos de Tempestade Crescente Por um período moderado a seguir, os Acertos Críticos de Yasuo recebem Penetração de Armadura adicional significativa.", 0);
		Campeoes yasuo = new Campeoes("Yasuo", YasuoP, YasuoQ, YasuoW, YasuoE, YasuoR, 490, 0, 60, 0, 30, 32);

		ChampionSkills JhinP = new ChampionSkills("Sussurro", "O canhão de Jhin, Sussurro, é um instrumento preciso criado para causar muito dano. Ele dispara com frequência fixa e carrega apenas quatro projéteis. Jhin encanta o projétil final com magia das trevas para causar acerto crítico e dano adicional de execução. Sempre que a Sussurro causa acerto crítico, ela inspira Jhin com Velocidade de Movimento", 0);
		ChampionSkills JhinQ = new ChampionSkills("Granada dançante", "Jhin lança um cartucho mágico em um inimigo. Ele pode atingir até quatro alvos e acumula dano a cada vez que causa um abate", 30);
		ChampionSkills JhinW = new ChampionSkills("Florescer mortal", "Jhin brande sua bengala, fazendo um disparo único com incrível alcance. Ele atravessa tropas e monstros, mas para no primeiro Campeão atingido. Se o alvo foi recentemente atingido por aliados de Jhin, por Armadilhas de Lótus ou recebeu dano de Jhin, ele será enraizado.", 50);
		ChampionSkills JhinE = new ChampionSkills("Audiência cativa", "Jhin posiciona uma armadilha de lótus invisível que floresce ao ser pisada. Ela reduz a velocidade de inimigos próximos antes de causar dano com uma explosão de pétalas serrilhadas. Beleza em Morte - Quando Jhin abate um Campeão inimigo, uma armadilha de lótus florescerá próximo a seu cadáver.", 20);
		ChampionSkills JhinR = new ChampionSkills("Aclamação", "Jhin canaliza, transformando a Sussurro em um mega-canhão de ombro. Ela é capaz de fazer 4 super disparos com extremo alcance que atravessam tropas e monstros, mas que param no primeiro campeão atingido. A Sussurro mutila os inimigos atingidos, o que reduz sua velocidade e aumenta o dano de execução. O 4º disparo é feito com perfeição, de poder épico e garante um acerto crítico", 100);
		Campeoes jhin = new Campeoes("Jhin", JhinP, JhinQ, JhinW, JhinE, JhinR, 585, 300, 59, 0, 24, 30);

		ChampionSkills ZoeP = new ChampionSkills("Brililim!", "O próximo ataque básico após Zoe conjurar uma habilidade causa Dano Mágico adicional.", 0);
		ChampionSkills ZoeQ = new ChampionSkills("Estrela desviada!", "Zoe dispara um projétil que pode ser redirecionado durante o percurso. Causa mais dano quanto maior for a distância percorrida em linha reta.", 50);
		ChampionSkills ZoeW = new ChampionSkills("Roubo arcano", "Zoe pode apanhar os vestígios das conjurações de Feitiço de Invocador ou de itens ativos do inimigo para que ela mesma os conjure. Sempre que ela conjura um Feitiço de Invocador, ela ganha 3 projéteis que são disparados contra o alvo mais próximo.", 20);
		ChampionSkills ZoeE = new ChampionSkills("Bolha do soninho", "Faz com que o alvo fique sonolento e depois adormeça. A primeira fonte de dano que interromper o sono é dobrada, até determinado limite.", 60);
		ChampionSkills ZoeR = new ChampionSkills("Salto Dimensional", "Teleporta-se para uma posição próxima por 1s, depois se teleporta de volta.", 10);
		Campeoes zoe = new Campeoes("Zoe", ZoeP, ZoeQ, ZoeW, ZoeE, ZoeR, 560, 425, 58, 0, 20, 30);

		ChampionSkills AzirP = new ChampionSkills("Legado de Shurima", "Azir pode invocar o Disco Solar das ruínas de uma torre aliada ou inimiga.", 0);
		ChampionSkills AzirQ = new ChampionSkills("Areias da conquista", "Azir comanda todos os Soldados de Areia na direção do local-alvo. Eles causam Dano Mágico aos inimigos que atravessam e aplicam redução de velocidade por 1 segundo.", 40);
		ChampionSkills AzirW = new ChampionSkills("Surja!", "Azir invoca um Soldado de Areia para atacar alvos próximos por ele, substituindo seu ataque básico contra alvos dentro do alcance do soldado. Seu ataque causa Dano Mágico a inimigos em linha reta. Surja! também concede Velocidade de Ataque passiva a Azir e seus Soldados de Areia.", 30);
		ChampionSkills AzirE = new ChampionSkills("Areias oscilantes", "Azir se protege com um escudo por um momento e avança na direção de um de seus Soldados de Areia, causando dano aos inimigos atingidos. Se Azir acertar um Campeão inimigo, ele prepara instantaneamente um novo Soldado de Areia para mobilização e cessa seu avanço.", 60);
		ChampionSkills AzirR = new ChampionSkills("Decreto do imperador", "Azir invoca uma parede de soldados que marcha em frente, causando dano e empurrando para trás os inimigos.", 100);
		Campeoes azir = new Campeoes("Azir", AzirP, AzirQ, AzirW, AzirE, AzirR, 552, 480, 52, 0, 19, 30);

		ChampionSkills amumuP = new ChampionSkills("Toque Amaldiçoado", "Os ataques básicos de Amumu Amaldiçoam seus inimigos, fazendo com que recebam Dano Verdadeiro adicional de qualquer Dano Mágico causado a eles.", 0);
		ChampionSkills amumuQ = new ChampionSkills("Lançar Bandagens", "Amumu lança uma bandagem pegajosa em seu alvo e se lança em sua direção, causando dano e atordoamento.", 40);
		ChampionSkills amumuW = new ChampionSkills("Desespero", "Tomados pela angústia, inimigos próximos perdem um percentual de sua Vida máxima a cada segundo e suas Maldições são restauradas.", 90);
		ChampionSkills amumuE = new ChampionSkills("Chilique", "Reduz permanentemente o Dano Físico que Amumu receberia. Ele pode liberar sua fúria, causando dano a inimigos próximos. Sempre que Amumu é atingido, o Tempo de Recarga de Chilique é reduzido em 0,5 segundo.", 20);
		ChampionSkills amumuR = new ChampionSkills("A Maldição da Múmia Triste", "Amumu amarra unidades inimigas ao seu redor com ataduras, aplicando sua Maldição, causando dano e deixando-as incapazes de atacar ou se mover.", 100);
		Campeoes amumu = new Campeoes("Amumu", amumuP, amumuQ, amumuW, amumuE, amumuR, 613, 287, 53, 0, 33, 32);

		ChampionSkills annieP = new ChampionSkills("Piromania", "Após conjurar 4 habilidades, a próxima habilidade de ataque de Annie atordoará o alvo.", 0);
		ChampionSkills annieQ = new ChampionSkills("Desintegrar", "Annie arremessa uma bola de fogo infundida em Mana, causando dano e recuperando o custo de Mana caso o alvo seja destruído.", 20);
		ChampionSkills annieW = new ChampionSkills("Incinerar", "Annie conjura um ardente cone de fogo, causando dano em todos os inimigos na área.", 90);
		ChampionSkills annieE = new ChampionSkills("Escudo Fundido", "Concede a Annie maior percentual de redução de dano, um impulso de Velocidade de Movimento e causa dano a inimigos que a atacarem com ataques básicos.", 40);
		ChampionSkills annieR = new ChampionSkills("Invocar: Tibbers", "Annie dá vida ao urso Tibbers, causando dano a unidades na área. Tibbers pode atacar e também queimar inimigos que ficarem próximos a ele.", 100);
		Campeoes annie = new Campeoes("Annie", annieP, annieQ, annieW, annieE, annieR, 524, 418, 50, 0, 19,30);

		ChampionSkills fizzP = new ChampionSkills("Lutador Ligeiro", "Fizz pode se mover através de unidades e sofre uma quantidade fixa de dano reduzido de todas as origens.", 0);
		ChampionSkills fizzQ = new ChampionSkills("Ataque do Ouriço", "Fizz avança em direção ao alvo, causando Dano Mágico e aplicando efeitos de contato.", 90);
		ChampionSkills fizzW = new ChampionSkills("Tridente da Pedra do Mar", "Os ataques de Fizz fazem seus inimigos sangrarem, causando Dano Mágico por vários segundos. Fizz pode fortalecer seu próximo ataque para causar dano adicional e fortalecer os seguintes por um curto período.", 20);
		ChampionSkills fizzE = new ChampionSkills("Brincalhão / Trapaceiro", "Fizz faz acrobacias no ar, aterrissando graciosamente sobre seu tridente e ficando inalvejável. Desta posição, ele pode tanto golpear o chão quanto pular novamente antes de cair de vez.", 40);
		ChampionSkills fizzR = new ChampionSkills("Lançar Isca", "Fizz arremessa um peixe em determinada direção, que se prende a qualquer Campeão que tocar, reduzindo a velocidade do alvo. Após um curto intervalo, um tubarão emerge do chão, lançando o alvo ao ar e empurrando outros inimigos para trás. Todos os inimigos atingidos recebem Dano Mágico e têm sua velocidade reduzida.", 100);
		Campeoes fizz = new Campeoes("Fizz", fizzP, fizzQ, fizzW, fizzE, fizzR, 570, 317, 58, 0, 22, 32);

		ChampionSkills luluP = new ChampionSkills("Pix, o Silfo Companheiro", "Pix faz disparos de energia mágica sempre que o Campeão que estiver seguindo atacar outra unidade inimiga. Os disparos seguem o inimigo, mas podem ser interceptados por outras unidades.", 0);
		ChampionSkills luluQ = new ChampionSkills("Lança-Purpurina", "Pix e Lulu disparam, cada uma, um projétil de energia mágica que reduz drasticamente a velocidade dos inimigos atingidos. Cada inimigo somente pode ser atingido por um projétil.", 50);
		ChampionSkills luluW = new ChampionSkills("Caprichos", "Se conjurada sobre um aliado, ela lhe concede Velocidade de Movimento por um curto período de tempo. Se lançado sobre um inimigo, ele é transformado em um adorável bichinho que não pode atacar nem lançar feitiços", 70);
		ChampionSkills luluE = new ChampionSkills("Socorro, Pix!", "Se conjurada em um aliado, ordena para que Pix pule nele e o proteja. Ela em seguida o segue e ajuda com seus ataques. Se conjurada em um inimigo, ordena para que Pix pule nele e o atinja. Ela o segue e lhe concede visão do inimigo.", 80);
		ChampionSkills luluR = new ChampionSkills("Crescimento Virente", "Lulu aumenta o tamanho de um aliado, arremessando ao ar inimigos próximos e concedendo ao aliado uma grande quantidade de Vida adicional. Pelos próximos segundos, tal aliado recebe uma aura que reduz a velocidade de inimigos próximos.", 100);
		Campeoes lulu = new Campeoes("Lulu", luluP, luluQ, luluW, luluE, luluR, 252, 250, 47, 0, 29,30);
		
		//CADASTRO JOGADORES E TÉCNICOS (POLIMORFISMO / POLIFORMISMO (NÃO SEI MAIS QUAL O CERTO, OBRIGADO DIEGO))
		Pessoa bwipo = new Jogadores ("Gabriël Rau", "Bwipo", 2, "Top");
		Pessoa selfmade  = new Jogadores ("Oskar Boderek", "Selfmade",4 , "Jungle");
		Pessoa nemesis = new Jogadores ("Tim Lipovšek", "Nemesis", 4, "Mid");
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
		Pessoa brtt = new Jogadores ("Felipe Gonçalves", "brTT", 5, "Adc");
		Pessoa esa = new Jogadores ("André Eidi Yanagimachi Pavezi", "esA", 1, "Sup");
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
		//CADASTRANDO PICK DE CAMPEÕES TIME 1
		robo.pickChamp(katarina, flash, incendiar);
		cariok.pickChamp(amumu, golpear, flash);
		tinowns.pickChamp(fizz, flash, incendiar);
		brtt.pickChamp(jhin, curar, flash);
		esa.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPEÕES TIME 2
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
		//CADASTRANDO PICK DE CAMPEÕES TIME 1
		impact.pickChamp(hecarim, flash, incendiar);
		broxah.pickChamp(amumu, golpear, flash);
		jensen.pickChamp(ahri, flash, incendiar);
		tactical.pickChamp(jhin, curar, flash);
		corejj.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPEÕES TIME 2
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
		//CADASTRANDO PICK DE CAMPEÕES TIME 1
		robo.pickChamp(katarina, flash, incendiar);
		cariok.pickChamp(amumu, golpear, flash);
		tinowns.pickChamp(fizz, flash, incendiar);
		brtt.pickChamp(jhin, curar, flash);
		esa.pickChamp(lulu, exaustao, flash);
		//CADASTRANDO PICK DE CAMPEÕES TIME 2
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
		
		//SETANDO CAMPEÃO E MVP DO CAMPEONATO SEGUIDO DAS INFORMAÇÕES
		worlds.setCampeao();
		worlds.setMvp(rekkles);
		worlds.getInfos();

		//EXEMPLO DE COMO AS AÇÕES DOS JOGADORES SÃO EXIBIDAS EM TELA, COM O NOME DO JOGADOR E DO CAMPEÃO QUE ELE ESTÁ REALIZANDO A AÇÃO
		System.out.println(" ");
		tinowns.recall();
		tinowns.emote(); //MESMA FUNÇÃO DO TÉCNICO MAS DEVIDO AO POLIMORFISMO DE INCLUSÃO, AS AÇÕES SÃO DIFERENTES.
		tinowns.castQ();
		
		//EXEMPLO DE COMO AS AÇÕES DOS TÉCNICOS SÃO EXIBIDAS EM TELA
		System.out.println(" ");
		xero.emote(); //MESMA FUNÇÃO DO JOGADOR MAS DEVIDO AO POLIMORFISMO DE INCLUSÃO, AS AÇÕES SÃO DIFERENTES
		xero.recall();
		
		//EXEMPLO DE COMO AS INFORMAÇÕES DO CAMPEÃO SÃO EXIBIDAS EM TELA
		System.out.println(" ");
		katarina.getInfos();
		//DETALHES DE UMA SKILL ESPECÍFICA
		katQ.getInfosPlus();
		
		//INFORMAÇÕES DO JOGADOR, CONTENDO O CAMPEÃO ATUAL E OS FEITIÇÕS DE INVOCADOR SELECIONADOS NO MOMENTO
		tinowns.getInfosPlus();
		System.out.println(" ");
		//INFORMAÇÕES DE UM TIME
		fnc.getInfos();
		//INFORMAÇÕES DE UM JOGADOR
		rekkles.getInfosPlus();
		
		
		
		





	}

}
