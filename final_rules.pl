%HECHOS DE LA BASE DE CONOCIMIENTO

%Hechos de pacientes
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

%Hechos de las edades
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

%Hechos de las personas infectadas
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

%Hechos de las personas con sintomas
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

%Hecho para la prueba de CT bajos
pruebaCTBajos(joshua).
%Hecho para la persona con una condicion especial
has_condition(joshua,obesidad).
%Hecho para persona que uso mascarilla
usesMask(laura).
%Hechos para la los sintomas
symptom(fiebre).
symptom(tos).
symptom(dolor_de_cabeza).
symptom(fatiga).
symptom(dolor_de_garganta).
symptom(migranna).
symptom(problemas_para_respirar).

%Hechos para la primera dosis de la vacuna
firstDosis(eduardo).
firstDosis(juan).
firstDosis(maria).
%Hechos para la segunda dosis de la vacuna
secondDosis(juan).
secondDosis(maria).
%Hechos para la tercera dosis de la vacuna
thirdDosis(maria).

%Hechos para las personas que tuvieron en contacto con otra
wasInContact(maria,jose).
wasInContact(maria, pedro).
wasInContact(yurgen, laura).
wasInContact(julia, flor).
wasInContact(john, sophia).
wasInContact(susan, george).
wasInContact(yurgen,michael).

%Hechos para quienes trabajan juntos
worksWith(yurgen,laura).
workWith(john, maria).
workWith(maria, peter).
workWith(peter, laura).
workWith(carlos, jose).
workWith(susan, george).
workWith(john, sophia).
workWith(andres, jose).
workWith(andres,carlos).

%Hechos para indicar quien contagio a quien
infects(maria,pedro).
infects(pedro,julia).
infects(julia,flor).
infects(flor,rosa).
infects(rosa,gloria).
infects(flor,carlos).
infects(carlos,jose).
infects(maria,andres).

%Hecho para quine dio negativo en prueba del covid
negativeCovidTest(paolo).


%REGLAS DE LA BASE DE CONOCIMIENTO
%Regla para determinar si la persona es adulta
adult(X):-
    age(X,Age),
    Age>=18.
%Regla para determinar si en una persona de tercera edad
elder(X):-
    age(X,Age),
    Age>=65.
%Regla para determinar que vacuna le toca según la edad
%El resultado se guarda el resultado en Vaccine
vaccineByAge(X,Vaccine):-
    age(X,Age),
    Age<18,
    Vaccine = 'Pfizer'.
vaccineByAge(X,Vaccine):-
    adult(X),
    Vaccine = 'Pfizer o Moderna'.

%Regla para indicar quien contagio a quien
spread_desease(X,Y):- infects(X,Y).
spread_desease(X,Y):- infects(X,Z),spread_desease(Z,Y).

% Determinar si una persona es sospechos de estar infectada
suspicious(X):- (has_symptom(X,_); (wasInContact(X,Y), infected(Y))).
% Determinar si una persona es media-baja sospechosa
mediumLowSuspicious(X) :- (wasInContact(X,Y), has_symptom(Y,_),(not(usesMask(X));not(usesMask(Y)))).
% Si una persona es de baja sospecha de tener el virus
lowSuspicious(X) :- wasInContact(X,Y), has_symptom(Y,_), (usesMask(X); usesMask(Y)).

%Regla para ver si una persona trabaja desde casa
workAtHome(X) :- infected(X); suspicious(X); (worksWith(X,Y),has_symptom(Y,_)).
%Si una persona tiene todas las vacunas
allVaccines(X) :- firstDosis(X), secondDosis(X),thirdDosis(X).
% Si una persona puede viajar
canTravel(X) :- allVaccines(X);negativeCovidTest(x).

%Reglas para determinar que refuerzo le toca a un paciente
%El resultado se guarda en Vaccines
recommendedReforceVaccine(X, Vaccine):-
 allVaccines(X),
 Vaccine = "Vacuna Bivalente".
recommendedReforceVaccine(X, Vaccine):-
 (secondDosis(X),not(thirdDosis(X))), Vaccine= "Completar esquema con refuerzo de la vacuna bivalente".
recommendedReforceVaccine(X,Vaccine):-
 (firstDosis(X),not(secondDosis(X))), Vaccine= "Una dosis de bivalente mas un refuerzo".
recommendedReforceVaccine(X,Vaccine):-
 paciente(X),(not(firstDosis(X))), Vaccine= "Dos dosis de bivalente mas un refuerzo".

%Determinar cuantas vacunas tiene una persona
%El resultado lo guarda en Result
howManyVaccines(X, Result):-
 allVaccines(X),
 Result = 3.
howManyVaccines(X, Result):-
 (secondDosis(X),not(thirdDosis(X))), Result= 2.
howManyVaccines(X,Result):-
 (firstDosis(X),not(secondDosis(X))), Result= 1.
howManyVaccines(X,Result):-
 paciente(X),(not(firstDosis(X))), Result = 0.

%Regla para contar los sintomas de un paciente
%Recibe el nombre del paciente, la lista de sintomas y guarda el resultado en N
count_symptoms(_,[],0).
count_symptoms(X,[H|T],N):- paciente(X),symptom(H), has_symptom(X,H),
                              count_symptoms(X,T,N1), N is N1+1.

%Regla que determina si un paciente es asintomatico
is_asymptomatic(X):- paciente(X), not(has_symptom(X,_)), infected(X).

%Regla para encontrar todo los sintomas de un  paciente
%Crea una lista con los sintomas y los guarda en Symptoms
find_symptoms(X, Symptoms):-findall(Symptom,(has_symptom(X,Symptom), symptom(Symptom)),Symptoms).

%Regla que busca los sintomas de un paciente y los contabiliza
%El resultado lo guarda en NumSymptoms
find_count_symptoms(X,NumSymptoms):-find_symptoms(X, Symptoms),count_symptoms(X,Symptoms,NumSymptoms).

%Determinar si una persona presenta un caso serio
serious_case(X):-has_symptom(X,problemas_para_respirar).

%Determina si una persona esta recuperada
recovered(X):- paciente(X), not(has_symptom(X,_)),pruebaCTBajos(X).

%Determinar si un paciente tiene un factor de riesgo
has_risk_factor(X):-elder(X); has_condition(X,_).

%Determinar si una persona es prioridad
is_priority(X):-has_risk_factor(X),infected(X).
