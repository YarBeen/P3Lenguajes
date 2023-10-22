

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
 
 has_risk_factor(X):-(age(X,Age), Age>=65); has_condition(X,_).
 
 is_priority(X):-has_risk_factor(X),infected(X).
 

 
