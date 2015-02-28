GameOfLifeUpgraded
===================

[Problem description](http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)
---------------------

The Rules
---------

> For a space that is *'populated'*:
   + Each cell with one or no neighbors dies, as if by loneliness. 
   +  Each cell with four or more neighbors dies, as if by overpopulation. 
   +  Each cell with two or three neighbors survives. 

> For a space that is *'empty'* or *'unpopulated'*
   +  Each cell with three neighbors becomes populated. 

Plan
----

> #3LifeController

> #3Grid
#4 public interactions
 - seed(positionstolive)
 - forwardToNextGeneration()

#4 private interactions
 - getNeighbours(cell)
 - forwardAllCellsToNextGeneration()
 - getNextGenerationLifeStatus(cell)

> #3AIEngine
#4 public interactions
 - computeNextGeneration(board)

#4 private interactions
#5 *for living cell*
 - isUnderPopulated(cell)
 - isOverCrowded(cell)
 - isAliveForNextGeneration(cell)
#5 *for empty cell*
 - isReadyForReproduction()

> #3Cell
#4 public interactions
 - hasLife()
 - setLifeForNextGeneration()
 - forwardToNextGeneration()