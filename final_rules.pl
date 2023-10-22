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

 

 count_symptoms(_,[],0).
 count_symptoms(X,[H|T],N):- paciente(X),symptom(H), has_symptom(X,H),
                              count_symptoms(X,T,N1), N is N1+1.
 is_asymptomatic(X):- paciente(X), not(has_sympton(X,_)), is_infected(X).

 find_symptoms(X, Symptoms):-findall(Symptom,(has_symptom(X,Symptom), symptom(Symptom)),Symptoms).


 find_count_symptoms(X,NumSymptoms):-find_symptoms(X, Symptoms),count_symptoms(X,Symptoms,NumSymptoms).


 serious_case(X):-has_symptom(X,'trouble breathing').

 infected_by(X):- infect(_,X).
 recovered(X):- paciente(X), not(has_symptom(X,_)).
 
 free_test(X):- find_count_symptoms(X,NumSymptoms), NumSymptoms > 2.
 
 has_risk_factor(X):-elder(X); has_condition(X,_).
 
 is_priority(X):-has_risk_factor(X),infected(X).