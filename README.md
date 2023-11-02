# Outils de manipulation des chaînes caractère

La classe `StringUtils` représente une classe utilitaire qui regroupe un ensemble des fonctionnalités
concernant les chaînes caractère sous la forme des méthodes statiques.

* La méthode `stripAccents()` prend en paramètre une chaîne caractère et retourne une nouvelle après avoir 
enlevé tous les accents. Par exemple le text "théâtre" deviendra "theatre".
* La méthode `removePunctuations()` prend en paramètre une chaîne caractère et retourne une nouvelle après
avoir enlevé tous les points de ponctuation. Par exemple le text "Bonjour, tout le monde !" deviendra "Bonjour
tout le monde ".
* La méthode `split()` prend en paramètre une chaîne caractère et retourne une liste qui contient tous les
mots de cette chaîne de caractère. Les mots sont séparés par des espaces, un tiret, ou un underscore.
* La méthode `countWord()` prend en paramètre deux chaînes caractère. La première est un texte dans lequel
on souhaite compter les occurrences d'un mot, passé en deuxième paramètre. La méthode retourne donc le
nombre d'occurrences du deuxième paramètre dans le premier.
* La méthode `slugify()` prend en paramètre une chaîne caractère et retourne une nouvelle qui représente
la version slugifiée du paramètre d'entrée.

Dans cet exercice, on s'intéresse aux réalisations des méthodes `countWord()` et `slugify()`. Les autres
méthodes sont considérées comme boîtes noires.

Un ensemble des tests unitaires est fourni dans la classe `StringUtilsTest` pour vérifier le bon
fonctionnement ces deux méthodes en particulier. À ne pas hésiter à relancer les tests lors de la
modification d'une de ces méthodes.

## API Stream
L'[API stream][1] propose des outils pour traiter les données d'une manière déclarative en s'appuyant sur
le paradigme de programmation fonctionnelle.

Par exemple, pour obtenir une liste de la représentation textuelle de tous les objets non nul dans une liste
`objects`, on pourrait faire le traitement suivant d'une manière impérative.

```java
List<String> strings = new ArrayList<>();
for (Object object: objects) {
    if (object != null) {
        strings.add(object.toString());
    }
}
```

Avec l'API stream le même objectif serait atteint d'une manière plus succincte :

```jaba
List<String> strings = objects.stream()
        .filter(o -> o != null)     // Opération 1
        .map(o -> o.toString())     // Opération 2
        .toList();                  // Opération terminale
```

Ou encore :

```jaba
List<String> strings = objects.stream()
        .filter(Objects::nonNull)   // Opération 1
        .map(Object::toString)      // Opération 2
        .toList();                  // Opération terminale
```

Ce code peut se lire de la manière suivante :
> À partir d'une liste d'objets, on réalise les fonctions suivantes :
> 1. On élimine les objets nuls (opération 1),
> 2. On transforme chaque objet à sa représentation textuelle (opération 2).
> 3. On envoie la liste des chaînes caractère résultantes (opération terminale).

On note que sur un stream, on peut appliquer plusieurs opérations intermédiaires, mais une seule opération
terminale. Une opération intermédiaire transforme un stream à un autre, alors qu'une opération terminale
transforme le stream à un résultat final.

La nature déclarative de l'API stream permet d'expliciter qu'est-ce qu'on veut faire, sans devoir préciser
comment le faire. Cela laisse à la JVM la possibilité de faire certaines optimisations, qui constitue un des
moult avantages de cette API. 

## Méthode `countWord()`
Le code fournit une version impérative de la méthode. On pourrait exprimer ce que cette méthode fait de la
manière suivante :
* Découper la chaîne caractère passée en paramètre en mots en utilisant la méthode `split()`.
* Filtrer les mots selon le critère d'égalité avec le mot recherché (voir condition `word.equals(current)`).
* Compter les éléments restants après filtrage et retourner ce chiffre.


### Exercice
Récrire la méthode `countWord()` en utilisant l'API stream et la programmation fonctionnelle.

## Méthode `slugify()`
Le code fournit une version impérative de la méthode. On pourrait exprimer ce que cette méthode fait de la
manière suivante :
* Découper la chaîne caractère passée en paramètre en mots en utilisant la méthode `split()`.
* Éliminer les chaînes caractère vide (voir condition `!word.isEmpty()`).
* Transformer chaque chaîne caractère afin d'éliminer les points de ponctuations en utilisant la méthode
`removePunctuations()`.
* Transformer chaque chaîne caractère afin d'éliminer les accents en utilisant la méthode `stripAccents()`.
* Transformer chaque chaîne caractère à son homologue en minuscule (voir l'appel à la méthode `toLowerCase()`).
* Concaténer les chaînes résultantes en ajoutant un tiret entre elles.


### Exercice
Récrire la méthode `slugify()` en utilisant l'API stream et la programmation fonctionnelle.

[1]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html
