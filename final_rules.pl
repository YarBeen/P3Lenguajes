%Facts

 has_symptom(juan, fiebre).
has_symptom(juan, tos).
has_symptom(juan, dolor_de_cabeza).
has_symptom(maria, fiebre).
has_symptom(maria, fatiga).
has_symptom(pedro, tos).
has_symptom(pedro, dolor_de_garganta).
has_symptom(laura, fiebre).
has_symptom(laura, dolor_de_garganta).

symptom(fiebre).
symptom(tos).
symptom(dolor_de_cabeza).
symptom(fatiga).
symptom(dolor_de_garganta).
paciente(yarman).
paciente(juan).
is_infected(yarman).
age(juan,30).
age(eduardo,10).
firstDosis(eduardo).
firstDosis(juan).
secondDosis(juan).
firstDosis(maria).
secondDosis(maria).
thirdDosis(maria).
infected(jose).
wasInContact(maria,jose).
infects(maria,pedro).
infects(pedro,julia).
infects(julia,flor).
infects(flor,rosa).
infects(rosa,gloria).
infects(jose,flor).
infects(carlos,jose).
infects(andres,jose).
has_symptom(jose,migraine).
wasInContact(yurgen,michael).
infected(michael).
paciente(yurgen).
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

spread_desease(X,Y):- infects(X,Y). %Done
spread_desease(X,Y):- infects(X,Z),spread_desease(Z,Y). %Done
suspicious(X):- (has_symptom(X,_); (wasInContact(X,Y), infected(Y))). %Done
mediumLowSuspicious(X) :- (wasInContact(X,Y), has_symptom(Y,_),(not(usesMask(X));not(usesMask(Y)))). %Done
lowSuspicious(X) :- wasInContact(X,Y), has_symptom(Y,_), (usesMask(X); usesMask(Y)). %Done
workAtHome(X) :- infected(X); suspicious(X); (worksWith(X,Y),has_symptom(Y,_)).
allVaccines(X) :- firstDosis(X), secondDosis(X),thirdDosis(X).
canTravel(X) :- allVaccines(X);negativeCovidTest(x).
%Done
recommendedReforceVaccine(X, Vaccine):-
 allVaccines(X),
 Vaccine = "Vacuna Bivalente".
recommendedReforceVaccine(X, Vaccine):-
 (secondDosis(X),not(thirdDosis(X))), Vaccine= "Completar esquema con refuerzo de la vacuna bivalente".
recommendedReforceVaccine(X,Vaccine):-
 (firstDosis(X),not(secondDosis(X))), Vaccine= "Una dosis de bivalente mas un refuerzo".
recommendedReforceVaccine(X,Vaccine):-
 paciente(X),(not(firstDosis(X))), Vaccine= "Dos dosis de bivalente mas un refuerzo".

 %Done
howManyVaccines(X, Result):-
 allVaccines(X),
 Result = 3.
howManyVaccines(X, Result):-
 (secondDosis(X),not(thirdDosis(X))), Result= 2.
howManyVaccines(X,Result):-
 (firstDosis(X),not(secondDosis(X))), Result= 1.
howManyVaccines(X,Result):-
 paciente(X),(not(firstDosis(X))), Result = 0.

 count_symptoms(_,[],0).
 count_symptoms(X,[H|T],N):- paciente(X),symptom(H), has_symptom(X,H),
                              count_symptoms(X,T,N1), N is N1+1.
 is_asymptomatic(X):- paciente(X), not(has_symptom(X,_)), is_infected(X).

 find_symptoms(X, Symptoms):-findall(Symptom,(has_symptom(X,Symptom), symptom(Symptom)),Symptoms).


 find_count_symptoms(X,NumSymptoms):-find_symptoms(X, Symptoms),count_symptoms(X,Symptoms,NumSymptoms).


 serious_case(X):-has_symptom(X,'trouble breathing').


 recovered(X):- paciente(X), not(has_symptom(X,_)).

 has_risk_factor(X):-elder(X); has_condition(X,_).

 is_priority(X):-has_risk_factor(X),infected(X).
