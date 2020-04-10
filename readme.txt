Bonjour,

Toutes les parties du code ont étées écrites par nous-même. Rien n'a été dupliqué.

Nous avons eu des soucis avec le remote du squellette, nous avons dû récupérer et push chaque fichiers à chaque nouveau TP.
Ce qui explique le chiffre important de lignes commit.

Actuellement, nous nous sommes arrêtés à l'évaluation de FGS. Nous rencontrons des difficultés sur le calcul des équations des in et out.

Nous avons légèremment modifié le script "evaluate.py" afin de pouvoir lancer les évaluations sur c3a, pre-nams, fg et fgs grâce à la méthode "evaluateDiff()".
Les lignes ajoutées sont les suivantes :

  c3aEvaluation = evaluateDiff(inputFiles, ".c3aout", "c3aout-ref/", "Code 3 Adresses")
  PrenasmEvaluation = evaluateDiff(inputFiles, ".pre-nasm", "prenasm-ref/", "Pre nasm")
  fgEvaluation = evaluateDiff(inputFiles, ".fg", "fg-ref/", "FG")
  fgsEvaluation = evaluateDiff(inputFiles, ".fgs", "fgs-ref/", "FGS")

   printEvaluationResult(sys.stdout, c3aEvaluation, useColor)
   printEvaluationResult(sys.stdout, PrenasmEvaluation, useColor)
   printEvaluationResult(sys.stdout, fgEvaluation, useColor)
   printEvaluationResult(sys.stdout, fgsEvaluation, useColor)


La méthode permettant d'évaluer Nasm "evaluateNasm()" est commentée.

De notre côté : sa, saout, ts, c3a, c3aout, pre-nams, fg sont corrects à 100%
fgs quant à lui est incorrect.


La quasi totalité du projet a été fait sur macOS Mojave, Version 10.14.

Cordialement,
Benjamin Ben-Esti, Théo Poujol.
