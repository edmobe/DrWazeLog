/*
 * Ejemplo 6.2.2.
 * Se soluciona el problema del genero y el numero
*/

oracion(S0,S):- sintagma_nominal(S0,S1,_Genero2,Numero), sintagma_verbal(S1,S,Numero).

sintagma_nominal(S0,S,Genero,Numero):- determinante(S0,S1,Genero,Numero), nombre(S1,S,Genero,Numero).
sintagma_verbal(S0,S,Numero):- verbo_intransitivo(S0,S,Numero).
sintagma_verbal(S0,S,Numero):- verbo_transitivo(S0,S1,Numero), sintagma_nominal(S1,S,_Genero,_Numero2).

/*
 * m: masculino
 * f: femenimo
 * s: singular
 * p: plural
*/

determinante([el|S],S,m,s).
determinante([un|S],S,m,s).

determinante([los|S],S,m,p).
determinante([unos|S],S,m,p).

determinante([la|S],S,f,s).
determinante([una|S],S,f,s).

determinante([las|S],S,f,p).
determinante([unas|S],S,f,p).

verbo_intransitivo([ladra|S],S,s).
verbo_intransitivo([ladran|S],S,p).

verbo_transitivo([muerde|S],S,s).
verbo_transitivo([muerden|S],S,p).

nombre([perro|S],S,m,s).
nombre([hueso|S],S,m,s).

nombre([perros|S],S,m,p).
nombre([huesos|S],S,m,p).

nombre([perra|S],S,f,s).

nombre([perras|S],S,f,p).


/*Preguntas, "Me llamo Eduardo", "Soy Eduardo", "Mi nombre es Eduardo"
"Voy para X", "Mi destino es X", "Me dirijo a X"
"Estoy en Y", "Me encuentro en Y", "Parto de Y", "Mi origen es Y", "El origen del viaje es Y"*/
