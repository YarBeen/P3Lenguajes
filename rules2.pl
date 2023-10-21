%Facts


%Rules
spread_desease(X,Y):- infects(X,Y).
spread_desease(X,Y):- infects(X,Z),spread_desease(Z,Y).
suspicious(X):- (hasSymptons(X); (wasInContact(X,Y), infected(Y))).
mediumLowSuspicious(X) :- (wasInContact(X,Y), hasSymptons(Y),(not(usesMask(X));not(usesMask(Y)))).
LowSuspicious(X) :- wasInContact(X,Y), hasSymptons(Y), (usesMask(X); usesMask(Y)).