%Facts

age(juan,30).
%Rules
adult(X):-
    age(X,Age),
    Age>=18.
elder(X):-
    age(X,Age),
    Age>=65.
vaccineByAge(X,Vaccine):-
    age(X,Age),
    Age<18,
    Vaccine = 'Pfizer'.
vaccineByAge(X,Vaccine):-
    adult(X),
    Vaccine = 'Pfizer o Moderna'.

spread_desease(X,Y):- infects(X,Y).
spread_desease(X,Y):- infects(X,Z),spread_desease(Z,Y).
suspicious(X):- (hasSymptons(X); (wasInContact(X,Y), infected(Y))).
mediumLowSuspicious(X) :- (wasInContact(X,Y), hasSymptons(Y),(not(usesMask(X));not(usesMask(Y)))).
lowSuspicious(X) :- wasInContact(X,Y), hasSymptons(Y), (usesMask(X); usesMask(Y)).
workAtHome(X) :- infected(X); suspicious(X); (worksWith(X,Y),hasSymptons(Y)).
allVaccines(X) :- firstDosis(X), secondDosis(X),thirdDosis(X).
canTravel(X) :- allVaccines(X);negativeCovidTest(x). 
recommendedReforceVaccine(X, Vaccine):-
 allVaccines(X),
 Vaccine = "Vacuna Bivalente".
recommendedReforceVaccine(X, Vaccine):-
 (secondDosis(X),not(thirdDosis(X))), Vaccine= "Completar esquema con refuerzo de la vacuna bivalente".
recommendedReforceVaccine(X,Vaccine):-
 (firstDosis(X),not(secondDosis(X))), Vaccine= "Una dosis de bivalente mas un refuerzo".
recommendedReforceVaccine(X,Vaccine):-
 (not(firstDosis(X))), Vaccine= "Dos dosis de bivalente mas un refuerzo".
 