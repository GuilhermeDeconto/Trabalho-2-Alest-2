# Trabalho 2 - Algoritmos e Estrutura de dados 2

# O caminho dos castelos

No século 13, a cidadezinha de Fragoletto era comandada pelo conde Sibério, o malvado governante que queria dominar toda a região da Lucrécia. Sibério usou as riquezas da cidade para montar um poderoso exército e sair conquistando castelos na região. Agora ele está com uma dúvida importante: como usar seu exército para conquistar o máximo possível de castelos? As escolhas devem ser bem feitas e você foi contratado para ajudá-lo a planejar sua campanha vitoriosa (claro que a sua cabeça continuar em cima dos ombros depende disso). As estratégias do combate medieval são bastante simples:

1. O conde Sibério ataca os castelos de um em um, seguindo pelas estradas até o castelo
seguinte;
2. Ele nunca divide seu exército, pois não é esperto ter dois exércitos mais fracos em vez de
um mais forte;
3. O conde só ataca castelos quando tem soldados suficientes para conquistar o castelo e
mantê-lo ocupado;
4. Atacar um castelo é dureza e se ele está ocupado por n soldados inimigos o exército
atacante perderá 2n soldados.
5. Ao mover-se para atacar outro castelo o conde deixa para trás uma guarnição de 50
soldados.

Agora, seu problema é descobrir o máximo de castelos que podem ser conquistados com o exército disponível e com a rede de estradas que existe. Felizmente, todas as informações já foram coletadas pelos espiões de Sibério, que entregaram um pergaminho como o que está ao lado e que é indecifrável pelos inimigos. As informações contidas nele são:

1. O tamanho do exército de Sibério;
2. O número C de castelos da vizinhança;
3. O número E de estradas da região;
4. Em seguida vem uma lista com o número de cada castelo
(entre 1 e C) e o tamanho de sua guarnição;
5. Em seguida vem uma lista das estradas (entre 1 e E) dizendo
de que castelo saem e para qual castelo vão.

Ah, sim. Como os espióes não sabiam que número dar para o castelo de Fragoletto, de onde Sibério deve sair, eles deram o número 0. Lá também devem ser deixada uma guarnição! Agora seu problema é interpretar e analisar vários destes documentos descrevendo várias situações diferentes e para cada um deles você deve informar quantos castelos podem ser conquistados, entregando um relatório completo para o conde. Claro que ele também quer saber muito mais: como qualquer senhor poderoso, ele deseja saber como você fez isso, que dificuldades encontrou, quais suas conclusões e tudo o mais que você puder informar.
