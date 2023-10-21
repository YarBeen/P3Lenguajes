%Facts


%Rules
spread_desease(X,Y):- infects(X,Y).
spread_desease(X,Y):- infects(X,Z),spread_desease(Z,Y).
suspicious(X):- (hasSymptons(X); (wasInContact(X,Y), infected(Y))).
mediumLowSuspicious(X) :- (wasInContact(X,Y), hasSymptons(Y),(not(usesMask(X));not(usesMask(Y)))).
lowSuspicious(X) :- wasInContact(X,Y), hasSymptons(Y), (usesMask(X); usesMask(Y)).
workAtHome(X) :- infected(X); suspicious(X); (worksWith(X,Y),hasSymptons(Y)).
allVaccines(X) :- firstDosis(X), secondDosis(X).
canTravel(X) :- (allVaccines(X);(firstDosis(X),negativeAntigens(X))),not(infected(X)). 