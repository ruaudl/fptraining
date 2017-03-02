Entrainement à la programmation fonctionnelle
==========

Ces exercices sont destinés à découvrir la programmation fonctionnelle.
Ils sont issus du projet [Dice Arena][1]


Sujet
-----
Le thème abordé dans les exercices est le jeu de dé Yahtzee, aussi appelé Yam's.
Il s'agît d'un jeu de dé mondialement connu et dont les règles sont assez simples.
Les joueurs lancent 5 dés et tentent d'obtenir des combinaisons qui rapportent des points selon leur complexité.
Ces combinaisons sont proches de ce que l'on trouve au Poker mais octroient un score différent pour chacune.

L'intérêt de ce thème réside justement dans les différentes règles de calcul des points obtenus pour chaque combinaison.
Elles vont permettre d'utiliser les différents concepts de programmation fonctionnelle.


Etape 1 : Fonctions et Java
---------------------------

Le langage Java n'est pas un langage fonctionnelle par essence.
Depuis sa version 8, il a été introduit la possiblité de référencer des fonctions.
Techniquement, les fonctions sont des méthodes et sont toujours attachées à une classe.
En revanche, des évolutions de syntaxe permettent de se concentrer sur le code de la fonction sans écrire toute la décoration induite par l'encapsulation dans une classe.


### Exercice 1-1

Commençons par créer une première classe Java classique.

Cette classe portera la valeur des dés jetés dans une liste d'entier ainsi que l'index du lancé.
Nous définirons ces champs à la sauce *JavaBean*.

**TODO:** Définissez les champs `index` et  `dice` respectivement de type `Integer` et `List<Integer>`.
 
**TODO:** Définissez le constructeur permettant de définir les champs.

**TODO:** Définissez les getters permettant d'obtenir la valeur des champs.

**TODO:** Complétez le test E01 de la classe T01.


### Exercice 1-2

Créons une deuxième classe Java nommée `Dice`. 
Cette classe sera définie comme une classe utilitaire classique et portera donc des méthodes statiques.
L'objectif de cette classe est de fournir des lancés de dés.

Le lancé d'un seul dé sera défini par la méthode `roll`. 
Elle ne prend pas de paramètres et retourne un entier.
Nous pouvons utiliser la classe `Random` de Java pour obtenir un nombre aléatoire.

**TODO:** Définissez la méthode statique `roll`.

**TODO:** Complétez le test E02 de la classe T01.


### Exercice 1-3

Les fonctions que nous avons référencées jusqu'à présent implémentaient l'interface `Supplier`.
En effet, pour être référencée, une fonction doit implémenter une interface dite fonctionnelle.
Si une méthode ne possède pas une signature compatible avec une interface fonctionnelle, elle ne pourra pas être référencée.

Comme il s'agît d'interfaces, il est tout à fait possible de l'implémenter à la volée via une classe interne anonyme.

**TODO:** Complétez le test E03 de la classe T01 en implémentant la méthode `roll` comme une classe anonyme implémentant l'interface `Supplier`.


### Exercice 1-4

Java 8 a introduit une nouvelle syntaxe pour définir des fonctions : les *lambdas*.
Techniquement, une *lambda* n'est que du sucre syntaxique pour écrire une classe anonyme comme nous venons de le faire dans l'exercice précédent.

**TODO:** Complétez le test E04 de la classe T01 en implémentant la méthode `roll` comme une lambda.


Auteurs
-------
Ce projet est réalisé par des développeurs passionées dans le cadre du dojo de Serli.


[1]: https://github.com/SerliDojo/dice-arena "Projet Dice Arena"
