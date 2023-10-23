%Facts
paciente(yarman).
paciente(jose).
paciente(juan).
paciente(maria).
paciente(pedro).
paciente(laura).
paciente(joshua).
paciente(eduardo).
paciente(yurgen).
paciente(julia).
paciente(flor).
paciente(rosa).
paciente(gloria).
paciente(carlos).
paciente(andres).
paciente(michael).
paciente(paolo).

age(juan,30).
age(yarman,21).
age(maria,25).
age(pedro,32).
age(laura,22).
age(joshua,30).
age(eduardo,10).
age(yurgen,19).
age(julia,30).
age(flor,22).
age(rosa,30).
age(gloria,15).
age(carlos,3).
age(andres,70).
age(michael,65).
age(paolo,66).


infected(jose).
infected(michael).
infected(rosa).
infected(flor).
infected(carlos).
infected(pedro).
infected(andres).
infected(gloria).
infected(michael).
infected(julia).
infected(joshua).

has_symptom(juan, fiebre).
has_symptom(juan, tos).
has_symptom(juan, dolor_de_cabeza).
has_symptom(maria, fiebre).
has_symptom(maria, fatiga).
has_symptom(pedro, tos).
has_symptom(pedro, dolor_de_garganta).
has_symptom(laura, fiebre).
has_symptom(laura, dolor_de_garganta).
has_symptom(jose,migranna).
has_symptom(michael,problemas_para_respirar).
has_symptom(andres,problemas_para_respirar).

pruebaCTBajos(joshua).

has_condition(joshua,obesidad).

usesMask(laura).

symptom(fiebre).
symptom(tos).
symptom(dolor_de_cabeza).
symptom(fatiga).
symptom(dolor_de_garganta).
symptom(migranna).
symptom(problemas_para_respirar).


firstDosis(eduardo).
firstDosis(juan).
firstDosis(maria).

secondDosis(juan).
secondDosis(maria).

thirdDosis(maria).

wasInContact(maria,jose).
wasInContact(maria, pedro).
wasInContact(yurgen, laura).
wasInContact(julia, flor).
wasInContact(john, sophia).
wasInContact(susan, george).
wasInContact(yurgen,michael).

worksWith(yurgen,laura).
workWith(john, maria).
workWith(maria, peter).
workWith(peter, laura).
workWith(carlos, jose).
workWith(susan, george).
workWith(john, sophia).
workWith(andres, jose).
workWith(andres,carlos).

infects(maria,pedro).
infects(pedro,julia).
infects(julia,flor).
infects(flor,rosa).
infects(rosa,gloria).
infects(flor,carlos).
infects(carlos,jose).
infects(maria,andres).

negativeCovidTest(paolo).


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
suspicious(X):- (has_symptom(X,_); (wasInContact(X,Y), infected(Y))).
mediumLowSuspicious(X) :- (wasInContact(X,Y), has_symptom(Y,_),(not(usesMask(X));not(usesMask(Y)))).
lowSuspicious(X) :- wasInContact(X,Y), has_symptom(Y,_), (usesMask(X); usesMask(Y)).
workAtHome(X) :- infected(X); suspicious(X); (worksWith(X,Y),has_symptom(Y,_)).
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
 paciente(X),(not(firstDosis(X))), Vaccine= "Dos dosis de bivalente mas un refuerzo".


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
 is_asymptomatic(X):- paciente(X), not(has_symptom(X,_)), infected(X).

 find_symptoms(X, Symptoms):-findall(Symptom,(has_symptom(X,Symptom), symptom(Symptom)),Symptoms).


 find_count_symptoms(X,NumSymptoms):-find_symptoms(X, Symptoms),count_symptoms(X,Symptoms,NumSymptoms).


 serious_case(X):-has_symptom(X,problemas_para_respirar).

 recovered(X):- paciente(X), not(has_symptom(X,_)),pruebaCTBajos(X).


 has_risk_factor(X):-elder(X); has_condition(X,_).

 is_priority(X):-has_risk_factor(X),infected(X).
