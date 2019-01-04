#!/bin/csh -f

#sqlite3 equivalenceClasses.db < equivalenceClasses.sql

sqlite3 equivalenceClasses.db '.tables'
sqlite3 equivalenceClasses.db '.schema equivalence'
sqlite3 equivalenceClasses.db 'select classRank from equivalence where c1=14 AND c2=13 AND c3=12 AND c4=11 AND c5=10 AND suited="S"'
sqlite3 equivalenceClasses.db 'select classRank from equivalence where c1=14 AND c2=13 AND c3=12 AND c4=11 AND c5=10 AND suited="NS"'
sqlite3 equivalenceClasses.db 'select classRank from equivalence where c1=8 AND c2=6 AND c3=5 AND c4=4 AND c5=3 AND suited="NS"'
